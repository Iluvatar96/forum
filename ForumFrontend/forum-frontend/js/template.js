$(function () {
    var badge = document.getElementById("navbar-user-badge");

    var menuSwitch = {
        popupElem: document.getElementById("user-menu"),
        enabled: false,
        toggle: function () {
            this.popupElem.classList.toggle("user-menu-hidden");
            this.enabled = !this.enabled
        },
        hide: function () {
            this.popupElem.classList.add("user-menu-hidden");
            this.enabled = false
        }
    };

    document.addEventListener("click", function (e) {
        if (menuSwitch.enabled && !e.target.closest("#navbar-user-badge") && !e.target.closest("#user-menu"))
            menuSwitch.hide();
    });

    badge.addEventListener("click", function (e) {
        menuSwitch.toggle();
    });
});

//CLOSEST POLYFILL
if (!Element.prototype.matches) {
    Element.prototype.matches = Element.prototype.msMatchesSelector ||
        Element.prototype.webkitMatchesSelector;
}

if (!Element.prototype.closest) {
    Element.prototype.closest = function (s) {
        var el = this;

        do {
            if (el.matches(s)) return el;
            el = el.parentElement || el.parentNode;
        } while (el !== null && el.nodeType === 1);
        return null;
    };
}
