    // take product prices input
    let prices = prompt("Enter the product prices");
    prices = prices?.trim();

    // handle empty or null values
    while(!prices) {
        alert("Please enter the product price values");
        prices = prompt("Enter the product prices");
        prices = prices?.trim();
    }

    // split them to array
    prices = prices.split(",");

    // map them to numbers
    prices = prices.map(val => Number(val));

    // filter the numbers
    prices = prices.filter(num => num > 0);

    // sort the prices
    // ascending 
    prices = prices.sort((a,b) => a-b);
    // descending
    // prices = prices.sort((a,b) => b-a);

    // print the sorted prices
    console.log(prices);