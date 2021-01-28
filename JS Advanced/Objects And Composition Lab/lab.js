function cityRecord(name, population, treasury) {
    const city = {
        name,
        population,
        treasury
    }
    return city;
}
console.log(cityRecord('Tortuga', 7000, 15000));

function townPopulation(townsString) {
    // let towns = {};
    // townsString.forEach(r => {
    //     let [name, population] = r.split(' <-> ');
    //     population = Number(population);
    //     if (towns[name] != undefined) {
    //         population += towns[name];
    //     }
    //     towns[name] = population;
    // });

    const towns = townsString.reduce((towns, r) => {
        let [name, population] = r.split(' <-> ');
        population = Number(population);
        if (towns[name] != undefined) {
            population += towns[name];
        }
        towns[name] = population;
        return towns;
    }, {});
    Object.keys(towns).forEach(town => console.log(town + ' : ' + Number(towns[town])));
}
townPopulation(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']);

function townsToJson(input) {
    let data = input.map(row => row.split('|').filter(x => x != '').map(x => x.trim()));
    let properties = data.shift();

    let result = [];
    data.forEach(r => {
        let town = {
            [properties[0]]: r[0],
            [properties[1]]: Number(Number(r[1]).toFixed(2)),
            [properties[2]]: Number(Number(r[2]).toFixed(2)),
        }
        result.push(town);
    });
    console.log(JSON.stringify(result));
}
townsToJson(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
);

function fromJsonToHtmlTable(input) {
    let jsonData = input.shift();
    let students = JSON.parse(jsonData);
    let first = students[0];
    let html = '<table>';
    html += `<tr>${Object.keys(first).map(x => `<th>${x}</th>`).join('')}</tr>`;
    students.forEach(student => {
        html += '<tr>';
        html += Object.values(student).map(x => `<td>${x}</td>`).join('');
        html += '</tr>';
    })
    html += '</table>';
    console.log(html);
}
fromJsonToHtmlTable(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]'])

const myObj = {
    firstName: 'Peter',
    lastName: 'Johnson',
    fullName() {
        return this.firstName + ' ' + this.lastName
    },
    sayHi() {
        return 'Hi';
    },
}

const person = {
    firstName: 'Pesho',
    lastName: 'Goshov',
};
person.fullName = myObj.fullName;

console.log(person.fullName());

function cookingByNumbers(...items) {
    let number = Number(items.shift());
    const operations = {
        chop(num) { return num /= 2 },
        dice(num) { return num = Math.sqrt(num) },
        spice(num) { return num += 1 },
        bake(num) { return num *= 3 },
        fillet(num) { return num *= 0.8 },
    }
    items.forEach(x => {
        number = operations[x](number);
        console.log(number);
    });
}
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet')

function cityTaxes(name, population, treasury) {
    const city = {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += this.population * this.taxRate;
        },
        applyGrowth(percentage) {
            this.population *= 1 + percentage / 100;
        },
        applyRecession(percentage) {
            this.treasury *= 1 - percentage / 100;
        },
    }
    return city;
}
const city =
    cityTaxes('Tortuga',
        7000,
        15000);
city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);

function createRect(width, height) {
    const rect = { width, height };
    rect.getArea = () => {
        return rect.width * rect.height;
    };
    return rect;
}

const myRect = createRect(15, 10);

console.log(myRect);

console.log(myRect.getArea());

const getArea = myRect.getArea;

console.log(getArea());

const library = {
    print: function () {
        console.log(`${this.name} is printing a page`);
    },
    scan: function () {
        console.log(`${this.name} is scanning a document`);
    },
    play: function (artist, track) {
        console.log(`${this.name} is playing '${track}' by ${artist}`);
    },
};
const orders = [
    {
        template: { name: 'ACME Printer' },
        parts: ['print']
    },
    {
        template: { name: 'Initech Scanner' },
        parts: ['scan']
    },
    {
        template: { name: 'ComTron Copier' },
        parts: ['scan', 'print']
    },
    {
        template: { name: 'BoomBox Stereo' },
        parts: ['play']
    },
];

const factory = (library, orders) => orders.map(order => Object.assign({}, order.template, order.parts.reduce((a, c) => Object.assign(a, { [c]: library[c] }), {})));


const products = factory(library, orders);
console.log(products);

const player = products[3];
