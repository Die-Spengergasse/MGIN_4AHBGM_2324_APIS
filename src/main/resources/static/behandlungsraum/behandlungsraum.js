document.addEventListener("DOMContentLoaded", function() {
    var reserveButton = document.getElementById("reserve-button");
    var saveButton = document.getElementById("saveButton");
    var reservations = [];
    reserveButton.addEventListener("click", function(event) {
        event.preventDefault();

        var hospital = document.getElementById("hospital").value;
        var room = document.getElementById("room").value;
        var date = document.getElementById("date").value;
        var time = document.getElementById("time").value;

        var reservation = {
            hospital: hospital,
            room: room,
            date: date,
            time: time
        };
        reservations.push(reservation);
        console.log("Reservierungen:", reservations);

        var table = document.getElementById("table");
        var newRow = table.insertRow(-1);

        var first = newRow.insertCell(0);
        var second = newRow.insertCell(1);
        var third = newRow.insertCell(2);
        var four = newRow.insertCell(3);

        first.innerHTML = reservation.hospital;
        second.innerHTML = reservation.room;
        third.innerHTML = reservation.date;
        four.innerHTML = reservation.time;
    });
    saveButton.addEventListener("click", function () {
        saveData(reservations);
    });
    function saveData(data) {
        fetch('/api/behandlungsraumen/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => response.json())
            .then(result => {
                console.log('Daten gespeichert:', result);
                reservations = [];
            })
            .catch(error => {
                console.error('Fehler beim Speichern der Daten:', error);
            });
    }
    fetch('/all')
        .then(response => response.json())
        .then(data => {
            console.log('Daten geladen:', data);
            data.forEach(item => {
                updateTable(item);
            });
        })
        .catch(error => {
            console.error('Fehler beim Laden der Daten:', error);
        });

    function updateTable(item) {
        var table = document.getElementById("table");
        var newRow = table.insertRow(-1);

        var first = newRow.insertCell(0);
        var second = newRow.insertCell(1);
        var third = newRow.insertCell(2);
        var four = newRow.insertCell(3);

        first.innerHTML = item.hospital;
        second.innerHTML = item.room;
        third.innerHTML = item.date;
        four.innerHTML = item.time;
    }
});
