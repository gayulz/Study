import { motion } from "motion/react";
import Section from "./ui/Section";

const education = [
  {
    degree: "컴퓨터공학과 (학사)",
    school: "서울디지털대학교",
    period: "2020.06 — 2024.02",
    description: "학사 학위 취득. 컴퓨터 과학 전반에 대한 기초를 다지고 소프트웨어 개발 역량을 키웠습니다."
  },
  {
    degree: "자바기반 웹 개발자 프로그래밍 과정",
    school: "휴먼교육센터",
    period: "2023.08 — 2024.01",
    description: "과정평가형 정보처리 산업기사. Java, Spring Framework, Database 등 실무 중심의 웹 개발 기술을 학습했습니다."
  }
];

export default function Education() {
  return (
    <Section id="education">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        EDUCATION
      </motion.h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-x-12 gap-y-16">
        {education.map((edu, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="border-t-2 border-gray-200 dark:border-gray-700 pt-8 hover:border-hot-pink transition-colors duration-300"
          >
            <h3 className="text-2xl font-bold mb-1 dark:text-white">{edu.degree}</h3>
            <div className="flex justify-between items-center mb-4">
              <span className="text-lg text-gray-600 dark:text-gray-400 font-medium">{edu.school}</span>
              <span className="text-sm font-mono text-gray-400 dark:text-gray-500">{edu.period}</span>
            </div>
            <p className="text-gray-600 dark:text-gray-400 leading-relaxed">
              {edu.description}
            </p>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
