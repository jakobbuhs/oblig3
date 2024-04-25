let liste = [];
$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlle();
});
function valideringEpost() {
    let epost = $("#epost").val();
    if(epost===""){
        $("#feilmeldingEpost").html("Du må huske å skrive inn eposten din!");
        return false;}
    else if(epost.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
        $("#feilmeldingEpost").html("");
        return true;
    }else {
        $("#feilmeldingEpost").html("Du har skrevet inn en ugyldig epost");
        return false;
    }
}
function valideringFornavn(){
    let fornavn = $("#fornavn").val();
    if(fornavn===""){
        $("#feilmeldingFornavn").html("Du må huske å skrive inn fornavnet ditt!");
        return false;
    }
    else if(/\d/.test(fornavn)
    ){
        $("#feilmeldingFornavn").html("Du har tall i fornavnet ditt.");
        return false;
    }else{

        $("#feilmeldingFornavn").html("");
        return true;
    }
}
function valideringEtternavn(){
    let etternavn = $("#fornavn").val();
    if(etternavn===""){
        $("#feilmeldingEtternavn").html("Du må huske å skrive inn etternavnet ditt!");
        return false;}
    if(/\d/.test(etternavn)){
        $("#feilmeldingEtternavn").html("Du har tall i etternavnet ditt.");
        return false;

    }else{
        $("#feilmeldingEtternavn").html("");
        return true;
    }
}
function valideringNummer(){
    let nummer = Number($("#nummer").val());
    if(nummer===0){
        $("#feilmeldingNummer").html("Har du kanskje glemt å skrive inn nummeret ditt?!");
        return false;}
    if(10000000 < nummer && nummer < 99999999){
        $("#feilmeldingNummer").html("");
        return true;
    }else {
        $("#feilmeldingNummer").html("Du har skrevet inn et ugyldig telefonnummer.");
        return false;
    }
}
function valideringBillett(){
    let billett = Number($("#antall").val());
    if(billett === 0){
        $("#feilmeldingAntall").html("Du må huske å skrive inn hvor mange dere skal være!");
        return false;}
    else if(billett >0 && billett<11){
        $("#feilmeldingAntall").html("");
        return true;
    }
    else{
        return false;
    }
}
function billettKjop(){
    if (valideringEpost() && valideringNummer() && valideringFornavn() && valideringEtternavn()) {
        const billettData = {
            filmer: $("#filmer").val(),
            antall: $("#antall").val(),
            fornavn: $("#fornavn").val(),
            etternavn: $("#etternavn").val(),
            nummer: $("#nummer").val(),
            epost: $("#epost").val()
        };

        $.post("/lagre", billettData, function(){
            hentAlle();
        });
    }
}
function hentAlle() {
    $.get("/hentAlle", function (data) {
        console.log(data)
        Ut(data);
    });
}
function Ut(billetter){
    let ut = "";
    for (let i in billetter) {
        ut += billetter[i].fornavn + " " + billetter[i].etternavn + " Skal se: " + billetter[i].filmer + " og er totalt " + billetter[i].antall + " personer,";
        ut += " Kontakt info: epost: " + billetter[i].epost + " tlf: " + billetter[i].nummer + "</br>";
    }
    $("#billetterUt").html(ut);
}

function slettBilletter(){
    $.get( "/slettAlle", function() {
        hentAlle();
    });
}