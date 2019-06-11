function SearchPopup(inputElem, popupElem) {
    this.inputElem = inputElem;
    this.popupElem = popupElem;
    this.handler = null;
    this.timeout = null;
    this.throttleTime = 800;
    this.dataToSend = null;

    inputElem.on("input", () => {
        this.inputEvent();
    });

    inputElem.on("focus", function () {
        if ($(this).val() !== "")
            popupElem.addClass("visible");
    });

    popupElem.on("click", "li", (e) => {
        inputElem.val(e.target.getAttribute("name"));
    });

    $(document).on("click", (e) => {
        if (e.target.id !== "username-input")
            popupElem.removeClass("visible");
    });


    this.cancelTimer = () => {
        clearTimeout(this.timeout);
        this.timeout = null;
    }

    this.DOMAction = () => {
        popupElem.removeClass("visible");
        this.cancelTimer();
        this.handler(inputElem.val());
    }

    this.inputEvent = () => {
        if (this.inputElem.val() === "")
            popupElem.removeClass("visible");

        if (this.timeout !== null)
            this.cancelTimer();

        this.timeout = setTimeout(this.DOMAction.bind(this), this.throttleTime);
    }

    this.onInputChange = (handler) => {
        this.handler = handler;
    }
}
