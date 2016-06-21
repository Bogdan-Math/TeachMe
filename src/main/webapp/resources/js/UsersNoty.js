function notyReloadPage(layout) {
    noty({
        layout: layout,
        text: 'Good work!!! Please, reload page to look at changes. Reload NOW???',
        type: 'success',
        theme: 'defaultTheme',
        buttons: [
            {
                addClass: 'btn btn-primary',
                text: 'ok',
                onClick: function ($noty) {
                    $noty.close();
                    location.reload();
                }
            },
            {
                addClass: 'btn btn-danger',
                text: 'cancel',
                onClick: function ($noty) {
                    $noty.close();
                }
            }
        ]
    });
}

function notyError() {
    noty({
        text: 'Ooops!!! Something go wrong!!! Try again!!!',
        type: 'error',
        layout: 'bottomRight',
        timeout: 3000
    });
}

function create() {
    var form = $('#createUserDetails');
    $.ajax({
        type: 'POST',
        url: 'users/save',
        data: form.serialize(),
        success: function () {
            $('#createUserModalWindow').modal('hide');
            notyReloadPage('topRight')
        },
        error: function () {
            notyError();
        }
    });

}

$(document).ready(function () {

    $('#createUser').on('click', function () {
        create();
    });

});