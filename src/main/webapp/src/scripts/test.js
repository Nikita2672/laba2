function receiveSubmit() {
    let xParam;
    if (validate()) {
        if (FIELD_X.val() === "") {
            xParam = 0;
        } else {
            xParam = FIELD_X.val();
        }
        $.get('ServletController', {
            x: xParam,
            y: FIELD_Y.val(),
            r: FIELD_R.val(),
            fromG: false
        }, function (data) {
            if (data !== "Data is incorrect") {
                drawDot(xParam, FIELD_Y.val(), FIELD_R.val());
                console.log(data);
                updateTable(data);
            } else {
                alert(data);
            }
        });
    } else {
        alert("data is invalid");
    }
}

function receiveFromGraph(x, y) {
    if (validateR()) {
        x = x / 175 * (FIELD_R.val() * 1.4583);
        y = y / 175 * (FIELD_R.val() * 1.4583);
        console.log("x: " + x + " y: " + y);
        $.get('ServletController', {
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


