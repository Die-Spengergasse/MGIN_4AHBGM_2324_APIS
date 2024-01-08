let geraetdata = []; 

window.addEventListener("DOMContentLoaded", function() {
    let dataString = localStorage.getItem("geraetdata");
    if (dataString) {
        geraetdata = JSON.parse(dataString);

        var table = document.getElementById('Geraete');
        var tbody = table.getElementsByTagName('tbody')[0];

        geraetdata.forEach(function(item) {
            var tr = document.createElement("tr");

            var cell1 = tr.insertCell(0);
            var cell2 = tr.insertCell(1);
            var cell3 = tr.insertCell(2);
            var cell4 = tr.insertCell(3);
            var deleteButtonCell = tr.insertCell(4);

            cell1.innerHTML = item.id;
            cell2.innerHTML = item.name;
            cell3.innerHTML = item.station;
            cell4.innerHTML = item.kategorie;

            cell1.addEventListener("click", function() {
                click(tr);
            });
            cell2.addEventListener("click", function() {
                click(tr);
            });
            cell3.addEventListener("click", function() {
                click(tr);
            });
            cell4.addEventListener("click", function() {
                click(tr);
            });

            deleteButtonCell.innerHTML = '<button onclick="deleteData(this)">Delete</button>';

            tbody.appendChild(tr);
        });

        table.appendChild(tbody);
    }
    sortTableByGerateId();
});

function insertData() {
    var gerateid = document.getElementById('gerateid').value;
    var geratenamen = document.getElementById('geratenamen').value;
    var station = document.getElementById('station').value;
    var kategorie = document.getElementById('kategorie').value;

    if (gerateid && geratenamen && station && kategorie) {
        try {
            var table = document.getElementById('Geraete');
            var tbody = table.getElementsByTagName('tbody')[0];

            if (!isGerateIdUnique(gerateid, tbody)) {
                alert('Die Geräte-ID ist bereits vorhanden. Bitte geben Sie eine eindeutige Geräte-ID ein.');
            }else{
                var newRow = tbody.insertRow();


                var cell1 = newRow.insertCell(0);
                var cell2 = newRow.insertCell(1);
                var cell3 = newRow.insertCell(2);
                var cell4 = newRow.insertCell(3);
                var deleteButtonCell = newRow.insertCell(4);
                deleteButtonCell.innerHTML = '<button onclick="deleteData(this)">Delete</button>';
                cell1.innerHTML = gerateid;
                cell2.innerHTML = geratenamen;
                cell3.innerHTML = station;
                cell4.innerHTML = kategorie;
                cell1.addEventListener("click", function() {
                    click(newRow);
                });            cell2.addEventListener("click", function() {
                    click(newRow);
                });            cell3.addEventListener("click", function() {
                    click(newRow);
                });            cell4.addEventListener("click", function() {
                    click(newRow);
                });
                var obj = {
                    id: cell1.innerHTML,
                    name: cell2.innerHTML,
                    station: cell3.innerHTML,
                    kategorie: cell4.innerHTML
                };
                geraetdata.push(obj);
    
                myJSON = JSON.stringify(geraetdata);
                localStorage.setItem("geraetdata", myJSON);
            }

    
        } catch (error) {
            alert("Ein Fehler ist aufgetreten: " + error);
        } finally {
            clearInputFields();
            sortTableByGerateId();
        }
    } else {
        alert('Bitte füllen Sie alle Felder aus.');
    }
}
function click(newRow) {
    try {
        var c1 = document.getElementById('gerateid');
        var c2 = document.getElementById('geratenamen');
        var c3 = document.getElementById('station');
        var c4 = document.getElementById('kategorie');
        c1.value = newRow.cells[0].innerHTML;
        c2.value = newRow.cells[1].innerHTML;
        c3.value = newRow.cells[2].innerHTML;
        c4.value = newRow.cells[3].innerHTML;
    } catch {
        alert("Fehler beim Setzen der Werte in die Eingabefelder.");
    }
}
function isGerateIdUnique(gerateid, tbody) {
    var tr = tbody.getElementsByTagName("tr");
    for (var i = 0; i < tr.length; i++) {
        var cell = tr[i].getElementsByTagName("td")[0];
        if (cell.innerHTML === gerateid) {
            return false; 
        }
    }
    return true; 
}


function deleteData(button) {
    let row = button.parentNode.parentNode; 
    let id = row.cells[0].innerHTML; 

    try {
        let dataString = localStorage.getItem("geraetdata");
        if (dataString) {
            geraetdata = JSON.parse(dataString);

            geraetdata = geraetdata.filter(item => item.id !== id);

            myJSON = JSON.stringify(geraetdata);
            localStorage.setItem("geraetdata", myJSON);
        }

        row.parentNode.removeChild(row);
    } catch (error) {
        alert("An error occurred: " + error);
    }

    clearInputFields();
}






function updateData() {
    try {
        var c1 = document.getElementById('gerateid').value;
        var table = document.getElementById('Geraete');
        var tbody = table.getElementsByTagName('tbody')[0];
        var tr = tbody.getElementsByTagName("tr");
        if (c1) {
           
        } 
        else 
        {
            // Remove the data from local storage
             let dataString = localStorage.getItem("geraetdata");
             if (dataString) {
                 geraetdata = JSON.parse(dataString);
                 geraetdata = geraetdata.filter(item => item.id !== c1);
                 myJSON = JSON.stringify(geraetdata);
                 localStorage.setItem("geraetdata", myJSON);
             }
 
             // Find and remove the row from the HTML table
             for (var i = 0; i < tr.length; i++) {
                 var cell = tr[i].getElementsByTagName("td")[0];
                 if (cell.innerHTML === c1) {
                    if  (isGerateIdUnique(c1.innerHTML, tbody))
                    {
                        tr[i].parentNode.removeChild(tr[i]);
                        break;
                    }
                }
             }
             insertData();
             clearInputFields();
             sortTableByGerateId();
             alert('Bitte geben Sie eine gültige Geräte-ID ein.');           
        }
    } catch (error) {
        alert("Ein Fehler ist aufgetreten: " + error);
    }
}


function clearInputFields() {
    document.getElementById('gerateid').value = '';
    document.getElementById('geratenamen').value = '';
    document.getElementById('station').value = '';
    document.getElementById('kategorie').value = '';
}

function sortTableByGerateId() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById('Geraete');
    switching = true;

    while (switching) {
        switching = false;
        rows = table.rows;

        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName('td')[0]; 
            y = rows[i + 1].getElementsByTagName('td')[0]; 

            if (x.innerHTML > y.innerHTML) {
                shouldSwitch = true;
                break;
            }
        }

        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}