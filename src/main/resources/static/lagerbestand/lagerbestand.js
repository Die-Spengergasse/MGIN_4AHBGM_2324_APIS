function delete_lagerbestand(id){
    fetch("/api/lagerbestand/lagerbestand" + id, {
        method : "delete"
    }).then(response => {location.reload()});
}



function table_row(l){
    let row = document.createElement("tr");
    row.innerHTML = `<td>${l.id}</td><td>${l.name}</td><td>${l.quantity}</td><td>${l.fachnr}</td>`
        + `<td><button class="btn btn-primary" onclick="delete_lagerbestand(${l.id})">Delete</button></td>`;
    return row;
}


function load_books(){
    fetch("/api/lagerbestand/all").then(response =>{
        if (response.ok)
            response.json().then(lagerbestand => {
                const tbody = document.getElementById("lagerbestand_list");
                for (const lager of lagerbestand) {
                    tbody.appendChild(table_row(lager));
                }
            });
        else
            alert("error loading entry: " + response.statusText);
    });
}

function save_lagerbestand(){
    const lagerbestand = {
        fachnr : document.getElementById("inputFachnr").value,
        name : document.getElementById("inputName").value,
        quantity : document.getElementById("inputQuantity").value

    };

    fetch("/api/lagerbestand/lagerbestand", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(lagerbestand)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'lagerbestand.html';
        }
        else{
            alert("error saving book : " + response.statusText);
        }
    });
}


/*async function load(){
    // get lagerbestand list from REST service
    const response = await fetch("/api/lagerbestand/all");
    const lager = await response.json();

    const bdy = document.querySelector("#lagertbl");
    for (const l of lager){
        bdy.insertRow().innerHTML = `<td>${l.id}</td><td>${l.name}</td><td>${l.quantity}</td><td>${l.fachnr}</td>`;
    }


    // post lagerbestand to REST service
    const spritze = lager[0];

    const init = {
        method : "post",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(spritze)
    };
    const rc = await fetch("/api/lagerbestand/", init);
    console.log(rc);
    if (rc.status != 200){
        alert("error sending verbrauchsmaterial to server");
    }

}*/