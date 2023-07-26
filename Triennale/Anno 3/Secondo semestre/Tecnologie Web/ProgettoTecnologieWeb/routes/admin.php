<?php

use App\Http\Controllers\FactoryController;
use App\Http\Controllers\FAQController;
use App\Http\Controllers\StatsController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

/*
 * ROTTE DI LIVELLO 3
 */
Route::group(['middleware' => 'can:isAdmin'],function () {
    // Rotta per l'apertura della pagina del gestionale delle FAQ.
    Route::get("/gestioneFAQ", [FAQController::class, 'getData'])
        ->name("gestioneFAQ");

    // Rotta per l'apertura della pagina per inserire una nuova FAQ.
    Route::view("/inserisciFAQ", 'admin/inserisciFAQ')
        ->name('inserisciFAQ');
    // Rotta per inserire la FAQ.
    Route::post('/inserisciFAQ', [FAQController::class, 'addFAQ']);

    // Rotta per l'apertura della pagina per la modifica di una FAQ.
    Route::get('/aggiornaFAQ/{id}/edit', [FAQController::class, 'getDataSingleFAQ'])
        ->name('aggiornaFAQ');
    // Rotta per la modifica di una determinata FAQ.
    Route::put('/aggiornaFAQ/{id}', [FAQController::class, 'updateDataSingleFAQ']);

    // Rotta per cancellare una determinata FAQ.
    Route::delete("/gestioneFAQ/elimina/{id}", [FAQController::class, 'deleteR'])
        ->name("eliminaFAQ");

    // Rotta per l'apertura della pagina per la cancellazione di un cliente.
    Route::get("/cancellazioneClienti", [UserController::class, 'getDataClienti'])
        ->name("cancellazioneClienti");
    // Rotta che ricerca un cliente.
    Route::post('/cancellazioneClienti', [UserController::class, 'getDataBRCC']);
    // Rotta che elimina un cliente specifico.
    Route::delete('cancellazioneClienti/{username}', [UserController::class, 'deleteC'])
        ->name('eliminaClienti');

    // Rotta che apre la pagina per la gestione dello staff.
    Route::get("/gestioneStaff", [UserController::class, 'getDataGS'])
        ->name("gestioneStaff");
    // Rotta che ricerca un membro dello staff.
    Route::post('/gestioneStaff', [UserController::class, 'getDataBRGS']);

    // Rotta che apre la pagina per inserire un nuovo membro dello staff.
    Route::view("/inserisciStaff", 'admin/inserisciStaff')
        ->name('inserisciStaff');
    // Rotta che inserisce lo staff.
    Route::post('/inserisciStaff', [UserController::class, 'addStaff']);

    // Rotta che apre la pagina per aggiornare un membro dello staff.
    Route::get('/aggiornaStaff/{username}/edit', [UserController::class, 'getDataSingleStaff'])
        ->name('aggiornaStaff');
    // Rotta che aggiorna effettivamente il membro dello staff.
    Route::put('/aggiornaStaff/{username}', [UserController::class, 'updateDataSingleStaff']);

    // Rotta che elimina un determinato membro dello staff.
    Route::delete("/gestioneStaff/elimina/{username}", [UserController::class, 'deleteS'])
        ->name("eliminaStaff");

    // Rotta che apre la pagina per la gestione delle aziende.
    Route::get("/gestioneAziende", [FactoryController::class, 'getDataGA'])
        ->name("gestioneAziende");
    // Rotta che ricerca un'azienda da gestire.
    Route::post('/gestioneAziende', [FactoryController::class, 'getDataBRGA']);

    // Rotta che apre la pagina per l'inserimento di una nuova azienda.
    Route::view("/inserisciAziende", 'admin/inserisciAziende')
        ->name('inserisciAziende');
    // Rotta che aggiunge un'azienda.
    Route::post('/inserisciAziende', [FactoryController::class, 'addAzienda']);

    // Rotta che apre la pagina per modificare un'azienda.
    Route::get('/aggiornaAziende/{id}/edit', [FactoryController::class, 'getDataSingleAzienda'])
        ->name('aggiornaAziende');
    // Rotta che modifica un'azienda.
    Route::put('/aggiornaAziende/{id}', [FactoryController::class, 'updateDataSingleAzienda']);

    // Rotta che elimina un'azienda.
    Route::delete("/gestioneAziende/elimina/{id}", [FactoryController::class, 'deleteA'])
        ->name("eliminaAziende");

    // Rotta che carica la pagina delle statistiche.
    Route::get("/statistiche", [StatsController::class, 'getData'])
        ->name('statistiche');

    // Rotta che filtra gli utenti e le offerte nelle statistiche.
    Route::post("/statistiche", [StatsController::class, 'getDataBR'])
        ->name('statistiche.ricerca');

    // Rotta che restituisce un JSON che indica il numero di coupon emessi da un'offerta
    Route::post('/statistiche/offerta', [StatsController::class, 'getOffertaCoupons'])
        ->name('statistiche.offerta');

    // Rotta che restituisce un JSON che indica il numero di coupon emessi per un utente
    Route::post('/statistiche/cliente', [StatsController::class, 'getClienteCoupons'])
        ->name('statistiche.cliente');
});
