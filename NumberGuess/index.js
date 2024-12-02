const button_click = document.getElementById("submit");
const result = document.getElementById("hidden");
const number = Math.floor(Math.random() * 100) + 1;

button_click.onclick = function() {

    let number_guessed = Number(document.getElementById("guess").value);
    
    if(number_guessed > number){
        result.classList.remove("hidden");
        result.textContent = "Too High!";
        document.getElementById("guess").value = '';
    }
    else if (number_guessed < number){
        result.classList.remove("hidden");
        result.textContent = "Too Low!";
        document.getElementById("guess").value = '';
    }
    else if (number_guessed < 1 || number_guessed > 100){
        result.classList.remove("hidden");
        result.textContent = "Enter a number within the given range!";
        document.getElementById("guess").value = '';
    }
    else if (number_guessed === number){
        result.classList.remove("hidden");
        result.textContent = "Congratulations! You guessed the number!";
        document.getElementById("guess").value = '';
    }
    else{
        result.classList.remove("hidden");
        result.textContent = "Something Went Wrong!";
        document.getElementById("guess").value = '';
    }
}