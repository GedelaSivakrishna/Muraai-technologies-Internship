    let nameElement = document.getElementById("name");
    let emailElement = document.getElementById("email");
    let nameErrorElement = document.getElementById("nameError");
    let emailErrorElement = document.getElementById("emailError");
    let successMsgElement = document.getElementById("successMsg");
    let btn = document.getElementById("btn");

    btn.addEventListener("click", (event) => {
        event.preventDefault();
        let name = DOMPurify.sanitize(nameElement.value.trim());
        let email = DOMPurify.sanitize(emailElement.value.trim());
        if(name === "") {
            nameErrorElement.textContent = "Please enter the name";
            nameErrorElement.style.color = "red";
        }
        if(email === "") {
            emailErrorElement.textContent = "Please enter the email";
            emailErrorElement.style.color = "red";
        }

        if(name && email) {
            if(validateEmail(email)) {
                nameElement.value = "";
                emailElement.value = "";
                successMsgElement.textContent = "Form Submitted ";
                successMsgElement.style.color = "green";
            }
            else {
                emailErrorElement.textContent = "Invalid email";
                emailErrorElement.style.color = "red";
            }
        }
    })

    nameElement.addEventListener("input", () => {
        nameErrorElement.textContent = "";
    })

    emailElement.addEventListener("input", () => {
        emailErrorElement.textContent = "";
    })

    function validateEmail(email) {
        const gmailRegex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
        return gmailRegex.test(email);
    }