<?php

namespace App\Http\Controllers;

use App\Models\Factory;
use Illuminate\Http\Request;
use App\Models\Offer;
use Illuminate\Support\Facades\Date;
use Illuminate\Validation\Rule;

class OfferController extends Controller
{
    // Ottenimento Dettagli di un'Offerta
    function getDataDO($id)
    {
        $data = Offer::where('id', $id)->first();
        return view('dettagliOfferta', ['tuple'=>$data]);
    }

    // Ottenimento lista completa delle Offerte
    function getDataOff()
    {
        $data = Offer::all();
        return view('staff/gestioneOfferte', ['List'=>$data]);
    }

    // Ottenimento offerte filtrate in base alla query scritta nella Barra di Ricerca in Gestione Offerte
    public function getDataBRGO(Request $request)
    {
        $query = $request->input('query');
        $dataNO = Offer::where('nome', 'LIKE', '%' .$query. '%')->get();
        return view('staff/gestioneOfferte', ['List'=>$dataNO]);
    }

    // Cancellazione Record di un'Offerta
    function deleteR($id)
    {
        // Trova la riga nel database
        $row = Offer::findOrFail($id);

        // Elimina la riga
        $row->delete();

        // Esempio di reindirizzamento alla pagina principale
        return redirect()->route('gestioneOfferte')->with('message', 'Offerta eliminata con successo.');
    }

    // Aggiunta di un'Offerta
    function addOff(Request $request)
    {
        // Controlla se i campi sono stati compilati correttamente
        $request->validate([
            'nome' => ['required','string','max:70', 'unique:offerte'],
            'dataOraScadenza' => ['required', 'after:'.Date::now('Europe/Rome')],
            'immagine' => ['required','file','mimes:jpg,jpeg,png,bin','max:1024']
        ]);

        $off = new Offer();
        if ($request->input('idAzienda') == "NULL")
        {
            $azienda = Factory::first();
        }
        else
        {
            $nomeA = $request->input('idAzienda');
            $azienda = Factory::where('nome', $nomeA)->first();
        }

        $off['idAzienda'] = $azienda['id'];
        $off['nome'] = $request->input('nome');
        $off['oggetto'] = $request->input('oggetto');
        $off['modalitaFruizione'] = $request->input('modalitaFruizione');
        $off['dataOraScadenza'] = $request->input('dataOraScadenza');
        $off['luogoFruizione'] = $request->input('luogoFruizione');
        $img = $request->file('immagine');
        $immagine = file_get_contents($img);
        $off['immagine'] = $immagine;
        $off->save();

        return redirect()->route('gestioneOfferte');
    }

    // Apre la pagina di inserimento di un'Offerta, comprensiva dell'elenco delle Aziende.
    function getInsertOfferPage()
    {
        $data = Factory::orderBy('id', 'asc')->get();
        return view('staff/inserisciOfferte', ['ListaNomi'=>$data]);
    }

    // Ottiene i dati di una specifica Offerta, usata per la pagina Modifica Offerta.
    // Viene corredata anche della lista di Aziende.
    function getDataSingleOff($id)
    {
        $dataAziende = Factory::orderBy('id' , 'asc')->get();
        $data = Offer::where('id', $id)->first();
        return view('staff/aggiornaOfferte', ['dati'=>$data], ['ListaNomi'=>$dataAziende]);
    }

    // Modifica una specifica Offerta.
    function updateDataSingleOff(Request $request, $id)
    {
        // Controlla se i campi sono stati compilati correttamente
        $request->validate([
            'nome' => ['required','string','max:70',
                Rule::unique('offerte')->ignore($id)],
            'dataOraScadenza' => ['required', 'after:'.Date::now('Europe/Rome')]
        ]);

        if (!$request->file('immagine'))
        {
            if ($request->input('idAzienda')=="NULL")
            {
                Offer::where('id', $id)->update(
                    [
                        'nome'=>$request->input('nome'),
                        'oggetto'=>$request->input('oggetto'),
                        'modalitaFruizione'=>$request->input('modalitaFruizione'),
                        'luogoFruizione'=>$request->input('luogoFruizione'),
                        'dataOraScadenza'=>$request->input('dataOraScadenza')
                    ]);
            }
            else
            {
                Offer::where('id', $id)->update(
                    [
                        'idAzienda' => $request->input('idAzienda'),
                        'nome'=>$request->input('nome'),
                        'oggetto'=>$request->input('oggetto'),
                        'modalitaFruizione'=>$request->input('modalitaFruizione'),
                        'luogoFruizione'=>$request->input('luogoFruizione'),
                        'dataOraScadenza'=>$request->input('dataOraScadenza')
                    ]);
            }
        }
        else
        {
            $request->validate([
                'immagine' => ['required','file','mimes:jpg,jpeg,png,bin','max:1024'],
            ]);

            $img = $request->file('immagine');
            $immagine = file_get_contents($img);

            if ($request->input('idAzienda')=="NULL")
            {
                Offer::where('id', $id)->update(
                    [
                        'nome'=>$request->input('nome'),
                        'oggetto'=>$request->input('oggetto'),
                        'modalitaFruizione'=>$request->input('modalitaFruizione'),
                        'luogoFruizione'=>$request->input('luogoFruizione'),
                        'dataOraScadenza'=>$request->input('dataOraScadenza'),
                        'immagine'=>$immagine
                    ]);
            }
            else
            {
                Offer::where('id', $id)->update(
                    [
                        'idAzienda'=>$request->input('idAzienda'),
                        'nome'=>$request->input('nome'),
                        'oggetto'=>$request->input('oggetto'),
                        'modalitaFruizione'=>$request->input('modalitaFruizione'),
                        'luogoFruizione'=>$request->input('luogoFruizione'),
                        'dataOraScadenza'=>$request->input('dataOraScadenza'),
                        'immagine'=>$immagine
                    ]);
            }
        }
        return redirect()->route('gestioneOfferte');
    }
}
