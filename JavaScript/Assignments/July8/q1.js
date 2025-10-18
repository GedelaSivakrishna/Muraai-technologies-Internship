function factorial(arg) {
    try {
        if(typeof arg === 'number') {
            if(!Number.isInteger(arg) || arg <= 0) {
                throw new Error(`Number cannot be less than or equal to zero or floating point or invalid value`);
            }
            let result = 1;
            for(let i = arg; i >= 1; i--) {
                result *= i;
            }
            return result;
        }
        else {
            throw new Error("Not a valid number");
        }
    }
    catch(error) {
        console.error(error.message);
    }   
}

console.log(factorial(-5));
console.log(factorial("5"));
console.log(factorial(-Infinity));





// console.log(Number.MAX_VALUE);
// console.log(Number.MIN_VALUE);
// console.log(factorial(170));
// console.log(factorial(10));
// console.log(factorial(171));
// console.log(factorial(1000));