const express = require('express');
const app = express();
const controller = require('./ollamaController');

function logger(){
    console.log(req);
}

app.get('/name/:factionId', controller.getName);
