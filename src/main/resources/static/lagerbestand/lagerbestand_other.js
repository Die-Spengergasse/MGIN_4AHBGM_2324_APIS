const lagerbestaende = [];


async function load() {
    // get book list from REST service
    const response  =  await fetch("/api/lagerbestand/lagerbestand/all");
    const lagerbestaende =  await response.json();

    const body = document.querySelector("#Tabelle-tabelle");
    for (const l of lagerbestaende) {
        body.insertRow().innerHTML = `<td>${l.verbrauchsmaterial}</td>
            <td>${l.quantity}</td><td>${l.fachnr}</td>`;
    }

    const lagerbestand1 = lagerbestaende[0];

    const init = {
        method : "post",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(lagerbestand1)
    };
    const rc = await fetch("/api/lagerbestand/", init);
    console.log(rc);
    if (rc.status != 200){
        alert("error sending verbrauchsmaterial to server");
    }
}