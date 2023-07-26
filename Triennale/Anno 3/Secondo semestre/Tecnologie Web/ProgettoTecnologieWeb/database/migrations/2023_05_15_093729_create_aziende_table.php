<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('aziende', function (Blueprint $table) {
            // Primary key auto-incrementata della tabella.
            $table->bigIncrements('id');

            $table->string('managerUsername', 30); // foreign key -> punta a Utenti(username)
            $table->text('descrizione');
            $table->text('localizzazione');
            $table->string('nome', 40)->unique();
            $table->string('ragioneSociale', 50)->unique();
            $table->string('tipologia', 30);

            // definizione del vincolo di FK
            $table->foreign('managerUsername')->references('username')->on('utenti')
                ->onDelete('cascade')->onUpdate('cascade');
        });

        // aggiungo qua il logo perchè Eloquent non supporta il tipo LONGBLOB direttamente. Per poter aggiungere un
        // oggetto di tipo LONGBLOB (che ci serve per memorizzare le immagini, essendo queste troppo grandi per poter
        // essere memorizzate su un BLOB standard) vado, una volta creata, a modificare la tabella aggiungendole l'
        // attributo di tipo LONGBLOB
        DB::statement("ALTER TABLE aziende ADD logo LONGBLOB");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('aziende');
    }
};
