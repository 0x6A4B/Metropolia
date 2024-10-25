//controllers.js
const getRoot = (req, res) => {
    res.send('I am endpoint get /');
  };
  


const getAPI = (req, res) => {
    console.log("XX")
    console.log(req);
    res.send('API_');
};


module.exports = { getRoot, getAPI };