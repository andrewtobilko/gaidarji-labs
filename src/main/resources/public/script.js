$(document).ready(function () {

    $.ajax({
        url: "http://192.168.1.139:5000/employees"
    }).then(function (data) {
        var employees = data._embedded.employees;

        for (var i = 0; i < employees.length; ++i) {
            var employee = employees[i];
            $('.employees').append('<div class="employee">' + employee.id + ". " + employee.name + " [" + employee.positionTitle + "] " + employee.birthDate + '</div>');
        }
    });

    (function poll() {
        setTimeout(function() {
            $.ajax({
                type: 'GET',
                url: "http://192.168.1.139:5000/state",
                success: function(data) {
                    if (data) {
                        refreshPage();
                    }
                },
                complete: poll
            });
        }, 1000);
    })();

});

function createEmployee() {
    var employee = {
        // name
        name: $('#edit-employee-name').val(),
        // position
        positionTitle: $('#edit-employee-position').val(),
        // date
        birthDate: new Date(
            $('#year').val() ? $('#year').val() : undefined,
            $('#month').val() ? $('#month').val() - 1 : undefined,
            $('#day').val() ? $('#day').val() : undefined
        )
    };
    makeAJAXRequest(
        "http://192.168.1.139:5000/employees/",
        'POST',
        employee
    );

    refreshPage();
}

function updateEmployee() {
    var employee = {
        // name
        name: $('#edit-employee-name').val() || undefined,
        // position
        positionTitle: $('#edit-employee-position').val(),
        // date
        birthDate: new Date(
            $('#year').val() ? $('#year').val() : undefined,
            $('#month').val() ? $('#month').val() - 1 : undefined,
            $('#day').val() ? $('#day').val() : undefined
        )
    };
    makeAJAXRequest(
        "http://192.168.1.139:5000/employees/" + $('#edit-employee-id').val(),
        'PUT',
        employee
    );

    refreshPage();

    makeAJAXRequest(

    );
    refreshPage();
}

function deleteEmployee() {
    var id = $('#delete-employee-id').val();
    makeAJAXRequest(
        "http://192.168.1.139:5000/employees/" + id,
        'DELETE'
    );
    refreshPage();
}

function makeAJAXRequest(url, method, data) {
    $.ajax({
        type: method,
        url: url,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            console.log('success callback = ' + data);
        },
        failure: function (data) {
            console.log('error callback = ' + data);
        }
    });
}

function refreshPage() {
    document.location.reload();
}