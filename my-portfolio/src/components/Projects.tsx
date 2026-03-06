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
	image: string;
	links: ProjectLink[];
}

const projects: Project[] = [
	{
		title: "수수료 정산 시스템",
		category: "Spring Boot & RabbitMQ",
		image: "/settlement-dashboard.png",
		links: [
			{ type: 'github', url: "https://github.com/gayulz/multi-level-fee", label: "GitHub" }
		]
	},
	{
		title: "결혼 청첩장 웹사이트",
		category: "React & Netlify",
		image: "https://picsum.photos/seed/wedding-invitation/800/600",
		links: [
			{ type: 'github', url: "https://github.com/gayulz/wedding", label: "GitHub" },
			{ type: 'live', url: "https://bong-yul-invitation.netlify.app/", label: "Live Site" }
		]
	},
	{
		title: "레거시 시스템 현대화",
		category: "Spring Boot 3.3 마이그레이션",
		image: "https://picsum.photos/seed/legacy-migration/800/600",
		links: [
			{ type: 'github', url: "/gayul-kim-resume.pdf", label: "Resume" }
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

      <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
        {projects.map((project, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 50 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="group relative aspect-video bg-gray-100 dark:bg-gray-800 overflow-hidden rounded-xl cursor-pointer"
          >
            <img
              src={project.image}
              alt={project.title}
              className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110"
            />
            <div className="absolute inset-0 bg-black/40 dark:bg-black/60 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex flex-col justify-center items-center text-white p-6 text-center backdrop-blur-sm">
              <h3 className="text-3xl font-display uppercase mb-2">{project.title}</h3>
              <p className="text-sm font-mono tracking-widest uppercase mb-6">{project.category}</p>

              {/* 다중 링크 버튼 */}
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
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
