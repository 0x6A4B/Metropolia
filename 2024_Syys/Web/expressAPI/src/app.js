const express = require('express');
const app = express();

const { getRoot } = require('./controller1'); // getRoot is imported


const port = 3000;

app.get('/', getRoot); // getRoot is used as a callback

/*
app.get('/', (req, res) => {
  res.send('Hello World!');
});
*/

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

