// Funktion zum Laden von Kontakten
async function loadContacts() {
    const result = await fetch("/api/contacts");
    const contacts = await result.json();
    for (const contact of contacts) {
        const tableBody = document.querySelector("#contact_list");
        const row = tableBody.insertRow();
        row.innerHTML = `
            <td>${contact.vorname}</td>
            <td>${contact.nachname}</td>
            <td>${contact.strasse}</td>
            <td>${contact.ort}</td>
            <td>${contact.plz}</td>
            <td>${contact.email}</td>
            <td>${contact.telefon}</td>
        `;
    }
}

// aufrufen von loadContacts beim Laden der Seite, um vorhandene Kontakte anzuzeigen
loadContacts();
