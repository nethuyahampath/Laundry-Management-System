function signupValidate(){
    var fname=document.forms["myForms"]["firstName"].value;
    var lname=document.forms["myForms"]["lastName"].value;
    var password=document.forms["myForms"]["password"].value;
    var no=document.forms["myForms"]["no"].value;
    var street=document.forms["myForms"]["street"].value;
    var city=document.forms["myForms"]["city"].value;
    var conatact=document.forms["myForms"]["contact"].value;
    var email=document.forms["myForms"]["email"].value;

   
    /*if(passwordValidation(password)){
     return true;
     }else {
     return false;
     }*/
	

    if(isAlphebaticf(fname))
        if(isAlphebaticl(lname))
           // if(isAlphebatic2(username))
                if(passwordValidation(password))
                    //if(confirmpasswordVal(confirmpassword))
                        //if(isAlphaNumeric(address))
                         if(isNumeric2(no))
                        	 if(isAlphebatics(street))
                        		 if(isAlphebaticc(city))
                            		if(isNumeric1(conatact))
                               
                                    if(emailValidation(email))
                                        return true;
                                    else
                                        return false;
                                else
                                    return false;
                            else
                                return false;
                        else
                            return false;
                    else
                        return false;
                else
                    return false;
            else
                return false;
        else
            return false;
    
	

}


function isEmpty(elemValue,field) {
    if (elemValue == "" || elemValue == null) {
        alert("you cannot have " + field + " filed empty");
        return true;
    }
    else {
        return false;
    }
}

function isAlphebaticf(elemValue){
    var exp=/^[a-zA-Z]+$/;
    if(!isEmpty(elemValue,"First Name")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your First Name");
            return false;
        }
    }
    else{
        return false;
    }
}

function isAlphebaticl(elemValue){
    var exp=/^[a-zA-Z]+$/;
    if(!isEmpty(elemValue,"Last Name")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your Last Name");
            return false;
        }
    }
    else{
        return false;
    }
}


function isAlphebatics(elemValue){
    var exp=/^[a-zA-Z]+$/;
    if(!isEmpty(elemValue,"Last Name")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your Street");
            return false;
        }
    }
    else{
        return false;
    }
}


function isAlphebaticc(elemValue){
    var exp=/^[a-zA-Z]+$/;
    if(!isEmpty(elemValue,"Last Name")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your City");
            return false;
        }
    }
    else{
        return false;
    }
}


function isAlphebatic2(elemValue){
    var exp=/^[a-zA-Z]+$/;
    if(!isEmpty(elemValue,"Username")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your Username.You can't add spaces.");
            return false;
        }
    }
    else{
        return false;
    }
}



function passwordValidation(elemValue) {
    if(!isEmpty(elemValue,"Password")) {
        var pw = document.forms["myForms"]["password"].value;
        var specialchar = "~!@#$%^&*_";
        var count=0;


        for (var i = 0; i < pw.length; i++) {
            if (specialchar.indexOf(pw.charAt(i)) > -1) {
                count = 1;
            }
        }


        if (/[a-z]/.test(pw)) {
            count ++;
        }

        if (/[A-Z]/.test(pw)) {
            count ++;
        }
        if (/[\d]/.test(pw)) {
            count ++;
        }
        if (pw.length >= 8) {
            count ++;
        }


        if(count>=5) {
            return true;
        }
        else {

            alert("Password must be at least 8 characters long and must be a combination of uppercase characters, lowercase characters, numeric characters and a special character. ");
            return false;
        }

    }else {
        return false;
    }


}

function confirmpasswordVal(elemValue) {
    if(!isEmpty(elemValue,"Confirm Password")){
        var pw=document.forms["myForms"]["password"].value;
        if(elemValue != pw){
            alert("Passwords are didn't match.");
            return false;
        }
        else{

            return true;
        }
    }else{
        return false;
    }

}




function isAlphaNumeric(elemValue) {
    var exp=/^[0-9a-zA-Z\n]+$/;
    if(!isEmpty(elemValue,"Address")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your Current Address");
            return false;
        }
    }
    else{
        return false;
    }

}



function isNumeric1(elemValue){
    if(!isEmpty(elemValue,"Contact")) {
        var exp = /^[0-9]+$/;
        if (elemValue.length == 10) {
            if (elemValue.match(exp)) {
                return true;
            }
            else {
                alert("Enter a valid contact");
                return false;
            }
        }else {
            alert("Enter a valid contact");
            return false;
        }
    }else {
        return false;
    }
}


function isNumeric2(elemValue){
    if(!isEmpty(elemValue,"Age")) {
        var exp = /^[0-9]+$/;
        if (elemValue >0) {
            if (elemValue.match(exp)) {
                return true;
            }
            else {
                alert("Enter a valid No");
                return false;
            }
        }else {
            alert("Enter a valid No");
            return false;
        }
    }else {
        return false;
    }
}




function emailValidation(elemValue) {
    if(!isEmpty(elemValue,"Email")){
        var atcheck=elemValue.indexOf("@");
        var dotcheck=elemValue.indexOf(".");

        if(atcheck<1 || dotcheck+2 >= elemValue.length || atcheck+2>dotcheck){
            alert("Enter valid email address.");
            return  false;
        }
        else{
            return true;
        }

    }else {
        return false;
    }
}

