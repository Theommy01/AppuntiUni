<?php

use App\Http\Controllers\CouponController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

/*
 * ROTTE DI LIVELLO 1
 */
Route::group(['middleware' => 'can:isUser'], function() {
    // Rotta per mostrare la pagina stampabile del coupon.
    Route::get("/coupon/{idOfferta}", [CouponController::class, 'getDataOC'])
        ->name("coupon");
    // Rotta per il salvataggio del coupon nel DB
    Route::post("/inserisciCoupon/{idOfferta}", [CouponController::class, 'saveDataC']);

    // Rotta per accedere alla modifica dei dati personali (livello 1).
    Route::get('/modificaDatiL1/edit', [UserController::class, 'getDatiPersonali1'])
        ->name('modificaDatiL1');
    // Rotta che aggiorna i dati.
    Route::put('/modificaDatiL1', [UserController::class, 'updateDatiPersonali1']);

    // Rotta che ti fa visualizzare i coupon utilizzati
    Route::get("/listaCouponUsati", [CouponController::class, 'getDataLCU'])
        ->name("listaCouponUsati");
    // Rotta per ricercare i coupon
    Route::post('/listaCouponUsati', [CouponController::class, 'getDataBRCU']);
});
