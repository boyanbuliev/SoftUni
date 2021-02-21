function attachEventsListeners() {
    const days = document.getElementById('days');
    const hours = document.getElementById('hours');
    const minutes = document.getElementById('minutes');
    const seconds = document.getElementById('seconds');
    document.getElementById('daysBtn').addEventListener('click', (e) => {
        const current = days.value;
        hours.value = current * 24;
        minutes.value = current * 24 * 60;
        seconds.value = current * 24 * 60 * 60;
    })
    document.getElementById('hoursBtn').addEventListener('click', (e) => {
        const current = hours.value;
        days.value = current / 24;
        minutes.value = current * 60;
        seconds.value = current * 60 * 60;
    });
    document.getElementById('minutesBtn').addEventListener('click', (e) => {
        const current = minutes.value;
        days.value = current / 60 / 24;
        hours.value = current / 60;
        seconds.value = current * 60;
    });
    document.getElementById('secondsBtn').addEventListener('click', (e) => {
        const current = seconds.value;
        days.value = current / 60 / 60 / 24;
        hours.value = current / 60 / 60;
        minutes.value = current / 60;
    });
}