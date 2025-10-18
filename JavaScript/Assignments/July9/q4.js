    // take string i/p
    let input = prompt("Enter a String");
    input = input?.trim();

    // handle null or empty values
    while(!input) {
        alert("Please enter a string");
        input = prompt("Enter a String");
        input = input?.trim();
    }

    let freqMap = new Map();

    // convert the string to lowercase and iterate through characters and
    input = input.toLowerCase();
    for(let i = 0; i < input.length; i++) {
        let ch = input.charAt(i);
        if(ch >= 'a' && ch <= 'z') {
            let prevVal = freqMap.get(ch) || 0;
            freqMap.set(ch, prevVal + 1);
            // console.log("Current alpha char: ", ch);
        }
    }

    // print the character frequencies
    console.log("Frequeny map after storing characters frequencies: ", freqMap);
    // alert("Frequency = " + freqMap.forEach((value, key) => `${key} -> ${value}, `));