const WORD_LENGTH = 5;
const MAX_ATTEMPTS = 6;
const TARGET_WORD = 'reign';  // The target word to guess (can be randomized)
let currentAttempt = 0;
let currentGuess = '';

const gameBoard = document.getElementById('game-board');
const keyboard = document.querySelector('.keyboard');

initializeGameBoard();

// Initialize the game board with empty tiles
function initializeGameBoard() {
    for (let i = 0; i < MAX_ATTEMPTS * WORD_LENGTH; i++) {
        const tile = document.createElement('div');
        tile.classList.add('tile');
        gameBoard.appendChild(tile);
    }
}

// Handle on-screen keyboard input
keyboard.addEventListener('click', (e) => {
    const key = e.target.getAttribute('data-key');
    if (key) {
        handleKeyPress(key);
    }
});

// Handle physical keyboard input
document.addEventListener('keydown', (e) => {
    const key = e.key;

    // Ignore keys that aren't letters, Enter, or Backspace
    if (
        /^[a-zA-Z]$/.test(key) ||
        key === 'Enter' ||
        key === 'Backspace'
    ) {
        handleKeyPress(key);
    }
});

// Handle key presses (both on-screen and physical keyboard)
function handleKeyPress(key) {
    if (key === 'Enter') {
        if (currentGuess.length === WORD_LENGTH) {
            checkGuess();
        }
    } else if (key === 'Backspace') {
        if (currentGuess.length > 0) {
            currentGuess = currentGuess.slice(0, -1);
            updateBoard();
        }
    } else if (currentGuess.length < WORD_LENGTH && /^[A-Z]$/i.test(key)) {
        currentGuess += key.toLowerCase();
        updateBoard();
    }
}

// Update the game board with the current guess
function updateBoard() {
    const tiles = gameBoard.querySelectorAll('.tile');
    const start = currentAttempt * WORD_LENGTH;
    for (let i = 0; i < WORD_LENGTH; i++) {
        tiles[start + i].textContent = currentGuess[i] || '';
    }
}

// Check the current guess against the target word
function checkGuess() {
    const tiles = gameBoard.querySelectorAll('.tile');
    const start = currentAttempt * WORD_LENGTH;

    for (let i = 0; i < WORD_LENGTH; i++) {
        const tile = tiles[start + i];
        const letter = currentGuess[i];

        if (TARGET_WORD[i] === letter) {
            tile.classList.add('correct');
        } else if (TARGET_WORD.includes(letter)) {
            tile.classList.add('present');
        } else {
            tile.classList.add('absent');
        }
    }

    if (currentGuess === TARGET_WORD) {
        alert('Congratulations! You guessed the word!');
        return;
    }

    currentAttempt++;
    currentGuess = '';

    if (currentAttempt === MAX_ATTEMPTS) {
        alert('Game Over! The word was: ' + TARGET_WORD);
    }
}