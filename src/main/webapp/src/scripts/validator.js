const numberPattern = /^[+-]?(\d*[.,])?\d+$/;

function validate() {
    return validateY() && validateR();
}

function validateAccuracy() {
    if (!numberPattern.test(FIELD_ACCURACY.val())) {
        //here you should input action which you want to do when field is wrong
        return false;
    } else {
        const accuracy = parseInt(FIELD_ACCURACY.val());
        return !(Number.isNaN(accuracy) || accuracy <= 0 || accuracy >= 32);
    }
}

function validateY() {
    if (checkY()) {
        FIELD_Y.removeClass('error');
        hideWarning(Y_WARNING);
        return true;
    } else {
        FIELD_Y.addClass('error');
        return false;
    }
}

function validateR() {
    if (checkR()) {
        FIELD_R.removeClass('error');
        hideWarning(R_WARNING);
        return true;
    } else {
        FIELD_R.addClass('error');
        return false;
    }
}

function hideWarning(warningElement) {
    warningElement.html("");
}

function checkY() {
    if (!numberPattern.test(FIELD_Y.val())) {
        Y_WARNING.html("Y in (-5; 5)");
        return false;
    }
    const y = FIELD_Y.val();
    const res = Number.isNaN(y) || y < -5 || y > 5
    if (res) {
        Y_WARNING.html("Y in (-5; 5)");
    }
    return !(res);
}

function checkR() {
    if (!numberPattern.test(FIELD_R.val())) {
        R_WARNING.html("R in (2; 5)");
        return false;
    }
    const r = FIELD_R.val();

    const res = Number.isNaN(r) || r < 2 || r > 5
    if (res) {
        R_WARNING.html("R in (2; 5)");
        console.log(r);
    }
    return !(Number.isNaN(r) || r < 2 || r > 5);
}
