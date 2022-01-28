const moveObserver = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('picture-animation');
            return;
        }
        entry.target.classList.remove('picture-animation');
    });
});

const allPictures = document.querySelectorAll('.picture')

for (const picture of allPictures ) {
    moveObserver.observe(picture);
}

for (const picture of allPictures) {
    picture.classList.remove('picture-transition')
}

const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('picture-transition');
            return;
        }

        // entry.target.classList.remove('picture-transition');
    });
});
for (const picture of allPictures) {
    observer.observe(picture);
}
