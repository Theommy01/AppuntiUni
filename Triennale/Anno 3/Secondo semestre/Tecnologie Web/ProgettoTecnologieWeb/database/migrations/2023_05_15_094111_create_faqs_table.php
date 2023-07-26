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
        Schema::create('faqs', function (Blueprint $table) {
            // Primary key auto-incrementale della tabella.
            $table->bigIncrements('id');

            $table->string('usernameCreatore', 30);
            $table->string('domanda', 300)->unique();
            $table->string('risposta', 300)->unique();

            // definizione del vincolo di FK
            $table->foreign('usernameCreatore')->references('username')
                ->on('utenti')->onDelete('cascade')->onUpdate('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('faqs');
    }
};
