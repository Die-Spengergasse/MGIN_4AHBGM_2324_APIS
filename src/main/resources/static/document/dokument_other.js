async function load_dokumente(){
    const result = await fetch("/api/dokumente");
    const dokumente = await result.json();
    for(const b of dokumente){
        const tbody = document.querySelector("#document_list");
        const row = tbody.insertRow();
        row.innerHTML = `
                <td>${b.dokumentenname}</td>
                <td>${b.dokumentenart}</td>
                <td>${b.dokumentbeschreibung}</td>
        `;

    }
}