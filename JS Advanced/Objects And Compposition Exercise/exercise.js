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
        dictionary[letter].sort((a, b) => a.name.localeCompare(b.name))
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

