let currentSlideIndex = 0;
const slides = document.querySelectorAll(".slide");
const totalSlides = slides.length;

document.getElementById("next").addEventListener("click", () => {
  moveToNextSlide();
});

document.getElementById("prev").addEventListener("click", () => {
  moveToPreviousSlide();
});

function updateSlide() {
  slides.forEach((slide, index) => {
    slide.classList.remove("active");
    if (index === currentSlideIndex) {
      slide.classList.add("active");
    }
  });
}

/*function moveToNextSlide() {
  currentSlideIndex = (currentSlideIndex + 1) % totalSlides;
  updateSlide();
}*/

function moveToNextSlide() {
  const nextIndex = (currentSlideIndex + 1) % totalSlides;
  const nextSlide = slides[nextIndex];
  const images = nextSlide.querySelectorAll("img");

  // Only move if at least one image is found and has a valid src
  const hasValidImage = Array.from(images).some(
    (img) => img.src && img.complete && img.naturalHeight !== 0
  );

  if (hasValidImage) {
    currentSlideIndex = nextIndex;
    updateSlide();
  } else {
    alert("Next slide has no  image ");
  }
}

function moveToPreviousSlide() {
  currentSlideIndex =
    (currentSlideIndex - 1 + totalSlides) % totalSlides;
  updateSlide();
}

// Initialize the first slide
updateSlide();
