// // setTimeout, clearTimeout
// // We use them to show loaders if data is not fetched within some time
// let timeoutId

// function showLoader() {
//     timeoutId = setTimeout(()=>{
//         console.log("showing loader after 5 seconds");
//     }, 5000);
// }

// showLoader();

// function showNotification() {
//     timeoutId = setTimeout(()=>{
//         console.log("cancel loader after 5 seconds");
//     }, 5000);
// }

// showNotification()

// function dismissNotification() {
//     clearTimeout(timeoutId);
// }

// setTimeout(()=>{
//     dismissNotification();
// }, 2000);

// console.log("This line gets executed immediately,,");

// setInterval, clearInterval
// console.log("Amazon sale offer started ! Ends in 10secs");

let intervalId;

function showOffer() {
    let time = 10;
    intervalId = setInterval(()=>{
        console.log(`Updating the offer timer: ${time}`);
        time--;
    },1000);
}

showOffer();

function endOffer() {
    clearInterval(intervalId);
}

setTimeout(()=>{
    endOffer();
},11000);
