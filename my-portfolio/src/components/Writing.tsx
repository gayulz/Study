import { motion } from "motion/react";
import Section from "./ui/Section";

const articles = [
  {
    title: "Spring Boot 마이그레이션 경험기",
    date: "2025.03",
    category: "BACKEND",
    url: "https://yurizzy.tistory.com/"
  },
  {
    title: "레거시 시스템 개선 과정",
    date: "2025.02",
    category: "LEGACY",
    url: "https://yurizzy.tistory.com/"
  },
  {
    title: "Java 17 전환 및 호환성 이슈 해결",
    date: "2025.01",
    category: "JAVA",
    url: "https://yurizzy.tistory.com/"
  },
  {
    title: "폐쇄망 환경에서의 개발 노하우",
    date: "2024.12",
    category: "DEV",
    url: "https://yurizzy.tistory.com/"
  },
  {
    title: "SQL 쿼리 최적화 및 성능 개선",
    date: "2024.11",
    category: "DATABASE",
    url: "https://yurizzy.tistory.com/"
  },
];

export default function Writing() {
  return (
    <Section id="writing">
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
          <a
            href={article.url}
            target="_blank"
            rel="noopener noreferrer"
            key={index}
          >
            <motion.div
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ delay: index * 0.05 }}
              className="group grid grid-cols-1 md:grid-cols-[1fr_120px_140px] md:gap-6 md:items-center py-8 border-b border-gray-200 dark:border-gray-700 hover:bg-white dark:hover:bg-gray-800/50 hover:px-4 transition-all duration-300 cursor-pointer"
            >
            <h3 className="text-xl md:text-2xl font-medium group-hover:text-hot-pink transition-colors dark:text-white">
              {article.title}
            </h3>
            <span className="text-sm text-gray-400 dark:text-gray-500 font-mono whitespace-nowrap mt-4 md:mt-0">{article.date}</span>
            <span className="text-xs font-bold uppercase tracking-widest text-hot-pink border border-hot-pink px-2 py-1 rounded-full whitespace-nowrap w-fit ml-auto">
              {article.category}
            </span>
          </motion.div>
          </a>
        ))}
      </div>
    </Section>
  );
}
