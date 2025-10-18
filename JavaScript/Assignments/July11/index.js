let marks = [95, 92, 82, 65, 78];
let [computer, math, science] = marks;
// console.log(computer);
// console.log(math);
// console.log(science);

// skipping elements & destructuring
let [,,english] = marks;
// console.log(english);

// Rest parameter
let [,, ...lowMarks] = marks;
// console.log(lowMarks);

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
        city: "Vistala",
        pincode: 761208
    }
}

// Object Destructuring
// let {name, age, gender} = student;
// console.log(name);
// console.log(age);
// console.log(gender);
let {name, age, ...others} = student;
// console.log(others);

// Nested Object Destructuring
let {contact: {phone}, address: {state}} = student;
// console.log(phone);
// console.log(state);

// shallow copy
let studentShallowCopy = {...student};
// Deep copy
let studentDeepCopy = structuredClone(student);
studentDeepCopy.contact.phone = 1234567890;
// console.log(student.contact.phone);
// console.log(studentDeepCopy.contact.phone);

function sum(...values) {
    // console.log(values);
    return values.reduce((acc, curr) => acc + curr, 0);
}

// console.log(sum());
