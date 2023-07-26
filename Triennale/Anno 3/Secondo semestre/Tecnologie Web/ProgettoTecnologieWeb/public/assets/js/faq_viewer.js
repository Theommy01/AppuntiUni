// Quando il DOM è pronto...
//il codice utilizza jQuery per gestire un'azione quando viene fatto clic su un elemento con determinate classi
//indica che il codice all'interno della funzione sarà eseguito quando il documento HTML è stato completamente caricato.
//In questo modo, ci si assicura che tutti gli elementi del DOM siano disponibili per essere selezionati e manipolati
$(document).ready(function() {
    // Ogni volta che faccio click su un elemento che ha quelle classi li...
    $(".toggle-list-mini .toggle").click(function() {
        // Prendo l'elemento che è stato cliccato, ottengo l'elemento che lo segue nel wrapped set, e lo espando/contraggo
        // a seconda del fatto che è già espanso/contratto (jQuery gestisce autonomamente questo evento con i metodi Toggle)
        $(this).next().slideToggle();
    });
});
