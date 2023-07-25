// Quando il DOM è pronto...
$(document).ready(function() {
    // Ogni volta che faccio click su un elemento che ha quelle classi li...
    $(".toggle-list-mini .toggle").click(function() {
        // Prendo l'elemento che è stato cliccato, ottengo l'elemento che lo segue nel wrapped set, e lo espando/contraggo
        // a seconda del fatto che è già espanso/contratto (jQuery gestisce autonomamente questo evento con i metodi Toggle)
        $(this).next().slideToggle();
    });
});
