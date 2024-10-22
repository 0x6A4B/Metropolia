function tarkistaIka() {
    var ika = document.getElementById("ika").value;
    console.log("Syötetty ikä: " + ika);
    if (ika >=18)
        console.log("Käyttäjä on täysi-ikäinen.");
    else
        console.log("Käyttäjä ei ole vielä täysi-ikäinen.");
}
