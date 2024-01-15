const patient1 = document.getElementById("patient");
const dr1 = document.getElementById("dr");
const surgery1 = document.getElementById("surgery");
const case1 = document.getElementById("case");
const date1 = document.getElementById("date");
const save1 = document.getElementById("save");
const ausgewaehlt = [];

save1.addEventListener("click", function (event) {
    event.preventDefault();
    const patient = patient1.value;
    const doctor = dr1.value;
    const surgery = surgery1.value;
    const caseselected = case1.value;
    const surgeryDate = date1.value;

    const daten = {
        patient,
        doctor,
        surgery,
        caseselected,
        surgeryDate,
    };

    ausgewaehlt.push(daten);
    console.log(ausgewaehlt);
});
/*
save1.addEventListener("click", function (event) {

});
*/