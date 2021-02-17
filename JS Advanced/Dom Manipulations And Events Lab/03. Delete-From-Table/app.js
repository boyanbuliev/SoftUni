function deleteByEmail() {
    const email = document.querySelector('input[name="email"]').value;
    let rows = [...document.querySelectorAll('#customers tbody tr td:last-child')];
    // let found = false;
    const result = document.getElementById('result');
    const matches = rows.filter(el => el.textContent == email);
    if (matches.length) {
        result.textContent = 'Deleted.';
        matches.forEach(el => el.parentNode.remove());
    } else {
        result.textContent = 'Not found.';
    }
    // rows.forEach(el => el.textContent == email ? (el.parentNode.remove(), found = true) : el);
    // found ? result.textContent = 'Deleted.' : result.textContent = 'Not found.';
}