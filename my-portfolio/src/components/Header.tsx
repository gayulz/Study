import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { Menu, X, Mail, Github, BookOpen } from "lucide-react";
import { cn } from "../lib/utils";
import { useNavigation } from "../contexts/NavigationContext";
import type { SectionName } from "../contexts/NavigationContext";

const navItems: Array<{ name: string; section: SectionName }> = [
	{ name: "Home", section: "home" },
	{ name: "About", section: "about" },
	{ name: "Projects", section: "projects" },
	{ name: "Experience", section: "experience" },
	{ name: "Education", section: "education" },
	{ name: "Certifications", section: "certifications" },
	{ name: "Writing", section: "writing" },
	{ name: "Contact", section: "contact" },
];

export default function Header() {
	const { setActiveSection } = useNavigation();
	const [isOpen, setIsOpen] = useState(false);
	const [scrolled, setScrolled] = useState(false);

	useEffect(() => {
		const handleScroll = () => {
			setScrolled(window.scrollY > 50);
		};
		window.addEventListener("scroll", handleScroll);
		return () => window.removeEventListener("scroll", handleScroll);
	}, []);

	// 섹션 이동 핸들러
	const handleNavClick = (section: SectionName) => {
		setActiveSection(section);
		setIsOpen(false); // 모바일 메뉴 닫기
	};

  return (
    <>
      {/* Desktop: Left Sidebar */}
		<aside className="hidden lg:flex fixed left-0 top-0 bottom-0 w-64 bg-[#0A0A0A]/95 backdrop-blur-md z-50 flex-col">
			<nav className="flex-1 px-8 py-12">
				<ul className="space-y-4">
					{navItems.map((item) => (
						<li key={item.name}>
							<button
								onClick={() => handleNavClick(item.section)}
								className="block py-2 text-base font-medium uppercase tracking-wider hover:text-hot-pink hover:translate-x-2 hover:scale-110 transition-all text-white w-full text-left"
							>
								{item.name}
							</button>
						</li>
					))}
				</ul>
			</nav>

			{/* 하단 고정: 소셜 링킹 및 저작권 (미니멀/고급스러운 스타일) */}
			<div className="p-8 border-t border-gray-800/30 bg-[#0A0A0A]">
				<div className="flex justify-between items-center mb-6">
					<button
						onClick={() => handleNavClick('contact')}
						className="text-gray-500 hover:text-hot-pink transition-colors group relative"
						aria-label="Contact"
					>
						<Mail size={18} className="group-hover:-translate-y-1 transition-transform" />
					</button>
					<a
						href="https://github.com/gayulz"
						target="_blank"
						rel="noopener noreferrer"
						className="text-gray-500 hover:text-white transition-colors group relative"
						aria-label="GitHub"
					>
						<Github size={18} className="group-hover:-translate-y-1 transition-transform" />
					</a>
					<a
						href="https://yurizzy.tistory.com/"
						target="_blank"
						rel="noopener noreferrer"
						className="text-gray-500 hover:text-white transition-colors group relative"
						aria-label="Blog"
					>
						<BookOpen size={18} className="group-hover:-translate-y-1 transition-transform" />
					</a>
				</div>
				<p className="text-[10px] text-gray-600 font-mono tracking-widest uppercase text-center">
					© {new Date().getFullYear()} gayul.kim
				</p>
			</div>
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
            <button onClick={() => handleNavClick('home')} className="font-display text-2xl font-bold tracking-tighter hover:text-hot-pink transition-colors text-white">
              GAYUL KIM
            </button>

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
                  <button
                    key={item.name}
                    onClick={() => handleNavClick(item.section)}
                    className="text-lg font-display uppercase hover:text-hot-pink transition-colors text-white text-left"
                  >
                    {item.name}
                  </button>
                ))}
              </nav>
            </motion.div>
          )}
        </AnimatePresence>
      </header>
    </>
  );
}
