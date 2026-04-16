import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { ChevronDown } from "lucide-react";
import InteractiveScene from "./InteractiveScene";

/**
 * [MIG] Hero 컴포넌트 - oryzo.ai 테크니컬 스타일 반영
 * - 극강의 미니멀리즘과 엔지니어링 스펙 시각화
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
export default function Hero() {
  const [isVisible, setIsVisible] = useState(true);

  useEffect(() => {
    const handleScroll = () => {
      setIsVisible(window.scrollY < 100);
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <div id="home" className="relative w-full h-screen overflow-hidden bg-tech-black">
      {/* Background Layer */}
      <div className="absolute inset-0 z-0 opacity-40">
        <InteractiveScene />
      </div>

      {/* Grid Pattern Overlay */}
      <div className="absolute inset-0 z-1 pointer-events-none opacity-10"
        style={{ backgroundImage: 'radial-gradient(circle, #333 1px, transparent 1px)', backgroundSize: '40px 40px' }} />

      {/* Main Content */}
      <div className="absolute inset-0 z-10 flex flex-col justify-center items-center pointer-events-none px-6">
        <div className="w-full max-w-[1400px] flex flex-col items-center">

          {/* Header Spec Tag */}
          <motion.div
            initial={{ opacity: 0, y: -20 }}
            animate={{ opacity: 1, y: 0 }}
            className="mono text-[10px] uppercase tracking-[0.5em] text-neon-cyan mb-12 border border-neon-cyan/30 px-4 py-1.5 rounded-full"
          >
            System Status: Optimized
          </motion.div>

          {/* Name Title */}
          <motion.h1
            initial={{ opacity: 0, scale: 0.95 }}
            animate={{ opacity: 1, scale: 1 }}
            transition={{ duration: 1, ease: [0.16, 1, 0.3, 1] }}
            className="text-7xl md:text-[12rem] font-black text-white leading-none tracking-tighter text-center"
          >
            KIMGAYUL<span className="text-neon-cyan">.</span>
          </motion.h1>

          {/* Subtitle / Spec List */}
          <div className="mt-12 flex flex-col md:flex-row gap-8 md:gap-24 items-center">
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              transition={{ delay: 0.5 }}
              className="flex flex-col items-start gap-1"
            >
              <span className="mono text-[10px] text-zinc-500 uppercase tracking-widest">Primary Role</span>
              <span className="text-xl md:text-2xl font-bold text-zinc-200">Backend Engineer</span>
            </motion.div>

            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              transition={{ delay: 0.7 }}
              className="flex flex-col items-start gap-1"
            >
              <span className="mono text-[10px] text-zinc-500 uppercase tracking-widest">Tech Stack</span>
              <span className="text-xl md:text-2xl font-bold text-zinc-200 uppercase">Java · Spring · AI</span>
            </motion.div>

            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              transition={{ delay: 0.9 }}
              className="flex flex-col items-start gap-1"
            >
              <span className="mono text-[10px] text-zinc-500 uppercase tracking-widest">Location</span>
              <span className="text-xl md:text-2xl font-bold text-zinc-200 uppercase">SUWON, KR</span>
            </motion.div>
          </div>
        </div>
      </div>

      {/* Scroll Down Guide */}
      <AnimatePresence>
        {isVisible && (
          <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0 }}
            className="absolute bottom-12 left-1/2 -translate-x-1/2 flex flex-col items-center gap-4 cursor-pointer z-20"
            onClick={() => window.scrollTo({ top: window.innerHeight, behavior: 'smooth' })}
          >
            <span className="mono text-[10px] uppercase tracking-[0.4em] text-zinc-500">Scroll to Explore</span>
            <motion.div
              animate={{ y: [0, 10, 0] }}
              transition={{ duration: 2, repeat: Infinity }}
            >
              <ChevronDown size={24} className="text-neon-cyan" strokeWidth={1} />
            </motion.div>
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
}
