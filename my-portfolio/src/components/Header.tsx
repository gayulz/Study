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
	{ name: "Learning", section: "learning" },
	{ name: "Writing", section: "writing" },
	{ name: "Contact", section: "contact" },];

export default function Header() {
	const { activeSection, setActiveSection } = useNavigation();
	const [isOpen, setIsOpen] = useState(false);
	const [scrolled, setScrolled] = useState(false);

	useEffect(() => {
		const handleScroll = () => {
			setScrolled(window.scrollY > 50);
		};
		window.addEventListener("scroll", handleScroll);
		return () => window.removeEventListener("scroll", handleScroll);
	}, []);

	// 섹션 이동 핸들러: 부드러운 스크롤 적용
	const handleNavClick = (section: SectionName) => {
		const element = document.getElementById(section);
		if (element) {
			const offset = 0; // 필요 시 오프셋 조절
			const bodyRect = document.body.getBoundingClientRect().top;
			const elementRect = element.getBoundingClientRect().top;
			const elementPosition = elementRect - bodyRect;
			const offsetPosition = elementPosition - offset;

			window.scrollTo({
				top: offsetPosition,
				behavior: "smooth"
			});
		}
		setIsOpen(false); // 모바일 메뉴 닫기
	};

  return (
    <>
      {/* Desktop: Left Sidebar */}
		<aside className="hidden lg:flex fixed left-0 top-0 bottom-0 w-64 bg-[#0A0A0A]/95 backdrop-blur-md z-50 flex-col border-r border-gray-800/30">
			<nav className="flex-1 px-8 py-12">
				<ul className="space-y-2">
					{navItems.map((item) => (
						<li key={item.name}>
							<button
								onClick={() => handleNavClick(item.section)}
								className={cn(
									"group relative block py-3 text-sm font-bold uppercase tracking-widest transition-all w-full text-left",
									activeSection === item.section 
										? "text-hot-pink translate-x-2" 
										: "text-gray-500 hover:text-white hover:translate-x-1"
								)}
							>
								{/* 활성화 상태 인디케이터 (Dot) */}
								{activeSection === item.section && (
									<motion.span 
										layoutId="activeDot"
										className="absolute left-[-16px] top-1/2 -translate-y-1/2 w-1.5 h-1.5 rounded-full bg-hot-pink shadow-[0_0_10px_#ff69b4]"
									/>
								)}
								{item.name}
							</button>
						</li>
					))}
				</ul>
			</nav>

			{/* 하단 고정: 소셜 링킹 및 저작권 */}
			<div className="p-8 border-t border-gray-800/30 bg-[#0A0A0A]">
				<div className="flex justify-between items-center mb-6">
					<button
						onClick={() => handleNavClick('contact')}
						className={cn(
							"transition-colors group relative",
							activeSection === 'contact' ? "text-hot-pink" : "text-gray-500 hover:text-white"
						)}
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
            ? "bg-[#0A0A0A]/90 backdrop-blur-md py-4 shadow-sm border-b border-gray-800/50"
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
              className="absolute top-full left-0 right-0 bg-[#0A0A0A] shadow-2xl border-t border-gray-800"
            >
              <nav className="flex flex-col p-8 space-y-6">
                {navItems.map((item) => (
                  <button
                    key={item.name}
                    onClick={() => handleNavClick(item.section)}
                    className={cn(
						"text-xl font-display uppercase tracking-widest transition-colors text-left",
						activeSection === item.section ? "text-hot-pink font-black" : "text-gray-400"
					)}
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
