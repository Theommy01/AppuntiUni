@extends('layouts.skel')

@section('title', 'Lista delle aziende partecipanti')

@section('content')
    <div class="container">
        <h1>Lista delle aziende associate</h1>
        <div class="desc">
            <p>Questa è la lista di tutte le aziende associate a Offertopoli e che pubblicano offerte. Clicca su un'azienda per
                scoprirne tutti i dettagli.</p>
        </div>

        <div class="search-container">
            <form id="search-form" method="POST" action="{{ route('aziende') }}">
                @csrf
                <div class="search-wrapper">
                    <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                    <input type="text" id="search-bar" name="query" placeholder="Cerca un'azienda..."
                           title="Cerca un'azienda scrivendo qui e poi premendo il taSto INVIO/ENTER">

                    <button type="submit">
                        <img src="{{ asset("assets/images/search.svg") }}" alt="Cerca">
                    </button>
                </div>
            </form>

            @if(isset($searchQuery))
            <div class="active-filters-container">
                Ricerca per:

                @if(isset($searchQuery))
                    <span><em>"{{ $searchQuery }}"</em></span>
                @endif

                <span> - </span>
                <a href="{{ route('aziende') }}">Reimposta</a>
            </div>
            @endif
        </div>

        <div id="section-offerte" class="card-deck">
            @if(count($Aziende) > 0)
                @foreach($Aziende as $aziende)
                    <div class="card" title="Clicca su nome dell'azienda per saparne di più!!!">
                        <img src="data:image/png/jpeg;base64,{{ base64_encode($aziende['logo']) }}" alt="Logo di un'azienda" class="logo-azienda">
                        <a class="card-title-link" href="{{ route('dettagliAzienda', $aziende['id']) }}">{{$aziende['nome']}}</a>
                    </div>
                @endforeach
            @else
                <div class="notfound">
                    <img src="{{ asset('assets/images/notfound.jpg') }}" width="135" alt="Nessuna azienda trovata">
                    <p>Nessuna azienda trovata.</p>
                </div>
            @endif
        </div>

        @include('pagination.paginator', ['pages' => $Aziende])
    </div>
@endsection
