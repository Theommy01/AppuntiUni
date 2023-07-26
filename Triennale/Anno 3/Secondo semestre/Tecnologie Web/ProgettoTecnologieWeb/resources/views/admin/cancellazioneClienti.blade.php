@extends('layouts.skel')

@section('title', 'Cancellazione clienti')

@section('content')
    <div class="container">
        <div class="panel">
            <h2>Cancellazione Clienti</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="{{route('cancellazioneClienti')}}">
                    @csrf
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" placeholder="Cerca un cliente..." title="Cerca un cliente scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="{{ asset("assets/images/search.svg") }}" alt="Cerca"></button>
                    </div>
                </form>
            </div>

            <table class="tabella">
                <thead>
                    <tr>
                        <th>Clienti</th>
                        <th>Elimina</th>
                    </tr>
                </thead>

                <tbody>
                @foreach($List as $list)
                    <tr>
                        <td>{{$list['username']}}</td>
                        <td title="Clicca qui per ELIMINARE la seguente domanda/risposta">
                           <form class="delete-form" action="{{ route('eliminaClienti', $list['username']) }}" method="POST">
                                @csrf
                                @method('DELETE')
                                <button type="submit" class="btn-table-delete" onclick="return confirm('Sei sicuro di voler eliminare questa domanda?')">
                                    Elimina</button>
                            </form>
                        </td>
                    </tr>
                @endforeach
                </tbody>
            </table>

            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('hubUtente') }}">Torna indietro</a>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="{{ asset('assets/js/searchOfferta.js') }}"></script>
@endsection
