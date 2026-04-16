import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import Section from "./ui/Section";
import { Target, Shield, Zap, Terminal, ChevronRight, ChevronLeft } from "lucide-react";

/**
 * [MIG] About 컴포넌트 - 스토리 중심의 서사 개편
 * - 10년의 서비스업 경험과 개발자로서의 전환 서사 강조
 * - HR이 5초 안에 몰입할 수 있는 스토리라인 구성
 *
 * @author gayul.kim
 * @since 2026-04-17
 */
export default function About() {
  const slides = [
    {
      image: "/image/gemini.png",
      title: "",
      subtitle: ""
    },
    {
      image: "/image/golf.jpeg",
      title: "Golf",
      subtitle: "FOCUS & BALANCE"
    },
    {
      image: "/image/reading.jpeg",
      title: "Reading",
      subtitle: "DEEP THINKING"
    },
    {
      image: "/image/trip.jpeg",
      title: "Trip",
      subtitle: "NEW PERSPECTIVE"
    }
  ];

  const [currentSlide, setCurrentSlide] = useState(0);
  const [showText, setShowText] = useState(true);

  const triggerText = () => {
    setShowText(false);
    setTimeout(() => setShowText(true), 10);
  };

  const handleNext = () => {
    setCurrentSlide((prev) => (prev + 1) % slides.length);
    triggerText();
  };

  const handlePrev = () => {
    setCurrentSlide((prev) => (prev - 1 + slides.length) % slides.length);
    triggerText();
  };

  useEffect(() => {
    if (showText) {
      const timer = setTimeout(() => {
        setShowText(false);
      }, 2500); // 2.5초 후 텍스트 사라짐
      return () => clearTimeout(timer);
    }
  }, [showText, currentSlide]);

  return (
    <Section id="about" className="bg-tech-black border-y border-zinc-900" variant="full">
      <div className="max-w-[1200px] mx-auto">
        {/* Section Header */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">01. Profile Abstract</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter uppercase">ABOUT ME</h2>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-12 gap-6 items-stretch">

          {/* Row 1: Core Narrative & Transition Story (8 cols) */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="md:col-span-8 p-8 md:p-12 bg-tech-gray rounded-3xl border border-white/5 flex flex-col justify-center"
          >
            <div className="mb-8">
              <span className="mono text-[10px] text-neon-cyan uppercase tracking-[0.3em] block mb-3">Backend Engineer · Legacy Modernization</span>
              <h3 className="text-3xl md:text-5xl font-black text-white leading-tight tracking-tight">
                서비스업 10년, 개발자 2년. <br />두 세계를 연결하는 엔지니어링.
              </h3>
            </div>

            <div className="space-y-6 text-zinc-400 text-lg leading-relaxed max-w-[650px]">
              <p>
                서비스업에서 10년, 개발자로 2년. 두 세계를 연결하는 지점에서 가장 단단한 엔지니어링이 나온다고 믿습니다.
                고객을 응대하며 얻은 본질을 읽어내는 감각과 집요함을 이젠 코드에 담아내고 있습니다.
              </p>
              <p>
                현재 저는 <span className="text-white font-bold">Java 1.7과 Spring Framework 4</span> 레거시를 <span className="text-neon-cyan font-bold">Java 17, Spring Boot 3</span> 환경으로 전환하는 현대화 프로젝트의 주축을 맡고 있습니다.
                시스템을 무너뜨리지 않으면서 <span className="text-white font-bold">53개의 이슈를 단독 해결</span>하며, 낡은 코드를 안정적으로 교체해나가고 있습니다.
              </p>
              <p>
                단순 생산성을 넘어 <span className="text-white font-bold">Claude Code, Gemini</span> 등 다양한 AI 도구를 워크플로우에 통합해 비즈니스 설계 본질에 집중합니다. 10년 뒤 누군가가 읽을 코드를 생각하며 씁니다.
              </p>
            </div>
          </motion.div>

          {/* Row 1: Profile Image Carousel (4 cols) */}
          <motion.div
            initial={{ opacity: 0, scale: 0.95 }}
            whileInView={{ opacity: 1, scale: 1 }}
            viewport={{ once: true }}
            transition={{ delay: 0.1 }}
            className="md:col-span-4 relative bg-tech-gray rounded-3xl overflow-hidden border border-white/5 min-h-[300px] flex items-center justify-center group"
          >
            <AnimatePresence mode="wait">
              <motion.img
                key={currentSlide}
                src={slides[currentSlide].image}
                initial={{ opacity: 0, scale: 1.05 }}
                animate={{ opacity: 1, scale: 1 }}
                exit={{ opacity: 0 }}
                transition={{ duration: 0.8 }}
                alt={slides[currentSlide].title || "Profile Status"}
                className="absolute inset-0 w-full h-full object-cover transition-all duration-700"
              />
            </AnimatePresence>

            <div className="absolute inset-0 bg-gradient-to-t from-tech-black/90 via-transparent to-tech-black/30 pointer-events-none" />

            <AnimatePresence mode="wait">
              {showText && slides[currentSlide].title && (
                <motion.div
                  key={currentSlide + '-text'}
                  initial={{ opacity: 0, scale: 0.95, y: 10 }}
                  animate={{ opacity: 1, scale: 1, y: 0 }}
                  exit={{ opacity: 0, scale: 0.95, y: -10 }}
                  transition={{ duration: 0.5, ease: "easeOut" }}
                  className="relative z-10 flex flex-col items-center justify-center text-center px-8"
                >
                  <span className="text-4xl font-black text-white tracking-widest uppercase drop-shadow-[0_4px_12px_rgba(0,0,0,0.8)] mb-2">
                    {slides[currentSlide].title}
                  </span>
                  <span className="mono text-xs text-neon-cyan font-bold tracking-[0.3em] uppercase drop-shadow-[0_2px_4px_rgba(0,0,0,0.8)]">
                    {slides[currentSlide].subtitle}
                  </span>
                  <div className="w-12 h-0.5 bg-neon-cyan/50 mt-6 rounded-full shadow-[0_0_8px_#00F3FF]" />
                </motion.div>
              )}
            </AnimatePresence>

            {/* Navigation Arrows */}
            <button
              onClick={handlePrev}
              className="absolute left-4 top-1/2 -translate-y-1/2 w-12 h-12 flex items-center justify-center text-white transition-transform hover:scale-110 z-20 drop-shadow-md"
            >
              <ChevronLeft size={36} />
            </button>
            <button
              onClick={handleNext}
              className="absolute right-4 top-1/2 -translate-y-1/2 w-12 h-12 flex items-center justify-center text-white transition-transform hover:scale-110 z-20 drop-shadow-md"
            >
              <ChevronRight size={36} />
            </button>

            {/* Pagination Dots */}
            <div className="absolute bottom-6 left-0 right-0 flex justify-center gap-2 z-20">
              {slides.map((_, idx) => (
                <div
                  key={idx}
                  className={`h-1.5 rounded-full transition-all duration-500 cursor-pointer ${idx === currentSlide ? "bg-neon-cyan w-5 shadow-[0_0_8px_#00F3FF]" : "bg-white/50 w-1.5 hover:bg-white/80"}`}
                  onClick={() => {
                    setCurrentSlide(idx);
                    triggerText();
                  }}
                />
              ))}
            </div>
          </motion.div>

          {/* Row 2: Core Mindset (12 cols, Horizontal) */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: 0.2 }}
            className="md:col-span-12 p-8 bg-tech-gray rounded-3xl border border-white/5"
          >
            <span className="mono text-[10px] text-zinc-500 uppercase tracking-[0.3em] block mb-6 px-2 text-center md:text-left">Core Mindset</span>
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
              {[
                { label: "Persistence", desc: "끝까지 붙잡고 해결하는 집요함", icon: <Target className="text-neon-cyan" size={24} /> },
                { label: "Stability", desc: "무너뜨리지 않으면서 바꾸는 안정성", icon: <Shield className="text-neon-cyan" size={24} /> },
                { label: "Insight", desc: "말하지 않은 요구를 읽어내는 감각", icon: <Zap className="text-neon-cyan" size={24} /> },
              ].map((val, i) => (
                <div key={i} className="flex flex-col gap-4 p-6 rounded-2xl bg-black/20 border border-white/5 group hover:border-neon-cyan/20 transition-colors">
                  <div className="w-12 h-12 flex items-center justify-center rounded-xl bg-black/40 border border-white/5 group-hover:bg-neon-cyan/5 transition-colors">
                    {val.icon}
                  </div>
                  <div>
                    <h4 className="text-white font-bold uppercase tracking-widest text-sm mb-2">{val.label}</h4>
                    <p className="text-sm text-zinc-400 leading-relaxed font-medium">{val.desc}</p>
                  </div>
                </div>
              ))}
            </div>
          </motion.div>

        </div>
      </div>
    </Section>
  );
}
