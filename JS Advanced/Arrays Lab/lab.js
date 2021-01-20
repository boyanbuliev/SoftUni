function evenPositionElement(numbers) {
    let elements = [];
    for (let i = 0; i < numbers.length; i++) {
        if (i % 2 == 0) {
            elements.push(numbers[i]);
        }
    }
    console.log(elements.join(' '));
}
evenPositionElement(['20', '30', '40', '50', '60']);

function lastKNumbersSequence(n, k) {
    let elements = [1];
    for (let i = 0; i < n - 1; i++) {
        elements.push(elements.slice(i - k + 1 > 0 ? i - k + 1 : 0).reduce((a, b) => a + b, 0));
        //     for (let j = 0; j < k; j++) {
        //         if (elements[i - j]) {
        //             currentElement += elements[i - j];
        //         } else {
        //             break;
        //         }
        //     }
        //     elements.push(currentElement);
    }
    console.log(elements.join(' '));
}
lastKNumbersSequence(8, 2);


function sumFirstLast(numbers) {
    console.log(Number(numbers[0]) + Number(numbers[numbers.length - 1]));
}
sumFirstLast(['20', '30', '40']);

function negativePositiveNumbers(elements) {
    let arr = [];
    for (let i = 0; i < elements.length; i++) {
        if (elements[i] < 0) {
            arr.unshift(elements[i]);
        } else {
            arr.push(elements[i]);
        }
    }
    console.log(arr.join('\n'));
}
negativePositiveNumbers([7, -2, 8, 9]);
// let numbers = [6, 3, 7, 3, 8, 5, 1, 9, 10];
// let names = ['Gosho', 'Pesho', 'Mariyka', 'Stamat'];
// let otherNames = ['Superman', 'Batman', 'WanderWomаn', 'Spiderman', 'Ironman'];
// let dcHeroes = otherNames.slice(0, 3);
// console.log(dcHeroes);
// otherNames.filter(x => x[0] !== 'S').forEach(x => console.log(x));
// console.log(otherNames.find(x => x[0] === 'S'));
// console.log(otherNames.some(x => x[0] === 'S'));
// otherNames.map(x => x.toUpperCase()).forEach(x => console.log(x));

// console.log(otherNames.reduce((a, b) => a + b[0], ''));

function smallestTwoNumbers(numbers) {
    console.log(numbers.sort((n1, n2) => n1 - n2).slice(0, 2));
}
// smallestTwoNumbers([30, 15, 50, 5]);

function biggerHalf(numbers) {
    console.log(numbers.sort((a, b) => a - b).slice(numbers.length / 2));
}
// biggerHalf([3, 19, 14, 7, 2, 19, 6]);


function pieceOfPie(arr, first, second) {
    console.log(arr.slice(arr.indexOf(first), arr.indexOf(second) + 1));
}
// pieceOfPie(['Pumpkin Pie', 'Key Lime Pie', 'Cherry Pie', 'Lemon Meringue Pie',
//     'Sugar Cream Pie'], 'Key Lime Pie', 'Lemon Meringue Pie');

function processOddPositions(arr) {
    console.log(arr.filter((x, i) => i % 2 != 0).map(x => x * 2).reverse());
}
processOddPositions([3, 0, 10, 4, 7, 3]);

function biggestElement(matrix) {
    let biggest = Number.MIN_SAFE_INTEGER;
    // console.log(Math.max(...matrix.map(row => Math.max(...row))));
    console.log(matrix.map(row => Math.max(...row)).reduce((a, b) => Math.max(a, b), Number.MIN_SAFE_INTEGER));
}
biggestElement([[3, 5, 7, 12], [-1, 4, 33, 2], [8, 3, 0, 4]]);

function diagonalSums(arr) {
    let diagonals = [0, 0];
    for (let i = 0; i < arr.length; i++) {
        diagonals[0] += arr[i][i];
        diagonals[1] += arr[i][arr.length - i - 1];
    }
    console.log(diagonals.join(' '));
}
diagonalSums([[3, 5, 17], [-1, 7, 14], [1, -8, 89]]);

function equalNeighbours(matrix) {
    let count = 0;
    for (let row = 0; row < matrix.length - 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == matrix[row + 1][col]) {
                count++;
            }
            if (matrix[row][col] == matrix[row][col + 1]) {
                count++;
            }
            if (row == matrix.length - 2) {
                if (matrix[row + 1][col] == matrix[row + 1][col + 1]) {
                    count++;
                }
            }
        }
    }

    console.log(count);
}
equalNeighbours([[2, 2, 5, 7, 4,], [4, 0, 5, 3, 4], [2, 5, 5, 4, 2]]);