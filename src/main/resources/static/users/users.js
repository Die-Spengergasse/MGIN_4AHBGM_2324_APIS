/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */


/**
 * this page contains client scripts for user administration
 */

/**
 * class user with some helper methods changing user roles
 */
class MedUser{
    constructor(name, password, roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    /**
     * check whether the user has the role with the given name
     * @param role_name name of the role
     * @returns {boolean} true if the user has this role
     */
    hasRole(role_name){
        for (const r of this.roles){
            if (r.name === role_name)
                return true;
        }
        return false;
    }

    /**
     * change the role with the given name for this user - this means:
     *      if the user already has the role it will be removed
     *      if the user doesn't have the role it will be added
     * @param role_name name of the role
     */
    toggleRole(role_name){
        // roles will be stored in this array - will replace existing roles
        const newRoles = [];

        // search for role in user's roles
        let found = false;
        for (const r of this.roles){
            if (r.name === role_name){
                found = true;
            }
            else {
                // if this is not the role we are looking for - it will remain
                // --> add it to new array
                newRoles.push(r);
            }
        }
        // if we didn't find the role --> add it to the array
        if (!found){
            newRoles.push({name : role_name});
        }
        // now replace old array of roles with new one
        this.roles = newRoles;
    }

    /**
     * save changes - send user data to UserController (PUT: /api/admin/users/update)
     * when finished - reload the page
     * @returns {Promise<void>}
     */
    async save(){
        const json = JSON.stringify(this);
        console.log(json);
        let response = await fetch("/api/admin/users/update", {
            body : json,
            method : "put",
            headers : {'Content-Type' : 'application/json'}
        });
        if (!response.ok){
            alert("error: " + response.status);
        }
        document.location.reload();
    }
}


/**
 * administration class for users
 */
class UserManager{
    constructor() {
        /**
         * maintain list of users
         * @type {MedUser[]}
         */
        this.users = [];
        // maintain list of roles
        this.roles = [];
    }

    /**
     * fetch users: send request to UserController (GET: /api/admin/users/all)
     * add user data to list of users
     * @returns {Promise<void>}
     */
    async loadUsers(){
        try {
            const response = await fetch("/api/admin/users/all");
            for (const u of await response.json()) {
                this.users.push(new MedUser(u.name, u.password, u.roles));
            }
        } catch (e) {
            alert(e);
        }
    }

    /**
     * fetch roles: send request to UserController (GET: /api/admin/users/roles)
     * add role data to list of roles
     * @returns {Promise<void>}
     */
    async loadRoles(){
        const response = await fetch("/api/admin/users/roles");
        if (response.ok) {
            this.roles = await response.json();
        }
        else{
            alert("error loading user roles: " + response.status);
        }
    }

    /**
     * fill user table with data from this.users
     * each user may be assigned any role of this.roles
     */
    showUserTable(){
        const utable = document.querySelector("#user_table");   // access to table
        for (const u of this.users){
            const tr = utable.insertRow();  // a new row for each user
            tr.insertCell().innerText = u.name; // first cell contains user name
            for (const r of this.roles){
                const cell = tr.insertCell(); // a cell for each role
                cell.appendChild(document.createTextNode(r.name + "  "));
                const check = cell.appendChild(document.createElement("input"));
                check.setAttribute("type", "checkbox"); // add a checkbox for the role
                if (u.hasRole(r.name))
                    check.setAttribute("checked", "checked");   // checked if user has this role
                // if state of checkbox changes - toggle role for this user
                check.setAttribute("onchange", `toggleRole("${u.name}", "${r.name}")`);
            }
            // add a link for deleting user
            const del = tr.insertCell().appendChild(document.createElement("a"));
            del.setAttribute("onclick",  `deleteUser("${u.name}")`);
            del.innerText = "delete";
        }
    }

    /**
     * called when role checkbox for the user changes selection state
     * @param userName  name of user
     * @param roleName  name of role
     * @returns {Promise<void>}
     */
    async toggleRole(userName, roleName){
        for (const u of this.users){
            if (u.name === userName){
                u.toggleRole(roleName);
                u.save();
            }
        }
    }

    /**
     * called when a new user shall be created
     * if the user name is available create new user:
     * send request to UserController (POST: /api/admin/users/create)
     * @param username of new user
     * @param password of new user
     * @returns {Promise<void>}
     * @throws exception if user name already in use
     */
    async newUser(username, password) {
        for (const user of this.users) {
            if (user.name === username) {
                throw {message: "username not available"};
            }
        }
        const response = await fetch("/api/admin/users/create", {
            method: "post",
            body: JSON.stringify({name: username, password: password}),
            headers: {'Content-Type': 'application/json'}
        });
        if (response.ok) {
            document.location.reload();
        } else {
            alert("error creating new user: " + response.status);
        }
    }
}


/**
 * there is one instance of UserManager
 * @type {UserManager}
 */
const user_manager = new UserManager();

/**
 * called when the page is loaded - gets user and role data from server and fills table
 */
async function loadUsers(){
    await user_manager.loadRoles();
    await user_manager.loadUsers();
    user_manager.showUserTable();
}

/**
 * called when a role of a user changes (checkbox changes selection state)
 * calls UserManager.toggleRole() to add/remove role and send update to server
 * @param username  user concerend
 * @param rolename  changed role
 */
function toggleRole(username, rolename){
    user_manager.toggleRole(username, rolename);
}

/**
 * called when a new user shall be created
 * gets username and password from form and calls UserManager.newUser()
 * @returns {Promise<void>}
 */
async function newUser(){
    const uname = document.querySelector("#username").value;
    if (uname.length > 0) {
        const pwd = document.querySelector("#password").value;
        try {
            await user_manager.newUser(uname, pwd);
        } catch (e) {
            alert(e);
        }
    } else {
        alert("please specify a user name");
    }
}

/**
 * called when a user shall be deleted
 * sends request to UserController (DELETE: api/admin/users/delete/{username} )
 * after request is finished the page will be reloaded
 * @param uname
 * @returns {Promise<void>}
 */
async function deleteUser(uname){
    const response = await fetch("/api/admin/users/delete/" + uname, {
        method : "delete"
    });
    if (!response.ok){alert("error deleting user: " + response.status)}
    window.location.reload();

}
