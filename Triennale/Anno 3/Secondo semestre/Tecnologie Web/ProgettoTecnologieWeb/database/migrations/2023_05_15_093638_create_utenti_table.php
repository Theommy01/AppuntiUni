<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
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
        // NOTA - per default, gli attributi creati hanno tutti il vincolo NOT NULL - viene specificato esplicitamente
        // se possono assumere valori NULL.
        Schema::create('utenti', function (Blueprint $table) {
            // Primary key della tabella.
            $table->string('username', 30)->primary();

            $table->string('nome', 20);
            $table->string('cognome', 20);
            $table->date('eta')->nullable();
            $table->string('genere', 1)->nullable();

            $table->integer('livello');
            $table->string('password', 255);

            $table->string('telefono', 10)->nullable();
            $table->string('email', 30);
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('utenti');
    }
};
