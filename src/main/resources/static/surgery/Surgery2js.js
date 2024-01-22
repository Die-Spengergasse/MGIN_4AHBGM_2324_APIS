const patient1 = document.getElementById("patient");
const dr1 = document.getElementById("dr");
const surgery1 = document.getElementById("surgery");
const case1 = document.getElementById("case");
const date1 = document.getElementById("date");
const save1 = document.getElementById("save");
const ausgewaehlt = [];


save1.addEventListener("click", function (event) {
    event.preventDefault();
    const patient = patient1.value;
    const doctor = dr1.value;
    const surgery = surgery1.value;
    const caseselected = case1.value;
    const surgeryDate = date1.value;

    const daten = {
        patient,
        doctor,
        surgery,
        caseselected,
        surgeryDate,
    };

    ausgewaehlt.push(daten);
    console.log(ausgewaehlt);
});
function addDataToTable(data) {
    const table = document.getElementById("tabelle1");

    const row = table.insertRow();

    const patientCell = row.insertCell(0);
    const doctorCell = row.insertCell(1);
    const caseCell = row.insertCell(2);
    const surgeryCell = row.insertCell(3);
    const dateCell = row.insertCell(4);


    patientCell.innerHTML = data.patient;
    doctorCell.innerHTML = data.doctor;
    caseCell.innerHTML = data.caseselected;
    surgeryCell.innerHTML = data.surgery;
    dateCell.innerHTML = data.surgeryDate;
}

save1.addEventListener("click", function (event) {
    //hier wird die Standardaktion eines HTML-Formulars verhindert
    event.preventDefault();
    //Diese Variablen zeigen welche Daten der Patient eingegeben hat
    const patient = patient1.value;
    const doctor = dr1.value;
    const surgery = surgery1.value;
    const caseselected = case1.value;
    const surgeryDate = date1.value;


    //In diesem Objekt werden die Daten eingefügt, welcher der Benutzer eingegeben hat
    const daten = {
        patient,
        doctor,
        surgery,
        caseselected,
        surgeryDate,
    };

    //Hier wird das daten Objekt in das Array "ausgewaehlt" gespeichert
    ausgewaehlt.push(daten);
    //Am schluss wird mithilfe von console.log das array auf der Konsole ausgegeben
    console.log(ausgewaehlt);

    addDataToTable(daten);
});
/*
save1.addEventListener("click", function (event) {

});
*/