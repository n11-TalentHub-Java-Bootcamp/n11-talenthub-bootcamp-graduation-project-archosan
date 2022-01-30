import { useFormik } from "formik";
import "./App.css";
import axios from "axios";
import { useState } from "react";
function App() {
  const [response, setResponse] = useState("");
  const handlePostValue = async () => {};

  const formik = useFormik({
    enableReinitialize: true,
    initialValues: {
      identityNumber: "",
      name: "",
      income: "",
      phone: "",
      birthDate: "",
      guarantee: "",
    },
    onSubmit: async (values) => {
      console.log(values);

      try {
        const response = await axios.post("http://localhost:3000/api/v1", {
          name: values.name,
          identityNumber: values.identityNumber,
          income: values.income,
          phone: values.phone,
          birthDate: values.birthDate,
          guarantee: values.guarantee,
        });
        console.log(response);
        setResponse(response.data);
      } catch (error) {
        console.log(error);
      }
    },
  });
  const deneme = `app__info${response && "__none"}`;
  console.log(deneme);
  return (
    <div className="app">
      <div>
        <form onSubmit={formik.handleSubmit}>
          <label htmlFor="identityNumber">Kimlik No</label>
          <input
            value={formik.values.identityNumber}
            onChange={formik.handleChange}
            type="text"
            id="identityNumber"
          />
          <label htmlFor="name">İsim</label>
          <input
            value={formik.values.name}
            onChange={formik.handleChange}
            type="text"
            id="name"
          />
          <label htmlFor="income">Aylık Gelir</label>
          <input
            value={formik.values.income}
            onChange={formik.handleChange}
            type="text"
            id="income"
          />
          <label htmlFor="phone">Telefon</label>
          <input
            value={formik.values.phone}
            onChange={formik.handleChange}
            type="text"
            id="phone"
          />
          <label htmlFor="birthDate">Doğum Tarihi</label>
          <input
            value={formik.values.birthDate}
            onChange={formik.handleChange}
            type="date"
            id="birthDate"
          />
          <label htmlFor="guarantee">Teminat</label>
          <input
            value={formik.values.guarantee}
            onChange={formik.handleChange}
            type="text"
            id="guarantee"
          />
          <button type="submit">Submit</button>
        </form>
      </div>
      <div className={`app__info${!response && "__none"}`}>
        <h1>
          Kredi Durumunuz:{" "}
          {`${response?.creditStatus ? "Onaylandı" : "Reddedildi"}`}
        </h1>
        <h1>Verilebilen toplam kredi</h1>
        <h1>{response?.amountCredit} TL</h1>
      </div>
    </div>
  );
}

export default App;
