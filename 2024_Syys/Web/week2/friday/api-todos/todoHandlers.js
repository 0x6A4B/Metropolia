let Todo = require('./todosLib');


const getAllTodos = (req, res) => {
    let todos = Todo.getAll();
    if (todos.length > 0) res.json(todos);
    else res.json({message: "No todos in list"})
}

const createTodo = (req, res) => {
    let newTodo = Todo.addOne(req.body.task, req.body.completed, req.body.dueDate);
    if (newTodo)
        res.json(newTodo);
    else
        res.status(500).json({message: "Error in creation"})
}

const getTodoById = (req, res) => {
    let todo = Todo.findById(req.params.todoId);
    if (todo)
        res.json(todo);
    else
        res.status(500).json({message: "Not found"})
}

const updateTodo = (req, res) => {
    console.log(req.params.todoId)
    let todo = Todo.updateOneById(req.params.todoId, req.body);
    if (todo)
        res.json(todo);
    else
        res.status(500).json({message: "Not found"})
}

const deleteTodo = (req, res) => {
    let todo = Todo.deleteOneById(req.params.todoId);
    if (todo)
        res.json({message: "Todo: " + req.params.todoId + " deleted"});
    else
        res.status(500).json({message: "Not found"})
}


module.exports = {getAllTodos, getTodoById, createTodo, updateTodo, deleteTodo};



