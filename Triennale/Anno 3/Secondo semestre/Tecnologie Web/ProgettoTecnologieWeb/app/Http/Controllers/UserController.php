<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Date;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rule;

class UserController extends Controller
{
    // ottiene la lista di clienti secondo la query di ricerca scritta nella Barra di Ricerca in Cancellazione Clienti
    public function getDataBRCC(Request $request)
    {
        $query = $request->input('query');
        $dataUN = User::where('username', 'LIKE', '%' .$query. '%')
            ->where('livello', 1)
            ->get();

        return view('admin/cancellazioneClienti', ['List'=>$dataUN]);
    }

    // Cancellazione di un Cliente
    function deleteC($username)
    {
        //In questo caso è stata necessaria una query cruda perchè non riconosceva l'id username
        DB::table('utenti')->where('username', $username)->delete();

        // Esempio di reindirizzamento alla pagina principale
        return redirect()->route('cancellazioneClienti');
    }

    // Ottenimento lista completa dei clienti
    function getDataClienti()
    {
        $data = User::where('livello', 1)->get();
        return view('admin/cancellazioneClienti', ['List'=>$data]);
    }

    // Ottenimento lista di Staff per la pagina Gestione Staff
    function getDataGS()
    {
        $data = User::where('livello', 2)->get();
        return view('admin/gestioneStaff', ['List'=>$data]);
    }

    // Ottenimento lista di Staff filtrata in base alla query di ricerca scritta nella Barra di Ricerca in Gestione Staff
    function getDataBRGS(Request $request)
    {
        $query = $request->input('query');
        $dataUserName = User::where('username', 'LIKE', '%' .$query. '%')
            ->where('livello', 2)
            ->get();

        return view('admin/gestioneStaff', ['List'=>$dataUserName]);
    }

    // Cancellazione di uno Staff
    function deleteS($username)
    {
        // Trova la riga nel database
        // Elimina la riga
        DB::table('utenti')->where('username', $username)->delete();

        // reindirizzamento alla pagina principale
        return redirect()->route('gestioneStaff');
    }

    // Aggiunta di uno Staff
    function addStaff(Request $request){
        // Validazione dei dati inviati dalla form di registrazione
        $request->validate([
            'username' => ['required','string', 'max:30', 'unique:utenti'],
            'password' => ['required','string','min:8'],
            'nome' => ['required','string','max:20'],
            'cognome' => ['required','string','max:20'],
            'eta' => ['required', 'date_format:Y-m-d'],
            'genere' => ['required'],
            'telefono' => ['string', 'max:10'],
            'email' => ['string','email','max:30']
        ]);

        $user = new User();
        $livello = 2;

        $user['username'] = $request->input('username');
        $user['nome'] = $request->input('nome');
        $user['cognome'] = $request->input('cognome');
        $user['eta'] = $request->input('eta');
        $user['password'] = Hash::make($request->input('password'));
        $user['email'] = $request->input('email');
        $user['telefono'] = $request->input('telefono');
        $user['genere'] = $request->input('genere');
        $user['livello'] = $livello;
        $user->save();

        return redirect()->route('gestioneStaff');
    }

    // Ottenimento dei dati di uno Staff per la pagina Modifica Staff
    function getDataSingleStaff($username){
        $data = User::where('username', $username)->first();
        return view('admin/aggiornaStaff', ['dati'=>$data]);
    }

    // Modifica di uno Staff
    function updateDataSingleStaff(Request $request, $username)
    {
        // Validazione dei dati inviati dalla form di registrazione
        $request->validate([
            'nome' => ['required','string','max:20'],
            'cognome' => ['required','string','max:20'],
            'eta' => ['required', 'date_format:Y-m-d'],
            'genere' => ['required'],
            'telefono' => ['string', 'max:10'],
            'email' => ['string','email','max:30']
        ]);

        if (!($request->input('password')))
        {
            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }
        else
        {
            $request->validate([
                'password' => ['required','string','min:8']
            ]);

            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'password'=>Hash::make($request->input('password')),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }

        return redirect()->route('gestioneStaff');
    }

    // Ottenimento dati personali del Cliente, per la pagina Modifica dati personali del Cliente.
    function getDatiPersonali1(){
        $username = Auth::user()->username;
        $data = User::where('username', $username)->first();

        return view('customer/modificaDatiL1', ['dati'=>$data]);
    }

    // Modifica dei dati personali del cliente.
    function updateDatiPersonali1(Request $request)
    {
        // questo è lo username dell'utente che si è loggato
        $username = Auth::user()->username;

        // Validazione dei dati inviati dalla form di registrazione
        $request->validate([
            'nome' => ['required','string','max:20'],
            'cognome' => ['required','string','max:20'],
            'eta' => ['required', 'date_format:Y-m-d'],
            'genere' => ['required'],
            'telefono' => ['string', 'max:10'],
            'email' => ['string','email','max:30']
        ]);

        if (!($request->input('password')))
        {
            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }
        else
        {
            $request->validate([
                'password' => ['required','string','min:8']
            ]);
            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'password'=>Hash::make($request->input('password')),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }

        return redirect()->route('hubUtente');
    }

    // Ottenimento dati personali dello Staff, per la pagina Modifica dati personali dello Staff.
    function getDatiPersonali2(){
        $username = Auth::user()->username;
        $data = User::where('username', $username)->first();

        return view('staff/modificaDatiL2', ['dati'=>$data]);
    }

    // Modifica dei dati personali dello Staff.
    function updateDatiPersonali2(Request $request)
    {
        $username = Auth::user()->username;

        // Validazione dei dati inviati dalla form di registrazione
        $request->validate([
            'nome' => ['required','string','max:20'],
            'cognome' => ['required','string','max:20'],
            'eta' => ['required', 'date_format:Y-m-d'],
            'genere' => ['required'],
            'telefono' => ['string', 'max:10'],
            'email' => ['string','email','max:30']
        ]);

        if (!($request->input('password')))
        {
            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }
        else
        {
            $request->validate([
                'password' => ['required','string','min:8']
            ]);
            User::where('username', $username)->update(
                [
                    'nome'=>$request->input('nome'),
                    'cognome'=>$request->input('cognome'),
                    'eta'=>$request->input('eta'),
                    'password'=>Hash::make($request->input('password')),
                    'email'=>$request->input('email'),
                    'telefono'=>$request->input('telefono'),
                    'genere'=>$request->input('genere')
                ]);
        }

        return redirect()->route('hubUtente');
    }
}
