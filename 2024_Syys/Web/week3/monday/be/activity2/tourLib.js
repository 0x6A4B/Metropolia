
const tours = [];

let nextId = 1;

function getAll(){
    return tours;
}

function findById(id){
    return tours.find(t => t.id === Number(id));
}

function updateById(tour){
    let result = tours.find(t => t.id === Number(tour.id))
    if (result){
        if (tour.name){
            result.name = tour.name;
        }
        if (tour.info){
            result.info = tour.info;
        }
        if (tour.image){
            result.image = tour.image;
        }
        if (tour.price){
            result.price = tour.price;
        }
        return result;
    }
    return null;
}

function createById(tour){
    return tours[tours.push({
        id: nextId++,
        name: tour.name,
        info: tour.info,
        image: tour.image,
        price: tour.price
    })-1];
}

function deleteById(id){
    let index = tours.indexOf(tours.find(t => t.id === Number(id)));
    if (index >= 0)
        return tours.splice(index, 1);
    return false;
}

module.exports = { deleteById, createById, updateById, findById, getAll };



if (require.main === module) {
    console.log("Create: ",
        createById({
            name: "7 Days Tour",
            info: " Join us for the Best of Helsinki!",
            image: "https://www.course-api.com/images/tours/tour-x.jpeg",
            price: "1,495"
        })
    );

    console.log("Create2: ",
        createById({
            name: "XXX",
            info: "YYYY",
            image: "https://www.course-api.com/images/tours/tour-x.jpeg",
            price: "2"
        }));

    createById({
        name: "ZZZZ",
        info: "HHHHH",
        image: "https://www.course-api.com/images/tours/tour-x.jpeg",
        price: "5"
    });

    console.log("Update: ", updateById({
        name: "UUSINIMI",
        id: 2
    }));

    console.log("GETALL: ", getAll());

    console.log("DEL: ", deleteById(2));
    console.log("DEL: ", deleteById(2));
    
    console.log("getAll called:", getAll());
    console.log("findById called:", findById(1));
    console.log("findById called:", findById(2));

    // rest of the tests here
}


