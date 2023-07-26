<?php

use App\Http\Controllers\CatalogoController;
use App\Http\Controllers\FactoryController;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\OfferController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

/*
 * ROTTE DI LIVELLO 0
 */

// Rotta per il caricamento della home page.
Route::get('/', [HomeController::class, 'index'])
    ->name('homepage');

// Rotta per il caricamento della lista delle aziende.
Route::get("/aziende", [FactoryController::class, 'getDataA'])
    ->name("aziende");
// Rotta per la ricerca di un'azienda dalla barra di ricerca apposita.
Route::post('/aziende', [FactoryController::class, 'getDataBR']);

// Rotta per il caricamento della pagina dei dettagli di un'azienda.
Route::get("/dettagliAzienda/{id}", [FactoryController::class, 'getDataDA'])
    ->name('dettagliAzienda');

// Rotta per il caricamento del catalogo corredato di lista delle offerte.
Route::get('/catalogo', [CatalogoController::class, 'getDataC'])
    ->name('catalogo');
Route::post('/catalogo', [CatalogoController::class, 'getDataBR']);

// Rotta per il caricamento della pagina dei dettagli di un'offerta selezionata.
Route::get("/dettagliOfferta/{id}", [OfferController::class, 'getDataDO'])
    ->name("dettagliOfferta");

/*
 * ROTTA PER L'HUB UTENTE, accedibile indipendentemente dal livello di utenza.
 */
Route::middleware('auth')->group(function() {
    Route::view("/hubUtente", 'hubUtente')
        ->name("hubUtente");
});

// Inclusione delle Routes per il login e per le aree dedicate a Clienti, Staff e Amministratore
require __DIR__.'/auth.php';
require __DIR__.'/customer.php';
require __DIR__.'/staff.php';
require __DIR__ . '/admin.php';
