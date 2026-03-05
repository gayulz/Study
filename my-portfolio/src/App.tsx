/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import Header from "./components/Header";
import Hero from "./components/Hero";
import About from "./components/About";
import Projects from "./components/Projects";
import Experience from "./components/Experience";
import Education from "./components/Education";
import Writing from "./components/Writing";
import Contact from "./components/Contact";

export default function App() {
  return (
    <div className="min-h-screen bg-white text-gray-900 selection:bg-hot-pink selection:text-white">
      <Header />
      <main>
        <Hero />
        <About />
        <Projects />
        <Experience />
        <Education />
        <Writing />
        <Contact />
      </main>
      
      <footer className="bg-black text-white py-12 text-center">
        <div className="max-w-7xl mx-auto px-4">
          <p className="font-display text-2xl mb-4">VILLO</p>
          <p className="text-gray-500 text-sm">
            &copy; {new Date().getFullYear()} Villo Portfolio. All rights reserved.
          </p>
        </div>
      </footer>
    </div>
  );
}
