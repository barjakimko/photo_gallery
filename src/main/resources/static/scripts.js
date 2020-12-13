function passwordLegitimate(newPasswordFirst) {

    let digits = /[1-9]/;
    let isDigit = newPasswordFirst.match(digits);
    if (!isDigit) {
        alert("Password must have a Digit")
        return false;
    }

    let smallLetter = /[a-z]/;
    let isSmallLetter = newPasswordFirst.match(smallLetter);
    if (!isSmallLetter) {
        alert("Password must have a small letter")
        return false;
    }

    let bigLetter = /[A-Z]/;
    let isBigLetter = newPasswordFirst.match(bigLetter);
    if (!isBigLetter) {
        alert("Password must have a big letter")
        return false;
    }

    let length = newPasswordFirst.length;
    if (length < 6) {
        alert("Password must have at least 8 characters")
        return false;
    }
}

    function loginLegitimate(login){


        let smallLetter = /[a-z]/;
        let isSmallLetter = login.match(smallLetter);
        if (!isSmallLetter) {
            alert("Login must have a small letter")
            return false;
        }

        let bigLetter = /[A-Z]/;
        let isBigLetter = login.match(bigLetter);
        if (!isBigLetter) {
            alert("Login must have a big letter")
            return false;
        }

        let length = login.length;
        if (length < 6) {
            alert("Login must have at least 8 characters")
            return false;
        }

        return true
    }


function addGallery(){

    let galleryName = document.getElementById("gallery-name").value


    let length = galleryName.length;
    if (length < 6) {
        alert("Login must have at least 8 characters")
        return false;
    }

    alert("Gallery added to user")
    document.getElementById('add-gallery').submit();

}

function loadImage(){
    let fileName = document.getElementById("filename").value

    let image = new Image();
    let url_image = '../photos/' + fileName;
    image.src = url_image;

    let width = image.width;


    if (width === 0) {
        alert("Wrong file name or wrong localization")
        return false;
    } else {
        alert("File exists")

    }

    document.getElementById('add-gallery').submit();
}

function addUser(logins){

    let login = document.getElementById("login").value

    if (logins.includes(login)){
        alert("Login already used")
        return false
    }

    if(loginLegitimate(login) === false){
        return false
    }

    let password = document.getElementById("password").value

    if (passwordLegitimate(password) === false){
        return false
    }

    alert("Customer added to base");
    document.getElementById('add-user').submit();


}