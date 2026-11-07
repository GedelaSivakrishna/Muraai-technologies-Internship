function linearSearch() {
    // implementation
}

function binarySearch() {
    // implementation
}

// We use `module` global variable in commonJS approach to export
// module.exports = {
//     linearSearch,
//     binarySearch
// }

// module.exports = linearSearch;
exports.binarySearch = binarySearch; // This comes into picture when module.exports is not used.
exports.linearSearch = linearSearch;
// console.log(exports);