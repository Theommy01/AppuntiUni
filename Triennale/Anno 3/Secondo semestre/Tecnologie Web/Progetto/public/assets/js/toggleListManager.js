const toggles = document.getElementsByClassName("toggle");

for (let i = 0; i < toggles.length; i++) {
    toggles[i].addEventListener("click", function() {
        const subList = this.querySelector(".sub-list");
        subList.classList.toggle("hidden");
    });
}
