import { motion } from "motion/react";
import Section from "./ui/Section";
import { Target, Shield, Zap, Plane, Book, Trophy } from "lucide-react";

/**
 * [MIG] About 컴포넌트 - Bento Grid & Technical Spec 스타일
 * - 정보를 구획화하여 엔지니어링 감성 및 인간적 면모(Human Metadata) 결합
 *
 * @author gayul.kim
 * @since 2026-04-17
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
          {/* Bento Box 1: Core Narrative & Philosophy */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="md:col-span-8 p-8 md:p-12 bg-tech-gray rounded-3xl border border-white/5 flex flex-col justify-center"
          >
            <div className="mb-6">
              <span className="mono text-[10px] text-neon-cyan uppercase tracking-[0.3em] block mb-2">Philosophy</span>
              <h3 className="text-3xl md:text-4xl font-black text-white leading-tight tracking-tight">
                "경험은 단단하게, <br />혁신은 유연하게."
              </h3>
            </div>
            
            <div className="space-y-6 text-zinc-400 text-lg leading-relaxed">
              <p>
                10년의 서비스업 경험은 저에게 <span className="text-white font-bold">'집요한 문제 해결 습관'</span>을 선물했습니다.
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
              className="object-cover w-full h-full brightness-75 hover:brightness-100 transition-all duration-700"
            />
            <div className="absolute inset-0 bg-gradient-to-t from-tech-black/80 via-transparent to-transparent" />
          </motion.div>

          {/* Bento Box 3: Core Values (Persistence, Stability, Efficiency) */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: 0.1 }}
            className="md:col-span-5 p-8 bg-tech-gray rounded-3xl border border-white/5 flex flex-col justify-between"
          >
            <span className="mono text-[10px] text-zinc-500 uppercase tracking-[0.3em] block mb-6">Core Values</span>
            <div className="space-y-6">
              {[
                { label: "Persistence", desc: "집요함", icon: <Target className="text-neon-cyan" size={20} /> },
                { label: "Stability", desc: "안정성", icon: <Shield className="text-neon-cyan" size={20} /> },
                { label: "Efficiency", desc: "효율", icon: <Zap className="text-neon-cyan" size={20} /> },
              ].map((val, i) => (
                <div key={i} className="flex items-center gap-4">
                  <div className="p-3 rounded-xl bg-black/30 border border-white/5">
                    {val.icon}
                  </div>
                  <div>
                    <h4 className="text-white font-bold uppercase tracking-widest text-sm">{val.label}</h4>
                    <p className="text-xs text-zinc-500">{val.desc}</p>
                  </div>
                </div>
              ))}
            </div>
          </motion.div>

          {/* Bento Box 4: Off-duty (Hobbies) */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: 0.2 }}
            className="md:col-span-7 p-8 bg-tech-gray rounded-3xl border border-white/5 flex flex-col overflow-hidden"
          >
            <span className="mono text-[10px] text-zinc-500 uppercase tracking-[0.3em] block mb-4">Off-duty</span>
            <div className="grid grid-cols-1 sm:grid-cols-3 gap-3 flex-1">
              {[
                { label: "Golf", desc: "Focus & Balance", icon: <Trophy className="text-white" size={20} />, img: "/image/golf.jpeg" },
                { label: "Reading", desc: "Deep Thinking", icon: <Book className="text-white" size={20} />, img: "/image/reading.jpeg" },
                { label: "Trip", desc: "New Perspective", icon: <Plane className="text-white" size={20} />, img: "/image/trip.jpeg" },
              ].map((hobby, i) => (
                <div key={i} className="group/hobby relative h-full min-h-[160px] rounded-2xl overflow-hidden border border-white/5 bg-black/20">
                  <img 
                    src={hobby.img} 
                    alt={hobby.label} 
                    className="absolute inset-0 w-full h-full object-cover opacity-20 grayscale group-hover/hobby:opacity-100 group-hover/hobby:grayscale-0 transition-all duration-700" 
                  />
                  <div className="relative h-full p-6 flex flex-col items-center justify-center text-center group-hover/hobby:opacity-0 transition-opacity duration-700">
                    <h4 className="text-zinc-100 font-bold text-base md:text-lg">{hobby.label}</h4>
                    <p className="mono text-[9px] text-zinc-300 uppercase tracking-widest mt-1">{hobby.desc}</p>
                  </div>
                </div>
              ))}
            </div>
          </motion.div>

          {/* Bento Box 5: Technical Specs (Skills) - Full Width */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: 0.3 }}
            className="md:col-span-12 p-8 bg-tech-gray rounded-3xl border border-white/5"
          >
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
              {[
                { label: "Runtime", value: "Java 17 / Spring Boot 3.3 / Spring Framework (레거시 운영)" },
                { label: "Persistence", value: "JPA / MyBatis / Oracle · MariaDB (운영) / MySQL (경험)" },
                { label: "Security", value: "Spring Security 6.x / Jasypt" },
                { label: "Messaging", value: "RabbitMQ / Spring AMQP" },
                { label: "Build", value: "Gradle / Maven / Nexus" },
                { label: "Server / Infra", value: "Linux / Apache HTTP Server / Apache Tomcat" },
                { label: "Cloud", value: "OCI (운영중) / AWS · GCP (경험)" },
                { label: "DevOps", value: "Docker / Netlify / Vercel / GitHub Actions" },
                { label: "Frontend", value: "React 19 / TypeScript / Tailwind CSS" },
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
