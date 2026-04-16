import { motion } from "motion/react";
import Section from "./ui/Section";
import { Terminal, Briefcase, Calendar, ChevronRight } from "lucide-react";

/**
 * [MIG] Experience 컴포넌트 - oryzo.ai 테크니컬 스타일 반영
 * - 타임라인 대신 'Career Log' 형태의 Bento Grid 레이아웃 적용
 *
 * @author gayul.kim
 * @since 2026-04-17
 */
const experiences = [
  {
    role: "Backend Engineer · SK Operations Team",
    company: "(주)포커스원 (FocusOne)",
    period: "2024.04 — PRESENT",
    description: "주요 사내 서비스 및 관리 시스템의 백엔드 현대화와 안정적인 운영을 담당하고 있습니다.",
    achievements: [
      "Legacy (Java 8/Spring 4) → Modern (Java 17/Spring Boot 3.3) 마이그레이션 주도",
      "XML 기반 설정을 Java Config로 전면 전환하여 유지보수성 40% 향상",
      "OKTA SSO 연동 및 인터셉터 최적화를 통한 보안 강화 및 인증 성능 개선",
      "1,000줄 이상의 비즈니스 로직을 계층화 및 DI 패턴으로 리팩토링"
    ],
    tech: ["Java 17", "Spring Boot 3.3", "JPA", "Oracle", "OKTA"]
  },
  {
    role: "Technical Support Specialist",
    company: "서비스에이스 (Service Ace)",
    period: "2019.08 — 2023.09",
    description: "SK브로드밴드 서비스의 1차 기술 지원 및 장애 대응 업무를 수행했습니다.",
    achievements: [
      "복잡한 네트워크 및 서비스 이슈에 대한 신속한 원격 진단 및 해결",
      "고객 요구사항 분석을 통한 문제 해결 프로세스 최적화 기여"
    ],
    tech: ["Network TS", "Remote Solutions", "CS Protocol"]
  },
  {
    role: "Financial Service Support",
    company: "메타넷 (Metanet)",
    period: "2014.10 — 2018.01",
    description: "메트라이프생명 금융 서비스 지원 및 고객 커뮤니케이션을 담당했습니다.",
    achievements: [
      "변액보험 및 금융 상품 관련 전문 상담 제공",
      "보험금 청구 프로세스 안내 및 고객 커뮤니케이션 역량 확보"
    ],
    tech: ["Financial Knowledge", "Communication", "CRM"]
  }
];

export default function Experience() {
  return (
    <Section id="experience" className="bg-tech-black border-t border-white/5">
      <div className="flex flex-col gap-4 mb-24 items-center text-center">
        <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">03. Career Timeline</span>
        <h2 className="text-6xl md:text-9xl font-black text-white tracking-tighter uppercase">EXPERIENCE</h2>
      </div>

      <div className="max-w-[1100px] mx-auto space-y-8">
        {experiences.map((exp, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="group relative p-8 md:p-12 bg-tech-gray rounded-3xl border border-white/5 hover:border-neon-cyan/30 transition-all duration-500"
          >
            {/* Background Accent */}
            <div className="absolute top-0 right-0 p-8 opacity-[0.03] group-hover:opacity-[0.07] transition-opacity">
              <Briefcase size={120} />
            </div>

            <div className="grid grid-cols-1 lg:grid-cols-12 gap-8 items-start relative z-10">
              {/* Meta Info */}
              <div className="lg:col-span-4 space-y-6">
                <div className="space-y-2">
                  <div className="flex items-center gap-2 text-neon-cyan mb-2">
                    <Terminal size={14} />
                    <span className="mono text-[10px] uppercase tracking-widest font-bold">Active Instance</span>
                  </div>
                  <h3 className="text-2xl font-bold text-white leading-tight">{exp.role}</h3>
                  <p className="text-zinc-500 font-medium">{exp.company}</p>
                </div>

                <div className="flex items-center gap-3 py-2 px-4 rounded-full bg-black/30 border border-white/5 w-fit">
                  <Calendar size={14} className="text-zinc-500" />
                  <span className="mono text-[10px] text-zinc-300 uppercase tracking-widest">{exp.period}</span>
                </div>

                <div className="flex flex-wrap gap-2 pt-4">
                  {exp.tech.map((t, i) => (
                    <span key={i} className="mono text-[9px] px-2 py-1 bg-white/5 text-zinc-500 rounded border border-white/5">
                      {t}
                    </span>
                  ))}
                </div>
              </div>

              {/* Description & Achievements */}
              <div className="lg:col-span-8 space-y-8">
                <p className="text-xl text-zinc-300 font-medium leading-relaxed">
                  {exp.description}
                </p>

                <div className="space-y-4">
                  <span className="mono text-[10px] text-zinc-600 uppercase tracking-[0.3em] block border-b border-white/5 pb-2">
                    Key Outcomes
                  </span>
                  <div className="grid grid-cols-1 gap-3">
                    {exp.achievements.map((item, i) => (
                      <div key={i} className="flex gap-4 items-start group/item">
                        <ChevronRight size={16} className="text-neon-cyan mt-1 shrink-0 group-hover/item:translate-x-1 transition-transform" />
                        <p className="text-zinc-400 leading-relaxed group-hover/item:text-zinc-200 transition-colors">
                          {item}
                        </p>
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            </div>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
