@extends('layouts.skel')

@section('title', "'Dettagli dell'azienda")

@section('content')
    <div class="container">
        <div class="panel">
            @if(isset($tuple))
            <div class="title-with-logo">
                <img src="data:image/png/jpeg;base64,{{ base64_encode($tuple['logo']) }}" alt="Logo Azienda" class="logo-azienda">
                <h2>{{$tuple['nome']}}</h2>
            </div>

            <div class="toggle-list">
                <p class="toggle-list-hint">Clicca sui titoli per espandere i contenitori dei dettagli</p>
                <ul>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Descrizione</h2>
                        <ul class="sub-list hidden">
                            <li><p>{{$tuple['descrizione']}}</p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Tipologia</h2>
                        <ul class="sub-list hidden">
                            <li><p>{{$tuple['tipologia']}}</p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Ragione Sociale</h2>
                        <ul class="sub-list hidden">
                            <li><p>{{$tuple['ragioneSociale']}}</p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Dove si trova</h2>
                        <ul class="sub-list hidden">
                            <li><p>{{$tuple['localizzazione']}}</p></li>
                        </ul>
                    </li>
                </ul>
            </div>
            @else
            <p>Errore: l'azienda richiesta non è disponibile sul database.</p>
            @endif

            <div class="panel-buttons">
                <a class="btn" href="{{ route('aziende') }}">Torna alla lista delle aziende</a><br><br>
            </div>
        </div>

        <script type="text/javascript" src="{{ asset('assets/js/toggleListManager.js') }}"></script>
    </div>
@endsection
