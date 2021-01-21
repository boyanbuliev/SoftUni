const printArrayWithAGivenDelimiter = (el, del) => el.join(del);

const printEveryNthElementFromAnArray = (arr, step) => arr.filter((x, i) => i % step == 0);

printEveryNthElementFromAnArray(['5', '20', '31', '4', '20'], 2);

function addAndRemoveElements(arr) {
    let elements = [];
    arr.forEach((x, i) => x === 'add' ? elements.push(i + 1) : elements.pop());
    return elements.length > 0 ? elements.join('\n') : 'Empty';
}
addAndRemoveElements(['remove',
    'remove',
    'remove']
);

function rotateArray(arr, n) {
    for (let i = 0; i < n; i++) {
        arr.unshift(arr.pop());
    }
    return arr.join(' ');
}
rotateArray(['Banana', 'Orange', 'Coconut', 'Apple'], 15);


const extractIncreasingSubsequenceFromArray = (arr) => arr.reduce((acc, cur) => {
    if (cur >= acc[acc.length - 1] || acc.length === 0) {
        acc.push(cur);
    }
    return acc;
}, []);
// console.log(extractIncreasingSubsequenceFromArray([20, 3, 2, 15, 6, 1]));

const listOfNames = (arr) => arr.sort((a, b) => a.localeCompare(b)).map((e, i) => e = i + 1 + '.' + e)
    .join('\n');
console.log(listOfNames(["John", "Bob", "Christina", "Ema"]));

function sortingNumbers(arr) {
    arr.sort((a, b) => a - b);
    let newArr = [];
    while (arr.length) {
        newArr.push(arr.shift());
        newArr.push(arr.pop());
    }
    return newArr.filter(x => x != undefined);
}
console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));


const sortArrayByTwoCriteria = (arr) => arr.sort((a, b) => a.length == b.length ?
    a.localeCompare(b) : a.length - b.length).join('\n');
console.log(sortArrayByTwoCriteria(['Isacc', 'Theodor', 'Jack', 'Harrison', 'George']));


function magicMatrices(matrix) {
    let rowSum = matrix.map(x => x.reduce((a, b) => a + b, 0)).every((e, i, arr) => e === arr[0]);
    let colSum = matrix.reduce((a, b) => a.map((x, i) => x + (b[i] || 0))).every((e, i, arr) => e === arr[0]);
    return rowSum && colSum;
    // let rowSum = matrix[0].reduce((a, b) => a + b, 0);
    // for (let i = 1; i < matrix.length; i++) {
    //     if (matrix[i].reduce((a, b) => a + b, 0) != rowSum) {
    //         return false;
    //     }
    // }
    // for (let i = 0; i < matrix[0].length; i++) {
    //     let colSum = 0;
    //     for (let j = 0; j < matrix.length; j++) {
    //         colSum += matrix[j][i];
    //     }
    //     if (colSum != rowSum) {
    //         return false;
    //     }
    // }
    // return true;
}
console.log(magicMatrices([[1, 0, 0],
[0, 0, 1],
[0, 1, 0]]

));