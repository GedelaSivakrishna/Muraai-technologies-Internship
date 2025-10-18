let student = {
    name: "Gedela Sivakrishna",
    age: 22,
    gender: "Male",
    contact: {
        phone: 9692849788,
        email: "gedelasivakrishna1@gmail.com"
    },
    address: {
        country: "India",
        state: "Odisha",
        // city: "Vistala",
        city: null,
        // pincode: 761208
    }
}

function getPhoneNumber() {
    try {
        let {contact: {phone}} = student;
        if(typeof(phone) === "undefined" || phone === null) {
            throw new Error(`Phone n.o not found`);
        }
        console.log(phone);
    }
    catch(error) {
        console.error(error.message);
    }
}

function getEmailId() {
    try {
        let {contact: {email}} = student;
        if(typeof(email) === "undefined" || email === null) {
            throw new Error(`Email id not found`);
        }
        console.log(email);
    }
    catch(error) {
        console.error(error.message);
    }
}

function getCountry() {
    try {
        let {address: {country}} = student;
        if(typeof(country) === "undefined" || country === null) {
            throw new Error(`Country not found`);
        }
        console.log(country);
    }
    catch(error) {
        console.error(error.message);
    }
}

function getState() {
    try {
        let {address: {state}} = student;
        if(typeof(state) === "undefined" || state === null) {
            throw new Error(`State not found`);
        }
        console.log(state);
    }
    catch(error) {
        console.error(error.message);
    }
}

function getCity() {
    try {
        let {address: {city}} = student;
        if(typeof(city) === "undefined" || city === null) {
            throw new Error(`City not found`);
        }
        console.log(city);
    }
    catch(error) {
        console.error(error.message);
    }
}

function getPincode() {
    try {
        let {address: {pincode}} = student;
        if(typeof(pincode) === "undefined" || pincode === null) {
            throw new Error(`Pincode not found`);
        }
        console.log(pincode);
    }
    catch(error) {
        console.error(error.message);
    }
}

getPhoneNumber();
getEmailId();
getCountry();
getState();
getCity();
getPincode();