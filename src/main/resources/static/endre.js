$(document).ready(function () {
    const id = window.location.search.substring(1);
    const url = "/hentEn?" + id;
    $.get(url, function (billett) {
        $("#id").val(billett.id);
        $("#filmer").val(billett.filmer);
        $("#antall").val(billett.antall);
        $("#fornavn").val(billett.fornavn);
        $("#etternavn").val(billett.etternavn);
        $("#nummer").val(billett.nummer);
        $("#epost").val(billett.epost);
    });

    $("#Endre").click(function (event) {
        event.preventDefault();

        const billettdata = {
            id: $("#id").val(),
            filmer: $("#filmer").val(),
            antall: $("#antall").val(),
            fornavn: $("#fornavn").val(),
            etternavn: $("#etternavn").val(),
            nummer: $("#nummer").val(),
            epost: $("#epost").val()
        };

        $.post("/endreEn", billettdata, function () {
            window.location.href = "/kinobiletter.html";
        });
    });
});

