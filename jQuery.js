var createAccountAPI = "http://localhost:8080/hitmeup/api/add";
var customerListAPI = "http://localhost:8080/hitmeup/api/list";


 // logic to fetch the customers list and fill the customers table
 var ajax;
 var customerData;
 var isLogged = false;
 
 
 // start the AJAX request
 if (window.XMLHttpRequest) {
     // Mozilla, Safari, IE7+ ...
     ajax = new XMLHttpRequest();
 }
 
 ajax.open('GET',customerListAPI, true);
 ajax.setRequestHeader('Content-type', 'application/json');
 ajax.send();
 
 // run this when the ajax request completes
 ajax.onreadystatechange = function() {
   if (ajax.readyState === 4 && ajax.status === 200) {
      customerData = JSON.parse(ajax.responseText);

   }
 };

// refreshes current page
function refresh(){
    location.reload();
}

// logic to add a customer
function createAccount(){
    $.ajax({
        url: createAccountAPI,
        type: 'POST',
        data: JSON.stringify({
            id: null,
            version: null,
            creationTime: null,
            updateTime: null,
            username: $('#signup-username').val(),
            alias: $('#alias').val(),
            email: $('#email').val(),
            password: $('#signup-password').val()
        }),
        async: true,
        contentType: 'application/json',
        success: refresh
    });

    
}

// adds a customer when clicking on 'add' button
$(document).on('click','#register-btn', createAccount);


var hitmansList;

function populateHitmansList(customerData) {
    hitmansList = customerData;
}

var loggedHitman; // para mensagem 

function verify(){
    for(let i = 0; i < customerData.length; i++){
        if( ($('#username').val() !== customerData[i].username) || ($('#password').val() !== customerData[i].password)){
            continue;
        }
        loggedHitman = customerData[i];
        isLogged = true;
    }
}



function login(){
    verify();
    if(isLogged === true) {
    alert("Verified!");
    redirect();
    console.log("hello");
    }
    if(isLogged === false){
        alert("Your password or username is incorrect");
        refresh();
    }
}

$(document).on('click','#login-btn', login);

function redirect(){
        window.location.href = "../homepage/homepage.html";
}


     

   





