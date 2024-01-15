async function load_medikation(){
    const result = await fetch("/api/medikation");
    const medikation = await result.json();
    for(const b of medikation){
        const tbody = medication.querySelector("#medication_list");
        const row = tbody.insertRow();
        row.innerHTML = `
                <td>${b.medikamentenname}</td>
                <td>${b.dosis}</td>
                <td>${b.zeitDerEinnahme}</td>
                <td>${b.altersgruppe}</td>
                <td>${b.beschreibung}</td>
        `;

    }
}