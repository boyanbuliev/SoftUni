document.getElementById('items').addEventListener('click', (ev) => {
    if (ev.target.tagName === 'A') {
        ev.target.parentNode.remove();
    }
});
function addItem() {
    const input = document.querySelector('#newText');
    const liElement = createElement('li', input.value);
    const deleteBtn = createElement('a', '[Delete]');
    deleteBtn.href = '#';
    // deleteBtn.addEventListener('click', (ev) => ev.target.parentNode.remove());
    liElement.appendChild(deleteBtn);
    document.querySelector('#items').appendChild(liElement);
    input.value = '';
    function createElement(type, content) {
        const element = document.createElement(type);
        element.textContent = content;
        return element;
    }
}

