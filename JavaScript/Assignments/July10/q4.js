    let imageElement = document.getElementById("image");
    let prevBtnElement = document.getElementById("prevBtn");
    let nextBtnElement = document.getElementById("nextBtn");
    let index = 0;

    const images = [
        "https://res.cloudinary.com/dheuqshro/image/upload/v1752226711/Muraai/Google_vyeodq.png",
        "https://res.cloudinary.com/dheuqshro/image/upload/v1752226710/Muraai/Apple_kjcegr.png",
        "https://res.cloudinary.com/dheuqshro/image/upload/v1752226711/Muraai/Amazon_twllsm.png",
        "https://res.cloudinary.com/dheuqshro/image/upload/v1752226710/Muraai/Microsoft_ez8o1u.png"
        ]

    imageElement.src = images[index];

    prevBtnElement.addEventListener("click", () => {
        --index;
        if(index < 0) {
            index = images.length - 1;
        }
        imageElement.src = images[index];
    })

    nextBtnElement.addEventListener("click", () => {
        ++index;
        if(index > images.length - 1) {
            index = 0;
        }
        imageElement.src = images[index];
    })

/* Improvements
    1) Buttons disabling can be done
*/