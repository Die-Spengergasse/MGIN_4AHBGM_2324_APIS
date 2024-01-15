const abrechnungen = [];

//Tabelle_Ausgabe
//http://localhost:8080/tabelle.html
async function load() {
    // get book list from REST service
    const response  =  await fetch("/api/abrechnungen/all");  //<- .then(funktion)
    const abrechnungen =  await response.json();

    const body = document.querySelector("#Tabelle-tabelle");
    for (const a of abrechnungen) {
        body.insertRow().innerHTML = `<td>${a.titel}</td>
            <td>${a.name}</td><td>${a.fall}</td><td>${a.svnr}</td><td>${a.bemerkung}</td>`;
    }
    // post abrechnung to REST service
    const abrechnung1 = abrechnungen[0];

    const init = {
        method : "post",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(abrechnung1)
    };
    const rc = await fetch("/api/abrechnungen/", init);
    console.log(rc);
    if (rc.status != 200){
        alert("error sending book to server");
    }
}