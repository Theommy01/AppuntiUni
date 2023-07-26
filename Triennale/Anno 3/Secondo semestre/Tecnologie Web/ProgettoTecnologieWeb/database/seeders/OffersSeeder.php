<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

// Seeder per la tabella Offerte.
class OffersSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Per caricare le immagini varie, ho bisogno di caricarle dal progetto.
        // Verranno poi trasformate in BLOB binari successivamente all'inserimento nel database.
        $huaweiOffer1 = file_get_contents(base_path("database/data/offer_huawei_1.jpeg"));
        $huaweiOffer2 = file_get_contents(base_path("database/data/offer_huawei_2.jpg"));
        $samsungOffer1 = file_get_contents(base_path("database/data/offer_samsung_1.jpeg"));
        $samsungOffer2 = file_get_contents(base_path("database/data/offer_samsung_2.jpg"));
        $justEatOffer = file_get_contents(base_path("database/data/offer_just_eat.jpeg"));
        $dysonOffer = file_get_contents(base_path("database/data/offer_dyson.webp"));
        $appleOffer = file_get_contents(base_path("database/data/offer_apple.jpeg"));
        $epicGamesOffer = file_get_contents(base_path("database/data/offer_epicgames.png"));
        $myproteinOffer = file_get_contents(base_path("database/data/offer_myprotein.jpg"));
        $nikeOffer = file_get_contents(base_path("database/data/offer_nike.jpg"));

        // Creazione tabella Offerte
        DB::table('offerte') -> insert([
            [
                'id' => NULL,
                'idAzienda' => 1,
                'nome' => '30% di sconto per 2 ordini',
                'oggetto' => 'Ottieni il 30% di sconto sul totale dei prossimi 2 ordini - Solo da Just Eat!',
                'modalitaFruizione' => "Inserire il codice del coupon nella sezione Inserisci sconto al momento dell'ordine sull'app.",
                'luogoFruizione' => "Utilizzabile solo sull'app Just Eat.",
                'dataOraCreazione' => '2023-03-20 10:00:00',
                'dataOraScadenza' => '2024-01-01 10:15:00',
                'immagine' => $justEatOffer
            ],
            [
                'id' => NULL,
                'idAzienda' => 2,
                'nome' => 'Huawei P60 a prezzo stracciato!',
                'oggetto' => 'Ottieni il nuovo Huawei P60 scontato del 35%!',
                'modalitaFruizione' => 'Mostrare il codice generato dal coupon alla cassa al momento del pagamento.',
                'luogoFruizione' => 'Presso negozi e punti vendita certificati Huawei.',
                'dataOraCreazione' => '2023-01-01 09:00:00',
                'dataOraScadenza' => '2024-01-01 10:15:00',
                'immagine' => $huaweiOffer1
            ],
            [
                'id' => NULL,
                'idAzienda' => 6,
                'nome' => '-50% sui laptop Samsung',
                'oggetto' => 'Affrettati per ricevere il 50% di sconto sui laptop Samsung!',
                'modalitaFruizione' => 'Scrivi il codice generato dal coupon nella apposita sezione al termine dell\'acquisto di un prodotto.',
                'luogoFruizione' => 'Presso i negozi certificati Samsung online.',
                'dataOraCreazione' => '2023-01-10 02:00:00',
                'dataOraScadenza' => '2023-09-30 12:00:00',
                'immagine' => $samsungOffer1
            ],
            [
                'id' => NULL,
                'idAzienda' => 6,
                'nome' => 'Galaxy S23 Ultra a soli 899€',
                'oggetto' => 'Samsung propone uno sconto esclusivo per un prodotto sbalorditivo!',
                'modalitaFruizione' => 'Inserisci questo coupon al termine dell\'ordine del nuovo Galaxy S23 Ultra.',
                'luogoFruizione' => 'Fruibile solamente online presso lo shop ufficiale samsung.com.',
                'dataOraCreazione' => '2023-03-18 05:00:00',
                'dataOraScadenza' => '2023-11-30 12:00:00',
                'immagine' => $samsungOffer2
            ],
            [
                'id' => NULL,
                'idAzienda' => 7,
                'nome' => '2 aspirapolveri al prezzo di 1',
                'oggetto' => 'Incredibile offerta di Dyson per i nuovi aspirapolveri V8 e V10',
                'modalitaFruizione' => 'Inserire il codice del coupon nella sezione Inserisci sconto nei siti online o mostrare il codice alla cassa se utilizzato nei negozi fisici.',
                'luogoFruizione' => 'Promozione utilizzabile nei negozi fisici e online certificati Dyson.',
                'dataOraCreazione' => '2023-02-01 00:00:00',
                'dataOraScadenza' => '2023-10-30 23:30:00',
                'immagine' => $dysonOffer
            ],
            [
                'id' => NULL,
                'idAzienda' => 2,
                'nome' => 'Huawei Matebook a soli 600 euro!',
                'oggetto' => 'In esclusiva, Huawei propone il Matebook con schermo da 14" e i5 di 11a generazione ad un prezzo bomba!',
                'modalitaFruizione' => 'Mostrare il codice generato dal coupon alla cassa al momento del pagamento.',
                'luogoFruizione' => 'Presso negozi e punti vendita certificati Huawei.',
                'dataOraCreazione' => '2023-01-01 09:00:00',
                'dataOraScadenza' => '2024-01-01 10:15:00',
                'immagine' => $huaweiOffer2
            ],
            [
                'id' => NULL,
                'idAzienda' => 4,
                'nome' => 'Sconto di 170 euro per i nuovi iPhone',
                'oggetto' => 'Acquista i nuovi iPhone 14 e ricevi 170 euro di sconto',
                'modalitaFruizione' => 'Scrivi il codice generato dal coupon nella apposita sezione al termine dell\'acquisto di un prodotto.',
                'luogoFruizione' => 'Utilizzabile solo nel sito Apple online.',
                'dataOraCreazione' => '2023-06-05 09:00:00',
                'dataOraScadenza' => '2024-01-01 00:00:00',
                'immagine' => $appleOffer
            ],
            [
                'id' => NULL,
                'idAzienda' => 9,
                'nome' => '4000 V-bucks a soli 30€',
                'oggetto' => 'Offerta interessantissima da Epic Games per l\'accesso a 4000 V-bucks ad un prezzo incredibile',
                'modalitaFruizione' => 'Inserisci questo coupon nello store di Fornite o nel launcher di Epic Games.',
                'luogoFruizione' => 'Online presso il launcher Epic Games o presso lo store di Fortnite',
                'dataOraCreazione' => '2023-06-01 14:30:00',
                'dataOraScadenza' => '2023-12-25 00:00:00',
                'immagine' => $epicGamesOffer
            ],
            [
                'id' => NULL,
                'idAzienda' => 11,
                'nome' => 'Bundle cibo proteico a soli 30€',
                'oggetto' => 'Barrette e frutta secca proteica in sconto solo per te',
                'modalitaFruizione' => 'Inserisci questo coupon nello store online di MyProtein.',
                'luogoFruizione' => 'Online presso lo store ufficiale MyProtein. Non utilizzabile su store terzi.',
                'dataOraCreazione' => '2023-01-01 10:30:00',
                'dataOraScadenza' => '2023-06-04 01:00:00',
                'immagine' => $myproteinOffer
            ],
            [
                'id' => NULL,
                'idAzienda' => 12,
                'nome' => 'Nike Air Max Ltd 3 a soli 99€',
                'oggetto' => 'Nike propone scottante sconto per i clienti Offertopoli',
                'modalitaFruizione' => 'Presenta questo codice nei negozi ufficiali Nike per ricevere le nuovissime Nike Air Max limited ad un prezzo bomba',
                'luogoFruizione' => 'Utilizzabile solamente nei negozi fisici Nike. Non utilizzabile nei negozi terzi e rivenditori Nike.',
                'dataOraCreazione' => '2023-01-01 14:30:00',
                'dataOraScadenza' => '2023-06-30 13:00:00',
                'immagine' => $nikeOffer
            ]
        ]);
    }
}
