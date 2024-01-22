const lagerArray = [];

function addItem() {


    const verbrauchsmaterial = document.getElementById("verbrauchsmaterial").value;
    const quantity = document.getElementById("quantity").value;
    const fachnr = document.getElementById("fachnr").value;

    const mengen = {
        Verbrauchsgut: verbrauchsmaterial,
        Anzahl: quantity,
        Fachnummer: fachnr
    }

    lagerArray.push(mengen);





    if (verbrauchsmaterial && quantity && fachnr) {
        const tableBody = document.getElementById("tabelle");
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${verbrauchsmaterial}</td>
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
