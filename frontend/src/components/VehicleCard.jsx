import {
   FaGasPump,
  FaCog,
  FaRoad,
  FaTrash,
  FaEdit
} from "react-icons/fa";

export default function VehicleCard({ car,
  onDelete,
  onPurchase,
  onEdit}) {


   return (

    <div className="vehicle-card">

      <img
        src={car.imageUrl}
        alt={car.brand}
      />

      <div className="vehicle-info">

        <span className="category">

          {car.category}

        </span>

        <h2>

          {car.brand} {car.model}

        </h2>

        <p className="year">

          {car.year}

        </p>

        <div className="specs">

          <span>

            <FaGasPump />

            {car.fuelType}

          </span>

          <span>

            <FaCog />

            {car.transmission}

          </span>

        </div>

        <div className="specs">

          <span>

            <FaRoad />

            {car.mileage} km

          </span>

          <span>

            {car.color}

          </span>

        </div>

        <h3 className="price">

          ₹ {Number(car.price).toLocaleString()}

        </h3>

        <p>

          Quantity :
          <strong> {car.quantity}</strong>

        </p>

        <button

          className="purchase-btn"

          disabled={car.quantity === 0}

          onClick={() => onPurchase(car.id)}

        >

          {car.quantity === 0

            ? "Out of Stock"

            : "Purchase"}

        </button>

        <div className="admin-buttons">

          <button

            className="edit-btn"

            onClick={() => {
    onEdit(car);
            }}

          >

            <FaEdit />

          </button>

          <button

            className="delete-btn"

            onClick={() => onDelete(car.id)}

          >

            <FaTrash />

          </button>

        </div>

      </div>

    </div>

  );
}