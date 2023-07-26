<?php

namespace App\Http\Controllers;

use App\Models\Offer;
use App\Models\User;
use Illuminate\Http\Request;
use App\Models\Coupon;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Str;

class CouponController extends Controller
{
    // OC = Offerte Coupon
    // Apre la pagina stampabile del coupon, che comprende il coupon stesso e l'offerta a cui è associato.
    function getDataOC($idOfferta)
    {
        $usernameCliente = Auth::user()->username;

        $dataCP = Coupon::where('idOfferta', $idOfferta)
            ->where('usernameCliente', $usernameCliente)
            ->first();
        $dataO = Offer::where('id', $idOfferta)->first();
        $dataC = User::where('username', $usernameCliente)->first();

        return view('customer/coupon', ['tuple'=>$dataO, 'cliente'=>$dataC, 'datiCoupon'=>$dataCP]);
    }

    // Inserisce un nuovo Coupon nel database.
    function saveDataC($idOfferta)
    {
        // questo è lo username del cliente
        $usernameCliente = Auth::user()->username;

        // se l'utente non ha richiesto già il coupon della stessa offerta vado a generare il suo coupon
        if(!Coupon::where('idOfferta', $idOfferta)->where('usernameCliente', $usernameCliente)->exists()) {
            // Genera il codice alfanumerico controllando
            // che non venga ripetuto
            do {
                $codice = Str::random(9);
            } while (Coupon::where('codice', $codice)->exists());

            $coupon = new Coupon();
            $coupon['idOfferta'] = $idOfferta;
            $coupon['usernameCliente'] = $usernameCliente;
            $coupon['codice'] = $codice;
            $coupon->save();
        }

        // ottengo i dettagli del coupon
        $dataO = Offer::where('id', $idOfferta)->first();
        $dataC = User::where('username', $usernameCliente)->first();
        $dataCP = Coupon::where('idOfferta', $idOfferta)
            ->where('usernameCliente', $usernameCliente)
            ->first();

        // ritorno la vista del coupon compresa di tutti i dati necessari
        return view('customer/coupon', ['tuple'=>$dataO, 'cliente'=>$dataC, 'datiCoupon'=>$dataCP]);
    }

    // Per mostrare la Lista di Coupons Usati
    function getDataLCU()
    {
        $usernameCliente = Auth::user()->username;

        $data = Coupon::select('utenti.username', 'offerte.id as idOfferte', 'offerte.nome as nomeOfferte', 'aziende.nome as nomeAziende',
                               'coupons.dataOraCreazione', 'offerte.dataOraScadenza', 'coupons.codice')
            ->join('offerte', 'coupons.idOfferta', '=', 'offerte.id')
            ->join('aziende', 'offerte.idAzienda', '=', 'aziende.id')
            ->join('utenti', 'utenti.username', '=', 'coupons.usernameCliente')
            ->orderBy('coupons.dataOraCreazione', 'asc')
            ->where('coupons.usernameCliente', $usernameCliente)
            ->get();

        return view('customer/listaCouponUsati', ['List'=>$data]);
    }

    // Metodo per la Barra di Ricerca per view lista Coupon Usati
    // Va ad ottenere i coupon che hanno come nome ciò che ho digitato nella barra di ricerca (Query di ricerca)
    public function getDataBRCU(Request $request)
    {
        $usernameCliente = Auth::user()->username;
        //viene utilizzato per accedere ai parametri di input inviati con la richiesta
        $query = $request->input('query');

        $dataCU = Coupon::select('utenti.username', 'offerte.id as idOfferte', 'offerte.nome as nomeOfferte', 'aziende.nome as nomeAziende',
                                 'coupons.dataOraCreazione', 'offerte.dataOraScadenza', 'coupons.codice')
            ->join('offerte', 'coupons.idOfferta', '=', 'offerte.id')
            ->join('aziende', 'offerte.idAzienda', '=', 'aziende.id')
            ->join('utenti', 'utenti.username', '=', 'coupons.usernameCliente')
            ->orderBy('coupons.dataOraCreazione', 'asc')
            ->where('offerte.nome', 'LIKE', '%' .$query. '%')
            ->where('coupons.usernameCliente', $usernameCliente)
            ->get();

        return view('customer/listaCouponUsati', ['List'=>$dataCU]);
    }
}
