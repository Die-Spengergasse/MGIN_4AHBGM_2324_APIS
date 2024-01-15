async function load_healthrecord(){
    const result = await fetch("/api/healthrecord");
    const healthrecords = await result.json();
    for(const b of healthrecords){
        const tbody = healthrecords.querySelector("#healthrecord_list");
        const row = tbody.insertRow();
        row.innerHTML = `
                <td>${b.allergies}</td>
                <td>${b.bloodgroup}</td>
                <td>${b.medication}</td>
        `;

    }
}