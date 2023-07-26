<?php

namespace App\Http\Controllers;

use App\Models\Offer;
use App\Models\User;
use Illuminate\Http\Request;
use App\Models\Factory;
use Illuminate\Support\Carbon;
use Illuminate\Support\Facades\DB;
use Illuminate\Validation\Rule;

class FactoryController extends Controller
{
    // Ottenimento lista di Aziende
    function getDataA()
    {
        $data = Factory::paginate(12);
        return view('aziende', ['Aziende'=>$data]);
    }

    // Ottenimento Dettagli Azienda
    public function getDataDA($id)
    {
        $data = Factory::where('id', $id)->first();
        return view('dettagliAzienda', ['tuple'=>$data]);
    }

    // Ottenimento aziende in base alla query scritta nella Barra Ricerca
    public function getDataBR(Request $request)
    {
        $query = $request->input('query');
        $dataNO = Factory::where('nome', 'LIKE', '%' .$query. '%')->paginate(12);
        return view('aziende', ['Aziende' => $dataNO, 'searchQuery' => $query]);
    }

    // Ottenimento lista COMPLETA e non impaginata delle Aziende, per la Gestione Aziende
    function getDataGA()
    {
        $data = Factory::all();
        return view('admin/gestioneAziende', ['List'=>$data]);
    }

    // Ottenimento aziende filtrate secondo la query digitata nella Barra di Ricerca in Gestione Aziende
    function getDataBRGA(Request $request)
    {
        $data = Factory::all();
        $query = $request->input('query');
        $dataN = Factory::where('nome', 'LIKE', '%' .$query. '%')->get();
        return view('admin/gestioneAziende', ['Azienda'=>$data], ['List'=>$dataN]);
    }

    // Cancellazione azienda
    function deleteA($id)
    {
        // Trova la riga nel database
        // Elimina la riga
        DB::table('aziende')->where('id', $id)->delete();

        // Esempio di reindirizzamento alla pagina principale
        return redirect()->route('gestioneAziende');
    }

    // Aggiunta azienda
    function addAzienda(Request $request){
        //Controlla se i campi sono stati compilati correttamente
        $request->validate([
            'nome' => ['required','string','max:40', 'unique:aziende'],
            'tipologia' => ['required','string','max:30'],
            'descrizione' => ['required','string'],
            'localizzazione' => ['required','string'],
            'ragioneSociale' => ['required', 'string','max:50'],
            'logo' => ['required', 'file', 'mimes:png,jpg,jpeg,bin', 'max:1024']
        ]);

        $admin = User::where('livello', 3)->first();
        //recupera il file inviato con una richiesta
        $immagine = $request->file('logo');
        //legge il contenuto come binario
        $logo = file_get_contents($immagine);

        $factory = new Factory();
        $factory['nome'] = $request->input('nome');
        $factory['tipologia'] = $request->input('tipologia');
        $factory['descrizione'] = $request->input('descrizione');
        $factory['localizzazione'] = $request->input('localizzazione');
        $factory['logo'] = $logo;
        $factory['ragioneSociale'] = $request->input('ragioneSociale');
        $factory['managerUsername'] = $admin['username'];
        $factory->save();

        return redirect()->route('gestioneAziende');
    }

    // Ottiene i dati di un'Azienda specifica, per la pagina di modifica di un'Azienda
    function getDataSingleAzienda($id){
        $data = Factory::where('id', $id)->first();
        return view('admin/aggiornaAziende', ['dati'=>$data]);
    }

    // Modifica i dati di una singola azienda
    function updateDataSingleAzienda(Request $request, $id)
    {
        // Controlla se i campi sono stati compilati correttamente
        $request->validate([
            'nome' => ['required','string','max:40',
                //regola di validazione che verifica l'unicità del valore del campo rispetto ai dati presenti nella tabella,
                //escludendo l'ID
                Rule::unique('aziende')->ignore($id)],
            'tipologia' => ['required','string','max:30'],
            'descrizione' => ['required','string'],
            'ragioneSociale' => ['required', 'string','max:50']
        ]);

        if (!$request->file('logo'))
        {
            Factory::where('id', $id)->update(
                [
                    'nome'=>$request->input('nome'),
                    'descrizione'=>$request->input('descrizione'),
                    'tipologia'=>$request->input('tipologia'),
                    'ragioneSociale'=>$request->input('ragioneSociale'),
                    'localizzazione' => $request->input('localizzazione')
                ]);
        }
        else
        {
            // Controlla se i campi sono stati compilati correttamente
            $request->validate([
                'logo' => ['required','file','mimes:jpg,jpeg,png,bin', 'max:1024'],
            ]);

            $immagine = $request->file('logo');
            $logo = file_get_contents($immagine);

            Factory::where('id', $id)->update(
                [
                    'nome'=>$request->input('nome'),
                    'descrizione'=>$request->input('descrizione'),
                    'tipologia'=>$request->input('tipologia'),
                    'ragioneSociale'=>$request->input('ragioneSociale'),
                    'localizzazione' => $request->input('localizzazione'),
                    'logo'=>$logo
                ]);
        }

        return redirect()->route('gestioneAziende');
    }
}
