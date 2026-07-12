import { FaSearch } from "react-icons/fa";
import { useState } from "react";

import {
    searchVehicle,
    getAllVehicles
} from "../services/VehicleServices";

export default function SearchBar({ setFilteredCars }) {

    const [search, setSearch] = useState("");

    const handleSearch = async (e) => {

    const value = e.target.value;

    setSearch(value);

    try {

        if (value.trim() === "") {

            const res = await getAllVehicles();

            setFilteredCars(res.data);

            return;
        }

        const res = await searchVehicle({

            brand: value,

            model: value

        });

        setFilteredCars(res.data);

    } catch (err) {

        console.log(err);

    }

};
    return (

        <div className="search-section">

            <div className="search-box">

                <FaSearch />

                <input

                    value={search}

                    onChange={handleSearch}

                    placeholder="Search Brand or Model"

                />

            </div>

        </div>

    );

}