


//      Closure
// function outer() {
//     let count = 0;
//     function inner() {
//         ++count;
//         console.log(count);
//     }
//     return inner;
// }

// let result = outer();
// result();


// let nums = [1,2,3,4,5,6,7,8,9,10];
// nums.shift();
// nums.unshift(10,20,30);
// Later experiment on this
// let slicedArray = nums.slice(-5, -8);
// console.log(nums);
// console.log(slicedArray);

//  this.name = "Global Sivakrishna";

// function greet() {
//      this.name = "Local Sivakrishna";

//     setTimeout(function () {
//         let name = "Functional Sivakrishna";
//         console.log(this.name);
//     },2000);

    // setTimeout(() => {
    //     let name = "Functional Sivakrishna";
    //     console.log(this.name);
    // },2000);
// }

// greet();



// let arr = [
//     () => {
//         console.log("First");
//     },
//     () => {
//         console.log("Second");
//     },
//     () => {
//         console.log("Third");
//     }
// ];

// let obj = {
//     name: "Sivakrishna",
//     age: 22,
//     greet: function () {
//          console.log("Good Morning");
//     },
// }

// arr[0]();

// let a;
// console.log(a);


// const obj = new Human();

// class Human {

// }



// sayHello();
// let sayHello = function () {
//     console.log("Hello ");
// }

// let age;
// console.log(age);

// variable hoisiting
// console.log(age);
// const age = 22;

// Function hoisting
    // sayMyName("Gedela Sivakrishna");

    // function sayMyName(name) {
    // console.log(name);
    // }

// Block scope
// {
    // var age = 22;
    // var age = 23;
// }
// console.log(age);



// Function scope
// function sayHello() {
//     var age = 22;
//     console.log(age);
// }

// console.log(age);

// Global Scope - variable can be accessed throught the file
// const age = 22;
// const age = 23;

// {
//     console.log(age);
// }

// if(true) {
//     console.log(age);
// }

// function hello() {
//     console.log(age);
// }

// hello();

// for(let i = 1; i <= 1; i++) {
//     console.log(age);
// }

// let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// let result1 = nums.find(v => v % 5 === 0);
// let result1 = nums.findIndex(v => v % 5 === 0);
// console.log(result1);

// nums.unshift(20);
// console.log(nums);

// console.log(nums.shift());
// console.log(nums);
// let arr = [25, 23, 12];
// nums.splice(0, 0, ...arr);
// console.log(nums);
// nums.splice(0,2, ...arr);
// console.log(nums);
// console.log("Start");
// let promise = new Promise((resolve, reject) => {
//     setTimeout(()=>{
//         resolve("Hi");
//     },5000);
// });

// promise.then(res => console.log(res))
//        .catch(error => console.log(error))
//        .finally(() => {
//         console.log("This is finally block");
//        });
// console.log("End");