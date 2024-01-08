const recipeArray = [];

async function savebutton() {
    console.log("button clicked");
    const recipes = {
        doctor : document.querySelector("#doctor").value,
        date : document.querySelector("#date").value,
        patientName : document.querySelector("#patientName").value,
        recipeName : document.querySelector("#recipeName").value,
        medication : document.querySelector("#medication").value,
        medDescription : document.querySelector("#medDescription").value,
        dosage : document.querySelector("#dosage").value
    }

    recipeArray.push(recipes);
    console.log(recipeArray);

    fetch("/recipes/post", {
        method : "post",
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(recipes)
    }).then(response => {
        if (response.ok) {
            window.location.href = 'index.html';
        }
        else{
            alert("error saving recipe : " + response.statusText);
        }
    });


    // Tabellenzeile hinzufügen

    function addtablerow(recipeObject) {
        const table = document.querySelector("#recipetable tbody");

        const newRow = table.insertRow();
        const doctorCell = newRow.insertCell(0);
        const dateCell = newRow.insertCell(1);
        const patientNameCell = newRow.insertCell(2);
        const recipeNameCell = newRow.insertCell(3);
        const medicationCell = newRow.insertCell(4);
        const medDescriptionCell = newRow.insertCell(5);
        const dosageCell = newRow.insertCell(6);
        const editCell = newRow.insertCell(7);

        doctorCell.innerHTML = recipeObject.doctorvalue;
        dateCell.innerHTML = recipeObject.datevalue;
        patientNameCell.innerHTML = recipeObject.patientNamevalue;
        recipeNameCell.innerHTML = recipeObject.recipeNamevalue;
        medicationCell.innerHTML = recipeObject.medicationvalue;
        medDescriptionCell.innerHTML = recipeObject.medDescriptionvalue;
        dosageCell.innerHTML = recipeObject.dosagevalue;

        const editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.addEventListener("click", function () {
            doctorCell.value = recipeObject.doctorvalue;
            dateCell.value = recipeObject.datevalue;
            patientNameCell.value = recipeObject.patientNamevalue;
            recipeNameCell.value = recipeObject.recipeNamevalue;
            medicationCell.value = recipeObject.medicationvalue;
            medDescriptionCell.value = recipeObject.medDescriptionvalue;
            dosageCell.value = recipeObject.dosagevalue;
        });

        editCell.appendChild(editButton);
    }
    addtablerow(recipeObject);


}

