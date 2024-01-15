function savedata()
{
var Besuchid = document.getElementById("Besuchid").value;
var Patienten = document.getElementById("Name des Patienten").value;
var Besuchstag = document.getElementById("Besuchstag").value;
var Grund = document.getElementById("Grund des Kommens").value;
} const titel1 = document.querySelector('#Titel').value;
const name1 = document.querySelector('#patients').value;
const case1 = document.querySelector('#case').value;
const insurance1 = document.querySelector('#insurance').value;
const remarks1 = document.querySelector('#remarks').value;


const abrechnung = {
    Titel: titel1,
    Name: name1,
    Case: case1,
    Insurance: insurance1,
    Remarks: remarks1
}


abrechnungen.push(abrechnung);



const tabelle = document.querySelector("#tabelle");

tabelle.innerHTML = "";


for (p of abrechnungen){
    const row = tabelle.insertRow();
    row.insertCell().innerText = p.Titel;
    row.insertCell().innerText = p.Name;
    row.insertCell().innerText = p.Case;
    row.insertCell().innerText = p.Insurance;
    row.insertCell().innerText = p.Remarks;
    row.insertCell().innerHTML =
        '<button onclick="bearbeiten(this)">bearbeiten</button>'+
        '<button onclick="rowdelete(this)">löschen</button>';

}


console.log(abrechnungen);
function insertdata()
{
    var Besuchid = document.getElementById(Besuchid).value;
    var Patienten = document.getElementById(Patienten).value;
    var Besuchstag = document.getElementById(Besuchstag).value;
    var Grund = document.getElementById(Grund).value;
}
 if(Patienten && Besuchstag && Grund){
    try {
        var table = document.getElementById("Besuch");
        var tbody = table.getElementsByTagName("tbody")[0];

        if (!isBesuchUnique(Besuchid, tbody)) {
            altert("Die Besucherid ist bereits vorhanden, seien die genauer");
        } else {
            var newRow = tbody.insertRow();

            var cell1 = newRow.insertCell(0);
            var cell1 = newRow.insertCell(1);
            var cell1 = newRow.insertCell(2);
            var cell1 = newRow.insertCell(3);
        }
    }catch (e){}
 }


 