var dataset = [];
let object;
$(document).ready(function () {
    object = $('#table_id').DataTable();
})

function updateTable(data) {
    object.destroy();
    let mass = data.split("%");
    dataset = [];
    for (let i = 1; i < mass.length; i++) {
        dataset.unshift(mass[i].split("*"));
    }
    object = $('#table_id').DataTable({
        data: dataset,
        columns: [
            {title: 'X',},
            {title: 'Y',},
            {title: 'R',},
            {title: 'Time',},
            {title: 'Time completed(milliseconds)',},
            {title: 'Result',},
        ],
    })
}
