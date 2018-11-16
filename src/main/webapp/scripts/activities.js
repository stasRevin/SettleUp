$(document).ready(function () {

    displayActivities();
console.log("after disply call");
});

function displayActivities() {

    //18.216.201.147:8080
    //localhost:8080
    $.get('http://18.216.201.147:8080/settleup/services/SettleUpFormData/', function () {

    }).done(function (data) {

        var html = '';

        for ( var i = 0; i < data.length; i ++ ) {

            html += '<option value="' + data[i]+ '">' + data[i] + '</option>';

        }

        $('#activity').append(html);

    }).fail(function (data) {
        console.log("Error getting results " + data )
    });

}