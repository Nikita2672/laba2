function receiveSubmit() {
    if (validate()) {
        $.get('ControllerServlet', {
            x: FIELD_X.val(),
            y: FIELD_Y.val(),
            r: FIELD_R.val(),
            fromG: false
        }, function (data) {
            if (data !== "Data is incorrect") {
                drawDot(FIELD_X.val(), FIELD_Y.val(), FIELD_R.val());
                console.log(data);
                updateTable(data);
            } else {
                alert(data);
            }
        });
    } else {
        console.log("data is invalid");
    }
}

function receiveFromGraph(x, y) {
    if (validateR()) {
        x = x / 175 * (FIELD_R.val() * 1.4583);
        y = y / 175 * (FIELD_R.val() * 1.4583);
        console.log("x: " + x + " y: " + y);
        $.get('ControllerServlet', {
            x: x,
            y: y,
            r: FIELD_R.val(),
            fromG: true
        }, function (data) {
            if (data !== "Data is incorrect") {
                drawDot(x, y, FIELD_R.val());
                console.log(data);
                updateTable(data);
            } else {
                alert(data);
            }
        });
    } else {
        alert("R is invalid");
    }
}


