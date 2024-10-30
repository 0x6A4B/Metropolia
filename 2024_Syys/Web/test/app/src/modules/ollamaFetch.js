async function queryOllama(faction){
    'use server'

    let name;
    await fetch('http://192.168.1.105:11434/api/generate', {
        method: "POST",
        headers: {
            //dataType : 'jsonp',
            //crossDomain : true,
            Origin: "https://hoplop.0x6a4b.dev",
            Host: "http://192.168.1.105",
            "Content-Type": "application/jsonp",
            //"Access-Control-Allow-Origin" : "*",
            //"Access-Control-Allow-Headers" : "Access-Control-Allow-Origin,Access-Control-Allow-Headers"
        },
        body: JSON.stringify( {
            "model": "llama3",
            "prompt": "give one good name for " + faction + ",  DO NOT ANSWER ANYHTING ELSE"
        })
    }).then(response => response.text())
    .then(data => {
        let arr = data.split("\n");

        let str = "";
        let i = 0;
        while(JSON.parse(arr[i]).done == false)
            str += JSON.parse(arr[i++]).response;
        name = str;
        console.log("XX:", str)
    })
    .catch(error  => console.error(error));

    console.log("Faction: " + faction + " Name: " + name)
    return name;
}

async function q(fa){
    try{
        const resp = await Promise.all(() => {
            fetch('http://192.168.1.105:11434/api/generate', {
                method: "POST",
                body: JSON.stringify( {
                    "model": "llama3",
                    "prompt": "give one good name for " + fa + ",  DO NOT ANSWER ANYHTING ELSE"
                })})}
        )
    }catch(err) {console.error(err);}
}

module.exports.queryOllama = queryOllama;