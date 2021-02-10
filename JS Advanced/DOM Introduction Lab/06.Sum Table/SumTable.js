function sumTable() {
    const items = [...document.querySelectorAll('table tr td:last-child')].slice(0, -1).map(el => Number(el.textContent));
    document.getElementById('sum').textContent = items.reduce((acc, cur) => acc + cur);
}