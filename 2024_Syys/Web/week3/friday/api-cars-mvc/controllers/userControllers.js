const User = require("../models/userModel");

// GET /users
const getAllUsers = (req, res) => {
  res.json(User.getAll());
};

// POST /users
const createUser = (req, res) => {
  res.status(204).json(User.addOne(req.body));
};

// GET /users/:userId
const getUserById = (req, res) => {
  res.json(User.findById(req.params.userId));
};

// PUT /users/:userId
const updateUser = (req, res) => {
  res.json(User.updateOneById(req.params.userId, req.body));
};

// DELETE /users/:userId
const deleteUser = (req, res) => {
  res.json(User.deleteOneById(req.params.userId));
};

module.exports = {
  getAllUsers,
  getUserById,
  createUser,
  updateUser,
  deleteUser,
};
