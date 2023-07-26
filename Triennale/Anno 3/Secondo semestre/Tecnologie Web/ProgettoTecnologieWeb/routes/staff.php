<?php

use App\Http\Controllers\OfferController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

/*
 *  ROTTE DI LIVELLO 2
 */
Route::group(['middleware' => 'can:isStaff'],function () {
    // Rotta per aprire la pagina della modifica dei dati personali per lo Staff.
    Route::get('/modificaDatiL2/edit', [UserController::class, 'getDatiPersonali2'])
        ->name('modificaDatiL2');
    // Rotta che aggiorna i dati.
    Route::put('/modificaDatiL2', [UserController::class, 'updateDatiPersonali2']);

    // Rotta per aprire la pagina per inserire una nuova offerta.
    Route::get("/inserisciOfferte", [OfferController::class, 'getInsertOfferPage'])
        ->name('inserisciOfferte');
    // Rotta per inserire una nuova offerta.
    Route::post('/inserisciOfferte', [OfferController::class, 'addOff']);

    // Rotta che apre la pagina per modificare un'offerta selezionata.
    Route::get('/aggiornaOfferte/{id}/edit', [OfferController::class, 'getDataSingleOff'])
        ->name('aggiornaOfferte');
    // Rotta che aggiorna una determinata offerta.
    Route::put('/aggiornaOfferte/{id}', [OfferController::class, 'updateDataSingleOff']);

    // Rotta per aprire la pagina della gestione delle offerte.
    Route::get("/gestioneOfferte", [OfferController::class, 'getDataOff'])
        ->name("gestioneOfferte");
    // Rotta per la ricerca di un'offerta dall'apposito gestionale.
    Route::post('/gestioneOfferte', [OfferController::class, 'getDataBRGO']);

    // Rotta che elimina una determinata offerta.
    Route::delete("/gestioneOfferte/elimina/{id}", [OfferController::class, 'deleteR'])
        ->name("eliminaOfferte");
});
