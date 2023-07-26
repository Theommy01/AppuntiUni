<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use App\Models\FAQ;
use Illuminate\Validation\Rule;

class FAQController extends Controller
{
    // Ottiene l'intera lista di FAQ, utilizzata per la pagina di Gestione FAQ
    function getData()
    {
        $data = FAQ::all();
        return view('admin/gestioneFAQ', ['List'=>$data]);
    }

    // Cancellazione di un Record di FAQ
    function deleteR($id)
    {
        // Trova la riga nel database
        $row = FAQ::findOrFail($id);

        // Elimina la riga
        $row->delete();

        // Esempio di reindirizzamento alla pagina principale
        return redirect()->route('gestioneFAQ');
    }

    // Aggiunta di una FAQ
    function addFAQ(Request $request){
        // Validazione dei dati inviati nella form
        $request->validate([
            'domanda' => ['required','string','max:300', 'unique:faqs'],
            'risposta' => ['required','string','max:300', 'unique:faqs']
        ]);

        $faq = new FAQ;
        $root = User::where('livello', 3)->first();

        $faq['domanda'] = $request->input('domanda');
        $faq['risposta'] = $request->input('risposta');
        $faq['usernameCreatore'] = $root['username'];
        $faq->save();

        return redirect()->route('gestioneFAQ');
    }

    // Ottenimento dettagli di una FAQ specifica, utilizzata per la pagina Modifica FAQ
    function getDataSingleFAQ($id){
        $data = FAQ::where('id', $id)->first();
        return view('admin/aggiornaFAQ', ['dati'=>$data]);
    }

    // Modifica una FAQ precisa.
    function updateDataSingleFAQ(Request $request, $id)
    {
        // Validazione dei dati inviati nella form
        $request->validate([
            'domanda' => ['required','string','max:300',
                Rule::unique('faqs')->ignore($id)],
            'risposta' => ['required','string','max:300',
                Rule::unique('faqs')->ignore($id)]
        ]);

        $record = FAQ::where('id', $id)->first();
        $record['domanda'] = $request->input('domanda');
        $record['risposta'] = $request->input('risposta');
        $record->update();

        return redirect()->route('gestioneFAQ');
    }
}
