<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <!-- metadati per la visualizzazione della pagina -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- titolo della pagina -->
    <title>Offertopoli: @yield('title', 'Scontati ma non scontrosi')</title>

    <!-- icona della pagina (favicon) -->
    <link rel="icon" type="image/x-icon" href="{{ asset('favicon.ico') }}">

    <!-- inserimento fogli di stile necessari al rendering del layout della pagina -->
    <link rel="stylesheet" type="text/css" href="{{ asset('assets/css/skel.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('assets/css/containers.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('assets/css/elements.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('assets/css/forms.css') }}">

    <!-- importazione jQuery tramite CDN (Content Delivery Network) -->
    <!-- NOTA - gli attributi integrity e crossorigin servono per certificare l'autenticità del file inviato dal CDN -->
    <!-- e quindi per dimostrare che è completamente originale e non è stato compromesso da terzi -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
            crossorigin="anonymous"></script>
</head>

<body>
<header>
    @include('layouts/navbar')
</header>

<main>
    @yield('content')
</main>

<footer>
    @include('layouts/footer')
</footer>
</body>
</html>
