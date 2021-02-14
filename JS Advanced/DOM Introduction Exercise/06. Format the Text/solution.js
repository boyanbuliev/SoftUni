function solve() {
  let text = document.getElementById('input').value.split('.').filter(el => el != '').map(el => el.trim());

  document.getElementById('output').innerHTML = text.map((el, index) => {
    if (index % 3 == 0) {
      el = `<p>${el}.`;
    } else if (index % 3 == 2 || index == text.length - 1) {
      el = `${el}.</p>`;

    } else {
      el = el + '.';
    }
    return el;
  }).join('');
}