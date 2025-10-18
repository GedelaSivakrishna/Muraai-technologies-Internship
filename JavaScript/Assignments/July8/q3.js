    let operand1 = prompt("Enter number 1");
    operand1 = operand1?.trim();
    while(!operand1) {
        alert("Invalid, please enter again ");
        operand1 = prompt("Enter number 1");
        console.log("Operand1 val: ", operand1);
        operand1 = operand1?.trim();
    }
    operand1 = Number(operand1);

    let operand2 = prompt("Enter number 2");
    operand2 = operand2?.trim();
    while(!operand2) {
        alert("Invalid, please enter again ");
        operand2 = prompt("Enter number 2");
        operand2 = operand2?.trim();
    }
    operand2 = Number(operand2);

    let operators = ['+', '-', '*', '/', '%', '^']
    let operator = prompt("Enter the operator");
    while(!operator || (operator && !operators.includes(operator))) {
        alert("Invalid, please enter again");
        operator = prompt("Enter the operator");
    }

    let result;
    switch(operator) {
        case '+':
            result = operand1 + operand2;
            break;
        case '-':
            result = operand1 - operand2;
            break;
        case '*':
            result = operand1 * operand2;
            break;
        case '/':
            // No exception thrown if we divide by zero
            try {
                if(operand2 == 0) {
                    throw new Error("Cannot divide by Zero");
                }
            result = operand1 / operand2;
            }
            catch(error) {
            result = "Cannot divide by Zero";
            }
            break;
        case '^':
            result = operand1 ** operand2;
            break;
        case '%':
            result = operand1 % operand2;
            break;
    }

    alert(`${operand1} ${operator} ${operand2} = ${result}`);
