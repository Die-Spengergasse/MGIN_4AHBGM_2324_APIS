// Konstante für die API-URL
const apiUrl = "/api/befund";

// Funktion zum Löschen eines Befunds
function delete_befund(id) {
    fetch(`${apiUrl}/delete/${id}`, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            location.reload();
        } else {
            alert("Fehler beim Löschen des Befunds: " + response.statusText);
        }
    });
}

// Funktion zum Erstellen einer Tabellenzeile für einen Befund
function table_row(befund) {
    let row = document.createElement("tr");
    row.innerHTML = `<td>${befund.name}</td><td>${befund.birth}</td><td>${befund.gender}</td><td>${befund.beschreibung}</td>`
        + `<td><button class="btn btn-primary" onclick="delete_befund(${befund.id})">Löschen</button></td>`;
    return row;
}

// Funktion zum Laden von Befunden
function load_befunde() {
    fetch(`${apiUrl}/all`).then(response => {
        if (response.ok)
            response.json().then(befunde => {
                const tbody = document.getElementById("studyTableBody");
                for (const befund of befunde) {
                    tbody.appendChild(table_row(befund));
                }
            });
        else
            alert("Fehler beim Laden der Befunde: " + response.statusText);
    });
}

// Funktion zum Speichern eines Befunds
function save_befund() {
    const befund = {
        name: document.getElementById("patientennamen").value,
        birth: document.getElementById("geburtstag").value,
        gender: document.querySelector("input[name='geschlecht']:checked").value,
        beschreibung: document.getElementById("befundText").value
    };

    fetch(`${apiUrl}/add`, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(befund)
    }).then(response => {
        if (response.ok) {
            window.location.reload();
        } else {
            alert("Fehler beim Speichern des Befunds: " + response.statusText);
        }
    });
}

// Die Funktionen werden umbenannt, um sie an das Befunderfassen-Beispiel anzupassen
window.onload = function () {
    load_befunde();
};
