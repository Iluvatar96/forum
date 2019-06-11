$(function () {
    var limit = 4;
    var tags = $("input[name='tags[]'");

    limitCheckableCheckboxes(limit, tags);
});

function limitCheckableCheckboxes(limit, elements) {
    elements.on("change", function (e) {

        if ($(this).siblings(":checked").length >= limit)
            this.checked = false;
    });
}