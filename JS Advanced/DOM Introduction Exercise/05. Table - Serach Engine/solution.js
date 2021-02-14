function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);
   const rows = document.querySelectorAll('tbody tr');

   function onClick() {
      const regex = document.getElementById('searchField').value;
      document.getElementById('searchField').value = '';
      [...rows].forEach(row => row.textContent.includes(regex) ? row.setAttribute('class', 'select') : row.removeAttribute('class'))
   }
}