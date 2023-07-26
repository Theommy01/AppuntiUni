<?php

namespace App\Http\Controllers;

use App\Models\Coupon;
use App\Models\Offer;
use App\Models\User;
use Illuminate\Http\Request;

class StatsController extends Controller
{
    // ottiene tutti i dati delle offerte, degli utenti e conta il numero totale di coupon che sono stati applicati
    function getData()
    {
        // ottengo tutte le offerte
        $promo = Offer::select('id', 'nome')->get();

        // ottengo gli utenti di livello 1, che sono i clienti
        $clienti = User::select('username', 'nome', 'cognome')->where('livello', 1)->get();

        // ottengo il numero di coupon totali che sono stati generati
        $couponNum = Coupon::count();

        // ritorno la view con tutti i dati che servono
        return view("admin/statistiche", ["Promo" => $promo, "Clienti" => $clienti, "NumeroCoupon" => $couponNum]);
    }

    // restituisce un JSON che contiene i coupon che sono stati emessi per una certa offerta dato il suo ID
    function getOffertaCoupons(Request $request) {
        // ottengo l'id dell'offerta a partire dai parametri arrivati in POST
        $idOfferta = $request->input("idOfferta");

        // ottengo il nome dell'offerta selezionata
        // NOTA: uso first() per prendere soltanto un elemento, in modo tale che ricevo subito un oggetto senza dover
        // prima accedere all'array
        $offer = Offer::select('nome')->where('id', $idOfferta)->first();

        // ottengo il numero di coupon generati da questa offerta
        $couponNumber = Coupon::join('offerte', 'coupons.idOfferta', '=', 'offerte.id')
                                ->where('idOfferta', $idOfferta)
                                ->count();

        // restituisco questi dati come risposta in formato JSON
        return response()->json(['offerName' => $offer->nome, 'couponNumber' => $couponNumber]);
    }

    // restituisce un JSON che contiene i coupon che sono stati emessi da un certo utente dato il suo username
    function getClienteCoupons(Request $request) {
        // ottengo lo username a partire dai parametri arrivati in POST
        $username = $request->input("username");

        // ottengo il numero di coupon che il cliente ha richiesto
        $couponNumber = Coupon::join('utenti', 'coupons.usernameCliente', '=', 'utenti.username')
                                ->where('livello', 1)
                                ->where('username', $username)
                                ->count();

        // restituisco questi dati come risposta in formato JSON
        return response()->json(['username' => $username, 'couponNumber' => $couponNumber]);
    }

    // ottiene sempre i dati delle offerte, dei clienti ma li filtra (se richiesto) in base alle key-words inserite nelle
    // barre di ricerca.
    // BR = Barra Ricerca
    function getDataBR(Request $request) {
        // ottengo tutte le offerte
        $promoQuery = Offer::select('id', 'nome');
        // se ho scritto qualcosa nella barra di ricerca delle offerte vado ad aggiungere alla query di prima
        // la condizione WHERE, che permette di filtrare le offerte in base al nome che ho digitato nella barra di ricerca
        if ($request->has("promoSearchQuery"))
            $promoQuery = $promoQuery->where('nome', 'LIKE', '%' . $request->input("promoSearchQuery") . '%');
        // ottengo le tuple dal database
        $promo = $promoQuery->get();

        // anche qui, stesso discorso delle offerte
        $clienteQuery = User::select('username', 'nome', 'cognome')->where('livello', 1);
        if ($request->has("clienteSearchQuery"))
            $clienteQuery = $clienteQuery->where('username', 'LIKE', '%' . $request->input('clienteSearchQuery') . '%');
        $clienti = $clienteQuery->get();

        // ottengo il numero di coupon totali che sono stati generati
        $couponNum = Coupon::count();

        // ritorno la view con tutti i dati che servono
        return view("admin/statistiche", ["Promo" => $promo, "Clienti" => $clienti, "NumeroCoupon" => $couponNum]);
    }
}
