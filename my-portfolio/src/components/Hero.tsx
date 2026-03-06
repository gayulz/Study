import { motion } from "motion/react";
import InteractiveScene from "./InteractiveScene";

export default function Hero() {
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
          className="text-center px-4"
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
            className="text-xl md:text-2xl font-light tracking-[0.2em] text-white uppercase"
            style={{
              textShadow: '0 0 20px rgba(255,255,255,0.5)',
            }}
          >
            Backend Developer | Java | Spring
          </motion.p>
        </motion.div>
      </div>

      {/* Scroll Indicator */}
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ delay: 1.5, duration: 1 }}
        className="absolute bottom-10 left-1/2 -translate-x-1/2 z-10 cursor-pointer pointer-events-auto"
        onClick={() => document.getElementById('about')?.scrollIntoView({ behavior: 'smooth' })}
      >
        <motion.div
          className="w-[1px] h-24 bg-gradient-to-b from-hot-pink to-transparent"
          animate={{
            opacity: [0.5, 1, 0.5],
            scaleY: [1, 1.2, 1],
          }}
          transition={{
            duration: 2,
            repeat: Infinity,
            ease: "easeInOut",
          }}
        />
      </motion.div>
    </div>
  );
}
