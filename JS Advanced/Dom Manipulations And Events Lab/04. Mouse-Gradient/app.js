function attachGradientEvents() {
    document.getElementById('gradient').addEventListener('mousemove', onMove);
    const output = document.getElementById('result');
    function onMove(event) {
        output.textContent = Math.floor(event.offsetX / event.target.clientWidth * 100) + '%';
    }
}