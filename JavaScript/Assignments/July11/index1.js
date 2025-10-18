let operand1 = prompt("Enter number 1");
operand1 = operand1?.trim();
// Handle for space i/p
while (!operand1) {
  alert("Invalid, please enter again ");
  operand1 = prompt("Enter number 1");
  console.log("Operand1 val: ", operand1);
  operand1 = operand1?.trim();
}
operand1 = Number(operand1);

let operand2 = prompt("Enter number 2");
operand2 = operand2?.trim();
// Handle for space i/p
while (!operand2) {
  alert("Invalid, please enter again ");
  operand2 = prompt("Enter number 2");
  operand2 = operand2?.trim();
}
operand2 = Number(operand2);

let operators = ["+", "-", "*", "/", "%", "^"];
let operator = prompt("Enter the operator");
while (!operator || (operator && !operators.includes(operator))) {
  alert("Invalid, please enter again");
  operator = prompt("Enter the operator");
}

// Addition
const add = () => {
  return operand1 + operand2;
};

// Substraction
const substract = () => {
  return operand1 - operand2;
};

// Multiplication
const multiply = () => {
  return operand1 * operand2;
};

// Division
const divide = () => {
  try {
    if (operand2 === 0) {
       throw new Error("Cannot divide by Zero");
    }
    return operand1 / operand2;
  } catch (error) {
    return error.message;
  }
};

// Reminder
const modulus = () => {
  return operand1 % operand2;
};

// Power
const pow = () => {
  return operand1 ** operand2;
};

let result;
switch (operator) {
  case "+":
    result = add();
    break;
  case "-":
    result = substract();
    break;
  case "*":
    result = multiply();
    break;
  case "/":
    result = divide();
    break;
  case "^":
    result = pow();
    break;
  case "%":
    result = modulus();
    break;
}

alert(`${operand1} ${operator} ${operand2} = ${result}`);
