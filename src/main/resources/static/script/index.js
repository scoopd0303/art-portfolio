// create lightbox element with id of lightbox
const lightbox = document.createElement('div')
lightbox.id = 'lightbox'
document.body.appendChild(lightbox)

const images = document.querySelectorAll('.art-image')
images.forEach(image => {
  image.addEventListener('click', e => {
    lightbox.classList.add('active')

    // find the closest img to the grid-box-mask element
//    let closestImage = image.closest('.doodle-box').lastElementChild.src;
//    console.log(closestImage);

    // create new img element with the id of lightbox image and src of lightbox-image
    const img = document.createElement('img')
    img.id = 'lightbox-image'
    img.src = image.src

    // only display one image at a time
    while (lightbox.firstChild) {
      lightbox.removeChild(lightbox.firstChild)
    }
    // add image to lightbox
    lightbox.appendChild(img)

  })
})

lightbox.addEventListener('click', e => {
  if (e.target !== e.currentTarget) return
  lightbox.classList.remove('active')
})