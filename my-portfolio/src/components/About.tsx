import { motion } from "motion/react";
import Section from "./ui/Section";

/**
 * [MIG] About 컴포넌트 고도화
 * - 가독성 중심의 심플한 텍스트 리라이팅
 * - 좌측 컨텐츠와 우측 이미지 높이 자동 동기화 (items-stretch)
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
export default function About() {
  return (
    <Section id="about" className="relative overflow-hidden" variant="full">
      <div className="grid grid-cols-1 lg:grid-cols-12 gap-16 items-stretch">
        {/* Left: Text Content (7/12) */}
        <motion.div
          initial={{ opacity: 0, x: -50 }}
          whileInView={{ opacity: 1, x: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
          className="lg:col-span-7 flex flex-col justify-center"
        >
          <h2 className="text-6xl md:text-8xl font-black text-hot-pink mb-10 tracking-tighter">
            ABOUT
          </h2>

          <div className="space-y-8 text-zinc-400">
            <div className="space-y-4">
              <p className="text-2xl md:text-3xl font-bold text-white leading-snug">
                "안정성을 설계하고 효율을 확장합니다."
              </p>
              <p className="text-lg leading-relaxed">
                10년의 현장 경험에서 얻은 <span className="text-white font-bold">'집요한 문제 해결 능력'</span>으로
                현재는 거대 레거시 시스템을 Spring Boot 3.3으로 현대화하는 핵심 엔지니어링을 수행하고 있습니다.
              </p>
            </div>

            <div className="space-y-4 text-lg leading-relaxed">
              <p>
                <span className="text-hot-pink font-bold">Claude Code, Gemini, Antigravity</span>를 실무에 전면 도입하여
                단순 코딩을 넘어 최적화된 <span className="text-white font-bold">AI 워크플로우와 프롬프트 엔지니어링</span>을 끊임없이 연구합니다.
              </p>
              <p>
                저에게 기술은 비즈니스 가치를 실현하는 도구입니다.
                <span className="text-zinc-200">가독성, 안정성, 성능</span>이라는 본질에 집중하며 타협 없는 시스템을 구축합니다.
              </p>
            </div>
          </div>

          {/* Skills Grid */}
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-12">
            {[
              { name: "Java 17 & Spring Boot 3.3", level: "90%" },
              { name: "JPA & QueryDSL", level: "85%" },
              { name: "AI Prompt Engineering", level: "85%" },
              { name: "RabbitMQ & Messaging", level: "75%" },
              { name: "Docker & OCI", level: "70%" },
              { name: "Claude Code & AI Studio", level: "90%" },
            ].map((skill) => (
              <div key={skill.name} className="bg-zinc-900/50 p-4 rounded-xl flex justify-between items-center border-l-2 border-hot-pink/50 hover:border-hot-pink transition-all w-full group">
                <span className="font-bold text-xs md:text-sm text-zinc-300 group-hover:text-white transition-colors">{skill.name}</span>
                <span className="text-hot-pink font-mono text-xs font-black ml-4">{skill.level}</span>
              </div>
            ))}
          </div>
        </motion.div>

        {/* Right: Profile Image (5/12) - Height automatically matches left side */}
        <motion.div
          initial={{ opacity: 0, scale: 0.95 }}
          whileInView={{ opacity: 1, scale: 1 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
          className="lg:col-span-5 relative bg-zinc-900 rounded-3xl overflow-hidden shadow-2xl flex"
        >
          <img
            src="/image/gemini.png"
            alt="Profile"
            className="object-cover w-full h-full grayscale hover:grayscale-0 transition-all duration-700 brightness-90 hover:brightness-110"
          />
          <div className="absolute inset-0 bg-gradient-to-t from-[#0A0A0A]/40 to-transparent pointer-events-none" />
        </motion.div>
      </div>
    </Section>
  );
}
