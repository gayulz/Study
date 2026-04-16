import { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { ChevronDown } from "lucide-react";
import InteractiveScene from "./InteractiveScene";

/**
 * [MIG] Hero 컴포넌트 고도화
 * - 스크롤 인디케이터 스타일 수정 (발광 효과 추가)
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
export default function Hero() {
  const [isVisible, setIsVisible] = useState(true);

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 50) {
        setIsVisible(false);
      } else {
        setIsVisible(true);
      }
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <div
      id="home"
      className="relative w-full h-screen overflow-hidden bg-gradient-to-br from-[#0A0A0A] to-[#050505]"
    >
      {/* Three.js 3D Background */}
      <div className="absolute inset-0 z-0">
        <InteractiveScene />
      </div>

      {/* Main Content */}
      <div className="absolute inset-0 z-10 flex flex-col justify-center items-center pointer-events-none">
        <motion.div
          initial={{ opacity: 0, y: 50 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8, delay: 0.3 }}
          className="text-center px-4 flex flex-col items-center"
        >
          <motion.h1
            className="text-6xl md:text-9xl font-black text-white mb-6"
            style={{
              textShadow: '0 0 40px rgba(255,255,255,0.9), 0 0 80px rgba(255,255,255,0.6)',
            }}
            animate={{
              textShadow: [
                '0 0 40px rgba(255,255,255,0.9), 0 0 80px rgba(255,255,255,0.6)',
                '0 0 60px rgba(255,255,255,1), 0 0 120px rgba(255,255,255,0.8)',
                '0 0 40px rgba(255,255,255,0.9), 0 0 80px rgba(255,255,255,0.6)',
              ],
            }}
            transition={{
              duration: 3,
              repeat: Infinity,
              ease: "easeInOut",
            }}
          >
            kimgayul
          </motion.h1>
          <motion.p
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ delay: 0.6 }}
            className="text-xl md:text-2xl font-light tracking-[0.2em] text-white uppercase mb-12"
            style={{
              textShadow: '0 0 20px rgba(255,255,255,0.5)',
            }}
          >
            Backend Developer | Java | Spring
          </motion.p>

          {/* Scroll Down Indicator */}
          <AnimatePresence>
            {isVisible && (
              <motion.div 
                initial={{ opacity: 0, y: 10 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0, y: 20 }}
                transition={{ delay: 1.2, duration: 0.8 }}
                className="flex flex-col items-center gap-4 mt-8"
              >
                <span 
                  className="text-sm md:text-lg font-bold uppercase tracking-[0.4em] text-white"
                  style={{
                    textShadow: '0 0 10px rgba(255,255,255,0.8), 0 0 20px rgba(255,0,127,0.4)',
                  }}
                >
                  Scroll Down
                </span>
                <motion.div
                  animate={{ y: [0, 12, 0] }}
                  transition={{ duration: 2, repeat: Infinity, ease: "easeInOut" }}
                >
                  <ChevronDown size={48} strokeWidth={1.5} className="text-white drop-shadow-[0_0_10px_rgba(255,0,127,0.8)]" />
                </motion.div>
              </motion.div>
            )}
          </AnimatePresence>
        </motion.div>
      </div>

    </div>
  );
}
