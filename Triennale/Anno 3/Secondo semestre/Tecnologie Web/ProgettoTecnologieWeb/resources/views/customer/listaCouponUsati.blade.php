@extends('layouts.skel')

@section('title', 'Lista dei coupon usati')

@section('content')
    <div class="container">
        <div class="panel">
            <h2>Lista coupon utilizzati</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="{{ route('listaCouponUsati') }}">
                    @csrf
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" placeholder="Cerca un coupon scrivendo il nome dell'offerta..." title="Cerca un coupon scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="{{ asset("assets/images/search.svg") }}" alt="Cerca"></button>
                    </div>
                </form>
            </div>

            <br>
            <table class="tabella">
                <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Offerta</th>
                    <th>Azienda</th>
                    <th>Data creazione</th>
                    <th>Data scadenza</th>
                    <th>Codice</th>
                </tr>
                </thead>

                <tbody>
                @foreach($List as $list)
                    <tr>
                        <td>{{$list['username']}}</td>
                        <td>{{$list['nomeOfferte']}}</td>
                        <td>{{$list['nomeAziende']}}</td>
                        <td>{{$list['dataOraCreazione']}}</td>
                        <td>{{$list['dataOraScadenza']}}</td>
                        <td>
                            <a id="link-cp" onclick="event.preventDefault(); document.getElementById('open-cp-{{ $list['idOfferte'] }}').submit();" href="">{{$list['codice']}}</a>
                            <form id="open-cp-{{ $list['idOfferte'] }}" action="{{ url('/inserisciCoupon/'.$list['idOfferte']) }}" method="POST" style="display: none;">
                                {{ csrf_field() }}
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

