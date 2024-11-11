import { useState } from "react";


function ContactUs() {
  const [formDataState, setFormDataState] = useState({});

  console.log("_", formDataState);

  const changeHandler = (event) => {
    let trgt = event.target;
    //console.log(trgt.id, trgt.value);
    setFormDataState(
      (prevData) =>
        ({ ...prevData, [trgt.id]: trgt.value })
        /* Object.assign won't work!! Must use above syntax */
        //Object.assign(formDataState, { ...prevData, [trgt.id]: trgt.value }) // THIS WON'T WORK!!!
    );

    
  };

  const submitData = (event) => {
    event.preventDefault();
    let _formData = { ...formDataState, submittedOn: new Date() };
    console.log("Submit form: ", _formData);

    setFormDataState({});
  };

  return (
    <div>
      <h2>Contact Us</h2>
      <form onSubmit={submitData}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            id="name"
            type="text"
            onChange={(e) => changeHandler(e)}
            value={formDataState.name || ""}
          />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input id="email" type="email" onChange={e => changeHandler(e)} value={formDataState.email || ""} />
        </div>
        <div>
          <label htmlFor="phone">Phone:</label>
          <input
            id="phone"
            type="tel"
            pattern="[0-9]{2,4}-[0-9]{7,8}"
            onChange={e => changeHandler(e)}
            value={formDataState.phone || ""}
          />
        </div>
        <div>
          <label htmlFor="phoneType">PhoneType:</label>
          <select id="phonetype" onChange={e => changeHandler(e)} value={formDataState.phonetype || "..Select phone type.."}>
            <option value="">..Select phone type..</option>
            <option value="mobile">Mobile</option>
            <option value="landline">Landline</option>
            <option value="tincan">Tincans connect with a string</option>
          </select>
        </div>
        <div>
          <label htmlFor="comment">Comments</label>
          <textarea id="comment" onChange={e => changeHandler(e)} value={formDataState.comment || ""} />
        </div>
        <button>Submit</button>
      </form>
    </div>
  );
}

export default ContactUs;
