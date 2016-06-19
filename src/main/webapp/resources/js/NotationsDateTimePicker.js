var startDate;
var startTime;
var endDate;
var endTime;

$(document).ready(function () {

    startDate = $('#startDate').datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });

    startTime = $('#startTime').datetimepicker({
        datepicker: false,
        format: 'H:i'
    });

    endDate = $('#endDate').datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });

    endTime = $('#endTime').datetimepicker({
        datepicker: false,
        format: 'H:i'
    });

});