/*
        I have no idea how to code this so please come back to me in the future
        and fix me because I am a sad code and want to be happy
*/


// Get the display (textarea) element
const display = document.getElementById('text');

// Select all buttons
const buttons = document.querySelectorAll('button');

// Variables for calculation logic
let currentInput = ''; // Stores the current input
let shouldResetDisplay = false; // Determines when to reset the display after an operation

// Add a click event listener to each button
buttons.forEach(button => {
    button.addEventListener('click', () => {
        const buttonValue = button.getAttribute('data-value');

        if (button.classList.contains('clear')) {
            clearDisplay();
        } else if (buttonValue === "=") {
            calculateResult();
        } else if (buttonValue === "π") {
            appendToDisplay(Math.PI.toFixed(8)); // Approximate value of PI
        } else if (buttonValue === "√") {
            calculateSquareRoot();
        } else if (buttonValue === "!") {
            calculateFactorial();
        } else if (buttonValue === "sin" || buttonValue === "cos" || buttonValue === "tan") {
            calculateTrigonometricFunction(buttonValue);
        } else {
            appendToDisplay(buttonValue);
        }
    });
});

// Function to clear the display
function clearDisplay() {
    currentInput = '';
    display.value = '';
}

// Function to append a value to the display
function appendToDisplay(value) {
    if (shouldResetDisplay) {
        currentInput = '';
        shouldResetDisplay = false;
    }
    currentInput += value;
    display.value = currentInput;
}

// Function to calculate the result of the expression
function calculateResult() {
    try {
        // Use eval to calculate the result (use cautiously)
        const result = eval(currentInput.replace('^', '**')); // Replace ^ with ** for power
        display.value = result;
        currentInput = result.toString();
        shouldResetDisplay = true;
    } catch (error) {
        display.value = 'Error';
        currentInput = '';
    }
}

// Function to calculate the square root
function calculateSquareRoot() {
    try {
        const result = Math.sqrt(eval(currentInput));
        display.value = result;
        currentInput = result.toString();
        shouldResetDisplay = true;
    } catch (error) {
        display.value = 'Error';
        currentInput = '';
    }
}

// Function to calculate factorial
function calculateFactorial() {
    try {
        const number = parseInt(currentInput);
        if (number < 0 || isNaN(number)) {
            display.value = 'Error';
            currentInput = '';
        } else {
            const result = factorial(number);
            display.value = result;
            currentInput = result.toString();
            shouldResetDisplay = true;
        }
    } catch (error) {
        display.value = 'Error';
        currentInput = '';
    }
}

// Helper function to calculate factorial
function factorial(n) {
    if (n === 0 || n === 1) return 1;
    return n * factorial(n - 1);
}

// Function to calculate trigonometric functions
function calculateTrigonometricFunction(func) {
    try {
        const radians = parseFloat(currentInput) * (Math.PI / 180); // Convert to radians
        let result;
        switch (func) {
            case 'sin':
                result = Math.sin(radians);
                break;
            case 'cos':
                result = Math.cos(radians);
                break;
            case 'tan':
                result = Math.tan(radians);
                break;
        }
        display.value = result.toFixed(8); // Limit precision
        currentInput = result.toString();
        shouldResetDisplay = true;
    } catch (error) {
        display.value = 'Error';
        currentInput = '';
    }
}
