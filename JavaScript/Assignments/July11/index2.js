let arr1 = [95, 92, 82, "Sivakrishna", 22, 9692849788, undefined];
let arr2 = ["gedelasivakrishna1@gmail.com", 22, "Odisha", 95, null];

// merged arr1 & arr2
let values = [...arr1, ...arr2];

// removed invalid data
values = values.filter((val) => typeof(val) !== "undefined" && val !== null);

// remove duplicate data 
// condition - unique elements return same index from both ends
values = values.filter((val) => values.indexOf(val) === values.lastIndexOf(val));

console.log(values);

