function isPalindrome(arg) {
    try {
        if(typeof(arg) === "string") {
            let left = 0, right = arg.length - 1;
            while(left < right) {
                if(arg.charAt(left) != arg.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        else {
            throw new Error("Invalid argument");
        }
    }
    catch(error) {
        console.log(error.message)
    }
}

// null, undefined, NaN, Integers
isPalindrome(null);
isPalindrome();
isPalindrome(NaN);
isPalindrome(123);
console.log(isPalindrome(""));