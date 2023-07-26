<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

// Seeder per il riempimento della tabella Utenti.
class UsersSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Creazione tabella Utenti.
        DB::table('utenti') -> insert([
            [
                'username' => 'adminadmin',
                'nome' => 'System',
                'cognome' => 'Administration',
                'eta' => NULL,
                'genere' => NULL,
                'livello' => 3,
                'password' => Hash::make('nFwNcJsR'),
                'telefono' => NULL,
                'email' => 'root@admin',
            ],
            [
                'username' => 'staffstaff',
                'nome' => 'Mario',
                'cognome' => 'Rossi',
                'eta' => '2001-04-24',
                'genere' => 'M',
                'livello' => 2,
                'password' => Hash::make("nFwNcJsR"),
                'telefono' => '7832891231',
                'email' => 'mariorossi99@gmail.com'
            ],
            [
                'username' => 'useruser',
                'nome' => 'Luigi',
                'cognome' => 'Verdi',
                'eta' => '2001-04-29',
                'genere' => 'M',
                'livello' => 1,
                'password' => Hash::make("nFwNcJsR"),
                'telefono' => '21635761',
                'email' => 'giannylay@hotmail.it'
            ]
        ]);
    }
}
