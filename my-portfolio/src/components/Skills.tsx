import { motion } from "motion/react";
import Section from "./ui/Section";
import { Terminal, Database, Server, Component, Settings } from "lucide-react";

/**
 * [NEW] Skills 컴포넌트 - 와이드 레이아웃 (사용자 원본 데이터 보존)
 * - 기존 9개의 카테고리 데이터 손실 없이, 시각적으로 넓고 가독성 좋게 재배치
 *
 * @author gayul.kim
 * @since 2026-04-17
 */
export default function Skills() {
  const skillBlocks = [
    {
      title: "Core Backend",
      colSpan: "md:col-span-7",
      icon: <Terminal className="text-neon-cyan" size={24} />,
      groups: [
        {
          name: "Language & Runtime",
          items: ["Java 17 (LTS)", "Java 7 (Legacy 유지보수)"]
        },
        {
          name: "Framework",
          items: ["Spring Boot 3.3", "Spring Framework 4 (Legacy)", "Spring Security", "Jasypt"]
        }
      ]
    },
    {
      title: "Data & Build",
      colSpan: "md:col-span-5",
      icon: <Database className="text-neon-cyan" size={24} />,
      groups: [
        {
          name: "Persistence",
          items: ["MariaDB", "Oracle", "MySQL", "MyBatis", "JPA (학습 중)"]
        },
        {
          name: "Build & Dependency",
          items: ["Gradle 8.8", "Maven", "Nexus (사내 저장소 운영)"]
        }
      ]
    },
    {
      title: "Infrastructure",
      colSpan: "md:col-span-5",
      icon: <Server className="text-neon-cyan" size={24} />,
      groups: [
        {
          name: "Server & Infra",
          items: ["Linux", "Apache HTTP Server", "Apache Tomcat", "OCI (운영 중)", "AWS", "GCP"]
        },
        {
          name: "DevOps & Tools",
          items: ["Docker", "GitHub Actions", "Git"]
        }
      ]
    },
    {
      title: "Frontend Development",
      colSpan: "md:col-span-4",
      icon: <Component className="text-neon-cyan" size={24} />,
      groups: [
        {
          name: "Frontend (Portfolio Site)",
          items: ["React 19", "TypeScript", "Tailwind CSS", "Vercel"]
        }
      ]
    },
    {
      title: "Practice & Growth",
      colSpan: "md:col-span-3",
      icon: <Settings className="text-neon-cyan" size={24} />,
      groups: [
        {
          name: "Practice",
          items: ["Legacy Migration", "Refactoring", "Code Review", "사내 폐쇄망 환경 개발 경험"]
        },
        {
          name: "Currently Learning",
          items: ["JPA 심화", "Spring Batch", "Spring Security 심화"]
        }
      ]
    }
  ];

  return (
    <Section id="skills" className="bg-tech-black border-b border-zinc-900" variant="full">
      <div className="max-w-[1200px] mx-auto">
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">02. Technical Stack</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter uppercase">SKILLS</h2>
        </div>

        <div className="flex flex-col gap-6">
          {skillBlocks.map((block, idx) => (
            <motion.div
              key={idx}
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              transition={{ delay: idx * 0.1 }}
              className="grid grid-cols-1 lg:grid-cols-12 gap-8 p-8 md:p-10 bg-tech-gray rounded-3xl border border-white/5 hover:border-neon-cyan/20 transition-all duration-500 group"
            >
              {/* Left Column: Block Title (4 cols) */}
              <div className="lg:col-span-4 flex items-start gap-4 border-b lg:border-b-0 lg:border-r border-white/5 pb-6 lg:pb-0 pr-0 lg:pr-6">
                <div className="w-14 h-14 shrink-0 flex items-center justify-center rounded-2xl bg-black/40 border border-white/5 group-hover:bg-neon-cyan/10 transition-colors shadow-inner">
                  {block.icon}
                </div>
                <div className="pt-3">
                  <h3 className="text-xl md:text-2xl font-bold text-white uppercase tracking-widest">{block.title}</h3>
                </div>
              </div>
              
              {/* Right Column: Groups & Pills (8 cols) */}
              <div className="lg:col-span-8 flex flex-col justify-center gap-6">
                {block.groups.map((g, i) => (
                  <div key={i} className="flex flex-col sm:flex-row sm:items-start gap-3 sm:gap-6">
                    {/* Category Name inside the block */}
                    <div className="w-48 shrink-0 relative sm:pt-2">
                      <span className="mono text-xs text-zinc-500 font-bold uppercase tracking-widest">
                        {g.name}
                      </span>
                    </div>
                    {/* Pills Container */}
                    <div className="flex flex-wrap gap-2.5 flex-1">
                      {g.items.map((item, j) => (
                        <span 
                          key={j} 
                          className="text-sm px-4 py-2 bg-black/40 border border-white/5 rounded-xl text-zinc-300 font-medium group-hover:border-neon-cyan/30 group-hover:bg-black/60 group-hover:text-zinc-100 transition-colors cursor-default shadow-sm"
                        >
                          {item}
                        </span>
                      ))}
                    </div>
                  </div>
                ))}
              </div>
            </motion.div>
          ))}
        </div>
      </div>
    </Section>
  );
}
