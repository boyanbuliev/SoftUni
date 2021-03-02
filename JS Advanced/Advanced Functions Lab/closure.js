function createCounter() {
    let count = 0;
    return function () {
        count++;
        console.log(count);
    }
}
const myCounter1 = createCounter();
myCounter1();
myCounter1();
myCounter1();
myCounter1();
myCounter1();

const myCounter2 = createCounter();
myCounter2();
myCounter2();
myCounter2();
myCounter2();