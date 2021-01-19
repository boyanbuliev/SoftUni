function fruit(fruit, weight, price) {
    console.log(`I need $${(price * weight / 1000)} to buy ${(weight /
        1000)} kilograms ${fruit}.`);
}
fruit('orange', 2500, 1.80);


function greatestCommonDivisor(a, b) {
    let smallestNum = Math.min(a, b);
    for (let i = smallestNum; i > 0; i--) {
        if (a % i == 0 && b % i == 0) {
            console.log(i);
            break;
        }
    }
}
greatestCommonDivisor(512, 256);


function sameNumbers(a) {
    let number = a.toString();
    function isEqual(num) {
        for (let i = 0; i < num.length - 1; i++) {
            if (num.charAt(i) !== num.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    function count(numberString) {
        let sum = 0;
        for (let i = 0; i < numberString.length; i++) {
            sum += Number(numberString[i]);
        }
        return sum;
    }
    console.log(isEqual(number));
    console.log(count(number));
}
sameNumbers(222222);


function timeToWalk(steps, stepLength, speed) {
    let distanceToUni = stepLength * steps;
    let speedInMetPerSec = speed * 1000 / 3600;
    let breaks = Math.floor(distanceToUni / 500) * 60;
    let timeToUni = Math.round(distanceToUni / speedInMetPerSec + breaks);
    let hours = addLeadingZero(Math.floor(timeToUni / 3600));
    let minutes = addLeadingZero(Math.floor(timeToUni / 60) % 60);
    let seconds = addLeadingZero(timeToUni % 60);
    function addLeadingZero(number) {
        if (number < 10) {
            return '0' + number;
        } else {
            return number;
        }
    }
    console.log(`${hours}:${minutes}:${seconds}`);
}
timeToWalk(7000, 0.70, 5.5);


function roadRadar(speed, area) {
    let speeding = 0;
    switch (area) {
        case 'motorway': if (speed > 130) { speeding = speed - 130; } break;
        case 'interstate': if (speed > 90) { speeding = speed - 90; } break;
        case 'city': if (speed > 50) { speeding = speed - 50; } break;
        case 'residential': if (speed > 20) { speeding = speed - 20; } break;
    }
    if (speeding > 0) {
        if (speeding <= 20) {
            console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${returnAreaSpeed(area)} - ${'speeding'}`);
        } else if (speeding <= 40) {
            console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${returnAreaSpeed(area)} - ${'excessive speeding'}`);
        } else {
            console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${returnAreaSpeed(area)} - ${'reckless driving'}`);
        }
    } else {
        console.log(`Driving ${speed} km/h in a ${returnAreaSpeed(area)} zone`);
    }
    function returnAreaSpeed(givenArea) {
        switch (givenArea) {
            case 'motorway': return 130;
            case 'interstate': return 90;
            case 'city': return 50;
            case 'residential': return 20;
        }
    }
}
roadRadar(200, 'motorway');


function cookingByNumbers(...items) {
    number = Number(items.shift());
    for (let i = 0; i < items.length; i++) {
        switch (items[i]) {
            case 'chop': number /= 2; break;
            case 'dice': number = Math.sqrt(number); break;
            case 'spice': number++; break;
            case 'bake': number *= 3; break;
            case 'fillet': number = number - 0.2 * number; break;
        }
        console.log(number);
    }
}
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');


function validityChecker(x1, y1, x2, y2) {
    console.log(`{${x1}, ${y1}} to {${0}, ${0}} is ${isValid(x1, y1, 0, 0)}`);
    console.log(`{${x2}, ${y2}} to {${0}, ${0}} is ${isValid(x2, y2, 0, 0)}`);
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${isValid(x1, y1, x2, y2)}`);
    function isValid(p1, p2, p3, p4) {
        return Number.isInteger(Math.sqrt((p3 - p1) ** 2 + (p4 - p2) ** 2)) ? 'valid' : 'invalid';
    }
}
validityChecker(2, 1, 1, 1);


function wordsUppercase(string) {
    let splitted = string.split(/\W+/);
    if (splitted[splitted.length - 1] === '') {
        splitted.length = splitted.length - 1;
    }
    splitted = splitted.map(function (e) { return e.toUpperCase() });
    console.log(splitted.join(', '));
}
wordsUppercase('Hi, how are you?');


function calorieObject(items) {
    let arr = [];
    let count = 0;
    for (let i = 0; i < items.length; i += 2) {
        arr[count++] = { name: items[i], calories: items[i + 1] }
    }
    arr.forEach(o => console.log(o.name + ': ' + o.calories));
}
calorieObject(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);