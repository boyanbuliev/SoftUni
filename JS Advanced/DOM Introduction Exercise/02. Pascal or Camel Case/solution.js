function solve() {
  const text = document.getElementById('text').value.toLowerCase();
  console.log(text);
  const convention = document.getElementById('naming-convention').value;
  let variable = '';
  switch (convention) {
    case 'Camel Case': variable = text.split(' ').map((el, index) => index > 0 ? el = el[0].toUpperCase() + el.substring(1) : el).join('');
      break;
    case 'Pascal Case': variable = text.split(' ').map(el => el[0].toUpperCase() + el.slice(1)).join('');
      break;
    default: variable = 'Error!';
  }
  document.getElementById('result').textContent = variable;
}