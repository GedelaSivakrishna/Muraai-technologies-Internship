// let fpara = document.querySelector("#fpara");
// let spara = document.querySelector("#spara");

// console.log(fpara.s);
// console.log(fpara.style.padding);
// console.log(fpara.style.backgroundColor);

//     By default, events execute in bubbling phase

// document.querySelector("#grandparent").addEventListener("click", () => {
//     console.log("Grandparent clicked!");
// });

// document.querySelector("#parent").addEventListener("click", (e) => {
//     console.log("Parent clicked!");
//     // e.stopPropagation();
// });

// document.querySelector("#child").addEventListener("click", (e) => {
//     console.log("Child clicked!");
    
// });

// document.querySelector("#parent").addEventListener("click", (e) => {
//     console.log(e.target.innerText);
// })

// let aElement = document.querySelector("#fanchor");

// aElement.addEventListener("click", (e) => {
//     e.preventDefault();
//     aElement.textContent = "Default behaviour prevented";
// })

// queueMicrotask() - to insert light weight async code to Microtask queue
// console.log("Starting");

// setTimeout(()=>{
//     console.log("I am a Macrotask");
// },0);

// queueMicrotask(()=>{
//     console.log("I am a Microtask");
// })

// console.log("Ending..");

// setImmediate() 

// let firstPromise = new Promise((resolve, reject) => {
//     // resolve(100);
//     // reject(new Error("Error occured while execution"));
//     // console.log("I',m synchronous code");
//     setTimeout(()=>{
//         greet();
//     },10000);
//     resolve(true);
// })

// function greet() {
//     console.log("Good Morning!");
// }

// let promise1 = new Promise((resolve, reject) => {
//     let success = true;
//     if(success) {
//         resolve("Promise resolved");
//     }
//     else {
//         reject("Promise rejected");
//     }
// })

// promise1.then((msg) => {return msg;})
//     .then((msg) => console.log("Then block second msg: ", msg))
//     .catch((msg) => console.error("Catch block msg: ", msg))
//     .finally(() => console.log("Finally block will get executed anyway"));

// let promise1 = new Promise((resolve, reject) => {
//     setTimeout(resolve, 1000, "FirstP");
// });

// let promise2 = new Promise((resolve, reject) => {
//     setTimeout(resolve, 3000, "SecondP");
// });

// let promise3 = new Promise((resolve, reject) => {
//     setTimeout(reject, 5000, "ThirdP");
// });

// Promise.all([promise1, promise2, promise3])
//     .then((values) => console.log(values))
//     .catch((error) => console.error(error));

// async - await 
// They help us write async code in clean & easy to debug way and allows us to write async
// code in synchronous like way i.e we make a block a code wait till some top level code
// completes it's execution.

// async function firstAsyncFn() {
//     return "async fn";
// }

// function syncFn() {
//     return "sync fn";
// }

// console.log(firstAsyncFn());
// console.log(syncFn());

// console.log("I'm synchronous code, I'll be executed first");

// async function getData() {
//     // get req - async
//     let response = await fetch('https://jsonplaceholder.typicode.com/comments?postId=5');
//     // parse response - async
//     let data = await response.json();

//     console.log(data);
// }

// getData();

// closure - binding of function and it's reference variables together
function outerFunction() {
    let name = "Sivakrishna";
    function innerFunction() {
        console.log(name);
    }
    return innerFunction;
}

let inner = outerFunction();
inner();