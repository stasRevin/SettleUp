$(document).ready(function () {

    displayActivities();

});

function displayActivities() {

    $.get('http://18.216.201.147/settleup/services/SettleUpFormData/', function () {

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