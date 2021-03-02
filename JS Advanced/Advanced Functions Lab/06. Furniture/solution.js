function solve() {
  const [input, output] = [...document.querySelectorAll('textarea')]
  const table = document.querySelector('table.table tbody');
  const [generateBtn, buyBtn] = [...document.querySelectorAll('button')];

  const furniture = [];

  generateBtn.addEventListener('click', () => {
    const furnitureArray = JSON.parse(input.value.trim());
    table.innerHTML = '';
    furnitureArray.forEach(f => {
      const item = createRow(f);
      furniture.push(item);
      table.appendChild(item.element);
    });
  });

  buyBtn.addEventListener('click', () => {
    furniture.forEach(f => console.log(f.getValues().name, f.isChecked()));
  });

  const td = e.bind(null, 'td');

  function createRow(data) {
    const img = e('img');
    img.src = data.img;
    const check = e('input');
    check.type = 'checkbox';

    const element = e('tr',
      td(img),
      td(e('p', data.name)),
      td(e('p', data.price)),
      td(e('p', data.decFactor)),
      td(check));

    return {
      element,
      isChecked,
      getValues
    }

    function isChecked() {
      return check.checked;
    }

    function getValues() {
      return data;
    }
  }

  function e(type, ...content) {
    const result = document.createElement(type);
    content.forEach(e => {
      if (typeof e == 'string') {
        const node = document.createTextNode(e);
        result.appendChild(node);
      } else {
        result.appendChild(e);
      }
    });
    return result;
  }
}