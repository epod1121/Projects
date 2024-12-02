const original_content = document.getElementById("originalContent")
const hidden_content = document.getElementById("hiddenContent")
const button_click = document.getElementById("button")

button_click.onclick = function(){
    original_content.classList.add("hidden")
    hidden_content.classList.remove("hidden")
    hidden_content.classList.add("centered")

    confetti({
        particleCount: 458,
        spread: 100,
        origin: { y: 0.6 }
    });
}