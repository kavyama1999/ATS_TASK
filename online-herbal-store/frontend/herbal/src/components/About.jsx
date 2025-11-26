import React from "react";
import "../pages/About.css";
import familyImg from "../assets/herbalfamily.jpg";


const About = () => {
  return (
    <div className="about-wrapper">

      {/* HERO SECTION */}
      <section className="about-hero">
        <div className="hero-content">
          <h1>
            Discover the Power of <span>Natural Healing</span>
          </h1>
          <p>
            Your trusted destination for Ayurvedic, organic and toxin-free herbal wellness.
          </p>
        </div>

        {/* SOAP IMAGE ADDED HERE */}
        {/* <img
          className="hero-right-img"
          src="C:\Users\Admin\Pictures\herbalfamily.jpg"
          alt="Herbal Soaps"
        /> */}
        <img
          className="hero-right-img"
          src={familyImg}         // <-- use imported image
          alt="Herbal Family"
        />
      </section>

      {/* WHO WE ARE */}
      <section className="about-section fade-in">
        <h2>🌿 Who We Are</h2>
        <p>
          Herbal Store is an online Ayurvedic marketplace offering pure,
          authentic, and chemical-free wellness products.
          We combine traditional herbal knowledge with modern scientific quality
          to bring you safe and natural solutions.
        </p>
      </section>

      {/* WHY CHOOSE US */}
      <section className="about-features fade-in">
        <h2>✨ Why Choose Herbal Store?</h2>

        <div className="feature-grid">
          <div className="feature-item">
            <img src="https://cdn-icons-png.flaticon.com/512/8097/8097774.png" />
            <h3>100% Organic Ingredients</h3>
            <p>All herbs are sourced from certified organic farms.</p>
          </div>

          <div className="feature-item">
            <img src="https://cdn-icons-png.flaticon.com/512/990/990631.png" />
            <h3>No Chemicals • No Toxins</h3>
            <p>Free from parabens, sulfates, and synthetic perfume.</p>
          </div>

          <div className="feature-item">
            <img src="https://cdn-icons-png.flaticon.com/512/3209/3209265.png" />
            <h3>Ayurvedic Formulations</h3>
            <p>Inspired by ancient Ayurvedic wisdom.</p>
          </div>

          <div className="feature-item">
            <img src="https://cdn-icons-png.flaticon.com/512/2436/2436702.png" />
            <h3>Lab Tested Quality</h3>
            <p>Each batch goes through safety and purity testing.</p>
          </div>
        </div>
      </section>

      {/* OUR STORY */}
      <section className="about-section fade-in">
        <h2>📜 Our Story</h2>
        <p>
          Started with a simple belief — health begins with nature.
          Our founders traveled across India exploring herbal forests,
          Ayurveda centers, and organic farms to collect the purest ingredients.
        </p>

        <p>
          Today, Herbal Store has become a trusted brand with thousands
          of happy customers seeking natural, safe, and pure wellness solutions.
        </p>
      </section>

      {/* SPECIAL PRODUCTS */}
      <section className="specialization fade-in">
        <h2>🌱 What Makes Our Products Special?</h2>

        <div className="spec-cards">

          {/* SOAP CARD ADDED */}
          <div className="spec-item">
            <img src="https://blossomsandextracts.com/cdn/shop/files/1-1-13_199172bd-b0a5-4799-a151-8ca1600f7399.jpg?v=1747278291" />
            <h3>Herbal Bathing Soaps</h3>
            <p>Natural soaps made using pure Ayurvedic herbs.</p>
          </div>

          <div className="spec-item">
            <img src="https://satopradhan.com/cdn/shop/articles/9_691d8038-b087-4285-a934-dfb3cca75fbc.jpg?v=1749376230" />
            <h3>Cold-Pressed Oils</h3>
            <p>Nutrient-rich oils for skin and hair health.</p>
          </div>

          <div className="spec-item">
            <img src="https://cdn.dotpe.in/longtail/store-items/5739802/V5NS1pHm.webp" />
            <h3>Natural Herbal Powders</h3>
            <p>Freshly ground herbs for daily wellness.</p>
          </div>
        </div>
      </section>

      {/* MISSION */}
      <section className="about-section fade-in">
        <h2>🛡️ Our Mission</h2>
        <p>
          To promote a healthier India by offering safe, natural,
          and affordable herbal products.
        </p>
      </section>

      {/* TRUST */}
      <section className="trust-section fade-in">
        <h2>🔒 Trust & Transparency</h2>

        <div className="trust-grid">
          <div className="trust-item">
            <img src="https://cdn-icons-png.flaticon.com/512/1828/1828640.png" />
            <h3>100% Authentic</h3>
          </div>

          <div className="trust-item">
            <img src="https://cdn-icons-png.flaticon.com/512/929/929610.png" />
            <h3>Secure Packaging</h3>
          </div>

          <div className="trust-item">
            <img src="https://cdn-icons-png.flaticon.com/512/992/992700.png" />
            <h3>Fast Delivery</h3>
          </div>
        </div>
      </section>

      {/* THANK YOU */}
      <section className="thank-section fade-in">
        <h2>💚 Thank You for Trusting Herbal Store</h2>
        <p>Join us in embracing the purity of nature.</p>
      </section>

    </div>
  );
};

export default About;
