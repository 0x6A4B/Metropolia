import {useState} from 'react';


const formData = {
    name: "",
    email: "",
    phone: "",
    phonetype: "",
    comment: ""
}

function ContactUs() {
    const [formDataState, setformDataState] = useState(formData);
    console.log("_", formDataState);
    

    const changeHandler = (event) => {
        let trgt = event.target;
        console.log(trgt.id, trgt.value);
        setformDataState(prevData => Object.assign(prevData, { [trgt.id] : trgt.value }))
    }

    const submitData = (event) => {
        event.preventDefault();
        let _formData = {...formDataState, submittedOn: new Date()};
        console.log("Submit form: ", _formData);
        setformDataState(formData);
    }

    return (
      <div>
        <h2>Contact Us</h2>
        <form onSubmit={submitData}>
          <div>
            <label htmlFor='name' value={formDataState.name}>Name:</label>
            <input id='name' type='text' onChange={changeHandler} />
          </div>
          <div>
            <label htmlFor='email'>Email:</label>
            <input id='email' type='text' onChange={changeHandler} />
          </div>
          <div>
            <label htmlFor='phone'>Phone:</label>
            <input id='phone' type='tel' onChange={changeHandler} />
          </div>
          <div>
            <label htmlFor="phoneType">PhoneType:</label>
            <select id="phonetype" onChange={changeHandler}>
                <option value="">..Select phone type..</option>
                <option value="mobile">Mobile</option>
                <option value="landline">Landline</option>
                <option value="tincan">Tincans connect with a string</option>
            </select>
          </div>
          <div>
            <label htmlFor="comment">Comments</label>
            <textarea id="comment" onChange={changeHandler} />
          </div>
          <button>Submit</button>
        </form>
      </div>
    );
  }
  
  export default ContactUs;