import { motion } from "motion/react";
import Section from "./ui/Section";

export default function About() {
  return (
    <Section id="about" className="relative overflow-hidden" variant="full">
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">
        {/* Text Content */}
        <motion.div
          initial={{ opacity: 0, x: -50 }}
          whileInView={{ opacity: 1, x: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
        >
          <h2 className="text-6xl md:text-9xl font-black text-hot-pink mb-8 tracking-tighter">
            ABOUT
          </h2>
          <p className="text-xl md:text-2xl leading-relaxed font-light text-gray-200 mb-6">
            "고객의 불편을 해결하던 서비스맨에서, 시스템의 문제를 해결하는 개발자로"
          </p>
          <p className="text-gray-400 leading-relaxed mb-8">
            약 10년간 서비스업(콜센터, 기술지원)에서 사람들의 문제를 듣고 해결하며 커뮤니케이션 역량과 문제 해결 능력을 키웠습니다.
            "왜 이 시스템은 자꾸 문제가 생길까?" 그 호기심이 저를 개발자의 길로 이끌었습니다.
            30세에 개발자로 전환한 뒤, 10년 이상 운영된 레거시 시스템을 Spring Boot로 전환하는 프로젝트를 독립 수행하며
            다수의 호환성 이슈를 체계적으로 해결했습니다.
            늦게 시작한 만큼 더 간절하고, 더 꾸준합니다.
          </p>

          {/* Skills */}
          <div className="space-y-6">
            {[
              { name: "Java & Spring", level: "90%" },
              { name: "Database (MySQL, Oracle)", level: "85%" },
              { name: "JavaScript & JSP", level: "80%" },
            ].map((skill) => (
              <div key={skill.name} className="bg-blue-50 dark:bg-gray-800/50 p-4 rounded-lg flex justify-between items-center border-l-4 border-hot-pink">
                <span className="font-bold text-lg dark:text-white">{skill.name}</span>
                <span className="text-hot-pink font-mono">{skill.level}</span>
              </div>
            ))}
          </div>
        </motion.div>

        {/* Image Placeholder */}
        <motion.div
          initial={{ opacity: 0, scale: 0.9 }}
          whileInView={{ opacity: 1, scale: 1 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
          className="relative aspect-[3/4] bg-gray-200 dark:bg-gray-800 rounded-2xl overflow-hidden shadow-2xl"
        >
          <img
            src="/image/20230430_032558.jpg"
            alt="Profile"
            className="object-cover w-full h-full grayscale hover:grayscale-0 transition-all duration-500"
          />
          <div className="absolute inset-0 bg-hot-pink/10 mix-blend-overlay pointer-events-none" />
        </motion.div>
      </div>
    </Section>
  );
}
