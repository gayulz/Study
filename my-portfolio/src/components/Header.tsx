import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { Menu, X } from "lucide-react";
import { cn } from "../lib/utils";

const navItems = [
  { name: "Home", href: "#home" },
  { name: "About", href: "#about" },
  { name: "Projects", href: "#projects" },
  { name: "Experience", href: "#experience" },
  { name: "Education", href: "#education" },
  { name: "Certifications", href: "#certifications" },
  { name: "Writing", href: "#writing" },
  { name: "Contact", href: "#contact" },
];

export default function Header() {
  const [isOpen, setIsOpen] = useState(false);
  const [scrolled, setScrolled] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      setScrolled(window.scrollY > 50);
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <>
      {/* Desktop: Left Sidebar */}
      <aside className="hidden lg:flex fixed left-0 top-0 bottom-0 w-64 bg-[#0A0A0A]/95 backdrop-blur-md border-r border-gray-800 z-50 flex-col">
        <div className="p-8">
          <a href="#home" className="font-display text-3xl font-bold tracking-tighter hover:text-hot-pink transition-colors text-white block">
            GAYUL KIM
          </a>
        </div>

        <nav className="flex-1 px-8 py-4">
          <ul className="space-y-2">
            {navItems.map((item) => (
              <li key={item.name}>
                <a
                  href={item.href}
                  className="block py-3 text-sm font-medium uppercase tracking-wider hover:text-hot-pink hover:translate-x-2 transition-all text-white"
                >
                  {item.name}
                </a>
              </li>
            ))}
          </ul>
        </nav>
      </aside>

      {/* Mobile: Top Header */}
      <header
        className={cn(
          "fixed top-0 left-0 right-0 z-50 transition-all duration-300 lg:hidden",
          scrolled
            ? "bg-[#0A0A0A]/90 backdrop-blur-md py-4 shadow-sm"
            : "bg-transparent py-6"
        )}
      >
        <div className="max-w-[1200px] mx-auto px-4 sm:px-6">
          <div className="flex justify-between items-center">
            <a href="#home" className="font-display text-2xl font-bold tracking-tighter hover:text-hot-pink transition-colors text-white">
              GAYUL KIM
            </a>

            <button
              className="p-2 text-white hover:text-hot-pink transition-colors"
              onClick={() => setIsOpen(!isOpen)}
            >
              {isOpen ? <X size={24} /> : <Menu size={24} />}
            </button>
          </div>
        </div>

        {/* Mobile Nav Overlay */}
        <AnimatePresence>
          {isOpen && (
            <motion.div
              initial={{ opacity: 0, y: -20 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -20 }}
              className="absolute top-full left-0 right-0 bg-[#1E1E1E] shadow-lg border-t border-gray-800"
            >
              <nav className="flex flex-col p-6 space-y-4">
                {navItems.map((item) => (
                  <a
                    key={item.name}
                    href={item.href}
                    className="text-lg font-display uppercase hover:text-hot-pink transition-colors text-white"
                    onClick={() => setIsOpen(false)}
                  >
                    {item.name}
                  </a>
                ))}
              </nav>
            </motion.div>
          )}
        </AnimatePresence>
      </header>
    </>
  );
}
