const express = require('express');
const app = express();
//const bodyParser = require('body-parser')

const { getRoot, getProducts, createProduct, updateProduct, deleteProduct } = require('./controllers.js'); // getRoot is imported


const port = 3005;

/*
app.use(bodyParser.urlencoded({
    extended: true
}));
*/
app.use(express.json())


app.get('/', getRoot); // getRoot is used as a callback
app.get('/API/product', getProducts);
app.post('/API/product', createProduct);
app.put('/API/product', updateProduct);
app.delete('/API/product', deleteProduct);

/*
app.get('/', (req, res) => {
  res.send('Hello World!');
});
*/

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

