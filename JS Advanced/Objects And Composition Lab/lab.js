function cityRecord(el1, el2, el3) {
    let city = {};
    city.name = el1;
    city.population = el2;
    city.treasury = el3;
    return city;
}
console.log(cityRecord('Tortuga', 7000, 15000));

function townPopulation(townsString) {
    let towns = [];
    townsString.forEach(x => {
        let splitString = x.split(' <-> ');
        let currentTown = { name: splitString[0], population: Number(splitString[1]) };
        if (towns.some(e => e.name == currentTown.name)) {
            towns.some(e => e.population += currentTown.population);
        } else {
            towns.push(currentTown);
        }
    });
    towns.forEach(x => console.log(x.name + ' : ' + Number(x.population)));
}
townPopulation(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
);

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