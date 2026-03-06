import { motion } from "motion/react";
import Section from "./ui/Section";
import { ArrowUpRight } from "lucide-react";

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
	image: string;
	links: ProjectLink[];
}

const projects: Project[] = [
	{
		title: "레거시 시스템 현대화",
		category: "Spring Boot 3.3 마이그레이션",
		typeLabel: "회사 프로젝트",
		image: "https://picsum.photos/seed/legacy-migration/800/600",
		links: [
			{ type: 'github', url: "/gayul-kim-resume.pdf", label: "Resume" }
		]
	},
	{
		title: "수수료 정산 시스템",
		category: "Spring Boot & RabbitMQ",
		typeLabel: "개인 프로젝트",
		image: "/multi-level-fee/settlement-dashboard-lightmode.png",
		links: [
			{ type: 'github', url: "https://github.com/gayulz/multi-level-fee", label: "GitHub" }
		]
	},
	{
		title: "결혼 청첩장 웹사이트",
		category: "React & Netlify",
		typeLabel: "개인 프로젝트",
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

      <div className="flex flex-col gap-12 w-full max-w-6xl mx-auto">
        {projects.map((project, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 50 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="flex flex-col lg:flex-row gap-0 lg:gap-8 bg-white dark:bg-gray-800/30 rounded-2xl overflow-hidden shadow-xl border border-gray-100 dark:border-gray-800"
          >
            {/* 좌측: 이미지 영역 (호버 효과 유지) */}
            <div className="group relative w-full lg:w-1/2 aspect-video overflow-hidden cursor-pointer border-b lg:border-b-0 lg:border-r border-gray-100 dark:border-gray-800">
              {/* 뱃지: 회사 / 개인 */}
              <div className="absolute top-4 left-4 z-10 transition-opacity duration-300 group-hover:opacity-0">
                 <span className={`px-3 py-1.5 rounded-full text-xs font-bold tracking-widest shadow-md border backdrop-blur-md
                   ${project.typeLabel === '회사 프로젝트' 
                     ? 'bg-indigo-600/90 text-white border-indigo-400' 
                     : 'bg-hot-pink/90 text-white border-pink-400'
                   }`}
                 >
                   {project.typeLabel}
                 </span>
              </div>

              <img
                src={project.image}
                alt={project.title}
                className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-105"
              />
              {/* 호버 시 오버레이 화면 및 버튼 */}
              <div className="absolute inset-0 bg-black/50 dark:bg-black/70 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex flex-col justify-center items-center text-white p-6 backdrop-blur-sm">
                <div className="flex gap-3 justify-center flex-wrap">
                  {project.links.map((link, idx) => (
                    <a
                      key={idx}
                      href={link.url}
                      target={link.type === 'github' || link.type === 'live' ? '_blank' : undefined}
                      rel={link.type === 'github' || link.type === 'live' ? 'noopener noreferrer' : undefined}
                      download={link.type === 'github' && link.url.endsWith('.pdf') ? 'gayul-kim-resume.pdf' : undefined}
                      className="px-6 py-3 rounded-full bg-hot-pink hover:bg-hot-pink-hover transition-colors text-white text-sm font-medium flex items-center gap-2"
                    >
                      <ArrowUpRight size={18} />
                      {link.label}
                    </a>
                  ))}
                </div>
              </div>
            </div>

            {/* 우측: 텍스트 정보 영역 */}
            <div className="w-full lg:w-1/2 p-8 lg:p-12 flex flex-col justify-center">
              <h3 className="text-3xl md:text-5xl font-display font-bold mb-4 dark:text-white">{project.title}</h3>
              
              <div className="flex items-center gap-3 mb-6">
                <span className="w-8 h-px bg-hot-pink"></span>
                <p className="text-hot-pink font-mono tracking-widest uppercase text-sm font-bold">{project.category}</p>
              </div>

              <p className="text-gray-600 dark:text-gray-400 leading-relaxed font-medium">
                {project.typeLabel === '회사 프로젝트'
                  ? '안정성과 확장성에 초점을 맞추어 설계 및 개발된 실무 프로젝트 경험입니다.'
                  : '기술적 도전과 성장을 위해 진행한 개인 포트폴리오 프로젝트입니다.'}
              </p>
            </div>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
