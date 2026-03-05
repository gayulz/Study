import { motion } from "motion/react";
import Section from "./ui/Section";

const articles = [
  { title: "Abstract concept in design", date: "May 28, 2025", category: "DESIGN" },
  { title: "Our illustration process", date: "May 20, 2025", category: "ART" },
  { title: "Animation in web design", date: "Apr 14, 2025", category: "DESIGN" },
  { title: "Color theory in design", date: "Mar 12, 2025", category: "DESIGN" },
  { title: "Sandwiches and lemon juice", date: "Feb 20, 2025", category: "FOOD" },
];

export default function Writing() {
  return (
    <Section id="writing" className="bg-gray-50">
      <motion.h2 
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        WRITING
      </motion.h2>

      <div className="space-y-0">
        {articles.map((article, index) => (
          <motion.div 
            key={index}
            initial={{ opacity: 0, x: -20 }}
            whileInView={{ opacity: 1, x: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.05 }}
            className="group flex flex-col md:flex-row justify-between items-start md:items-center py-8 border-b border-gray-200 hover:bg-white hover:px-4 transition-all duration-300 cursor-pointer"
          >
            <h3 className="text-xl md:text-2xl font-medium group-hover:text-hot-pink transition-colors">
              {article.title}
            </h3>
            <div className="flex items-center space-x-8 mt-2 md:mt-0">
              <span className="text-sm text-gray-400 font-mono">{article.date}</span>
              <span className="text-xs font-bold uppercase tracking-widest text-hot-pink border border-hot-pink px-2 py-1 rounded-full">
                {article.category}
              </span>
            </div>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
