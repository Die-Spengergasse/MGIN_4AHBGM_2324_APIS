var formularDaten = [];



function speichernFormular() {
    var medikamentenname = document.getElementById("medikamentenname").value;
    var dosierung = document.getElementById("dosierung").value;
    var anwendungsart = document.getElementById("anwendungsart").value;
    var anwendungszeitpunkt = document.getElementById("anwendungszeitpunkt").value;
    var hinweise = document.getElementById("hinweise").value;

    var medikament = {
        Medikamentenname: medikamentenname,
        Dosierung: dosierung,
        Anwendungsart: anwendungsart,
        Anwendungszeitpunkt: anwendungszeitpunkt,
        Hinweise: hinweise,
    };




    formularDaten.push(medikament);

    console.log("Formulardaten:");
    console.log(formularDaten);

}