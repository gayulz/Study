import { motion } from "motion/react";
import Section from "./ui/Section";

const experiences = [
  {
    role: "백엔드 개발자 · SK운영팀",
    company: "(주)포커스원",
    period: "2024.04 — 현재",
    description: "사내 모바일 앱스토어 웹 서비스의 백엔드 개발을 담당하고 있습니다. SSO 기반 통합 인증 시스템 운영, 레거시 시스템 현대화, 게시판 기능 개선 및 보안 강화 등 다양한 백엔드 개발 업무를 수행하고 있습니다."
  },
  {
    role: "기술 지원 및 고객 응대",
    company: "서비스에이스",
    period: "2019.08 — 2023.09",
    description: "SK브로드밴드 서비스의 기술 지원 업무를 담당했습니다. 고객의 문제를 신속하게 파악하고 원격 조치하는 1차 기술지원과 CS를 복합적으로 수행하며 문제 해결 능력을 키웠습니다."
  },
  {
    role: "고객 상담 및 금융 서비스 지원",
    company: "메타넷",
    period: "2014.10 — 2018.01",
    description: "메트라이프생명 콜센터에서 인바운드 상담을 담당했습니다. 고객 지원, 금융 상담, 변액펀드 상담 및 보험금 청구 관련 업무를 수행하며 고객 커뮤니케이션 역량을 쌓았습니다."
  }
];

export default function Experience() {
  return (
    <Section id="experience">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        EXPERIENCE
      </motion.h2>

      <div className="relative max-w-4xl mx-auto">
        {/* 세로 타임라인 */}
        <div className="absolute left-0 md:left-8 top-0 bottom-0 w-0.5 bg-hot-pink"></div>

        {/* 경력 목록 */}
        <div className="space-y-12">
          {experiences.map((exp, index) => (
            <motion.div
              key={index}
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ delay: index * 0.1 }}
              className="relative pl-12 md:pl-24"
            >
              {/* 타임라인 점 */}
              <div className="absolute left-0 md:left-8 top-2 -translate-x-1/2 w-4 h-4 rounded-full bg-hot-pink border-4 border-black"></div>

              {/* 경력 정보 */}
              <div className="bg-zinc-900/50 p-6 rounded-lg border border-zinc-800 hover:border-hot-pink transition-colors duration-300">
                <div className="flex flex-col md:flex-row md:justify-between md:items-start gap-2 mb-3">
                  <h3 className="text-2xl font-bold text-white">{exp.role}</h3>
                  <span className="text-sm font-mono text-hot-pink font-semibold">{exp.period}</span>
                </div>
                <p className="text-lg text-gray-400 font-medium mb-4">{exp.company}</p>
                <p className="text-gray-400 leading-relaxed">
                  {exp.description}
                </p>
              </div>
            </motion.div>
          ))}
        </div>
      </div>
    </Section>
  );
}
