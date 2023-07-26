<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Http\Requests\Auth\LoginRequest;
use App\Providers\RouteServiceProvider;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class AuthenticatedSessionController extends Controller {

    /**
     * Display the login view.
     *
     * @return \Illuminate\View\View
     */
    public function create() {
        return view('auth.login');
    }

    /**
     * Handle an incoming authentication request.
     *
     * @param  \App\Http\Requests\Auth\LoginRequest  $request
     * @return \Illuminate\Http\RedirectResponse
     */
    public function store(LoginRequest $request) {
        // eseguo l'autenticazione
        $request->authenticate();

        // genero una nuova sessione relativa a questo utente
        $request->session()->regenerate();

        // faccio il redirect all'area personale dell'utente
        return redirect()->route('hubUtente');
    }

    /**
     * Destroy an authenticated session.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\RedirectResponse
     */
    public function destroy(Request $request) {
        // esegue il logout
        Auth::guard('web')->logout();

        // invalida la sessione, distruggendola
        $request->session()->invalidate();

        // ricrea il token CSRF, in modo tale che per la prossima sessione ce ne sia uno nuovo
        $request->session()->regenerateToken();

        // redirect alla home page.
        return redirect('/');
    }

}
