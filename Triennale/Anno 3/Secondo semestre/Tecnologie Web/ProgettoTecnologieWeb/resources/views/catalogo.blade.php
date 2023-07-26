@extends('layouts.skel')

@section('title', 'Catalogo prodotti')

@section('content')
    @if(isset($FactoryQuery) or isset($OfferQuery))
        <div class="active-filters-container">
            Ricerca per:

            @if(isset($FactoryQuery))
                <span><strong>{{ $FactoryQuery }}</strong></span>
            @endif

            @if(isset($OfferQuery))
                <span><em>"{{ $OfferQuery }}"</em></span>
            @endif

            <span> - </span>
            <a href="{{ route('catalogo') }}">Reimposta</a>
        </div>
    @endif

    <div class="container container-with-aside">
        <aside>
            <div class="search-container search-container-aside">
                <a href="#" onclick="toggleSearchArea()" title="Clicca qui per effettuare una ricerca">
                    <img src="{{ asset('assets/images/search_offer.png') }}" alt="Apri sezione di ricerca" class="open-search-area">
                </a>

                <form id="catalog-search-form" method="POST" action="{{ route('catalogo') }}">
                    @csrf
                    <h2>Ricerca per offerta</h2>
                    <input type="text" id="search-bar" name="offer_query" placeholder="Cerca un'offerta...">

                    <h2>Ricerca azienda</h2>
                    <input type="text" id="search-bar" name="factory_query" placeholder="Cerca un'azienda...">

                    <button type="submit" class="btn">Ricerca</button>
                </form>
            </div>
        </aside>

        <div id="section-offerte" class="card-deck">
            @if(count($Offerte) > 0)
                @foreach($Offerte as $offerte)
                    <div class="card">
                        <img src="data:image/png/jpg/webp/jpeg;base64,{{ base64_encode($offerte['logoAzienda']) }}" class="card-top-logo" alt="Logo azienda">
                        <img src="data:image/png/jpg/webp/jpeg;base64,{{ base64_encode($offerte['immagineOfferta']) }}" alt="Offerta">
                        <h3>{{$offerte['nomeOfferta']}}</h3>
                        <p>{{$offerte['oggettoOfferta']}}</p>
                        <a href="{{ url('/dettagliOfferta/'.$offerte['idOfferta']) }}" class="card-btn">Scopri di più</a>
                    </div>
                @endforeach
            @else
                <div class="notfound">
                    <img src="{{ asset('assets/images/notfound.jpg') }}" width="135" alt="Nessuna offerta trovata">
                    <p>Nessuna offerta trovata.</p>
                </div>
            @endif
        </div>
    </div>

    @include('pagination.paginator', ['pages' => $Offerte])

    <script type="text/javascript" src="{{ asset('assets/js/popupSearch.js') }}"></script>
@endsection
