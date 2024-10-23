
const fs = require('fs');
const os = require('os');


/*fs.readFile('./test.js', 'utf8', (err, data) => {
    if (err) console.log(err);

    print(data);
});*/

/* Asynchronous stuff can be a bit hard...
 * you'd expect the code to be run line by line but in js it often isn't
 * as it uses asynchronous operations implisitely and you often didn't even think
 * it would be asynchronous. Hence the variable might be null when you print it if
 * you won't wait for reading or other async operations to finish first
 */

fs.readFile('./sample.txt', 'utf8', printData);

function print(t) {
    console.log("_ " + t);
}

function printData(err, data) {
    if (err)
        console.error("_error: " + err);
    else
        console.log("Read:\n" + data);
}

fs.readFile('./sample.txt', 'utf8', (err, data) => {
    if (err)
        console.error("Error: " + err);
    else
        fs.writeFile('./output.txt', data, 'utf8', (err) => {
            if (err) console.error("error: " + err);
            else
                console.log("\nWritten");
        });
});


os_stuff(os.hostname(), os.platform(), os.cpus().length);

function os_stuff(hostname, platform, cores){
    let os_string = "Hostname: " + hostname + "  OS: " + platform + "  cores: " + cores;
    console.log("OS Stuff:\n" + os_string + "\n\n\n");

    fs.writeFile('os_stuff.txt', os_string.replaceAll("  ", "\n") + "\n"
        ,(err) => console.error(err ? err : "Success!! Wohooo!!!!"));
}


/* Async-await */

printIp();

async function printIp(){
    let t = await (await fetch('https://api.ipify.org?format=json')).json()
    console.log("Your external IP is: " + t.ip);
}

