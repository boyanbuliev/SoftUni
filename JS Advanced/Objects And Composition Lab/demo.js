class Person {
    static type = 'No homo';
    #currentAge;
    constructor(firstName, lastName, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.#greet();
    }
    get fullName() {
        return this.firstName + ' ' + this.lastName;
    }

    set age(value) {
        if (value > 0 && value < 120) {
            this.#currentAge = value;
        }
    }
    get age() {
        return this.#currentAge;
    }
    #greet() {
        console.log('Hi, my name is ' + this.fullName);
    }

    static talk() {
        console.log('blabla');
    }
}

let person1 = new Person('Pesho', 'Petrov', -18);
let person2 = new Person('Gosho', 'Ivanov', 22);

Person.talk();
console.log(Person.type);