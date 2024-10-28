//controllers.js
const getRoot = (req, res) => {
    res.send('I am endpoint get /');
  };

products = [{id: 1, name: "product_1"}];


const getProducts = (req, res) => {
    console.log("req")
    console.log(req.query.id);
    let _result = "";
    products.forEach(p => _result += "ID: " + p.id + " Name: " + p.name + "<br>")
    //res.send(req.query.id);
    console.log(_result);
    res.send("RESULT:\n<br>" + _result);
};

const createProduct = (req, res) => {
    console.log("create")
    console.log(req.body)
    products.push({ id: req.body.id, name: req.body.name });
    res.send(req.body);
};

const updateProduct = (req, res) => {
    console.log("update")
    products[((products.filter(p => p.id = req.body.id))[0].id)-1]
        = { id: req.body.id, name: req.body.name};
    res.send(req.body);
};

const deleteProduct = (req, res) => {
    console.log(products.filter(p => p.id == req.body.id));
    console.log("delete: " + req.body.id)
    
    console.log(products.filter(p => p.id == req.body.id)[0]);
    console.log(products.indexOf(products.filter(p => p.id == req.body.id)[0]));

    if (products.indexOf(products.filter(p => p.id == req.body.id)[0], 1) >= 0)
        products.splice(products.indexOf(products.filter(p => p.id == req.body.id)[0], 1));
    res.send(req.body);
};


module.exports = { getRoot, getProducts, createProduct, updateProduct, deleteProduct };