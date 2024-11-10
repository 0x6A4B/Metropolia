const Tour = require("./tourLib");

const getAllTours = (req, res) => {
    res.json(Tour.getAll());
};

const createTour = (req, res) => {
    res.json(Tour.createById(req.body));
};

const getTourById = (req, res) => {
    let result = Tour.findById(req.params.tourId);
    if (result !== "undefined")
        res.json(result);
    else
        res.status(404).json({ message: "ID: " + req.params.tourId + " not found" })
};

const updateTour = (req, res) => {
    let result = Tour.updateById({
        name: req.body.name,
        info: req.body.info,
        image: req.body.image,
        price: req.body.price,
        id: req.params.tourId
    });
    if (result)
        res.status(201).json(result);
    else
        res.status(404).json({message: "error in update"});
};

const deleteTour = (req, res) => {
    let result = Tour.deleteById(req.params.tourId);
    if (result)
        res.status(204).send(); //.json({ message: "DELETED", ...result });
    else
        res.status(404).json({ message: "Not found"});
};

module.exports = {
  getAllTours,
  getTourById,
  createTour,
  updateTour,
  deleteTour,
};