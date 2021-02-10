function extract(content) {
    const regex = /\((.+?)\)/gm;
    let text = document.getElementById(content).textContent;
    let match = regex.exec(text);
    let result = [];
    while (match != null) {
        result.push(match[1]);
        match = regex.exec(text);
    }
    return result.join('; ');
    // let match = text.match(regex).map(el => el.substring(1, el.length - 1));
    // return match.join('; ');
}