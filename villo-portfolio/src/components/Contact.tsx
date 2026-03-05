import { motion } from "motion/react";
import Section from "./ui/Section";
import { Send } from "lucide-react";

export default function Contact() {
  return (
    <Section id="contact" className="bg-white mb-20">
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
          <h3 className="text-3xl font-bold mb-6">Looking to start a project or you need consultation? Feel free to contact me.</h3>
          <div className="space-y-2 text-lg text-gray-600">
            <p>San Francisco, CA, USA</p>
            <a href="mailto:lucas@email.com" className="block text-hot-pink hover:underline">lucas@email.com</a>
            <a href="https://www.cocobasic.com" className="block text-hot-pink hover:underline">www.cocobasic.com</a>
          </div>
        </div>

        <form className="space-y-6">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <input 
              type="text" 
              placeholder="Jane Smith" 
              className="w-full bg-gray-50 border border-gray-200 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all"
            />
            <input 
              type="email" 
              placeholder="jane@framer.com" 
              className="w-full bg-gray-50 border border-gray-200 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all"
            />
          </div>
          <textarea 
            placeholder="Message..." 
            rows={6}
            className="w-full bg-gray-50 border border-gray-200 p-4 rounded-lg focus:outline-none focus:border-hot-pink focus:ring-1 focus:ring-hot-pink transition-all resize-none"
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
    </Section>
  );
}
