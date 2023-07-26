@extends('layouts.skel')

@section('title', 'Gestione delle F.A.Q.')

@section('content')
    <div class="container">
        <div class="panel">
            <h2>Gestione F.A.Q.</h2>

            <br>
            <table class="tabella insert-element-table">
                <tbody>
                <tr>
                    <td class="insert-element-desc">Vuoi inserire una nuova F.A.Q.?</td>
                    <td class="insert-element-btn-container">
                        <a href="{{ route('inserisciFAQ') }}" class="btn btn-FAQ">Inserisci</a>
                    </td>
                </tr>
                </tbody>
            </table>

            <br>
            <br>
            <table class="tabella">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Domanda</th>
                        <th>Risposta</th>
                        <th>Modifica</th>
                        <th>Elimina</th>
                    </tr>
                </thead>

                <tbody>
                @foreach($List as $list)
                    <tr>
                        <td>{{$list['id']}}</td>
                        <td>{{$list['domanda']}}</td>
                        <td>{{$list['risposta']}}</td>
                        <td title="Clicca qui per AGGIORNARE la seguente domanda/risposta"><a class="btn-table-update" href="{{ route('aggiornaFAQ', $list['id']) }}">Modifica</a></td>
                        <td title="Clicca qui per ELIMINARE la seguente domanda/risposta">
                            <form class="delete-form" action="{{ route('eliminaFAQ', $list['id']) }}" method="POST">
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
@endsection
