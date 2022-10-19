function receiveSubmit() {
    if (validate()) {
        $.get('ControllerServlet', {
            x: FIELD_X.val(),
            y: FIELD_Y.val(),
            r: FIELD_R.val(),
            fromG: false
        }, function (data) {
            if (data !== "Data is incorrect") {
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
        x = x / 150 * (FIELD_R.val() * 1.5);
        y = y / 150 * (FIELD_R.val() * 1.5);
        console.log("x: " + x + " y: " + y);
        $.get('ControllerServlet', {
            x: x,
            y: y,
            r: FIELD_R.val(),
            fromG: true
        }, function (data) {
            if (data !== "Data is incorrect") {
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


