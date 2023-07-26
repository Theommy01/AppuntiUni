@extends('layouts.skel')

@section('content')
    <div class="container">
        <div class="panel">
            <div class="title-with-logo">
                @can('isUser')
                    <img src="{{ asset('assets/images/customer_icon.png') }}" alt="Logo utente">
                @elsecan('isStaff')
                    <img src="{{ asset('assets/images/staff_icon.png') }}" alt="Logo staff">
                @elsecan('isAdmin')
                    <img src="{{ asset('assets/images/admin_icon.png') }}" alt="Logo admin">
                @endcan

                @auth
                    <h2>Benvenuto nell'Area personale, {{ Auth::user()->nome }} {{ Auth::user()->cognome }} </h2>
                @else
                    <h2>Benvenuto nell'Area personale</h2>
                @endauth
            </div>

            @can('isUser')
                <div class="panel-buttons">
                    <a href="{{ route('modificaDatiL1') }}" class="btn">Modifica dati personali</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('listaCouponUsati') }}" class="btn">Visualizza i coupon utilizzati</a>
                </div>
            @elsecan('isStaff')
                <div class="panel-buttons">
                    <a href="{{ route('modificaDatiL2') }}" class="btn">Modifica dati personali</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('gestioneOfferte') }}" class="btn">Gestione offerte</a>
                </div>
            @elsecan('isAdmin')
                <div class="panel-buttons">
                    <a href="{{ route('gestioneFAQ') }}" class="btn">Gestione F.A.Q.</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('statistiche') }}" class="btn">Statistiche</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('cancellazioneClienti') }}" class="btn">Cancellazione clienti</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('gestioneStaff') }}" class="btn">Gestione staff</a>
                </div>
                <div class="panel-buttons">
                    <a href="{{ route('gestioneAziende') }}" class="btn">Gestione aziende</a>
                </div>
            @endcan

            <div class="panel-buttons">
                <a href="" class="btn btn-back" title="Esci dal sito" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Logout</a>
                <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                    {{ csrf_field() }}
                </form>
            </div>
        </div>
    </div>
@endsection
