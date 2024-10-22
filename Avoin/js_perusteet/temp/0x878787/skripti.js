function boxClicked(i) {
//    console.log("klik: " + i);
    if (run) {
//        console.log(run);
        run = false;
        clearInterval(spinnah);
    } else {
//        console.log(run);
        run = true;
        spinnah = setInterval(() => zzz() ,30);
    }
}

function spin(yyy) {
    let a = yyy.charCodeAt(0) + 1;
    let b = yyy.charCodeAt(1);
    let c = yyy.charCodeAt(2);
    
    if (round % 2 === 0) b++;
    if (round % 4 === 0) c++;

    if (a >= end) a = start;
    if (b >= end) b = start;
    if (c >= end) c = start;

    return String.fromCharCode(a) + String.fromCharCode(b) + String.fromCharCode(c);
}

let round = 0;
let start = 64; let end = 93;
let run = true;
const el = document.getElementsByClassName("spin");
let spinnah = setInterval(() => zzz() ,30);

function zzz() {
    el[0].innerHTML = "[" + spin(el[0].innerHTML.substr(1,4)) + "]";
    el[1].innerHTML = "[" + spin(el[1].innerHTML.substr(1,4)) + "]";
    round++;
}
