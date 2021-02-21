function solve() {
  const textareas = document.querySelectorAll('textarea');
  const buttons = document.querySelectorAll('button');
  const body = document.querySelector('tbody');
  function createCell(type, textContent, attribute) {
    const cell = document.createElement('td');
    const content = document.createElement(type);
    if (attribute) {
      content.setAttribute(attribute[0], attribute[1]);
    }
    content.textContent = textContent;
    cell.appendChild(content);
    return cell;
  }
  buttons[0].addEventListener('click', (e) => {
    const text = JSON.parse(textareas[0].value);

    text.forEach(el => {
      const row = document.createElement('tr');
      const cellImage = createCell('img', '', ['src', el.img]);
      const cellCheck = createCell('input', '', ['type', 'checkbox']);
      const cellName = createCell('p', el.name);
      const cellPrice = createCell('p', el.price);
      const cellDecor = createCell('p', el.decFactor);
      row.appendChild(cellImage);
      row.appendChild(cellName);
      row.appendChild(cellPrice);
      row.appendChild(cellDecor);
      row.appendChild(cellCheck);
      body.appendChild(row);
    });
    document.querySelector('textarea').value = '';
  })
  buttons[1].addEventListener('click', (e) => {
    const furniture = [...body.querySelectorAll('input[type=checkbox]:checked')].map(i => i.parentNode.parentNode).reduce((acc, cur) => {
      const currentItem = cur.querySelectorAll('p');
      acc.items.push(currentItem[0].textContent);
      acc.price += Number(currentItem[1].textContent);
      acc.decFactor += Number(currentItem[2].textContent);
      return acc;
    }, { items: [], price: 0, decFactor: 0 });
    textareas[1].value = `Bought furniture: ${furniture.items.join(', ')}\nTotal price: ${furniture.price.toFixed(2)}\nAverage decoration factor: ${furniture.decFactor / furniture.items.length}`
  })
}