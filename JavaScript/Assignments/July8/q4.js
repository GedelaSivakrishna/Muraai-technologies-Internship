    function validTemperatureRange(celsius) {
        celsius = celsius?.trim();
        if(celsius) {
            celsius = Number(celsius);
            if(celsius < -273 || celsius > 100) {
                return false;
            }
            console.log("Valid temperature: ", celsius);
            return true;
        } 
        return false;
    }

    let celsius = prompt("Enter the celsius temperature");
    celsius = celsius?.trim();
    if(!validTemperatureRange(celsius)) {
        celsius = null;
    }

    while(!celsius) {
        alert("Invalid, Enter a valid celsius value");
        celsius = prompt("Enter the celsius temperature");
        if(!validTemperatureRange(celsius)) {
            celsius = null;
        }
    }
    let farenheit = (celsius * 1.8) + 32;
    alert(`${celsius}'C in Farenheit = ${farenheit.toFixed(2)}'F`);

