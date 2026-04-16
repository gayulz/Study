import { motion } from "motion/react";
import Section from "./ui/Section";

/**
 * [MIG] About 컴포넌트 - Bento Grid & Technical Spec 스타일
 * - 정보를 구획화하여 엔지니어링 감성 극대화
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
export default function About() {
  return (
    <Section id="about" className="bg-tech-black border-y border-zinc-900" variant="full">
      <div className="max-w-[1200px] mx-auto">
        <div className="flex flex-col gap-4 mb-16">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">01. Profile Abstract</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter">ENGINEERING MINDSET</h2>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-12 gap-6 items-stretch">
          {/* Bento Box 1: Core Narrative */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="md:col-span-8 p-8 md:p-12 bg-tech-gray rounded-3xl border border-white/5 flex flex-col justify-center"
          >
            <p className="text-2xl md:text-3xl font-bold text-white mb-8 leading-tight">
              "안정성을 설계하고 <br />AI와 함께 효율의 임계치를 돌파합니다."
            </p>
            <div className="space-y-6 text-zinc-400 text-lg leading-relaxed">
              <p>
                10년의 서비스업 경험은 <span className="text-white font-bold">'집요한 문제 해결 습관'</span>을 선물했습니다.
                현재는 Spring Boot 3.3 현대화 프로젝트의 주축으로서, 레거시의 복잡한 의존성을 해소하고 시스템 성능을 최적화하는 데 집중하고 있습니다.
              </p>
              <p>
                단순 생산성 향상을 넘어, <span className="text-neon-cyan font-bold">Claude Code, Gemini, Codex</span> 등 다양한
                AI 도구와 개발툴들을 실무 워크플로우에 깊숙이 통합하여 단순 반복을 줄이고 본질적인 설계와 비즈니스 가치에 집중할 수 있는 환경을 만드는 것을 즐깁니다.
              </p>
            </div>
          </motion.div>

          {/* Bento Box 2: Profile Image */}
          <motion.div
            initial={{ opacity: 0, scale: 0.95 }}
            whileInView={{ opacity: 1, scale: 1 }}
            viewport={{ once: true }}
            className="md:col-span-4 relative bg-tech-gray rounded-3xl overflow-hidden border border-white/5"
          >
            <img
              src="/image/gemini.png"
              alt="Profile"
              className="object-cover w-full h-full  brightness-75 hover:grayscale-0 hover:brightness-10 transition-all duration-700"
            />
            <div className="absolute inset-0 bg-gradient-to-t from-tech-black/80 via-transparent to-transparent" />
          </motion.div>

          {/* Bento Box 3: Technical Specs (Skills) */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: 0.2 }}
            className="md:col-span-12 p-8 bg-tech-gray rounded-3xl border border-white/5"
          >
            <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-4">
              {[
                { label: "Runtime", value: "Java 17 / Spring Boot 3.3" },
                { label: "Persistence", value: "JPA / QueryDSL / Oracle" },
                { label: "Messaging", value: "RabbitMQ / Async Processing" },
                { label: "DevOps", value: "Docker / OCI / Netlify" },
                { label: "AI Stack", value: "Claude Code / Prompt Eng." },
                { label: "Frontend", value: "React 19 / TS / Tailwind" },
              ].map((spec, i) => (
                <div key={i} className="flex flex-col gap-2 p-4 rounded-2xl bg-black/20 border border-white/5 hover:border-neon-cyan/30 transition-colors">
                  <span className="mono text-[9px] uppercase tracking-widest text-zinc-500">{spec.label}</span>
                  <span className="text-xs md:text-sm font-bold text-zinc-200">{spec.value}</span>
                </div>
              ))}
            </div>
          </motion.div>
        </div>
      </div>
    </Section>
  );
}
