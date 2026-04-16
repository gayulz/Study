import { motion } from "motion/react";
import Section from "./ui/Section";
import { ArrowUpRight, Sparkles, Terminal, Database, Cpu } from "lucide-react";

type LinkType = 'github' | 'live';

interface ProjectLink {
  type: LinkType;
  url: string;
  label: string;
}

interface Project {
  id: string;
  title: string;
  version: string;
  tags: string[];
  description: string;
  highlights: string[];
  techStack: string[];
  image: string;
  links: ProjectLink[];
  aiTools?: string[];
  metrics?: { label: string; value: string }[];
}

const projects: Project[] = [
  {
    id: "modernization",
    title: "Legacy Modernization",
    version: "v3.3.2",
    tags: ["System Modernization", "Enterprise Solution (Company)"],
    description: "10년 이상 운영된 거대 레거시 시스템을 최신 Spring Boot 아키텍처로 안전하게 이식한 프로젝트입니다.",
    highlights: [
      "Spring 4/XML 설정을 Java Config로 전면 전환",
      "생성자 주입 및 계층 분리를 통한 결합도 해소",
      "OKTA SSO 연동 및 인터셉터 성능 최적화"
    ],
    techStack: ["Java 7", "Spring Framework 4", "Java 17", "Spring Boot 3.3", "Apache", "mariaDB", "JPA", "Mybatis", "OKTA", "Spring Security", "JSP", "Javascript", "Linux", "Git"],
    metrics: [
      { label: "Build Speed", value: "+40%" },
      { label: "Maintenance", value: "Optimized" },
      { label: "Security", value: "Hardened" }
    ],
    image: "/image/spring-gradle.png",
    links: [
      { type: 'github', url: "/gayul-kim-resume.pdf", label: "Work Experience" }
    ]
  },
  {
    id: "settletree",
    title: "SettleTree",
    version: "v1.2.0",
    tags: ["Open Source"],
    description: "계층형 조직 구조에서의 복잡한 수수료 배분 로직을 전산화한 엔터프라이즈급 백엔드 엔진입니다.",
    highlights: [
      "DFS 재귀 알고리즘 기반의 정밀 수수료 계산",
      "Direct Exchange 방식의 RabbitMQ 비동기 메시징",
      "BigDecimal 활용 소수점 낙전(Dust) 보정 시스템"
    ],
    techStack: ["Java 17", "Spring Boot 3.3", "RabbitMQ", "PostgreSQL", "Docker", "OCI", "Linux", "Git"],
    aiTools: ["Gemini", "Antigravity", "Claude Code"],
    metrics: [
      { label: "Complexity", value: "High" },
      { label: "Throughput", value: "Scalable" },
      { label: "Precision", value: "99.9%" }
    ],
    image: "image/settlement.png",
    links: [
      { type: 'github', url: "https://github.com/gayulz/multi-level-fee", label: "Source" },
      { type: 'live', url: "https://settletree.p-e.kr/", label: "Live Spec" }
    ]
  },
  {
    id: "wedding",
    title: "Luxury Wedding",
    version: "v2.0.1",
    tags: ["Interactive App"],
    description: "모바일 환경에 최적화된 고감도 인터랙션 디지털 청첩장 시스템입니다.",
    highlights: [
      "Framer Motion 기반 60fps 애니메이션 최적화",
      "Firebase Firestore 실시간 데이터 싱크",
      "Netlify Functions 서버리스 아키텍처"
    ],
    techStack: ["React 19", "TS", "Framer Motion", "Firebase", "Netlify", "Git", "Vercel"],
    aiTools: ["Claude Code", "AI Studio"],
    metrics: [
      { label: "FPS", value: "60" },
      { label: "Latency", value: "Minimal" },
      { label: "UX", value: "Premium" }
    ],
    image: "/image/wedding.png",
    links: [
      { type: 'github', url: "https://github.com/gayulz/wedding", label: "Repo" },
      { type: 'live', url: "https://bong-yul-invitation.netlify.app/", label: "Demo" }
    ]
  },
];

export default function Projects() {
  return (
    <Section id="projects" className="bg-tech-black">
      <div className="max-w-[1200px] mx-auto">
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">03. Engineering Portfolio</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter uppercase">PROJECTS</h2>
        </div>
      </div>
      <br />
      <div className="flex flex-col gap-32 max-w-[1200px] mx-auto">
        {projects.map((project, index) => (
          <motion.div
            key={project.id}
            initial={{ opacity: 0, y: 40 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="grid grid-cols-1 lg:grid-cols-12 gap-12 lg:items-stretch"
          >
            {/* Left: Project Image & Version (5/12) */}
            <div className="lg:col-span-5 flex flex-col h-full lg:min-h-0">
              <div className="relative aspect-square md:aspect-[4/5] lg:aspect-auto lg:flex-1 lg:min-h-0 rounded-3xl overflow-hidden border border-white/5 bg-tech-gray group">
                <img
                  src={project.image}
                  alt={project.title}
                  className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110 opacity-60 group-hover:opacity-100"
                />
                <div className="absolute inset-0 bg-gradient-to-t from-black/90 via-transparent to-transparent opacity-70 group-hover:opacity-90 transition-opacity duration-700" />
                <div className="absolute bottom-6 left-6 right-6 flex flex-col lg:flex-row lg:items-end justify-between gap-4">
                  <div className="flex flex-col gap-1 shrink-0">
                    <span className="mono text-[10px] text-zinc-400 uppercase tracking-widest">Build Version</span>
                    <span className="text-xl font-bold text-white">{project.version}</span>
                  </div>
                  <div className="flex items-center gap-2 flex-wrap lg:justify-end">
                    {project.tags.map((tag, i) => (
                      <span key={i} className="mono text-[9px] bg-neon-cyan/10 backdrop-blur-md border border-neon-cyan/20 text-neon-cyan uppercase tracking-widest px-3 py-1.5 rounded-full">
                        {tag}
                      </span>
                    ))}
                    {project.aiTools && (
                      <span className="mono text-[9px] bg-emerald-500/10 backdrop-blur-md border border-emerald-500/20 text-emerald-500 uppercase tracking-widest flex items-center gap-1.5 px-3 py-1.5 rounded-full">
                        <Sparkles size={10} /> AI Assisted
                      </span>
                    )}
                  </div>
                </div>
              </div>
            </div>

            {/* Right: Project Details (7/12) */}
            <div className="lg:col-span-7 flex flex-col pt-0">
              <br />
              <div className="flex flex-wrap gap-2 mb-6">
                {project.techStack.map((tech, i) => (
                  <span key={i} className="mono text-[10px] px-3 py-1 text-neon-cyan border border-neon-cyan/20 rounded-full">
                    {tech}
                  </span>
                ))}
              </div>

              <h3 className="text-4xl md:text-5xl font-black mb-8 text-white tracking-tighter">
                {project.title}<span className="text-neon-cyan">.</span>
              </h3>

              <p className="text-zinc-400 text-lg mb-12 leading-relaxed">
                {project.description}
              </p>

              {/* Technical Metrics Table */}
              <div className="grid grid-cols-3 gap-1 border-y border-white/5 mb-12 py-8">
                {project.metrics?.map((m, i) => (
                  <div key={i} className="flex flex-col gap-1 text-center">
                    <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest">{m.label}</span>
                    <span className="text-xl font-bold text-zinc-200">{m.value}</span>
                  </div>
                ))}
              </div>

              <div className="space-y-4 mb-12">
                {project.highlights.map((h, i) => (
                  <div key={i} className="flex gap-4 items-start">
                    <div className="mt-1.5 w-1.5 h-1.5 rounded-full bg-neon-cyan shadow-[0_0_8px_#00F3FF]" />
                    <p className="text-sm md:text-base text-zinc-300 font-medium">{h}</p>
                  </div>
                ))}
              </div>

              <div className="flex gap-4">
                {project.links.map((link, idx) => (
                  <a
                    key={idx}
                    href={link.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="mono text-[10px] uppercase tracking-widest px-8 py-4 bg-white text-black font-black flex items-center gap-2 hover:bg-neon-cyan transition-colors"
                  >
                    {link.label} <ArrowUpRight size={14} />
                  </a>
                ))}
              </div>
            </div>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
