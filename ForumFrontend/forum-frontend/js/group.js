/*
 * SEND AJAX REQUEST FOR SUBSCRIPTION
 */
$(function () {

    var pendingRequest = false;

    $("#subscribe-btn").click(function (event) {
        var elem = $(this);

        //PREVENT SENDING MULTIPLE REQUESTS AT ONCE
        if (pendingRequest)
            return;

        pendingRequest = true;

        $.ajax({
            type: "POST",
            url: 'subscribe',
            success: function (data) {
                if (data === "subscribed")
                    elem.empty().append($("<i class='fas fa-check'></i>")).append($("<span> Subskrybujesz</span>"));
                else if (data === "unsubscribed")
                    elem.empty().text("Subskrybuj");

            },
            complete: function () {
                pendingRequest = false;
            }
        });

    });
});