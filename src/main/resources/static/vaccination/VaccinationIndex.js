// Array, um die Impfungsdaten zu speichern
var impfungsArray = [];

// Funktion, um die Formulardaten zu speichern und die Tabelle zu aktualisieren
function speichereImpfung() {
    var patient = document.getElementById("patient").value;
    var impfstoff = document.getElementById("impfstoff").value;
    var dosis = document.getElementById("dosis").value;
    var arzt = document.getElementById("arzt").value;
    var bemerkungen = document.getElementById("bemerkungen").value;
    var impfdatum = document.getElementById("impfdatum").value;

    // Erstellung eines JavaScript-Objekts mit den Formulardaten
    var impfung = {
        patient: patient,
        impfstoff: impfstoff,
        dosis: dosis,
        arzt: arzt,
        bemerkungen: bemerkungen,
        impfdatum: impfdatum
    };

    // Füge das Objekt dem Array hinzu
    impfungsArray.push(impfung);

    // Zurücksetzen des Formulars
    document.getElementById("patient").value = "";
    document.getElementById("impfstoff").value = "";
    document.getElementById("dosis").value = "";
    document.getElementById("arzt").value = "";
    document.getElementById("bemerkungen").value = "";
    document.getElementById("impfdatum").value = "";

    // Aktualisiere die Tabelle
    aktualisiereTabelle();



    //Code aus dem Unterricht: START
    async function load(){
        // get book list from REST service
        const response = await fetch("/api/books/all");
        const books = await response.json();

        const bdy = document.querySelector("#books");
        for (const b of books){
            bdy.insertRow().innerHTML = `<td>${b.isbn}</td>
            <td>${b.title}</td><td>${b.author}</td>`;
        }


        // post book to REST service
        const book1 = books[0];

        const init = {
            method : "post",
            headers: {
                "Content-Type": "application/json",
            },
            body : JSON.stringify(book1)
        };
        const rc = await fetch("/api/books/", init);
        console.log(rc);
        if (rc.status != 200){
            alert("error sending book to server");
        }

    }
    //Code aus dem Unterricht: ENDE
}

// Funktion zum Aktualisieren der Tabelle
function aktualisiereTabelle() {
    var tableBody = document.getElementById("impfungsTabelle");

    // Leere die bestehende Tabelle
    tableBody.innerHTML = "";

    // Durchlaufe das Impfungs-Array und erstelle Zeilen für die Tabelle
    for (var i = 0; i < impfungsArray.length; i++) {
        var row = tableBody.insertRow();

        // Füge Zellen für die Daten hinzu
        var cellPatient = row.insertCell(0);
        var cellImpfstoff = row.insertCell(1);
        var cellDosis = row.insertCell(2);
        var cellArzt = row.insertCell(3);
        var cellBemerkungen = row.insertCell(4);
        var cellImpfdatum = row.insertCell(5);

        // Setze die Zellenwerte
        cellPatient.innerHTML = impfungsArray[i].patient;
        cellImpfstoff.innerHTML = impfungsArray[i].impfstoff;
        cellDosis.innerHTML = impfungsArray[i].dosis;
        cellArzt.innerHTML = impfungsArray[i].arzt;
        cellBemerkungen.innerHTML = impfungsArray[i].bemerkungen;
        cellImpfdatum.innerHTML = impfungsArray[i].impfdatum;
    }
}

// Füge einen Eventlistener zum "Impfung durchführen"-Button hinzu
document.getElementById("impfungButton").addEventListener("click", speichereImpfung);

// Rufe die Funktion zur Aktualisierung der Tabelle auf, um vorhandene Daten anzuzeigen
aktualisiereTabelle();










// Funktion, um die Formulardaten mit den Daten aus der Tabelle zu füllen
function bearbeiteImpfung(index) {
    var impfung = impfungsArray[index];

    // Fülle die Formularfelder mit den Daten aus der ausgewählten Zeile
    document.getElementById("patient").value = impfung.patient;
    document.getElementById("impfstoff").value = impfung.impfstoff;
    document.getElementById("dosis").value = impfung.dosis;
    document.getElementById("arzt").value = impfung.arzt;
    document.getElementById("bemerkungen").value = impfung.bemerkungen;
    document.getElementById("impfdatum").value = impfung.impfdatum;
}

// Füge einen Eventlistener zu jedem "Bearbeiten"-Button in der Tabelle hinzu
function fuegeBearbeitenButtonHinzu() {
    var table = document.getElementById("impfungsTabelle");

    for (var i = 0; i < impfungsArray.length; i++) {
        var row = table.rows[i + 1]; // Die erste Zeile ist die Header-Zeile

        var bearbeitenButton = document.createElement("button");
        bearbeitenButton.innerHTML = "Bearbeiten";
        bearbeitenButton.className = "btn btn-primary";
        bearbeitenButton.onclick = function () {
            bearbeiteImpfung(i);
        };

        var cell = row.insertCell(6); // 6. Spalte für den "Bearbeiten"-Button
        cell.appendChild(bearbeitenButton);
    }
}

// Rufe die Funktion zum Hinzufügen der "Bearbeiten"-Buttons auf
fuegeBearbeitenButtonHinzu();

