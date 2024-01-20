function delete_laboratoryreport(svnr) {
    fetch(`/api/laborbefund/${svnr}`, {
        method: "delete"
    })
        .then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("Error deleting diagnosis: " + response.statusText);
            }
        })
        .catch(error => {
            alert("Error deleting diagnosis: " + error.message);
        });
}

function table_row(laborbefund) {
    let row = document.createElement("tr");
    row.innerHTML = `<td>${laborbefund.vorname}</td><td>${laborbefund.nachname}</td><td>${laborbefund.geburtsdatum}</td><td>${laborbefund.svn}</td><td>${laborbefund.leukozyten}</td><td>${laborbefund.thrombozyten}</td><td>${laborbefund.erythrozyten}</td><td>${laborbefund.haemoglobin}</td><td>${laborbefund.haemotokrit}</td><td>${laborbefund.mch}</td><td>${laborbefund.mcv}</td><td>${laborbefund.mchc}</td>`
        + `<td><button class="btn btn-primary" onclick="delete_laboratoryreport(${laborbefund.svn})">Delete</button></td>`;
    return row;
}

function load_laborbefund() {
    fetch("/api/laborbefund").then(response => {
        if (response.ok)
            response.json().then(laborbefunde => {
                const tbody = document.getElementById("laboratory_list");
                for (const laborbefund of laborbefunde) {
                    tbody.appendChild(table_row(laborbefund));
                }
            });
        else
            alert("Error loading diagnoses: " + response.statusText);
    });
}

function saveData() {
    const laborbefund = {
        Vorname: document.getElementById("vorname").value,
        Nachname: document.getElementById("nachname").value,
        Geburtsdatum: document.getElementById("geburtsdatum").value,
        SVNR: document.getElementById("svn").value,
        Leukozyten: document.getElementById("leukozyten").value,
        Thrombozyten: document.getElementById("thrombozyten").value,
        Erythrozyten: document.getElementById("erythrozyten").value,
        Hämoglobin: document.getElementById("haemoglobin").value,
        Hämotokrit: document.getElementById("haemotokrit").value,
        MCH: document.getElementById("mch").value,
        MCV: document.getElementById("mcv").value,
        MCHC: document.getElementById("mchc").value,
    };

    fetch("/api/laborbefund", {
        method: "post",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(laborbefund)
    })
        .then(response => {
            if (response.ok) {
                window.location.href = '../../templates/laborbefund/laborbefund.html';
            } else {
                throw new Error("Error saving diagnosis: " + response.statusText);
            }
        })
        .catch(error => {
            alert(error.message);
        });
}
