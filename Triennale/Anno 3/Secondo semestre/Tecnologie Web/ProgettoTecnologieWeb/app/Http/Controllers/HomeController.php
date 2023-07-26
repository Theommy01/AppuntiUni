<?php

namespace App\Http\Controllers;

use App\Models\Factory;
use App\Models\FAQ;

class HomeController extends Controller
{
    // Apre la home page, corredata di lista parziale delle Aziende e delle FAQ
    public function index()
    {
        $dataHome = Factory::all()->take(8);
        $data = FAQ::all();

        return view('homepage', ['List'=>$data], ['Aziende'=>$dataHome]);
    }
}
