

function checkAllN() {
    var name = document.getElementById("uname");
    if (name.value == null || name.value == "") {
        document.getElementById("errorN").innerHTML = "×";

    }
    if (name.value != null && name.value != "") {
        if (name.value.length < 2 || name.value.length >= 6) {
            document.getElementById("errorN").innerHTML = "×";

        }
        else {
            document.getElementById("errorN").innerHTML = "";

        }
    }
}
function checkAllP() {
    var pass = document.getElementById("password");
    if (pass.value == null || pass.value == "") {
        document.getElementById("errorP").innerHTML = "×";
    }
    if (pass.value != null && pass.value != "") {
        if (pass.value.length <= 3 || pass.value.length >= 9) {
            document.getElementById("errorP").innerHTML = "×";
        }
        else {
            document.getElementById("errorP").innerHTML = "";
        }
    }

}
function checkAllP2() {
    var pass1 = document.getElementById("password");
    var pass2 = document.getElementById("password2");
    if (pass2.value == null || pass2.value == "") {
        document.getElementById("errorP2").innerHTML = "×";
    }
    else {
        if (pass2.value.length <= 3 || pass2.value.length >= 9) {
            document.getElementById("errorP2").innerHTML = "×";
        } else if (pass1.value != pass2.value) {
            document.getElementById("errorP2").innerHTML = "×";
        }
        else {
            document.getElementById("errorP2").innerHTML = "";
        }
    }

}
function checkAllE() {
    var email = document.getElementById("email");
    var check = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (email.value == null || email.value == "") {
        document.getElementById("errorE").innerHTML = "×";
    }
    if (!check.test(email.value)) {
        document.getElementById("errorE").innerHTML = "×";
    } else {
        document.getElementById("errorE").innerHTML = "";
    }

}
function checkAll() {
    var name = document.getElementById("uname");
    var password1 = document.getElementById("password");
    var password2 = document.getElementById("password2");
    var email = document.getElementById("email");
    if (name.value == null || name.value == "" || password1.value == null || password1.value == "" || password2.value == null || password2.value == "" || email.value == null || email.value == "") {
       alert("请填写完整信息！")
        return false;
    } else {
        return true;
    }


}