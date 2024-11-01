let Car = require('./carLib');


const getAllCars = (req, res) => {
    let cars = Car.getAll();
    console.log("XX", cars.length)
    if (cars.length > 0) res.json(cars);
    else res.json({message: "No cars in list"})
}

const createCar = (req, res) => {
    let newCar = Car.addOne(req.body.model, req.body.color, req.body.age);
    if (newCar)
        res.json(newCar);
    else
        res.status(500).json({message: "Error in creation"})
}

const getCarById = (req, res) => {
    let car = Car.findById(req.params.carId);
    if (car)
        res.json(car);
    else
        res.status(500).json({message: "Not found"})
}

const updateCar = (req, res) => {
    let car = Car.updateOneById(req.params.carId, req.body);
    if (car)
        res.json(car);
    else
        res.status(500).json({message: "Not found"})
}

const deleteCar = (req, res) => {
    let car = Car.deleteOneById(req.params.carId);
    if (car)
        res.json({message: "Car: " + req.params.carId + " deleted"});
    else
        res.status(500).json({message: "Not found"})
}


module.exports = {getAllCars, getCarById, createCar, updateCar, deleteCar};



