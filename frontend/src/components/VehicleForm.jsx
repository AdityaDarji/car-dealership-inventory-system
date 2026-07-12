import { useState } from "react";

export default function VehicleForm({
    initialData,
    onSubmit,
    submitText
}) {

    const [form, setForm] = useState(initialData);

    const handleChange = (e) => {

        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

    };

    const submit = (e) => {

        e.preventDefault();

        onSubmit(form);

    };

    return (

        <div className="container mt-5">

            <div className="card shadow-lg p-4">

                <h2 className="mb-4">

                    {submitText} Vehicle

                </h2>

                <form onSubmit={submit}>

                    <div className="row">

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="brand"
                                placeholder="Brand"
                                value={form.brand}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="model"
                                placeholder="Model"
                                value={form.model}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-4 mb-3">

                            <input
                                className="form-control"
                                name="year"
                                type="number"
                                placeholder="Year"
                                value={form.year}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-4 mb-3">

                            <input
                                className="form-control"
                                name="color"
                                placeholder="Color"
                                value={form.color}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-4 mb-3">

                            <input
                                className="form-control"
                                name="fuelType"
                                placeholder="Fuel Type"
                                value={form.fuelType}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="transmission"
                                placeholder="Transmission"
                                value={form.transmission}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="mileage"
                                type="number"
                                placeholder="Mileage"
                                value={form.mileage}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="price"
                                type="number"
                                placeholder="Price"
                                value={form.price}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="quantity"
                                type="number"
                                placeholder="Quantity"
                                value={form.quantity}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="category"
                                placeholder="Category"
                                value={form.category}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-md-6 mb-3">

                            <input
                                className="form-control"
                                name="vin"
                                placeholder="VIN"
                                value={form.vin}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-12 mb-3">

                            <input
                                className="form-control"
                                name="imageUrl"
                                placeholder="Image URL"
                                value={form.imageUrl}
                                onChange={handleChange}
                            />

                        </div>

                        <div className="col-12 mb-4">

                            <select
                                className="form-select"
                                name="status"
                                value={form.status}
                                onChange={handleChange}
                            >

                                <option value="AVAILABLE">AVAILABLE</option>
                                <option value="RESERVED">RESERVED</option>
                                <option value="SOLD">SOLD</option>
                                <option value="OUT_OF_STOCK">OUT OF STOCK</option>

                            </select>

                        </div>

                    </div>

                    <button
                        className="btn btn-primary w-100"
                    >
                        {submitText}
                    </button>

                </form>

            </div>

        </div>

    );

}