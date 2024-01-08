function delete_diagnosis(id) {
    fetch(`/api/diagnoses/${id}`, {
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

function table_row(diagnosis) {
    let row = document.createElement("tr");
    row.innerHTML = `<td>${diagnosis.id}</td><td>${diagnosis.name}</td><td>${diagnosis.diagnoseCode}</td><td>${diagnosis.vorerkrankungen}</td><td>${diagnosis.diagnoseDatum}</td><td>${diagnosis.diagnoseBeschreibung}</td>`
        + `<td><button class="btn btn-primary" onclick="delete_diagnosis(${diagnosis.id})">Delete</button></td>`;
    return row;
}

function load_diagnosis() {
    fetch("/api/diagnoses").then(response => {
        if (response.ok)
            response.json().then(diagnoses => {
                const tbody = document.getElementById("diagnosis_list");
                for (const diagnosis of diagnoses) {
                    tbody.appendChild(table_row(diagnosis));
                }
            });
        else
            alert("Error loading diagnoses: " + response.statusText);
    });
}

function save_diagnosis() {
    const diagnosis = {
        name: document.getElementById("inputName").value,
        diagnoseCode: document.getElementById("inputDiagnoseCode").value,
        vorerkrankungen: document.getElementById("inputVorerkrankungen").value,
        diagnoseDatum: document.getElementById("inputDiagnoseDatum").value,
        diagnoseBeschreibung: document.getElementById("inputDiagnoseBeschreibung").value,
    };

    fetch("/api/diagnoses", {
        method: "post",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(diagnosis)
    })
        .then(response => {
            if (response.ok) {
                window.location.href = 'diagnosis.html';
            } else {
                throw new Error("Error saving diagnosis: " + response.statusText);
            }
        })
        .catch(error => {
            alert(error.message);
        });
}
