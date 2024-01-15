async function load_diagnosis() {
    try {
        const result = await fetch("/api/diagnoses");
        const diagnoses = await result.json();

        for (const d of diagnoses) {
            const tbody = document.querySelector("#diagnosis_list");
            const row = tbody.insertRow();
            row.innerHTML = `
                <td>${d.id}</td>
                <td>${d.medicalCase}</td>
                <td>${d.icd10}</td>
                <td>${d.doctor}</td>
                <td><button class="btn btn-primary" onclick="delete_diagnosis(${d.id})">Delete</button></td>
            `;
        }
    } catch (error) {
        alert(`Error loading diagnoses: ${error.message}`);
    }
}

async function delete_diagnosis(id) {
    try {
        const response = await fetch(`/api/diagnoses/${id}`, {
            method: "delete"
        });

        if (response.ok) {
            location.reload();
        } else {
            throw new Error(`Error deleting diagnosis: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error deleting diagnosis: ${error.message}`);
    }
}

async function save_diagnosis() {
    const diagnosis = {
        medicalCase: document.getElementById("inputMedicalCase").value,
        icd10: document.getElementById("inputIcd10").value,
        doctor: document.getElementById("inputDoctor").value,
    };

    try {
        const response = await fetch("/api/diagnoses", {
            method: "post",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(diagnosis)
        });

        if (response.ok) {
            window.location.href = 'diagnosis.html';
        } else {
            throw new Error(`Error saving diagnosis: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error saving diagnosis: ${error.message}`);
    }
}
