
function delete_grunddaten(id){
    fetch("/api/grunddaten/" + id, {
        method : "delete"
    }).then(response => {location.reload()});
}



function table_row(grunddaten){
    let row = document.createElement("tr");
    row.innerHTML = <td>${grunddaten.name}</td>
    <td>${grunddaten.allergies}</td>
    <td>${grunddaten.bloodgroup}</td>
    <td>${grunddaten.medication}</td>
    + <td><button class="btn btn-primary" onclick="delete_grunddaten(${grunddaten.id})">Delete</button></td>;
    return row;
}


function load_dokumente(){
    fetch("/api/grunddaten").then(response =>{
        if (response.ok)
            response.json().then(grunddaten => {
                const tbody = document.getElementById("grunddaten_list");
                for (const grunddaten of grunddaten) {
                    tbody.appendChild(table_row(grunddaten));
                }
            });
        else
            alert("error loading grunddaten: " + response.statusText);
    });
}

function save_dokument(){
    const grunddaten = {
        grunddatenname : document.getElementById("inputName").value,
        grunddatenallergies : document.getElementById("inputAllergies").value,
        grunddatenbloodgroup : document.getElementById("inputBloodgroup").value,
        grunddatenMedication : document.getElementById("inputMedication").value
    };

    fetch("/api/grunddaten", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(grunddaten)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'grunddaten.html';
        }
        else{
            alert("error saving grunddaten : " + response.statusText);
        }
    });
}