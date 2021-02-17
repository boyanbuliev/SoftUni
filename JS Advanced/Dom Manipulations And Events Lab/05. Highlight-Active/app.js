function focused() {
    [...document.querySelectorAll('input')].forEach(i => {
        i.addEventListener('focus', (ev) => ev.target.parentNode.classList.add('focus'));
        i.addEventListener('blur', (ev) => ev.target.parentNode.classList.remove('focus'));
    });
    // function onFocus(ev) {
    //     ev.target.parentNode.classList.add('focused');
    // }
    // function onBlur(ev) {
    //     ev.target.parentNode.classList.remove('focused');
    // }
}