import { BrowserRouter, Routes, Route } from "react-router-dom";

import PrivateRoute from "./components/PrivateRoute";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import AddCar from "./pages/AddCar";
import EditCar from "./pages/EditCar";

function App() {

    return (

        <BrowserRouter>

            <Routes>

                <Route
                    path="/"
                    element={<Login />}
                />

                <Route
                    path="/register"
                    element={<Register />}
                />

                <Route
                    path="/dashboard"
                    element={
                        <PrivateRoute>
                            <Dashboard />
                        </PrivateRoute>
                    }
                />

                <Route
                    path="/add-car"
                    element={
                        <PrivateRoute>
                            <AddCar />
                        </PrivateRoute>
                    }
                />

                <Route
                    path="/edit-car/:id"
                    element={
                        <PrivateRoute>
                            <EditCar />
                        </PrivateRoute>
                    }
                />

            </Routes>

        </BrowserRouter>

    );

}

export default App;