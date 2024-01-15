function handleSpeichern1() {
    var patientName = document.getElementById('patient_name').value;
    var date = document.getElementById('date').value;
    var symptoms = document.getElementById('symptoms').value;
    var diagnosis = document.getElementById('diagnosis').value;
    var prescription = document.getElementById('prescription').value;
    var absenceDates = document.getElementById('absence_dates').value;

    var konsultation = {
        patientName: patientName,
        date: date,
        symptoms: symptoms,
        diagnosis: diagnosis,
        prescription: prescription,
        absenceDates: absenceDates
    };

    if (!localStorage.getItem('konsultationen')) {
        localStorage.setItem('konsultationen', JSON.stringify([]));
    }

    var konsultationen = JSON.parse(localStorage.getItem('konsultationen'));
    konsultationen.push(konsultation);
    localStorage.setItem('konsultationen', JSON.stringify(konsultationen));


    // Füge die neue Zeile zur Tabelle hinzu
    var table = document.getElementById("consultation_table").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.rows.length);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);
    var cell6 = newRow.insertCell(5);

    cell1.innerHTML = patientName;
    cell2.innerHTML = date;
    cell3.innerHTML = symptoms;
    cell4.innerHTML = diagnosis;
    cell5.innerHTML = prescription;
    cell6.innerHTML = absenceDates;

    console.log('Aktuelle Konsultation:', konsultation);
    console.log('Alle Konsultationen:', konsultationen);
}
