/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import { motion, AnimatePresence } from "motion/react";
import Header from "./components/Header";
import Hero from "./components/Hero";
import About from "./components/About";
import Projects from "./components/Projects";
import Experience from "./components/Experience";
import Education from "./components/Education";
import Certifications from "./components/Certifications";
import Writing from "./components/Writing";
import Contact from "./components/Contact";
import Footer from "./components/Footer";
import { NavigationProvider, useNavigation } from './contexts/NavigationContext';

// 메인 컨텐츠를 별도 컴포넌트로 분리 (Provider 내부에서 useNavigation 사용)
function MainContent() {
	const { activeSection } = useNavigation();

	// 현재 섹션에 맞는 컴포넌트 렌더링
	const renderSection = () => {
		switch (activeSection) {
			case 'home': return <Hero />;
			case 'about': return <About />;
			case 'projects': return <Projects />;
			case 'experience': return <Experience />;
			case 'education': return <Education />;
			case 'certifications': return <Certifications />;
			case 'writing': return <Writing />;
			case 'contact': return <Contact />;
			default: return <Hero />;
		}
	};

	return (
		<div className="min-h-screen bg-[#0A0A0A] text-white selection:bg-hot-pink selection:text-white">
			<Header />
			<div className="lg:pl-64">
				<main>
					{/* AnimatePresence로 섹션 전환 애니메이션 적용 */}
					<AnimatePresence mode="wait">
						<motion.div
							key={activeSection}
							initial={{ opacity: 0, y: 20 }}
							animate={{ opacity: 1, y: 0 }}
							exit={{ opacity: 0, y: -20 }}
							transition={{ duration: 0.4, ease: 'easeInOut' }}
						>
							{renderSection()}
						</motion.div>
					</AnimatePresence>
				</main>
			</div>

			{/* Footer는 일반 플로우에 포함되며, 좌측 네비게이션 영역까지 확장 (left-0부터 시작) */}
			<Footer />
		</div>
	);
}

// NavigationProvider로 앱 래핑
export default function App() {
	return (
		<NavigationProvider>
			<MainContent />
		</NavigationProvider>
	);
}
