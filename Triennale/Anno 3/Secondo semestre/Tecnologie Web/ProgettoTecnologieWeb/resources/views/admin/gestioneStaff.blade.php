@extends('layouts.skel')

@section('title', 'Gestione dello staff')

@section('content')
    <div class="container">
        <div class="panel">
            <h2>Gestione Staff</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="{{ route('gestioneStaff') }}">
                    @csrf
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" placeholder="Cerca un membro dello Staff..." title="Cerca un membro dello staff scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="{{ asset("assets/images/search.svg") }}" alt="Cerca"></button>
                    </div>
                </form>
            </div>

            <table class="tabella insert-element-table">
                <tbody>
                <tr>
                    <td class="insert-element-desc">Vuoi inserire un nuovo membro dello Staff?</td>
                    <td class="insert-element-btn-container">
                        <a href="{{ route('inserisciStaff') }}" class="btn btn-FAQ">Inserisci</a>
                    </td>
                </tr>
                </tbody>
            </table>

            <br>
            <br>
            <table class="tabella">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Modifica</th>
                        <th>Elimina</th>
                    </tr>
                </thead>

                <tbody>
                @foreach($List as $list)
                    <tr>
                        <td>{{$list['username']}}</td>
                        <td title="Clicca qui per AGGIORNARE il seguente membro Staff"><a class="btn-table-update" href="{{ route('aggiornaStaff', $list['username']) }}">Modifica</a></td>
                        <td title="Clicca qui per ELIMINARE il seguente membro dello Staff">
                            <form class="delete-form" action="{{ route('eliminaStaff', $list['username']) }}" method="POST">
                                @csrf
                                @method('DELETE')
                                <button type="submit" class="btn-table-delete" onclick="return confirm('Sei sicuro di voler eliminare questo membro dello Staff?')">
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
@endsection

