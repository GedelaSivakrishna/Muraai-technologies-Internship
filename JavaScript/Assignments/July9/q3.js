    // take array values input
    let values = prompt("Enter the values");
    values = values?.trim();
    // values = values.split(",");
    if(values) {
        values = formatValues(values);
        if(values?.length <= 1) {
            values = null;
        }
    }

    // handle null or empty values or single values
    while(!values || values?.length <= 1) {
        alert("Please enter atleast two integer values");
        values = prompt("Enter the values");
        values = values?.trim();
        if(values) {
            values = formatValues(values);
            console.log("Formatted values: ", values);
            if(values?.length <= 1) {
                values = null;
            }
        }
    }

    // console.log("Entered numeric values: ", values);
    function formatValues(values) {
        let numValues = values?.split(",");
        numValues = numValues?.map(val => Number(val));
        numValues = numValues?.filter(val => (typeof(val) === "number" && !isNaN(val)));
        return numValues;
    }
    // find the second largest element and show it in alert
    let largest = Number.NEGATIVE_INFINITY;
    let secondLargest = Number.NEGATIVE_INFINITY;
    console.log("Values for finding second Largest = ", values);
    for(let i = 0; i < values.length; i++) {
        let currVal = values[i];
        if(currVal > largest) {
            secondLargest = largest;
            largest = currVal;
        }
        else if (currVal > secondLargest) {
            secondLargest = currVal;
        }
    }
    // resolve the prompt suppressed console warning
    alert("Second Largest element = " + secondLargest);