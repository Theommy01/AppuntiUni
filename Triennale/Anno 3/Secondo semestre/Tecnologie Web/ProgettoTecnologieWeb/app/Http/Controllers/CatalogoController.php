<?php

namespace App\Http\Controllers;

use App\Models\Offer;
use Illuminate\Http\Request;
use Illuminate\Support\Carbon;

class CatalogoController extends Controller
{
    // Ottiene tutte le offerte (assieme alle aziende a cui appartengono) per il Catalogo.
    function getDataC()
    {
        // Ordino la lista di offerte in base all'ID dell'azienda, questo per far si che le offerte della stessa azienda
        // compaiano tutte di seguito.
        // NOTA - Carbon è una libreria che si usa per migliorare la gestione delle date/ore in PHP e Laravel.
        $dataAO = Offer::select('offerte.id as idOfferta', 'offerte.nome as nomeOfferta', 'offerte.oggetto as oggettoOfferta',
            'offerte.immagine as immagineOfferta', 'aziende.logo as logoAzienda')
            ->join("aziende", "offerte.idAzienda", "=", "aziende.id")
            ->where('offerte.dataOraScadenza', '>', Carbon::now('Europe/Rome')->format('Y-m-d H:i:s'))
            ->orderBy('aziende.id')->paginate(9);

        return view('catalogo', ['Offerte'=>$dataAO]);
    }

    // BR = Barra Ricerca
    public function getDataBR(Request $request)
    {
        // Query di base per ottenere la lista di offerte e le aziende che le pubblicano
        $dbQuery = Offer::select('offerte.id as idOfferta', 'offerte.nome as nomeOfferta', 'offerte.oggetto as oggettoOfferta',
                                'offerte.immagine as immagineOfferta', 'aziende.logo as logoAzienda')
                        ->join("aziende", "offerte.idAzienda", "=", "aziende.id");
        // Questo è l'array che contiene i dati che vengono inviati alla View
        $viewData = Array();

        // Query di ricerca per Azienda e Offerta
        $factoryQuery = $request->input("factory_query");
        $offerQuery = $request->input("offer_query");

        // Se nella barra di ricerca per Azienda ho scritto qualcosa, ergo faccio una ricerca per Azienda...
        if ($factoryQuery != null)
        {
            // aggiungo la parte di query che mi permette di filtrare le offerte per nome/descrizione
            $dbQuery->where("aziende.nome", "LIKE", "%" . $factoryQuery . "%");
            // aggiungo la query usata per la ricerca nell'array
            $viewData['FactoryQuery'] = $factoryQuery;
        }

        // Se nella barra di ricerca per Offerta ho scritto qualcosa, ergo faccio una ricerca per contenuto Offerta...
        if ($offerQuery != null)
        {
            // NOTA - uso questa notazione per l'espressione WHERE perchè ho bisogno di metterla all'interno di parentesi
            // tonde, per evitare problemi con la query
            // Output finale: SELECT * FROM Offerte WHERE (nome LIKE %% OR oggetto LIKE %%);
            $dbQuery = $dbQuery->where(function($dbQuery) use ($offerQuery) {
                $dbQuery->where('offerte.nome', 'LIKE', '%' . $offerQuery . '%')
                    ->orWhere('offerte.oggetto', 'LIKE', '%' . $offerQuery . '%');
            });

            $viewData["OfferQuery"] = $offerQuery;
        }

        // Eseguo la query e inserisco il risultato all'interno dell'array
        $offerList = $dbQuery->where('offerte.dataOraScadenza', '>', now())->orderBy('aziende.id')->paginate(9);
        $viewData["Offerte"] = $offerList;

        // Ritorno la View con i dati inseriti nell'array, che verranno visualizzati sulla View stessa.
        return view("catalogo", $viewData);
    }
}
