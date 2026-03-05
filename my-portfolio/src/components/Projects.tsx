import { motion } from "motion/react";
import Section from "./ui/Section";
import { ArrowUpRight } from "lucide-react";

const projects = [
  { title: "E-Commerce Redesign", category: "UX/UI Design", image: "https://picsum.photos/seed/project1/800/600" },
  { title: "Finance Dashboard", category: "Web Development", image: "https://picsum.photos/seed/project2/800/600" },
  { title: "Travel App", category: "Mobile App", image: "https://picsum.photos/seed/project3/800/600" },
  { title: "Portfolio V1", category: "Branding", image: "https://picsum.photos/seed/project4/800/600" },
];

export default function Projects() {
  return (
    <Section id="projects" className="bg-white">
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
            className="group relative aspect-video bg-gray-100 overflow-hidden rounded-xl cursor-pointer"
          >
            <img 
              src={project.image} 
              alt={project.title} 
              className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110"
            />
            <div className="absolute inset-0 bg-black/40 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex flex-col justify-center items-center text-white p-6 text-center backdrop-blur-sm">
              <h3 className="text-3xl font-display uppercase mb-2">{project.title}</h3>
              <p className="text-sm font-mono tracking-widest uppercase mb-6">{project.category}</p>
              <div className="w-12 h-12 rounded-full bg-hot-pink flex items-center justify-center">
                <ArrowUpRight className="text-white" />
              </div>
            </div>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
