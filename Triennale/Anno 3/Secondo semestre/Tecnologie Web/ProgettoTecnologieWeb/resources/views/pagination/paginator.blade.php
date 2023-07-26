@if($pages->total() > 0)
<div class="pagination">
    <!-- Link alla prima pagina -->
    <!-- se non mi trovo già nella 1a pagina... -->
    @if (!$pages->onFirstPage())
        <!-- vado alla 1a pagina -->
        <a href="{{ $pages->url(1) }}">
            <img class="paginator-icon" src="{{ asset('assets/images/first_page.png') }}" alt="Prima pagina" title="Vai alla prima pagina">
        </a>
    @endif

    <!-- Link alla pagina precedente -->
    <!-- se non sono nella 1a pagina... -->
    @if ($pages->currentPage() != 1)
        <a href="{{ $pages->previousPageUrl() }}">
            <img class="paginator-icon" src="{{ asset('assets/images/prev_page.png') }} " alt="Pagina precedente" title="Vai alla pagina precedente">
        </a>
    @endif

    <!-- visualizzo rispettivamente: 1° e ultimo elemento della pagina, elementi totali -->
    {{ $pages->firstItem() }} - {{ $pages->lastItem() }} di {{ $pages->total() }}

    <!-- Link alla pagina successiva -->
    <!-- se ci sono ancora pagine disponibili... -->
    @if ($pages->hasMorePages())
        <a href="{{ $pages->nextPageUrl() }}">
            <img class="paginator-icon" src="{{ asset('assets/images/next_page.png') }}" alt="Pagina successiva" title="Vai alla pagina successiva">
        </a>
    @endif

    <!-- Link all'ultima pagina -->
    <!-- se ci sono ancora pagine, ottengo l'ultima -->
    @if ($pages->hasMorePages())
        <a href="{{ $pages->url($pages->lastPage()) }}">
            <img class="paginator-icon" src="{{ asset('assets/images/last_page.png') }}" alt="Ultima pagina" title="Vai all'ultima pagina">
        </a>
    @endif
</div>
@endif
