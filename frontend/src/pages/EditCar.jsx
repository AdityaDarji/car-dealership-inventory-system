import { useEffect, useState } from "react";

import { useNavigate, useParams } from "react-router-dom";

import VehicleForm from "../components/VehicleForm";

import {

    getVehicleById,

    updateVehicle

} from "../services/VehicleServices";

export default function EditCar(){

    const {id}=useParams();

    const navigate=useNavigate();

    const [vehicle,setVehicle]=useState(null);

    useEffect(()=>{

        load();

    },[]);

    const load=async()=>{

        const res=await getVehicleById(id);

        setVehicle(res.data);

    }

    const update=async(data)=>{

        await updateVehicle(id,data);

        navigate("/dashboard");

    }

    if(!vehicle){

        return <h2 className="text-center mt-5">Loading...</h2>

    }

    return(

        <VehicleForm

            initialData={vehicle}

            submitText="Update"

            onSubmit={update}

        />

    );

}