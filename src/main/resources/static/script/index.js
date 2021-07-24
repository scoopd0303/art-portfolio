function getPreviousImageElement(img) {
    if(img.parentElement.parentElement.previousElementSibling != null) {
        return img.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild;
    }
    else {return img;}
}

function getNextImageElement(img) {
    if(img.parentElement.parentElement.nextElementSibling != null) {
        return img.parentElement.parentElement.nextElementSibling.firstElementChild.firstElementChild;
    }
    else {return img;}
}

window.addEventListener("load", function() {
    // create lightbox element with id of lightbox
    const lightbox = document.createElement('div')
    lightbox.id = 'lightbox'
    document.body.appendChild(lightbox)

    const images = document.querySelectorAll('.gallery-item')
    images.forEach(image => {
      image.addEventListener('click', e => {
        lightbox.classList.add('active')

        let currentImageElement = image.firstElementChild;
        let previousImageElement;
        let nextImageElement;

        function setImage(imgElement) {
            previousImageElement = getPreviousImageElement(imgElement);
            nextImageElement = getNextImageElement(imgElement);
            return imgElement.src;
        }

        // create new img element with the id of lightbox-image and src of image
        let img = document.createElement('img')
        img.id = 'lightbox-image'
        img.src = setImage(currentImageElement);

        // only display one image at a time
        while (lightbox.firstChild) {
          lightbox.removeChild(lightbox.firstChild)
        }
        // add image to lightbox
        lightbox.appendChild(img)

        document.onkeydown = (e) => {
            switch(e.keyCode) {
                case 37:
                    img.src = setImage(previousImageElement);
                    break;
                case 39:
                    img.src = setImage(nextImageElement);
                    break;
            }
        }

      })
    })

    lightbox.addEventListener('click', e => {
      if (e.target !== e.currentTarget) return
      lightbox.classList.remove('active')
    })
});