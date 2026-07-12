import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthLayout from "../components/AuthLayout";
import { register } from "../services/authService";
import { toast } from "react-toastify";

export default function Register() {

    const navigate = useNavigate();

    const [form, setForm] = useState({

        name: "",

        email: "",

        password: "",

        role: "USER"

    });

    const handleChange = (e) => {

        setForm({

            ...form,

            [e.target.name]: e.target.value

        });

    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            await register(form);

            toast.success("Registration Successful");

            navigate("/");

        } catch {

            toast.error("Registration Failed");

        }

    };

    return (

        <AuthLayout

            title="CREATE ACCOUNT"

            subtitle="Join Bilal Garage."

        >

            <form onSubmit={handleSubmit}>

                <input

                    className="auth-input"

                    name="name"

                    placeholder="Name"

                    onChange={handleChange}

                />

                <input

                    className="auth-input"

                    name="email"

                    placeholder="Email"

                    onChange={handleChange}

                />

                <input

                    className="auth-input"

                    type="password"

                    name="password"

                    placeholder="Password"

                    onChange={handleChange}

                />

                <button

                    className="auth-btn"

                    type="submit"

                >

                    REGISTER

                </button>

            </form>

            <div className="bottom-link">

                Already have an account?

                <Link to="/">

                    Login

                </Link>

            </div>

        </AuthLayout>

    );

}