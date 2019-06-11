var pendingXhr = false;

$(function () {
    var usernameInput = $("#username-input");
    var popupList = $("#user-search-popup");
    var searchPopup = new SearchPopup(usernameInput, popupList);

    searchPopup.onInputChange((value) => {
        if (value !== "") {
            $.get("", { userId: value })
                .done(() => {
                    renderList(data)
                    /*renderList(popupList, [
                        "user1", "usser_2", "wewr", "Tymek", "Jin_hots"
                    ]);*/
                    $("#user-search-popup").addClass("visible");
                });
        }
    });
    handleUserRemoval();
});

function handleUserRemoval() {
    $(".delete-mod-btn").on("click", function () {
        var listElement = $(this).parent("li");
        var userId = listElement.attr("user-id");
        sendUnban(listElement, userId);
    });
}

function sendUnban(listElement, userId) {
    if (pendingXhr)
        return;

    pendingXhr = true;
    $.post("", { userId: userId })
        .done(() => listElement.remove())
        .always(() => pendingXhr = false);
}

function renderList(popupList, data) {
    popupList.empty();
    for (var username of data) {
        popupList.append($(`<li name=${username} class='list-group-item'>${username}</li>`))
    }
}