selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("delivary_id").value = this.cells[1].textContent;
            document.getElementById("invoice_id").value = this.cells[2].textContent;
            document.getElementById("emp_id").value = this.cells[3].textContent;
            document.getElementById("address").value = this.cells[4].textContent;
            document.getElementById("cus_contact").value = this.cells[5].textContent;
            document.getElementById("status").value = this.cells[6].textContent;
            document.getElementById("date_time").value = this.cells[7].textContent;
        };
    }
}

function save() {
    var delivary_id = $('#delivary_id').val();
    var invoice_id = $('#invoice_id').val();
    var emp_id = $('#emp_id').val();
    var address = $('#address').val();
    var cus_contact = $('#cus_contact').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (delivary_id === "" || invoice_id === "" || emp_id === "" || address === "" || cus_contact === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (contactValidation()) {

    } else {
        $.ajax({
            url: 'DelivaryServlet',
            method: 'POST',
            data: {action: action, delivary_id: delivary_id, invoice_id: invoice_id, emp_id: emp_id, address: address, cus_contact: cus_contact, status: status, date_time: date_time},
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
    var delivary_id = $('#delivary_id').val();
    var invoice_id = $('#invoice_id').val();
    var emp_id = $('#emp_id').val();
    var address = $('#address').val();
    var cus_contact = $('#cus_contact').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "update";
    delivary_id = parseInt(delivary_id);
    if (delivary_id === 0) {
        alert("Please Select to Update")
    } else if (delivary_id === "" || invoice_id === "" || emp_id === "" || address === "" || cus_contact === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (contactValidation()) {

    } else {
        $.ajax({
            url: 'DelivaryServlet',
            method: 'POST',
            data: {action: action, delivary_id: delivary_id, invoice_id: invoice_id, emp_id: emp_id, address: address, cus_contact: cus_contact, status: status, date_time: date_time},
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
    var delivary_id = $('#delivary_id').val();
    var action = "delete";
    delivary_id = parseInt(delivary_id);
    if (delivary_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'DelivaryServlet',
                method: 'POST',
                data: {action: action, delivary_id: delivary_id},
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
    var dropdown1 = document.getElementById('invoice_id');
    $('#invoice_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'InvoiceServlet',
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
                    option.text = step2[0];
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
    var dropdown2 = document.getElementById('emp_id');
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
                    dropdown2.add(option);

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
        url: 'DelivaryServlet',
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
                            cell8 = newRow.insertCell(8),
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
                    cell7.innerHTML = step2[6];
                    cell8.innerHTML = step2[7];
                }
            }
            selectedRowToInput();
            getInvoiceDetails();
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
    document.getElementById("form").reset();
}

function contactValidation() {
    var contactNo = $('#cus_contact').val();
    if (contactNo.length === 10) {
        return false;
    } else {
        alert("Invalid Contact Number");
        document.getElementById("cus_contact").select();
        return true;
    }
}

function getInvoiceDetails() {
    var invoice_id = $('#invoice_id').val();
    var action = "serch_customer_details";

    $.ajax({
        url: 'DelivaryServlet',
        method: 'POST',
        data: {action: action, invoice_id: invoice_id},
        success: function (resultText) {
            var x = [];
            x = resultText.split(",");
            document.getElementById("cus_contact").value = x[0];
            document.getElementById("address").value = x[1];
        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
}

function generateReport() {
    var action = "report";
    $.ajax({
        url: 'DelivaryServlet',
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
