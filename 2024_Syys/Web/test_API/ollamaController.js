const ollamaModel = require('./ollamaModel');

function getName(req, res){
    return ollamaModel.getName(req.params.factionId);
}