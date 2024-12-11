const form = document.getElementById('reservationForm');
form.addEventListener('submit', function (event) {
    const checkin = new Date(document.getElementById('checkin').value);
    const checkout = new Date(document.getElementById('checkout').value);

    if (checkin >= checkout) {
        alert('Check-out date must be after check-in date.');
        event.preventDefault(); // 阻止表單提交
    }
});
