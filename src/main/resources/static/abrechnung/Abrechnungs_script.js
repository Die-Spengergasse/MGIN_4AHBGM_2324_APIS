const abrechnungen = [];


function bearbeiten() {

    alert("Keine Lust gehabt es zu machen :)");
}

function rowdelete(button){
    let row = button.parentNode.parentNode

    row.parentNode.removeChild(row);

}


function werteZuweisen(){



    const titel1 = document.querySelector('#Titel').value;
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
}



document.querySelector('#save').addEventListener('click', werteZuweisen);