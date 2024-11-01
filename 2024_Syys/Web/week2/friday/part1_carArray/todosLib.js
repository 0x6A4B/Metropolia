let todosArray = [];
/*    {
        "task": "Buy groceries",
        "completed": false,
        "dueDate": "2024-08-30"
    }
]*/

// added id because task title is not necessarily good for a unique
// could have just pointed to the location in the array => [0] would be first
function addOne(task, completed, dueDate){
    let length = todosArray.length;
    return todosArray.push({"id": todosArray.length+1, "task": task, "completed": completed, "dueDate": dueDate}) > length;
}

function getAll(){
    return todosArray;
}

function findById(todoId){
    let todo = todosArray.find(i  => i.id === todoId);
    return todo ? todo : false;
}

function updateOneById(id, todo){
    // casting to array just so I can use map, because functional stream is so pretty
    // and no need for assisting variables
    return !findById(id) ? false
        : [findById(id)].map(t => {
        if (todo.task) t.task = todo.task;
        if (todo.completed) t.completed = todo.completed;
        if (todo.dueDate) t.dueDate = todo.dueDate;
        return t;
    })[0];
}

function deleteOneById(id){
    let length = todosArray.length;
    todosArray = todosArray.filter(i => i.id !== id);
    return todosArray.length === length - 1;
}


if (require.main === module) {
    // Add cars
    let result = addOne("Buy groceries", false, "2024-08-30");
    console.log(result);
    result = addOne("Buy more groceries", false, "2024-08-31");
    console.log(result);

    // no type checking or matching function overload so weird things can be pushed in...
    result = addOne("WRONG", "Buy more groceries", false, "2024-08-31");
    console.log(result);

    console.log("getAll called:", getAll());

    console.log("findById called:", findById(10));
    console.log("findById called:", findById(1));

    console.log("updateOneById called:", updateOneById(3, { completed: true }));
    console.log("updateOneById called:", updateOneById(1, { completed: true }));
    console.log("findById called after item updated:", findById(1));

    console.log("deleteOneById called:", deleteOneById(5));
    console.log("deleteOneById called:", deleteOneById(1));
    console.log("findById called after item deleted:", findById(1));

    console.log("getAll called:", getAll());
}

const Todos = {
    getAll,
    addOne,
    findById,
    updateOneById,
    deleteOneById
};

module.exports = Todos;