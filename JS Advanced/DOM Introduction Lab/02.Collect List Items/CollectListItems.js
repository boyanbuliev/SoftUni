function extractText() {
    const liElements = [...document.getElementsByTagName('li')];
    const elementText = liElements.map(el => el.textContent);
    document.getElementById('result').value = elementText.join('\n');
}