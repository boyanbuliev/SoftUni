function encodeAndDecodeMessages() {
    const textareas = document.querySelectorAll('textarea');
    const buttons = document.querySelector('button');
    const map = {
        encode: {
            textarea: textareas[0],
            button: buttons[0],
            func: char => String.fromCharCode(char.charCodeAt(0) + 1)
        },
        decode: {
            textarea: textareas[1],
            button: buttons[1],
            func: char => String.fromCharCode(char.charCodeAt(0) - 1)
        }
    }
    document.getElementById('main').addEventListener('click', (e) => {
        if (e.target.tagName !== 'BUTTON') {
            return;
        }
        const type = e.target.textContent.toLowerCase().trim().includes('encode') ? 'encode' : 'decode';
        map.decode.textarea.value = [...map[type].textarea.value].map(map[type].func).join('');
        map.encode.textarea.value = '';
    });
}