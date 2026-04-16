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
    version: "18단계 · 5개월",
    tags: ["1인 독립 수행", "폐쇄망 환경", "단독 수행"],
    description: "10년 이상 운영된 레거시(Java 1.7 / Spring 3.x)를 Java 17 / Spring Boot 3.3.2로 1인 전환했습니다. 단순 이식이 아닌 아키텍처 재설계 · 보안 강화 · 코드 품질 개선을 병행했습니다. 폐쇄망 환경에서 오프라인 Gradle 빌드 구조를 완성했습니다.",
    highlights: [
      "18단계 전환 공정 수립 및 1인 독립 수행 완료",
      "보안 취약점 3건 선제 발굴 및 운영 배포 전 전수 해결",
      "Spring 4/XML 설정을 Java Config로 전면 전환 및 계층 분리"
    ],
    techStack: ["Java 17", "Spring Boot 3.3", "Spring Security 6", "MyBatis", "JPA", "MariaDB", "Gradle 8.8", "폐쇄망 환경", "단독 수행"],
    metrics: [
      { label: "Build Time", value: "-28% (2m 40s)" },
      { label: "Fix Cycle", value: "-66% (1 day)" },
      { label: "Security", value: "3 Hardened" }
    ],
    image: "/image/spring-gradle.png",
    links: [
      { type: 'github', url: "/gayul-kim-resume.pdf", label: "Work Experience" }
    ]
  },
  {
    id: "settletree",
    title: "SettleTree",
    version: "1인 설계·개발",
    tags: ["N-Depth 트리 정산", "금융 정합성 100%"],
    description: "판매망·프랜차이즈 등 N-Depth 계층 구조에서 발생하는 결제 대금을 각 계층의 수수료율에 따라 자동 분배하는 백엔드 정산 엔진입니다. DFS 알고리즘 기반 분배와 소수점 낙전(Dust) 보정으로 금융 정합성 100%를 달성했습니다.",
    highlights: [
      "DFS 알고리즘 기반 분배 + 소수점 낙전(Dust) 보정 알고리즘 설계",
      "N+1 문제를 QueryDSL Fetch Join으로 해결 (쿼리 1회로 트리 전체 로드)",
      "CI 환경에서 RabbitMQ MockBean 격리 → 빌드 속도 83% 단축 (30s → 5s)"
    ],
    techStack: ["Java 17", "Spring Boot 3.3", "Spring Data JPA", "QueryDSL", "RabbitMQ", "PostgreSQL", "Docker", "GitHub Actions", "DFS", "1인 설계"],
    aiTools: ["Gemini", "Claude Code"],
    metrics: [
      { label: "Test Build", value: "-83% (5s)" },
      { label: "Tree Load", value: "1 Query" },
      { label: "Precision", value: "100.0%" }
    ],
    image: "image/settlement.png",
    links: [
      { type: 'github', url: "https://github.com/gayulz/multi-level-fee", label: "자세한 트러블슈팅 보기 →" },
      { type: 'live', url: "https://settletree.p-e.kr/", label: "Live Spec" }
    ]
  },
  {
    id: "wedding",
    title: "Luxury Wedding",
    version: "1인 전담 프로젝트",
    tags: ["직접 기획/디자인", "풀스택"],
    description: "직접 기획 · 개발 · 디자인 · 영상 제작까지 수행한 웨딩 초대장 풀스택 프로젝트입니다. 기획부터 배포까지 전 과정을 1인 전담하여 구현했습니다. React 19와 Framer Motion으로 고감도 인터랙션을 구현했습니다.",
    highlights: [
      "React 19 및 Framer Motion 기반 60fps 애니메이션 최적화",
      "기획부터 개발, 디자인, 영상 제작까지 1인 전담 프로세스 수행",
      "Vercel을 통한 자동 배포 환경 구축 및 운영"
    ],
    techStack: ["React 19", "TS", "Framer Motion", "Firebase", "Netlify", "Vercel", "개인 프로젝트", "1인 전담"],
    aiTools: ["Claude Code", "AI Studio"],
    metrics: [
      { label: "FPS", value: "60" },
      { label: "Latency", value: "Minimal" },
      { label: "Role", value: "Fullstack" }
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
