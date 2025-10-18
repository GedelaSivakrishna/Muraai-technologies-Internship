    // take array of values as an i/p from user
    let array = prompt("Enter the array values");
    array = array?.trim();

    // handle empty, null values
    while(!array) {
        alert("Please enter the values");
        array = prompt("Enter the array values");
        array = array?.trim();
    }

    // seperate them into array
    let values = array.split(",");
    console.log(values);

    // Map them into numbers
    values = values.map(num => Number(num));

    // filter the positive numbers
    values = values.filter(num => num > 0);

    // print filtered positive values
    console.log(values);