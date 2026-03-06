import { motion } from "motion/react";
import { Send } from "lucide-react";

export default function Contact() {
  return (
    <section id="contact" className="w-full px-4 sm:px-6 lg:px-12 py-24 md:py-40 mb-20 border-t border-gray-200 dark:border-gray-800">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        CONTACT
      </motion.h2>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-16">
        <div>
          <h3 className="text-3xl font-bold mb-6 dark:text-white">프로젝트 협업이나 개발 관련 문의가 있으시면 언제든지 연락 주세요.</h3>
          <div className="space-y-2 text-lg text-gray-600 dark:text-gray-400">
            <p>Backend Developer | Java & Spring</p>
            <a href="mailto:gayulz@kakao.com" className="block text-hot-pink hover:underline">gayulz@kakao.com</a>
            <a href="https://github.com/gayulz" target="_blank" rel="noopener noreferrer" className="block text-hot-pink hover:underline">github.com/gayulz</a>
            <a href="https://yurizzy.tistory.com/" target="_blank" rel="noopener noreferrer" className="block text-hot-pink hover:underline">yurizzy.tistory.com</a>
          </div>
        </div>

        <form className="space-y-6">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <input
              type="text"
              placeholder="Jane Smith"
              className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all dark:text-white"
            />
            <input
              type="email"
              placeholder="jane@framer.com"
              className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all dark:text-white"
            />
          </div>
          <textarea
            placeholder="Message..."
            rows={6}
            className="w-full bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all resize-none dark:text-white"
          />
          <button
            type="button"
            className="w-full bg-hot-pink text-white font-bold uppercase tracking-widest py-4 rounded-lg hover:bg-hot-pink-hover transition-colors flex items-center justify-center space-x-2"
          >
            <span>Send Message</span>
            <Send size={18} />
          </button>
        </form>
      </div>
    </section>
  );
}
