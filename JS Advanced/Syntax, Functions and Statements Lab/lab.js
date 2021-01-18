function echoFunction(a) {
    console.log(a.length);
    console.log(a);
}
echoFunction('Hello, JavaScript!')


function stringLength(a, b, c) {
    let sumOfLengths = a.length + b.length + c.length;
    console.log(sumOfLengths);
    console.log(Math.floor(sumOfLengths / 3));
}
stringLength('chocolate', 'ice cream', 'cake');


function largestNumber(...numbers) {
    console.log(`The largest number is ${Math.max(...numbers)}.`);
}
largestNumber(5, -3, 16);


function circleArea(a) {
    // try {
    //     console.log(parseFloat(Math.PI * Math.pow(a, 2)).toFixed(2));
    // } catch (error) {
    //     console.log(`We can not calculate the circle area, because we receive a ${typeof a}.`);
    // }
    if (!isNaN(a) && a !== null && a !== NaN) {
        console.log((Math.PI * Math.pow(a, 2)).toFixed(2));
    } else {
        console.log(`We can not calculate the circle area, because we receive a ${typeof a}.`);
    }
}
circleArea(NaN);


function mathOperations(a, b, c) {
    let result;
    switch (c) {
        case '+': result = a + b; break;
        case '-': result = a - b; break;
        case '*': result = a * b; break;
        case '/': result = a / b; break;
        case '%': result = a % b; break;
        case '**': result = a ** b; break;
    }
    console.log(result);
}
mathOperations(3, 5.5, '*');

function sumOfNumbersNM(n, m) {
    let num1 = Number(n);
    let num2 = Number(m);
    let result = 0;
    for (let i = num1; i <= num2; i++) {
        result += i;
    } console.log(result);
}
sumOfNumbersNM('1', '5');


function dayOfWeek(a) {
    let result;
    switch (a) {
        case 'Monday': result = 1; break;
        case 'Tuesday': result = 2; break;
        case 'Wednesday': result = 3; break;
        case 'Thursday': result = 4; break;
        case 'Friday': result = 5; break;
        case 'Saturday': result = 6; break;
        case 'Sunday': result = 7; break;
        default: result = 'error';
    }
    console.log(result);
}
dayOfWeek('Friday');


function squareOfStars(a = 5) {
    for (let i = 0; i < a; i++) {
        console.log('* '.repeat(a));
    }
}
squareOfStars();


function aggregateElements(elements) {
    aggregate(elements, 0, (a, b) => a + b);
    aggregate(elements, 0, (a, b) => a + 1 / b);
    aggregate(elements, '', (a, b) => a + b);
    function aggregate(arr, initVal, func) {
        let val = initVal;
        for (let i = 0; i < arr.length; i++) {
            val = func(val, arr[i]);
        }
        console.log(val);
    }
}
aggregateElements([2, 4, 8, 16]);