var dataset = [];
let object;
$(document).ready(function () {
    object = $('#table_id').DataTable();
    $.get('ServletController', {
        loadData: "true"
    }, function (data) {
        if (data !== "There is no data" && data !== "Data is invalid") {
            updateTable(data);
            for (let i = 0; i < dataset.length; i++) {
                drawDot(dataset[i][0], dataset[i][1], dataset[i][2]);
            }
        }
        if (data === "Data is invalid") {
            alert(data);
        }
    });
})

function updateTable(data) {
    object.destroy();
    let mass = data.split("%");
    dataset = [];
    for (let i = 1; i < mass.length; i++) {
        dataset.unshift(mass[i].split("*"));
    }
    console.log(dataset);
    object = $('#table_id').DataTable({
        data: dataset,
        columns: [
            {title: 'X',},
            {title: 'Y',},
            {title: 'R',},
            {title: 'Time',},
            {title: 'Time completed',},
            {title: 'Result',},
        ],
    })
}
