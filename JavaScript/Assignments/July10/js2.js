    let btn = document.getElementById("btn");
    let textElement = document.getElementById("text");

    btn.addEventListener("click", () => {
        let r = Math.floor(Math.random() * 255);
        let g = Math.floor(Math.random() * 255);
        let b = Math.floor(Math.random() * 255);
        textElement.style.color = `rgb(${r}, ${g}, ${b})`; 
    })