const Feedback = require("./feedbackLib");

const getAllFeedbacks = (req, res) => {

    res.json(Feedback.getAll());
};

const createFeedback = (req, res) => {

    res.status(201).json(Feedback.createFeedback(req.body));
};

const getFeedbackById = (req, res) => {

    const temp = Feedback.findById(req.params.feedbackId);

    if (temp) {
        res.json(temp);
    } else {
        res.status(500).json({error:"Feedback id not found"});
    }
};

const updateFeedback = (req, res) => {

    const temp = Feedback.updateFeedback({
        id:req.params.feedbackId,
        sender:req.body.sender,
        message:req.body.message,
        rating:req.body.rating
    });

    if (temp) {
        res.json(temp);
    } else {
        res.status(500).json({error:"Message not found"})
    }
};

const deleteFeedback = (req, res) => {

    res.status(204).json(Feedback.deleteFeedback(req.params.feedbackId));
};

module.exports = {
  getAllFeedbacks,
  getFeedbackById,
  createFeedback,
  updateFeedback,
  deleteFeedback,
};