// Spread operator
let arr1 = [1, 2, 3];
let arr3 = [];
let arr2 = [...arr1, 4, 5, ...arr3];
console.log(arr2);

// Rest operator
function calcSum(...marks) {
    return marks.reduce((acc, curr) => acc + curr, 0);
} 
// console.log("Sum is : ", calcSum(1,2,3,4,5));
// console.log("Sum is : ", calcSum(10,20,30,40,50));
// console.log("Sum is : ", calcSum());

let i = null;
// console.log(i ?? "Default value");

// let myObj = {
//     name: "Siva",
//     roll: 242
// }
let myObj = null;
// console.log(myObj?.age);

let stud1 = ["sivakrishna", 22, "Odisha", "Male", 5.5];
let marks = [90, 95, 82];

/*
    sort(a,b) function rules based on result of substraction
        1) negative - a comes before b
        2) positive - a comes after b
        3) zero - no change in order
*/

// Ascending order
// marks.sort( (a,b) => a-b);
// Descending order
// marks.sort((a,b) => b-a);

// console.log(marks);

let student = {
    name: "Sivakrishna",
    contact: {
        phone: 9348683295,
        email: "siva@gmail.com"
    }
};

let studentCopy = {...student};

// studentCopy.contact.phone = 9692849788;
studentCopy.name = "Kiran";

console.log(student.name);
console.log(studentCopy.name);

// afun();
// ----------------- Explore more about functions and variables hoisting behaviour
let afun = function () {
    console.log("I'm an anonymous function",abcd);
}

// afun()
