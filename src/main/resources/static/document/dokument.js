function delete_dokument(id){
    fetch("/api/dokument/" + id, {
        method : "delete"
    }).then(response => {location.reload()});
}



function table_row(dokument){
    let row = document.createElement("tr");
    row.innerHTML = <td>${dokument.dokumentename}</td>
    <td>${dokument.dokumentenart}</td>
    <td>${dokument.dokumentbeschreibung}</td>
    + <td><button class="btn btn-primary" onclick="delete_dokument(${dokument.id})">Delete</button></td>;
    return row;
}


function load_dokumente(){
    fetch("/api/dokumente").then(response =>{
        if (response.ok)
            response.json().then(dokumente => {
                const tbody = document.getElementById("document_list");
                for (const dokument of dokumente) {
                    tbody.appendChild(table_row(dokument));
                }
            });
        else
            alert("error loading documents: " + response.statusText);
    });
}

function save_dokument(){
    const dokument = {
        dokumentename : document.getElementById("inputDokumentenname").value,
        dokumentenart : document.getElementById("inputDokumentenart").value,
        dokumentbeschreibung : document.getElementById("inputDokumentbeschreibung").value
    };

    fetch("/api/dokument", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(dokument)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'dokument.html';
        }
        else{
            alert("error saving dokument : " + response.statusText);
        }
    });
}