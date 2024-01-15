// Funktion zum Speichern von Kontaktdaten
function speichereKontaktdaten() {
    // Erfassen der eingegebenen Werte aus dem HTML-Formular
    var vorname = document.getElementById('vorname').value;
    var nachname = document.getElementById('nachname').value;
    var strasse = document.getElementById('strasse').value;
    var ort = document.getElementById('ort').value;
    var plz = document.getElementById('plz').value;
    var email = document.getElementById('email').value;
    var telefon = document.getElementById('telefon').value;

    // Erstellen eines Kontaktobjekts
    var kontakt = {
        Vorname: vorname,
        Nachname: nachname,
        Strasse: strasse,
        Ort: ort,
        PLZ: plz,
        Email: email,
        Telefonnummer: telefon
    };

    // Überprüfen, ob es bereits gespeicherte Kontakte gibt
    if (!localStorage.kontakte) {
        localStorage.kontakte = JSON.stringify([]);
    }

    // Abrufen der vorhandenen Kontakte und Hinzufügen des neuen Kontakts
    var kontakteArray = JSON.parse(localStorage.kontakte);
    kontakteArray.push(kontakt);
    localStorage.kontakte = JSON.stringify(kontakteArray);

    // Aufrufen der Funktion zur Darstellung der Kontakte
    renderContacts();
}

// Funktion zum Darstellen der Kontakte in der Tabelle
function renderContacts() {
    var kontakteArray = JSON.parse(localStorage.kontakte || '[]');
    var tableBody = document.getElementById('kontaktTableBody');
    tableBody.innerHTML = '';

    // Iterieren durch die Kontakte und Erstellen von Tabellenzeilen
    for (var i = 0; i < kontakteArray.length; i++) {
        var kontakt = kontakteArray[i];
        var row = tableBody.insertRow();
        row.insertCell().innerText = kontakt.Vorname;
        row.insertCell().innerText = kontakt.Nachname;
        row.insertCell().innerText = kontakt.Strasse;
        row.insertCell().innerText = kontakt.Ort;
        row.insertCell().innerText = kontakt.PLZ;
        row.insertCell().innerText = kontakt.Email;
        row.insertCell().innerText = kontakt.Telefonnummer;

        // Aktionsbuttons hinzufügen (Bearbeiten und Löschen)
        var actionCell = row.insertCell();
        var editBtn = createButton('Bearbeiten', createEditHandler(i));
        var deleteBtn = createButton('Löschen', createDeleteHandler(i), 'delete');
        actionCell.appendChild(editBtn);
        actionCell.appendChild(deleteBtn);
    }
}

// Funktion zum Erstellen eines Buttons mit angegebenem Text und Klick-Handler
function createButton(text, clickHandler, className = '') {
    var button = document.createElement('button');
    button.innerText = text;
    button.onclick = clickHandler;
    button.className = 'btn btn-sm ' + className;
    return button;
}

// Funktion zum Erstellen eines Bearbeitungs-Button-Handlers
function createEditHandler(index) {
    return function () {
        fillFormForEditing(index);
    };
}

// Funktion zum Erstellen eines Löschen-Button-Handlers
function createDeleteHandler(index) {
    return function () {
        deleteContact(index);
    };
}
