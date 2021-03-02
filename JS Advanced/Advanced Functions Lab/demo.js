function pow(power, num) {
    return num ** power;
}

const sqr = pow.bind(null, 2);

console.log(sqr(3));
console.log(sqr(4));
console.log(sqr(5));
console.log(pow(3, 2));