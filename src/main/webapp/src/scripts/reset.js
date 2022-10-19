function cleanInput() {
    $('#x' + FIELD_X.val()).removeClass('selected');
    FIELD_X.val("");
    FIELD_Y.removeClass('error');
    FIELD_R.removeClass('error');
    Y_WARNING.html("Y in (-5; 5)");
    R_WARNING.html("R in (2; 5)");
}
