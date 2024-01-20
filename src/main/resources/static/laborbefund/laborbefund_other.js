async function load_laborbefund() {
    try {
        const result = await fetch("/api/laborbefund");
        const laborbefunde = await result.json();

        for (const d of laborbefunde) {
            const tbody = document.querySelector("#laboratory_list");
            const row = tbody.insertRow();
            row.innerHTML = `
                <td>${d.vorname}</td>
                <td>${d.nachname}</td>
                <td>${d.geburtsdatum}</td>
                <td>${d.svn}</td>
                <td>${d.leukozyten}</td>
                <td>${d.thrombozyten}</td>
                <td>${d.erythrozyten}</td>
                <td>${d.haemoglobin}</td>
                <td>${d.haemotokrit}</td>
                <td>${d.mch}</td>
                <td>${d.mcv}</td>
                <td>${d.mchc}</td>
                <td><button class="btn btn-primary" onclick="delete_laboratoryreport(${d.svn})">Delete</button></td>
            `;
        }
    } catch (error) {
        alert(`Error loading laboratory report: ${error.message}`);
    }
}

async function delete_laboratoryreport(svnr) {
    try {
        const response = await fetch(`/api/laborbefund/${svnr}`, {
            method: "delete"
        });

        if (response.ok) {
            location.reload();
        } else {
            throw new Error(`Error deleting laboratory report: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error deleting laboratory report: ${error.message}`);
    }
}

async function saveData() {
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
    }

    try {
        const response = await fetch("/api/laborbefund", {
            method: "post",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(laborbefund)
        });

        if (response.ok) {
            window.location.href = '../../templates/laborbefund/laborbefund.html';
        } else {
            throw new Error(`Error saving laboratory report: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error saving laboratory report: ${error.message}`);
    }
}
