function delete_medikation(id){
    fetch("/api/medikation/" + id, {
        method : "delete"
    }).then(response => {location.reload()});
}



function table_row(medikation){
    let row = medication.createElement("tr");
    row.innerHTML = <td>${medikation.medikamentenname}</td>
    <td>${medikation.dosis}</td>
    <td>${medikation.zeitdereinnahme}</td>
    <td>${medikation.altersgruppe}</td>
    <td>${medikation.beschreibung}</td>
    + <td><button class="btn btn-primary" onclick="delete_medikation(${medikation.id})">Delete</button></td>;
    return row;
}


function load_medikation(){
    fetch("/api/medikation").then(response =>{
        if (response.ok)
            response.json().then(medikation => {
                const tbody = medication.getElementById("medication_list");
                for (const medikation of medications) {
                    tbody.appendChild(table_row(medikation));
                }
            });
        else
            alert("error loading medications: " + response.statusText);
    });
}

function save_medikation(){
    const medikation = {
        medikamentenname : medication.getElementById("inputMedikamentenname").value,
        dosis : medication.getElementById("inputDosis").value,
        zeitDerEinnahme : medication.getElementById("inputZeitDerEinnahme").value,
        altersgruppe : medication.getElementById("inputAltersgruppe").value,
        beschreibung : medication.getElementById("inputBeschreibung").value
    };

    fetch("/api/medikation", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(medikation)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'medication.html';
        }
        else{
            alert("error saving medikation : " + response.statusText);
        }
    });
}