let username = document.querySelector("#name");
let dob = document.querySelector("#dob");
let btn = document.querySelector("#btn");
let nameErrorPara = document.querySelector("#nameError");
let dobErrorPara = document.querySelector("#dobError");
let successMsg = document.querySelector("#successMsg");

btn.addEventListener("click", (event) => {
    event.preventDefault();
    let usernameValue = DOMPurify.sanitize(username.value).trim();
    let dobValue = DOMPurify.sanitize(dob.value).trim();
    dobValue = new Date(dobValue);
    // console.log(dobValue);
    if(!usernameValue) {
        username.value = "";
        nameErrorPara.textContent = "Please enter your name";
        nameErrorPara.style.color = "red";
    }
    if(isNaN(dobValue)) {
        dobErrorPara.textContent = "Please enter your data of birth";
        dobErrorPara.style.color = "red";
    }
    
    let today = new Date();
    let minDate = new Date();
    minDate.setFullYear(today.getFullYear() - 120);

    if(usernameValue !== "") {
        console.log(usernameValue);
        if(dobValue >= minDate && dobValue <= today) {
            let years = today.getFullYear() - dobValue.getFullYear();
            let month = today.getMonth() - dobValue.getMonth();
            if(month < 0 || (month === 0 && today.getDate() < dobValue.getDate())) {
                --years;
            }
            username.value = "";
            dob.value = "";
            successMsg.textContent = `Hey ${usernameValue}, you are ${years} years old`;
        }
        else {
            dobErrorPara.textContent = "Please select valid date";
            dobErrorPara.style.color = "red";
        }
    }
})

username.addEventListener("input", () => {
    nameErrorPara.textContent = "";
    successMsg.textContent = "";
})

dob.addEventListener("click", () => {
    dobErrorPara.textContent = "";
    successMsg.textContent = "";
})