import carImage from "../assets/car-bg.jpg";
import "../styles/auth.css";

export default function AuthLayout({
    title,
    subtitle,
    children,
}) {

    return (

        <div className="auth-container">

            <div className="auth-wrapper">
                <div className="auth-image">

                    <img src={carImage} alt="Car"/>

                    <div className="image-overlay"></div>

                </div>

                <div className="auth-right">

                <div className="glass-card">

                    <h1>{title}</h1>

                    <p>{subtitle}</p>

                    {children}

                </div>

            </div>
        </div>
        </div>

    );

}