import { motion } from "motion/react";
import SplineScene from "./SplineScene";

export default function Hero() {
  return (
    <div id="home" className="relative w-full h-screen overflow-hidden bg-gray-50">
      {/* Spline Background */}
      <div className="absolute inset-0 z-0">
        <SplineScene />
      </div>

      {/* Content Overlay */}
      <div className="absolute inset-0 z-10 flex flex-col justify-center items-center pointer-events-none">
        <motion.div
          initial={{ opacity: 0, y: 50 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8, delay: 0.5 }}
          className="text-center px-4"
        >
          <p className="mt-4 text-xl md:text-2xl font-light tracking-[0.2em] text-gray-800 uppercase bg-white/30 backdrop-blur-sm inline-block px-4 py-2 rounded-full">
            Creative Developer
          </p>
        </motion.div>
      </div>

      {/* Scroll Indicator */}
      <motion.div 
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ delay: 1.5, duration: 1 }}
        className="absolute bottom-10 left-1/2 -translate-x-1/2 z-10 cursor-pointer"
        onClick={() => document.getElementById('about')?.scrollIntoView({ behavior: 'smooth' })}
      >
        <div className="w-[1px] h-24 bg-gradient-to-b from-hot-pink to-transparent animate-pulse" />
      </motion.div>
    </div>
  );
}
