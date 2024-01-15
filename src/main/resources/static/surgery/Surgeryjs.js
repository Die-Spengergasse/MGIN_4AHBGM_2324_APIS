async function load(){
    // get book list from REST service
    const response = await fetch("/api/surgery/all");
    const surgeries = await response.json();

    const bdy = document.querySelector("#tabelle");
    for (const s of surgeries){
        bdy.insertRow().innerHTML = `<td>${s.drname}</td>
            <td>${s.paname}</td><td>${s.date}</td><td>${s.surcase}</td><td>${s.surintervention}</td>`;
    }


    // post book to REST service
    const surgery1 = surgeries[0];

    const init = {
        method : "post",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(surgery1)
    };
    const rc = await fetch("/api/surgery/", init);
    console.log(rc);
    if (rc.status != 200){
        alert("error sending surgery to server");
    }
}