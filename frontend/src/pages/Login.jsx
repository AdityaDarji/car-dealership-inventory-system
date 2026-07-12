import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthLayout from "../components/AuthLayout";
import { login } from "../services/authService";
import { toast } from "react-toastify";

export default function Login() {

    const navigate = useNavigate();

    const [form, setForm] = useState({
        email: "",
        password: ""
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

            const res = await login(form);

            localStorage.setItem("token", res.data.token);

            toast.success("Login Successful");

            navigate("/dashboard");

        } catch (err) {

            toast.error("Invalid email or password");

        }

    };

    return (

        <AuthLayout
            title="WELCOME BACK"
            subtitle="Login to manage your vehicles."
        >

            <form onSubmit={handleSubmit}>

                <input
                    className="auth-input"
                    name="email"
                    type="email"
                    placeholder="Email"
                    value={form.email}
                    onChange={handleChange}
                />

                <input
                    className="auth-input"
                    name="password"
                    type="password"
                    placeholder="Password"
                    value={form.password}
                    onChange={handleChange}
                />

                <button
                    type="submit"
                    className="auth-btn"
                >
                    LOGIN
                </button>

            </form>

            <div className="bottom-link">

                Don't have an account?

                <Link to="/register">

                    Register

                </Link>

            </div>

        </AuthLayout>

    );

}