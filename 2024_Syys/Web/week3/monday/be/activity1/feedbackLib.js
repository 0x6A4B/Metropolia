const feedbacks = [];
let nextId = 1;

// {
//     "sender": "John Smith",
//     "message": "Great session on React components! I found the examples very helpful.",
//     "rating": 5
//   }

const getAll = () => {
    return feedbacks;
}

const findById = (id) => {

    for (let i = 0; i < feedbacks.length; i++) {
        if (id == feedbacks[i].id) {
            return feedbacks[i];
        }
    }

    return null;
}

const createFeedback = (input) => {

    const {sender, message, rating} = input;

    feedbacks.push({
        id:nextId++,
        sender:sender,
        message:message,
        rating:rating
    })

    return feedbacks[feedbacks.length - 1];
}

const updateFeedback = (input) => {

    const {id, sender, message, rating} = input;

    for (let i = 0; i < feedbacks.length; i++) {
        if (feedbacks[i].id == id) {
            if (sender) feedbacks[i].sender = sender;
            if (message) feedbacks[i].message = message;
            if (rating) feedbacks[i].rating = rating;
            return feedbacks[i];
        }
    }
    return null;
}

const deleteFeedback = (id) => {

    for (let i = 0; i < feedbacks.length; i++) {
        if (feedbacks[i].id == id) {
            feedbacks.splice(i, 1);
            return true;
        }
    }
    return false;
}

if (require.main === module) {
    let result = createFeedback({
        sender:"John Smith",
        message:"Something goes here",
        rating:2
    });
    let result2 = createFeedback({
        sender:"ASKdkasdk",
        message:"AJSdJASDJASJDJA",
        rating:2222
    });
    let result3 = createFeedback({
        sender:"Bob",
        message:"Something",
        rating:1
    });

    console.log("First result", result);

    const allreviews = getAll();
    console.log("All reviews", allreviews);

    const test = {
        id:1,
        sender:"Something",
        message:"Something else goes here",
        rating:999999
    }

    updateFeedback(test);

    console.log("Updated feedback", getAll());

    deleteFeedback(2);

    console.log("Deleted id 2", getAll());
   }

module.exports = {
    getAll,
    findById,
    createFeedback,
    updateFeedback,
    deleteFeedback
}