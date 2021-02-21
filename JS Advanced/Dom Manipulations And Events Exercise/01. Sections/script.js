function create(words) {
   const content = document.getElementById('content')
   words.forEach(w => {
      const paragraph = document.createElement('p');
      paragraph.textContent = w;
      const divEl = document.createElement('div');
      paragraph.style.display = 'none';
      divEl.appendChild(paragraph);
      content.appendChild(divEl);
   });
   content.addEventListener('click', (e) => e.target.querySelector('p').style.display = 'block');
}