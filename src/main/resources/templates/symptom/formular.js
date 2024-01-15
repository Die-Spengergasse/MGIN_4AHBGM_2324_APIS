window.addEventListener("DOMContentLoaded", function () {

});

function savedata() {
    const datum1 = document.getElementById("birthday");
    const patient1 = document.getElementById("p_id");
    const symptome1 = document.getElementById("s_id");
    const dokumentation1 = document.getElementById("d_name");
    const save = document.getElementById("save");
    const choosen = [];

    const patient = patient1.value;
    const datum = datum1.value;
    const symptome = symptome1.value;
    const dokumentation = dokumentation1.value;

    const daten = {
        patient, datum, symptome, dokumentation
    };

    choosen.push(daten)


    let patList = JSON.parse(localStorage.getItem("1"));

    if (patList === null){
        patList=[];
    }

    patList.push(daten)

    window.localStorage.setItem("1", JSON.stringify(patList));
    console.log(choosen);

    const data = document.querySelector("#data");
    for (p of choosen) {
        try {
            const row = data.insertRow();
            row.insertCell().innerText = p.datum;
            row.insertCell().innerText = p.patient;
            row.insertCell().innerText = p.symptome;
            row.insertCell().innerText = p.dokumentation;
            const btn = document.createElement("button");
            btn.setAttribute('onclick', `editPerson(${p.patient})`);
            btn.innerText = "Edit";
            row.insertCell().appendChild(btn);
        } catch (error) {
            alert("proplem1");
        }
    }

}

function editPerson(Person) {
    alert("boblem1")

}

document.addEventListener('DOMContentLoaded', function () {
    const data = localStorage.getItem("1");
    if (data != null) {
        console.log(data);
        const test = JSON.parse(data);
        console.log(test);

        const data1 = document.querySelector("#data");
        for (p of test) {

            const row = data1.insertRow();
            row.insertCell().innerText = p.datum;
            row.insertCell().innerText = p.patient;
            row.insertCell().innerText = p.symptome;
            row.insertCell().innerText = p.dokumentation;
            const btn = document.createElement("button");
            btn.setAttribute('onclick', `editPerson(${p.patient})`);
            btn.innerText = "Edit";
            row.insertCell().appendChild(btn);

        }
    }


});


function sendPatient(name) {
    fetch("http://localhost/symptoms/add", {
        method: "POST",
        body: {
            "name": name,
            id: 2
        },

    })
}
function getSymptome(){
    const symptome1= document.getElementById("symptomeid");

    const symptome=symptome1.value();
}