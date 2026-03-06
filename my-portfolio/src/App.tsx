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
import Certifications from "./components/Certifications";
import Writing from "./components/Writing";
import Contact from "./components/Contact";

export default function App() {
  return (
    <div className="min-h-screen bg-[#0A0A0A] text-white selection:bg-hot-pink selection:text-white">
      <Header />
      <div className="lg:pl-64">
        <main>
          <Hero />
          <About />
          <Projects />
          <Experience />
          <Education />
          <Certifications />
          <Writing />
          <Contact />
        </main>

        <footer className="bg-[#050505] text-white py-12 text-center border-t border-gray-900">
          <div className="max-w-[1200px] mx-auto px-4">
            <p className="font-display text-2xl mb-4">GAYUL KIM</p>
            <p className="text-gray-600 text-sm">
              &copy; {new Date().getFullYear()} Gayul Kim Portfolio. All rights reserved.
            </p>
          </div>
        </footer>
      </div>
    </div>
  );
}
