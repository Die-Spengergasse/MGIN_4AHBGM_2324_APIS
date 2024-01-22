/*const lagerbestaende = [];


function rowdelete(button){
    let row = button.parentNode.parentNode

    row.parentNode.removeChild(row);

}


function saveinput(){

    const verbrauchsmaterial = document.querySelector('#verbrauchsmaterial').value;
    const quantity = document.querySelector('#quantity').value;
    const fachnr = document.querySelector('#fachnr').value;


    const lagerbestand = {
        Name: verbrauchsmaterial,
        Quantity: quantity,
        Fachnr: fachnr

    }


    lagerbestaende.push(lagerbestand);



    const table = document.querySelector("#table");

    table.innerHTML = "";


    for (l of lagerbestaende){
        const row = table.insertRow();
        row.insertCell().innerText = l.Name;
        row.insertCell().innerText = l.Quantity;
        row.insertCell().innerText = l.Fachnr;
        row.insertCell().innerHTML =
            '<button onclick="rowdelete(this)">löschen</button>';

    }

    console.log(lagerbestaende);
}

document.querySelector('#save').addEventListener('click', saveinput);*/
const lagerArray = [];


function addItem() {


    const item = document.getElementById("verbrauchsmaterial").value;
    const quantity = document.getElementById("quantity").value;
    const fachnr = document.getElementById("fachnr").value;

    const mengen = {
        Verbrauchsgut: verbrauchsmaterial,
        Anzahl: quantity,
        Fachnummer: fachnr
    }

    lagerArray.push(mengen);



    if (item && quantity && fachnr) {
        const tableBody = document.getElementById("table");
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item}</td>
            <td>${quantity}</td>
            <td>${fachnr}</td>
            <td>
                <button onclick="bearbeiten(this)">Bearbeiten</button>
                <button onclick="löschen(this)">Löschen</button>
            </td>
        `;
        tableBody.appendChild(row);
    }

    console.log(lagerArray);

}

function bearbeiten(button) {
    const row = button.closest("tr");
    const cells = row.getElementsByTagName("td");
    const item = cells[0].textContent;
    const quantity = cells[1].textContent;
    document.getElementById("verbrauchsmaterial").value = item;
    document.getElementById("quantity").value = quantity;
    row.remove();
}

function löschen(button) {
    //"tr", weil wir die zeile löschen wollen
    const row = button.closest("tr");
    row.remove();
}
