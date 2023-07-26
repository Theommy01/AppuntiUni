// Questa variabile serve ad indicare se il box di ricerca laterale è aperto o no.
// Serve perchè quando il box di ricerca verrà aperto sarà necessario restringere leggermente il contenitore delle offerte
// per ottimizzare la visualizzazione della pagina web.
var searchAreaOpen = false;

function toggleSearchArea() {
    if (!searchAreaOpen) {
        $("#catalog-search-form").show();
        // restringo il contenitore delle offerte per farci stare meglio il box di ricerca
        $("#section-offerte").css("width", "80%");

        searchAreaOpen = true;
    } else if (searchAreaOpen) {
        $("#catalog-search-form").hide();
        // siccome il box di ricerca è scomparso riporto il contenitore delle offerte alla sua larghezza originale
        $("#section-offerte").css("width", "100%");

        searchAreaOpen = false;
    }
}
