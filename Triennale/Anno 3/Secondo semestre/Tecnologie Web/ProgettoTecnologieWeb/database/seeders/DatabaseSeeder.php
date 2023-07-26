<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        // Richiamo i Seeder che ho definito nella cartella seeders.
        $this->call([
            UsersSeeder::class,
            FactoriesSeeder::class,
            OffersSeeder::class,
            FAQSeeder::class,
        ]);
    }
}
