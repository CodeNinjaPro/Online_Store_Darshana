selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("salary_shedule_id").value = this.cells[1].textContent;
            document.getElementById("emp_id").value = this.cells[2].textContent;
            document.getElementById("basic_salary").value = this.cells[3].textContent;
            document.getElementById("ot_rate").value = this.cells[4].textContent;
            document.getElementById("bonus").value = this.cells[5].textContent;
            document.getElementById("date_time").value = this.cells[6].textContent;
        };
    }
}

function save() {
    var salary_shedule_id = $('#salary_shedule_id').val();
    var emp_id = $('#emp_id').val();
    var basic_salary = $('#basic_salary').val();
    var ot_rate = $('#ot_rate').val();
    var bonus = $('#bonus').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (salary_shedule_id === "" || emp_id === "" || basic_salary === "" || ot_rate === "" || bonus === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Salary_sheduleServlet',
            method: 'POST',
            data: {action: action, salary_shedule_id: salary_shedule_id, emp_id: emp_id, basic_salary: basic_salary, ot_rate: ot_rate, bonus: bonus, date_time: date_time},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function update() {
    var salary_shedule_id = $('#salary_shedule_id').val();
    var emp_id = $('#emp_id').val();
    var basic_salary = $('#basic_salary').val();
    var ot_rate = $('#ot_rate').val();
    var bonus = $('#bonus').val();
    var date_time = $('#date_time').val();
    var action = "update";
    salary_shedule_id = parseInt(salary_shedule_id);
    if (salary_shedule_id === 0) {
        alert("Please Select to Update")
    } else if (salary_shedule_id === "" || emp_id === "" || basic_salary === "" || ot_rate === "" || bonus === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Salary_sheduleServlet',
            method: 'POST',
            data: {action: action, salary_shedule_id: salary_shedule_id, emp_id: emp_id, basic_salary: basic_salary, ot_rate: ot_rate, bonus: bonus, date_time: date_time},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function delet() {
    var salary_shedule_id = $('#salary_shedule_id').val();
    var action = "delete";
    salary_shedule_id = parseInt(salary_shedule_id);
    if (salary_shedule_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'Salary_sheduleServlet',
                method: 'POST',
                data: {action: action, salary_shedule_id: salary_shedule_id},
                success: function (resultText) {
                    $("#table").find("tr:gt(0)").remove();
                    load();
                    alert("Deleted")
                },
                error: function (jqXHR, exception) {
                    alert("Fail Ajax");
                }
            });
        } else {
            alert("Not Deleted")
        }
    }
}

function load() {
    var table = document.getElementById('table');
    var dropdown1 = document.getElementById('emp_id');
    $('#emp_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'EmployeeServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {

            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");

            var c = [];
            c = resultText;


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1];
                    option.value = step2[0];
                    dropdown1.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var action = "serch";
    $.ajax({
        url: 'Salary_sheduleServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {
            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");
            var c = [];
            c = resultText;
            if (c.length > 5) {
                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");
                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var newRow = table.insertRow(table.length),
                            cell0 = newRow.insertCell(0),
                            cell1 = newRow.insertCell(1),
                            cell2 = newRow.insertCell(2),
                            cell3 = newRow.insertCell(3),
                            cell4 = newRow.insertCell(4),
                            cell5 = newRow.insertCell(5),
                            cell6 = newRow.insertCell(6),
                            cell7 = newRow.insertCell(7),
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
                    cell7.innerHTML = step2[6];
                }
            }
            selectedRowToInput();
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
    document.getElementById("form").reset();
}

function generateReport() {
    var action = "report";
    $.ajax({
        url: 'Salary_sheduleServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {
            alert(resultText);
            window.open('http://localhost/Reports/report.pdf', '_blank');
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
}