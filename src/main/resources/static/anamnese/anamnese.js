

    let datenObjekte = [];

    function speichernDaten() {
    const name = document.querySelector('#na').value;
    const geburtsdatum = document.querySelector('#gd').value;
    const svnr = document.querySelector('#sv').value;
    const geschlecht = document.querySelector('#ges').value;
    const allergien = document.querySelector('#al').value;
    const medikamente = document.querySelector('#med').value;
    const vorherigekrankheiten = document.querySelector('#vk').value;
    const familienanamnese = document.querySelector('#fam').value;

    const datenObjekt = {
    name: name,
    geburtsdatum: geburtsdatum,
    svnr: svnr,
    geschlecht: geschlecht,
    allergien: allergien,
    medikamente: medikamente,
    vorherigekrankheiten: vorherigekrankheiten,
    familienanamnese: familienanamnese
};

    datenObjekte.push(datenObjekt);

    // Daten zur Tabelle hinzufügen
    const tableBody = document.getElementById('data-table-body');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
                <td>${name}</td>
                <td>${geburtsdatum}</td>
                <td>${svnr}</td>
                <td>${geschlecht}</td>
                <td>${allergien}</td>
                <td>${medikamente}</td>
                <td>${vorherigekrankheiten}</td>
                <td>${familienanamnese}</td>
                <td>
                    <button onclick="editRow(this)">Edit</button>
                </td>
            `;
    tableBody.appendChild(newRow);


    document.querySelector('form').reset();
}

    function editRow(button) {
    const row = button.closest('tr');
    const cells = row.getElementsByTagName('td');
    document.querySelector('#na').value = cells[0].textContent;
    document.querySelector('#gd').value = cells[1].textContent;
    document.querySelector('#sv').value = cells[2].textContent;
    document.querySelector('#ges').value = cells[3].textContent;
    document.querySelector('#al').value = cells[4].textContent;
    document.querySelector('#med').value = cells[5].textContent;
    document.querySelector('#vk').value = cells[6].textContent;
    document.querySelector('#fam').value = cells[7].textContent;

    row.remove();
}

    document.querySelector('#submit').addEventListener('click', speichernDaten);
    document.querySelector('#save').addEventListener('click', speichernDaten);

    fetch("/api/anamnese", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(anamnese)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'anamnese.html';
        }
        else{
            alert("error saving anamnese : " + response.statusText);
        }
    });