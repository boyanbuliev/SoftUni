function calorieObject(arr) {
    // let el = {};
    // for (let i = 0; i < arr.length; i += 2) {
    //     el[arr[i]] = Number(arr[i + 1]);
    // }
    // return el;
    let result = {};
    arr.forEach((el, i) => i % 2 == 0 ? result[el] = undefined : result[arr[i - 1]] = Number(el));
    return result;
}
console.log(calorieObject(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']));

function constructionCrew(obj) {
    if (obj.dizziness) {
        obj.levelOfHydrated += obj.experience * obj.weight * 0.1;
        obj.dizziness = false;
    }
    return obj;
}
console.log(constructionCrew({
    weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true
}
));

function carFactory(obj) {
    const { model, power, carriage, color, wheelsize } = obj;
    function selectEngine(power) {
        const engines = [{ power: 90, volume: 1800 }, { power: 120, volume: 2400 }, { power: 200, volume: 3500 }]
        return engines.find(el => el.power >= power);
    }
    return {
        model,
        engine: selectEngine(power),
        carriage: { type: carriage, color },
        wheels: Array(4).fill(wheelsize % 2 === 0 ? wheelsize - 1 : wheelsize),
    }
}
console.log(carFactory({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}
));

function heroicInventory(arr) {
    let result = [];
    // arr.forEach(r => {
    //     let [name, level, items] = r.split(' / ');
    //     level = Number(level);
    //     items = items ? items.split(', ') : [];
    //     result.push({ name, level, items });
    // });
    while (arr.length) {
        let hero = arr.shift();
        let [name, level, items] = hero.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : [];
        result.push({ name, level, items });
    }
    return JSON.stringify(result);
}
console.log(heroicInventory(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
));

function lowestPricesInCities(arr) {
    let result = {};

    arr.forEach(r => {
        let [town, product, price] = r.split(' | ');
        if (!result[product]) {
            result[product] = { town, price: Number(price) };
        } else {
            result[product] = result[product].price <= Number(price) ? result[product] : { town, price: Number(price) };
        }
    });
    let log = [];
    Object.keys(result).forEach(key => log.push(`${key} -> ${result[key].price} (${result[key].town})`));
    return log.join('\n');
}
console.log(lowestPricesInCities(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']));


function storageCatalogue(arr) {
    // let result = [];
    // arr.forEach(el => {
    //     let [name, price] = el.split(' : ');
    //     result.push({ name, price: Number(price) })
    // })
    // result.sort((a, b) => a.name.localeCompare(b.name));
    // let current = undefined;
    // let final = [];
    // for (const item of result) {
    //     if (item.name[0] != current) {
    //         current = item.name[0];
    //         final.push(current);
    //     }
    //     final.push(`  ${item.name}: ${item.price}`);
    // }
    // return final.join('\n');

    let dictionary = {};
    while (arr.length) {
        let [name, price] = arr.shift().split(' : ');
        const letter = name[0];
        if (!dictionary[letter]) {
            dictionary[letter] = [];
        }
        dictionary[letter].push({ name, price: Number(price) });
    }
    let result = [];
    Object.entries(dictionary).sort((a, b) => a[0].localeCompare(b[0])).forEach(entry => {
        let values = entry[1].sort((a, b) => (a.name).localeCompare(b.name)).map(product => `  ${product.name}: ${product.price}`).join('\n');
        let string = `${entry[0]}\n${values}`;
        result.push(string);
    })
    return result.join('\n');
}
console.log(storageCatalogue(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']));

function townsToJson(arr) {
    let [columns, ...table] = arr.map(splitLine);
    function isEmptyString(x) { return x != '' }
    function convertIfNum(x) { return isNaN(x) ? x : +Number(x).toFixed(2) }
    function splitLine(input) {
        return input.split('|').filter(isEmptyString).map(x => x.trim()).map(convertIfNum);
    }
    return JSON.stringify(table.map(entry => {
        return columns.reduce((acc, curr, index) => {
            acc[curr] = entry[index];
            return acc;
        }, {});
    }));
    // let [town, latitude, longitude] = arr.shift().split('\|').filter(e => e != '').map(x => x.trim());
    // let result = [];
    // while (arr.length) {
    //     let currentTown = arr.shift().split('\|').filter(e => e != '').map(x => x.trim());
    //     let current = {
    //         [town]: currentTown[0],
    //         [latitude]: +Number(currentTown[1]).toFixed(2),
    //         [longitude]: +Number(currentTown[2]).toFixed(2),
    //     }
    //     result.push(current);
    // }
    // return JSON.stringify(result);
}
console.log(townsToJson(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));


function rectangle(width, height, color) {
    function capitalize(word) { return word[0].toUpperCase() + word.slice(1); };
    function calcArea() { return this.width * this.height; };
    return {
        width, height, color: capitalize(color), calcArea,
    }
}
let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());


function createSortedList() {
    let list = [];
    function add(element) {
        list.push(element);
        this.size++;
        list.sort((a, b) => a - b);
    }
    function remove(index) {
        if (index >= 0 && index < list.length) {
            list.splice(index, 1);
            this.size--;
        }
    }
    function get(index) {
        if (index >= 0 && index < list.length) {
            return list[index];
        }
    }
    return { add, remove, get, size: 0 };
}
let list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));


function heroes() {
    const canCast = (state) => ({
        cast: (spell) => {
            console.log(`${state.name} cast ${spell}`);
            state.mana--;
        }
    })
    const canFight = (state) => ({
        fight: () => {
            console.log(`${state.name} slashes at the foe!`);
            state.stamina--;
        }
    })
    const mage = (name) => {
        let state = { name, health: 100, mana: 100 };
        return Object.assign(state, canCast(state));
    }
    const fighter = (name) => {
        let state = { name, health: 100, stamina: 100 };
        return Object.assign(state, canFight(state));
    }
    return { mage, fighter }
}
let create = heroes();
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);