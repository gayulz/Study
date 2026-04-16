/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import { useEffect, useRef } from "react";
import Header from "./components/Header";
import Hero from "./components/Hero";
import About from "./components/About";
import Projects from "./components/Projects";
import Experience from "./components/Experience";
import Learning from "./components/Learning";
import Writing from "./components/Writing";
import Contact from "./components/Contact";
import { NavigationProvider, useNavigation } from './contexts/NavigationContext';
import type { SectionName } from "./contexts/NavigationContext";

function MainContent() {
        const { setActiveSection } = useNavigation();
        const observer = useRef<IntersectionObserver | null>(null);

        useEffect(() => {
                // Intersection Observer 설정: 화면의 상단 1/3 지점을 지날 때 섹션 활성화
                observer.current = new IntersectionObserver((entries) => {
                        entries.forEach((entry) => {
                                if (entry.isIntersecting) {
                                        setActiveSection(entry.target.id as SectionName);
                                }
                        });
                }, {
                        // 화면 상단 30%와 하단 50%를 제외한 영역에 진입했을 때 감지
                        rootMargin: "-30% 0px -50% 0px",
                        threshold: 0
                });

                // 감시 대상 섹션들
                const sectionIds = ["home", "about", "projects", "experience", "learning", "writing", "contact"];
                sectionIds.forEach(id => {
                        const element = document.getElementById(id);
                        if (element) {
                                observer.current?.observe(element);
                        }
                });

                return () => observer.current?.disconnect();
        }, [setActiveSection]);

        return (
                <div className="min-h-screen bg-black text-white">
                        <Header />
                        <div className="lg:pl-64">
                                <main>
                                        <Hero />
                                        <About />
                                        <Projects />
                                        <Experience />
                                        <Learning />
                                        <Writing />
                                        <Contact />
                                </main>
                        </div>
                </div>
        );
}

export default function App() {
        return (
                <NavigationProvider>
                        <MainContent />
                </NavigationProvider>
        );
}
