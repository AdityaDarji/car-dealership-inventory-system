import hero from "../assets/car-bg.jpg";

export default function Hero() {

    return (

        <div
            className="hero"
            style={{
                backgroundImage: `url(${hero})`
            }}
        >

            <div className="hero-overlay">

                <h1>Drive The Extraordinary</h1>

                <p>
                    Premium cars. Premium experience.
                </p>

                <button>
                    Browse Inventory
                </button>

            </div>

        </div>

    );

}