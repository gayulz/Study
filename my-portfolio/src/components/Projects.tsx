import { motion } from "motion/react";
import Section from "./ui/Section";
import { ArrowUpRight, Sparkles } from "lucide-react";

type LinkType = 'github' | 'live';

interface ProjectLink {
  type: LinkType;
  url: string;
  label: string;
}

interface Project {
  title: string;
  category: string;
  typeLabel: '회사 프로젝트' | '개인 프로젝트';
  description: string;
  highlights: string[];
  techStack: string[];
  image: string;
  links: ProjectLink[];
  aiTools?: string[];
}

const projects: Project[] = [
  {
    title: "SettleTree: 계층형 정산 시스템",
    category: "Spring Boot & RabbitMQ",
    typeLabel: "개인 프로젝트",
    description: "다중 레벨 조직 구조에서의 복잡한 수수료 배분 로직을 전산화한 백엔드 시스템입니다.",
    highlights: [
      "DFS 재귀 알고리즘을 활용한 다단계 수수료 계산 로직 구현",
      "RabbitMQ를 이용한 정산 요청의 비동기 메시징 처리 (Direct Exchange)",
      "BigDecimal 기반의 소수점 절삭(낙전) 보정 및 데이터 정합성 보장",
      "QueryDSL Fetch Join을 통한 트리 구조 N+1 성능 문제 해결"
    ],
    techStack: ["Java 17", "Spring Boot 3.3", "QueryDSL", "RabbitMQ", "PostgreSQL", "Docker"],
    aiTools: ["Gemini", "Antigravity", "Claude Code"],
    image: "image/settlement.png",
    links: [
      { type: 'github', url: "https://github.com/gayulz/multi-level-fee", label: "GitHub" },
      { type: 'live', url: "https://settletree.p-e.kr/", label: "Live Demo" }
    ]
  },
  {
    title: "Legacy System Modernization",
    category: "Java 17 & Spring Boot 3.3 Migration",
    typeLabel: "회사 프로젝트",
    description: "10년 이상 된 사내 핵심 레거시 시스템을 최신 아키텍처로 안전하게 마이그레이션한 프로젝트입니다.",
    highlights: [
      "Spring 4/XML 설정을 Boot 3.3 Java Config 기반으로 전면 전환",
      "복잡한 의존성 구조를 분석하여 DI 방식 개선(생성자 주입) 및 계층 분리",
      "SSO(OKTA) 인증 연동 및 레거시 인증 체계와의 호환성 유지",
      "인터셉터 및 공통 필터 성능 최적화 (지연 호출 적용)"
    ],
    techStack: ["Java 17", "Spring Boot 3.3", "JPA", "Gradle", "MariaDB", "OKTA"],
    image: "https://picsum.photos/seed/legacy-migration/800/600",
    links: [
      { type: 'github', url: "/gayul-kim-resume.pdf", label: "Resume" }
    ]
  },
  {
    title: "Luxury Wedding Invitation",
    category: "React & Serverless",
    typeLabel: "개인 프로젝트",
    description: "모바일 환경에 최적화된 인터랙티브 디지털 청첩장 웹 애플리케이션입니다.",
    highlights: [
      "Framer Motion을 활용한 60fps 수준의 부드러운 애니메이션 구현",
      "Firebase Firestore를 이용한 방명록 및 실시간 데이터 관리",
      "Vercel/Netlify Functions를 활용한 서버리스 API 구성",
      "다양한 기기 대응을 위한 반응형 및 터치 인터랙션 최적화"
    ],
    techStack: ["React 19", "TypeScript", "Framer Motion", "Firebase", "Vite", "Netlify"],
    aiTools: ["Claude Code", "AI Studio"],
    image: "/image/wedding.png",
    links: [
      { type: 'github', url: "https://github.com/gayulz/wedding", label: "GitHub" },
      { type: 'live', url: "https://bong-yul-invitation.netlify.app/", label: "Live Site" }
    ]
  },
];

export default function Projects() {
  return (
    <Section id="projects">
      <motion.h2
        initial={{ opacity: 0, y: 20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        className="text-6xl md:text-9xl font-black text-center text-hot-pink mb-20 tracking-tighter"
      >
        PROJECTS
      </motion.h2>

      <div className="flex flex-col gap-24 w-full max-w-6xl mx-auto">
        {projects.map((project, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 50 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="group grid grid-cols-1 lg:grid-cols-12 gap-8 items-start"
          >
            {/* 좌측: 이미지 영역 */}
            <div className="lg:col-span-5 relative aspect-video lg:aspect-square rounded-2xl overflow-hidden shadow-2xl bg-zinc-900 border border-zinc-800">
              <img
                src={project.image}
                alt={project.title}
                className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110 opacity-80 group-hover:opacity-100"
              />
              <div className="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-60" />

              <div className="absolute top-4 left-4 z-10 flex flex-col gap-2">
                <span className={`px-3 py-1 rounded-full text-[10px] font-black tracking-widest shadow-md border backdrop-blur-md uppercase
                   ${project.typeLabel === '회사 프로젝트'
                    ? 'bg-blue-600/90 text-white border-blue-400'
                    : 'bg-hot-pink/90 text-white border-pink-400'
                  }`}
                >
                  {project.typeLabel}
                </span>
                {project.aiTools && (
                  <span className="px-3 py-1 rounded-full text-[10px] font-black tracking-widest shadow-md border backdrop-blur-md uppercase bg-emerald-500/90 text-white border-emerald-400 flex items-center gap-1">
                    <Sparkles size={10} /> AI Assisted
                  </span>
                )}
              </div>
            </div>

            {/* 우측: 텍스트 정보 영역 */}
            <div className="lg:col-span-7 flex flex-col pt-2">
              <div className="flex items-center gap-3 mb-4">
                <span className="w-12 h-[2px] bg-hot-pink"></span>
                <p className="text-hot-pink font-mono tracking-[0.2em] uppercase text-xs font-black">{project.category}</p>
              </div>

              <h3 className="text-4xl md:text-6xl font-black mb-6 text-white tracking-tighter group-hover:text-hot-pink transition-colors">
                {project.title}
              </h3>

              <p className="text-zinc-400 text-lg mb-8 leading-relaxed font-medium">
                {project.description}
              </p>

              {/* AI Tools (Highlight) */}
              {project.aiTools && (
                <div className="mb-6 flex flex-wrap gap-2">
                  <span className="text-xs font-bold text-emerald-400 uppercase tracking-widest flex items-center gap-2 mr-2">
                    AI Stack:
                  </span>
                  {project.aiTools.map((tool, i) => (
                    <span key={i} className="px-2 py-0.5 rounded bg-emerald-500/10 text-emerald-500 text-[10px] font-black border border-emerald-500/20 uppercase">
                      {tool}
                    </span>
                  ))}
                </div>
              )}

              {/* 핵심 성과 (Back-end focus) */}
              <div className="mb-8 space-y-3">
                <h4 className="text-zinc-200 text-sm font-bold uppercase tracking-widest mb-4 flex items-center gap-2">
                  <span className="w-1.5 h-1.5 rounded-full bg-hot-pink" /> Key Achievements
                </h4>
                <ul className="grid grid-cols-1 gap-2">
                  {project.highlights.map((item, i) => (
                    <li key={i} className="text-zinc-400 text-sm flex gap-3 items-start">
                      <span className="text-hot-pink mt-1">▹</span>
                      <span>{item}</span>
                    </li>
                  ))}
                </ul>
              </div>

              {/* 기술 스택 뱃지 */}
              <div className="flex flex-wrap gap-2 mb-10">
                {project.techStack.map((tech, i) => (
                  <span key={i} className="px-3 py-1 bg-zinc-900 border border-zinc-800 text-zinc-500 text-[11px] font-mono rounded-md group-hover:border-zinc-700 transition-colors">
                    {tech}
                  </span>
                ))}
              </div>

              {/* 링크 버튼 */}
              <div className="flex gap-4">
                {project.links.map((link, idx) => (
                  <a
                    key={idx}
                    href={link.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="group/btn relative px-6 py-3 bg-white text-black text-sm font-black flex items-center gap-2 overflow-hidden"
                  >
                    <span className="relative z-10 flex items-center gap-2">
                      {link.label} <ArrowUpRight size={16} />
                    </span>
                    <div className="absolute inset-0 bg-hot-pink translate-y-full group-hover/btn:translate-y-0 transition-transform duration-300" />
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
