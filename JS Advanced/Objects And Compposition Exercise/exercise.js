function calorieObject(arr) {
    let el = {};
    for (let i = 0; i < arr.length; i += 2) {
        el[arr[i]] = Number(arr[i + 1]);
    }
    return el;
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
    function selectEngine(power) {
        if (power > 120) {
            return { power: 200, volume: 3500 };
        } else if (power > 90) {
            return { power: 120, volume: 2400 };
        } else { return { power: 90, volume: 1800 }; }
    }
    let car = {};
    car.model = obj.model;
    car.engine = selectEngine(obj.power);
    car.carriage = { type: obj.carriage, color: obj.color };
    car.wheelsize = Array(4).fill(obj.wheelsize % 2 === 0 ? obj.wheelsize - 1 : obj.wheelsize);
    return car;
}
console.log(carFactory({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}
));