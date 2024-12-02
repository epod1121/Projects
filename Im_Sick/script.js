let count = 0;
const imageSrc = "Guinea-pig.webp"; // Replace with your image URL
const imageCount = 10; // Number of images to display
const rotationInterval = 1000; // Rotation interval in milliseconds

const pictures = [];

for(i = 0; i < 5; i++){
    pictures[i] = i;
}

document.addEventListener('keydown', () => {
    if (count < pictures.length - 1) {
        addHiddenContent();
        count += 1;
    }
});

function addHiddenContent(){
    if (count < pictures.length - 1) {
        document.getElementById(pictures[count]).classList.add('hidden');
        document.getElementById(pictures[count + 1]).classList.remove('hidden');
    }
}

  // Function to generate a random number between min and max
  function getRandom(min, max) {
    return Math.random() * (max - min) + min;
  }

  // Function to create and place random images
  function createRandomImages() {
    const images = [];
    for (let i = 0; i < imageCount; i++) {
      const img = document.createElement('img');
      img.src = imageSrc;
      img.classList.add('random-image');
      
      // Randomly position the image
      img.style.width = `${getRandom(50, 150)}px`; // Random size between 50px and 150px
      img.style.top = `${getRandom(0, window.innerHeight - 150)}px`; // Random vertical position
      img.style.left = `${getRandom(0, window.innerWidth - 150)}px`; // Random horizontal position

      // Append to the document
      document.body.appendChild(img);
      images.push(img);
    }
    return images;
  }

  // Function to rotate images
  function rotateImages(images) {
    setInterval(() => {
      images.forEach(img => {
        // Randomly decide to rotate left or right
        const rotationAngle = getRandom(-30, 30); // Angle between -30 and 30 degrees
        img.style.transform = `rotate(${rotationAngle}deg)`;
      });
    }, rotationInterval);
  }

  const audio = document.getElementById('backgroundAudio');

  // Example: Pause and resume audio with a button
  document.addEventListener('keydown', () => {
    if (audio.paused) {
      audio.play();
    }
  });

  // Main execution
  const randomImages = createRandomImages();
  rotateImages(randomImages);
