import "../pages/About.css";

const About = () => {
  return (
    <div className="about-container">

      <h1>
        About <span>Herbal Store</span>
      </h1>

      <p>
        Welcome to <strong className="highlight">Herbal Store</strong>, where nature meets purity.
        We believe in providing natural, toxin-free herbal solutions inspired by Ayurveda.  
      </p>

      <h2>🌿 Our Vision</h2>
      <p>
        To revive ancient herbal wisdom and make it accessible to every home — sustainably and affordably.
      </p>

      <h2>✨ What We Offer</h2>
      <ul className="about-list">
        <li>Organic & chemical-free herbal oils</li>
        <li>Natural skin and hair care wellness products</li>
        <li>Cold-pressed essential oils</li>
        <li>Products sourced directly from organic farms</li>
      </ul>

      <h2>🌱 Our Values</h2>
      <div className="about-cards">
        <div className="card-item">
          <img src="https://cdn-icons-png.flaticon.com/512/2903/2903604.png" alt="Natural" />
          <h3>100% Natural</h3>
          <p>We avoid preservatives, chemicals, and artificial fragrances.</p>
        </div>
        <div className="card-item">
          <img src="https://cdn-icons-png.flaticon.com/512/1053/1053103.png" alt="Quality" />
          <h3>Quality Tested</h3>
          <p>Every product is tested for purity, safety, and effectiveness.</p>
        </div>
        <div className="card-item">
          <img src="https://cdn-icons-png.flaticon.com/512/4286/4286895.png" alt="Eco Friendly" />
          <h3>Eco-friendly</h3>
          <p>Eco-friendly packaging, promoting sustainability.</p>
        </div>
      </div>

      <h2>🛡️ Trust & Transparency</h2>
      <p>
        You deserve products that are safe. We are transparent about our sourcing and production process.
        No hidden ingredients. No compromises.
      </p>

      <p className="closing-text">
        Thank you for trusting <strong>Herbal Store</strong>.  
        Your wellness journey starts here. 🍃
      </p>

    </div>
  );
};

export default About;
