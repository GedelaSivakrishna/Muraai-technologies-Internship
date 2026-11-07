function union(arr1, arr2) {
    // create a set
    let set = new Set();
    
    // add 1st array elements
    for(let elem of arr1) {
        if(elem != null && typeof(elem) == "object") {
            if(deepEqualityCheck(set, elem)) { // elem already present, continue to next element
                continue;
            }
        }
        set.add(elem);
    }

    // add 2nd array elements
    for(let elem of arr2) {
        if(elem != null && typeof(elem) == "object") {
            if(deepEqualityCheck(set, elem)) { // elem already present, continue to next element
                continue;
            }
        }
        set.add(elem);
    }

    // copy elements from set to array
    let result = [...set];

    // return result array
    console.log(result);
}

function deepEqualityCheck(set, val) {
    // if val object equals value, then it's already present in the set 
    for(let value of set.values()) {
        if(Array.isArray(value) && Array.isArray(val)) {
            if(deepArrayEqualityCheck(value, val)) return true;
        } else if (value != null && typeof(value) == "object") {
            if(deepObjectEqualityCheck(value, val)) return true;
        }
    }

    // if val object not present in the set
    return false;
}

function deepArrayEqualityCheck(array1, array2) {
    // check lengths
    if(array1.length != array2.length) {
        return false;
    }

    // 1. checks if both arrays has elements present at same index, 
    // 2. every returns true for empty arrays, it doesn't even execute the callback even once for empty arrays
    //    as there are no elements to traverse.
    return array1.every((element, index) => element === array2[index]);
}

function deepObjectEqualityCheck(object1, object2) {
    // check if the references are same
    if(object1 == object2) return true;

    // check if the type of both parameters are objects and not null
    if(typeof(object1) != "object" || typeof(object1) == null || typeof(object2) != "object" || typeof(object2) == null) {
        return false;
    }

    // get the keys and compare lengths
    let keys1 = Object.keys(object1);
    let keys2 = Object.keys(object2);

    if(keys1.length != keys2.length) return false;

    let keySet = new Set(keys2);

    // check if all keys of object1 are present in object2 and recursively check for values
    for(let key of keys1) {
        // check if key present in object2
        if(!keySet.has(key)) return false;

        // recursively check for values of keys of both objects
        if(!deepObjectEqualityCheck(object1[key], object2[key])) return false;
    }

    // if all keys and values match, object1 equal to object2
    return true;
}

// union([1,2,3], [2,3,4]); // [1,2,3,4]
// union(['a'], ['b']); // ['a', 'b']
// union([1], ['1', 1]); // [1, '1']
// union([{a: {b: 10}}], [{a: {b: 20}}]); // [ { a: { b: 10 } }, { a: { b: 20 } } ]
// union([{b: 10, c: {z: {t: 5, _t: 5}, f: [4]}}, 2], [{b: 10, c: {z: {t: 5, _t: 5}, f: [4]}}, '2']);
// union(['siva', ''], ['krishna', 'siva', '']); // ['siva', '', 'krishna']
// union([true, false, true], [false, false, true]); // [true, false]
// union([null, []], [[]]); // [null, []]
// console.log();
// union([undefined], [undefined, undefined]); // [undefined]
// union([{}, {}], [{}]); // [{}]
// console.log(typeof([]));
// console.log(deepArrayEqualityCheck([1, 2], [2, 1]));
// console.log(typeof([]));
// console.log(Object.keys([0, 1, 5]));
// let object1 = {
//     name: "Gedela",
//     address: {
//         state: "Odisha",
//         pincode: 761208
//     }
// }

// let object2 = {
//     name: "Gedela",
//     address: {
//         pincode: 761208,
//         state: "Odisha"
//     }
// }

// console.log(deepObjectEqualityCheck(object1, object2));
// union([[]], [[]]); // [[]]
// union([{}, {}], [{}]);
// union([{b: 10, c: {z: {t: 5, _t: 5}, f: [4]}}, 2], [{b: 10, c: {z: {t: 5, _t: 5}, f: [4]}}, '2']);
// union([null, null], [null]);