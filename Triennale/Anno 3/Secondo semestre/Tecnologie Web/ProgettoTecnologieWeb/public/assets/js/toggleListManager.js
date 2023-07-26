// Questa variabile corrisponde ad un array contenente tutti gli elementi della pagina
// che hanno come nome della classe "toggle"
const toggles = document.getElementsByClassName("toggle");

// Questo ciclo for va a gestire ognuno degli elementi dell'array precedente (toggles)
// tramite "addEventListener" di tipo "click"
for (let i = 0; i < toggles.length; i++) {
    // Nel caso in cui un elemento di classe "toggle" venga cliccato va a prendere
    // l'elemento di classe "sub-list" (contentuto nel tag di classe "toggle" i-esimo)
    // che è nascosto di default (nel CSS è di tipo hidden) e tramite
    // la riga 13 permette di mostrarlo e nasconderlo (con il toggle)
    // andando a togliere e mettere il token "hidden" all'interno del nome della classe
    toggles[i].addEventListener("click", function() {
        const subList = this.querySelector(".sub-list");
        subList.classList.toggle("hidden");
    });
}
