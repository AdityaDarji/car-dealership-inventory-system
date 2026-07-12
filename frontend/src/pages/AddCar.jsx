import { useNavigate } from "react-router-dom";
import VehicleForm from "../components/VehicleForm";
import { addVehicle } from "../services/VehicleServices";

export default function AddCar() {

    const navigate = useNavigate();

    const initialData = {

        brand:"",
        model:"",
        year:"",
        color:"",
        fuelType:"",
        imageUrl:"",
        transmission:"",
        mileage:"",
        price:"",
        category:"",
        quantity:"",
        vin:"",
        status:"AVAILABLE"

    };

    const save = async(vehicle)=>{

        await addVehicle(vehicle);

        navigate("/dashboard");

    };

    return (

        <VehicleForm

            initialData={initialData}

            submitText="Add"

            onSubmit={save}

        />

    );

}