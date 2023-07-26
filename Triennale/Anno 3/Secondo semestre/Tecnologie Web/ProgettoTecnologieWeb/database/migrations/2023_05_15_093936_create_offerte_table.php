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
        Schema::create('offerte', function (Blueprint $table) {
            // Primary key auto-incrementale della tabella.
            $table->bigIncrements('id');

            $table->bigInteger('idAzienda')->unsigned();    // foreign key -> punta a Aziende(id)
            $table->string('nome', 70);
            $table->text('oggetto');

            $table->text('modalitaFruizione');
            $table->text('luogoFruizione');

            // inserisco come data di default la data corrente, nel caso questo valore non dovesse essere riempito
            $table->dateTime('dataOraCreazione')->default(DB::raw('CURRENT_TIMESTAMP'));
            $table->dateTime('dataOraScadenza');

            // definizione dei vincoli della FK
            $table->foreign('idAzienda')->references('id')->on('aziende')
                ->onDelete('cascade')->onUpdate('cascade');
        });

        // aggiungo qua il logo perchè Eloquent non supporta il tipo LONGBLOB direttamente. Per poter aggiungere un
        // oggetto di tipo LONGBLOB (che ci serve per memorizzare le immagini, essendo queste troppo grandi per poter
        // essere memorizzate su un BLOB standard) vado, una volta creata, a modificare la tabella aggiungendole l'
        // attributo di tipo LONGBLOB
        DB::statement("ALTER TABLE offerte ADD immagine LONGBLOB");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('offerte');
    }
};
