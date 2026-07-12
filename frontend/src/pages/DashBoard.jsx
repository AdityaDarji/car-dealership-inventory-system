import { useEffect, useState } from "react";

import Navbar from "../components/Navbar";
import Hero from "../components/Hero";
import SearchBar from "../components/SearchBar";
import VehicleCard from "../components/VehicleCard";


import {

    getAllVehicles,

    deleteVehicle,

    purchaseVehicle

} from "../services/VehicleServices";


import "../styles/dashboard.css";

import { useNavigate } from "react-router-dom";




export default function Dashboard() {

  const navigate = useNavigate();

  const [cars, setCars] = useState([]);


  const [filteredCars, setFilteredCars] = useState([]);

  const loadCars = async () => {

    try {

      const response = await getAllVehicles();

      setCars(response.data);

      setFilteredCars(response.data);

    } catch (err) {

      console.log(err);

    }

  };

  useEffect(() => {

    loadCars();

  }, []);

  const handleDelete = async (id) => {

    const confirmDelete = window.confirm(
        "Are you sure you want to delete this vehicle?"
    );

    if (!confirmDelete) return;

    try{

        await deleteVehicle(id);

        loadCars();

    }catch(err){

        alert("Delete failed");

  }
 
}
 const handleEdit=(car)=>{

    navigate(`/edit-car/${car.id}`);


};

  const handlePurchase = async (id) => {

    await purchaseVehicle(id);

    loadCars();

  };

  return (

    <>

      <Navbar />

      <Hero />

      <div className="container">

        <SearchBar
          setFilteredCars={setFilteredCars}
        />

        <div className="vehicle-grid">

          {

            filteredCars.map((car) => (

    <VehicleCard
        key={car.id}
        car={car}
        onDelete={handleDelete}
        onPurchase={handlePurchase}
        onEdit={handleEdit}
    />

))
          }

        </div>

      </div>

    </>

  );

}