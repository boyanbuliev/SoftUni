function addItem() {
    const dropDownMenu = document.getElementById('menu');
    const text = document.getElementById('newItemText');
    const value = document.getElementById('newItemValue');
    const option = document.createElement('option');
    option.textContent = text.value;
    option.value = value.value;
    dropDownMenu.add(option);
    text.value = '';
    value.value = '';

}