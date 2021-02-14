function search() {
   const regex = document.getElementById('searchText').value;
   let count = 0;
   [...document.getElementsByTagName('li')].forEach(el => el.textContent.includes(regex) ?
      (el.style.fontWeight = 'bold', el.style.textDecoration = 'underline', count++) : (el.style.fontWeight = '', el.style.textDecoration = ''));
   document.getElementById('result').textContent = count + ' matches found'
}
