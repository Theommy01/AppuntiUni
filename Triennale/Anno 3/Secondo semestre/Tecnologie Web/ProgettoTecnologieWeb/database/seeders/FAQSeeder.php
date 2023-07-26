<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

// Seeder per la tabella FAQ.
class FAQSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Creazione tabella FAQs.
        DB::table('faqs') -> insert([
            [
                'id' => NULL,
                'usernameCreatore' => 'adminadmin',
                'domanda' => 'Come faccio ad applicare un coupon?',
                'risposta' => 'È sufficiente selezionare l\'offerta desiderata e cliccare sul tasto Genera coupon.
                               Per poter usufruire dei coupon è necessario aver effettuato il login (quindi essere
                               registrati sul nostro sito!)'
            ],
            [
                'id' => NULL,
                'usernameCreatore' => 'adminadmin',
                'domanda' => "L'uso di Offertopoli è gratuito oppure è necessario pagare un abbonamento per usare i coupon?",
                'risposta' => 'Si, Offertopoli è gratuito, tutti i coupon contenuti sono liberamente e gratuitamente utilizzabili.'
            ]
        ]);
    }
}
