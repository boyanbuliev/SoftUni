function validate() {
    document.getElementById('email').addEventListener('change', onChange);

    function onChange(ev) {
        const email = ev.target.value;
        ev.target.className = '';
        if (/^[a-z]+@[a-z]+\.[a-z]+$/.test(email)) {
            ev.target.className = '';
        } else {
            ev.target.className = 'error';
        }
        // if (!ev.target.value.match(regex)) {
        // ev.target.className = 'error';
        // } else {
        //     ev.target.className = '';
        // }
    }
} 