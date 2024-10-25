const express = require('express');
const app = express();

const { getRoot, getAPI } = require('./controllers.js'); // getRoot is imported


const port = 3005;

app.get('/', getRoot); // getRoot is used as a callback
app.get('/API/name', getAPI);
/*
app.get('/', (req, res) => {
  res.send('Hello World!');
});
*/

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

