async function load_lagerbestand2(){
    const result = await fetch("/api/lagerbestand/lagerbestand/all");
    const lagerbestand = await result.json();
    for(const l of lagerbestand){
        const tbody = document.querySelector("#lagerbestand_list");
        const row = tbody.insertRow();
        row.innerHTML = `
                <td>${l.id}</td>
                <td>${l.name}</td>
                <td>${l.quantity}</td>
                <td>${l.fachnr}</td>
        `;

    }
}