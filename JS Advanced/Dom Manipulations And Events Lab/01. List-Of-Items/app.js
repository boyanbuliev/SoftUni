function addItem() {
    let input = document.createElement('li');
    input.textContent = document.querySelector('#newItemText').value;
    document.querySelector('#items').appendChild(input);
    document.querySelector('#newItemText').value = '';
}