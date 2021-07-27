// if applicable, variable to hold last number generated, else null
let lastRandomNumber;
let repositorySize = artworks.length;
for (i=0;i<artworks.length;i++) {
    console.log(',' + artworks[i] + ',');
}

// function to generate random number within given range without repeats
function getRandomNumber(numberRange) {

    let a = Math.floor(Math.random() * numberRange);

    if (a != lastRandomNumber) {
        lastRandomNumber = a;
        return a;
    } else {
        if (a < (numberRange/2)) {
            a = a + 1;
            lastRandomNumber = a;
            return a;
        } else {
            a = a - 1;
            lastRandomNumber = a;
            return a;
        }
    }
}

// randomly generates src for boxImage using getRandomNumber()
function getRandomImage(numberRange) {
    let randomImage = artworks[getRandomNumber(numberRange)];
    if (randomImage != undefined) {
        return  `..${randomImage}`;
    }

}

// ON LOAD
window.addEventListener("load", function() {
    let boxPath = document.querySelector("#box-path");
    let box = document.getElementById('box');
    let boxImage = document.querySelector('.box-image');

    box.classList = 'box-closed';
    box.style.animation = 'none';
    boxImage.src = getRandomImage(repositorySize);

    function openBox() {
        box.classList = 'box-open';
        boxImage.style.display = "flex";
        boxImage.style.animation = 'image-pop-up 200ms 1';
        box.style.animation = 'shake-open 200ms 1';
    }

    function closeBox() {
        box.classList = 'box-closed';
        box.style.animation = "rattle 3s 500ms infinite"
        boxImage.src = getRandomImage(repositorySize);
        boxImage.style.display = "none";
    }

    function toggleBox() {
        if(box.classList != 'box-closed') {
            closeBox();
        } else {
            openBox();
        }
    }

    boxPath.addEventListener('click', () => {
        toggleBox();
    });

    boxPath.addEventListener('mouseover', () => {
        if (box.classList != 'box-open') {
            box.style.animation = "rattle 3s 500ms infinite";
        } else {
            box.style.animation = 'none';
        }
    });

    boxPath.addEventListener('mouseout', () => {
        if(box.classList != 'box-open') {
            boxImage.style.display = 'none';
        }
        box.style.animation = 'none';
    });
});
