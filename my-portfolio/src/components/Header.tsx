import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { Menu, X, Mail, Github, BookOpen } from "lucide-react";
import { cn } from "../lib/utils";
import { useNavigation } from "../contexts/NavigationContext";
import type { SectionName } from "../contexts/NavigationContext";

const navItems: Array<{ name: string; section: SectionName }> = [
	{ name: "Home", section: "home" },
	{ name: "About", section: "about" },
	{ name: "Skills", section: "skills" },
	{ name: "Projects", section: "projects" },
	{ name: "Experience", section: "experience" },
	{ name: "Learning", section: "learning" },
	{ name: "Writing", section: "writing" },
	{ name: "Contact", section: "contact" },
];

export default function Header() {
	const { activeSection } = useNavigation();
	const [isOpen, setIsOpen] = useState(false);
	const [scrolled, setScrolled] = useState(false);

	useEffect(() => {
		const handleScroll = () => {
			setScrolled(window.scrollY > 50);
		};
		window.addEventListener("scroll", handleScroll);
		return () => window.removeEventListener("scroll", handleScroll);
	}, []);

	const handleNavClick = (section: SectionName) => {
		const element = document.getElementById(section);
		if (element) {
			window.scrollTo({
				top: element.offsetTop,
				behavior: "smooth"
			});
		}
		setIsOpen(false);
	};

	return (
		<>
			{/* Desktop: Left Technical Sidebar */}
			<aside className="hidden lg:flex fixed left-0 top-0 bottom-0 w-64 bg-tech-black border-r border-white/5 z-50 flex-col">
				<div className="p-8 border-b border-white/5">
					<button onClick={() => handleNavClick('home')} className="font-black text-2xl tracking-tighter text-white">
						GAYUL<span className="text-neon-cyan">.</span>
					</button>
				</div>

				<nav className="flex-1 px-6 py-12">
					<ul className="space-y-1">
						{navItems.map((item, i) => (
							<li key={item.name}>
								<button
									onClick={() => handleNavClick(item.section)}
									className={cn(
										"group relative flex items-center gap-4 py-3 px-4 w-full text-left transition-all duration-300 rounded-xl",
										activeSection === item.section 
											? "bg-white/5 text-white" 
											: "text-zinc-500 hover:text-zinc-200 hover:bg-white/[0.02]"
									)}
								>
									<span className="mono text-[10px] opacity-30 group-hover:opacity-100 transition-opacity">0{i + 1}</span>
									<span className="text-xs font-bold uppercase tracking-widest">{item.name}</span>
									
									{activeSection === item.section && (
										<motion.div 
											layoutId="activeGlow"
											className="absolute right-0 w-1 h-4 bg-neon-cyan shadow-[0_0_10px_#00F3FF] rounded-l-full"
										/>
									)}
								</button>
							</li>
						))}
					</ul>
				</nav>

				<div className="p-8 border-t border-white/5 bg-black/20">
					<div className="flex justify-between items-center mb-6">
						<a href="https://github.com/gayulz" target="_blank" rel="noopener noreferrer" className="text-zinc-500 hover:text-neon-cyan transition-colors">
							<Github size={18} />
						</a>
						<a href="https://yurizzy.tistory.com/" target="_blank" rel="noopener noreferrer" className="text-zinc-500 hover:text-neon-cyan transition-colors">
							<BookOpen size={18} />
						</a>
						<button onClick={() => handleNavClick('contact')} className="text-zinc-500 hover:text-neon-cyan transition-colors">
							<Mail size={18} />
						</button>
					</div>
					<p className="mono text-[8px] text-zinc-600 uppercase tracking-[0.2em] text-center">
						System v4.16 © 2026
					</p>
				</div>
			</aside>

			{/* Mobile Header */}
			<header className={cn(
				"fixed top-0 left-0 right-0 z-50 transition-all duration-500 lg:hidden",
				scrolled ? "bg-tech-black/90 backdrop-blur-xl border-b border-white/5 py-4" : "bg-transparent py-6"
			)}>
				<div className="px-6 flex justify-between items-center">
					<button onClick={() => handleNavClick('home')} className="font-black text-xl tracking-tighter text-white">
						GAYUL<span className="text-neon-cyan">.</span>
					</button>
					<button onClick={() => setIsOpen(!isOpen)} className="text-white p-2">
						{isOpen ? <X size={24} /> : <Menu size={24} />}
					</button>
				</div>

				<AnimatePresence>
					{isOpen && (
						<motion.div
							initial={{ opacity: 0, height: 0 }}
							animate={{ opacity: 1, height: 'auto' }}
							exit={{ opacity: 0, height: 0 }}
							className="bg-tech-black border-b border-white/5 overflow-hidden"
						>
							<nav className="p-8 flex flex-col gap-6">
								{navItems.map((item) => (
									<button
										key={item.name}
										onClick={() => handleNavClick(item.section)}
										className={cn(
											"text-2xl font-black uppercase tracking-tighter text-left transition-colors",
											activeSection === item.section ? "text-neon-cyan" : "text-zinc-500"
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
