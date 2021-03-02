function area() {
    return Math.abs(this.x * this.y);
};
function vol() {
    return Math.abs(this.x * this.y * this.z);
};
const solve = (area, vol, input) => JSON.parse(input).map(f => ({ area: area.call(f), volume: vol.call(f) }));
// return JSON.parse(input).reduce((obj, fig) => {
//     obj.push({ area: area.call(fig), volume: vol.call(fig) });
//     return obj;
// }, []);

console.log(solve(area, vol, '[{ "x": "1", "y": "2", "z": "10" }, { "x": "7", "y": "7", "z": "10" }, { "x": "5", "y": "2", "z": "10" }]'));
