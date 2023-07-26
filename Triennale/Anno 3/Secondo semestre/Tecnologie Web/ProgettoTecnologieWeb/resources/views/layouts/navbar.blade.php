<nav>
    <!-- area di sinistra: contiene logo di Offertopoli -->
    <div class="navbar-logo-container">
        <img src="{{ asset('assets/images/logo_with_text.png') }}" class="navbar-logo" alt="Logo Offertopoli">
    </div>

    <!-- area di destra: contiene i link che indirizzano alle pagine del sito web -->
    <div class="navbar-links-container">
        <ul>
            <li><a href="{{ route('homepage') }}">Home</a></li>
            <li><a href="{{ route('aziende') }}">Aziende</a></li>
            <li><a href="{{ route('catalogo') }}">Catalogo</a></li>
            @guest
                <li><a href="{{ route('login') }}">Login</a></li>
            @endguest
            @auth
                <li><a href="{{route('hubUtente')}}">Area Personale</a></li>
            @endauth
        </ul>
    </div>
</nav>
