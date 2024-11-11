const ollamaFetch = require('./ollamaFetch')


function getName(faction){
    return ollamaFetch.queryOllama(faction)
}


export default llamaModel;