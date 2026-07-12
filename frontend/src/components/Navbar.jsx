import { FaCarSide, FaSignOutAlt, FaPlus } from "react-icons/fa";

import { useNavigate } from "react-router-dom";
import { logout } from "../services/authService";

export default function Navbar() {

    const navigate = useNavigate();

    const handleLogout = () => {

    logout();

    navigate("/");

};
  return (
    <nav className="navbar-custom">

      <div className="logo">
        <FaCarSide />
        <span>Kata Car Inventory</span>
      </div>

      <div className="nav-links">

        <button className="nav-btn" onClick={()=>navigate("/add-car")}>
          <FaPlus />
          Add Vehicle
        </button>

        <button className="logout-btn" onClick={handleLogout}>
          <FaSignOutAlt />
          Logout
        </button>

      </div>

    </nav>
  );
}