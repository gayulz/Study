import { motion } from "motion/react";
import Section from "./ui/Section";

const experiences = [
  {
    role: "Senior UX/UI Designer",
    company: "SuperCo",
    period: "2019 — Present",
    description: "Led the redesign of the flagship mobile application, resulting in a increase in user retention within six months."
  },
  {
    role: "UI/UX Designer",
    company: "BlendXYZ",
    period: "2016 — 2017",
    description: "Collaborated with the development team to implement a responsive design approach, increasing mobile app engagement."
  },
  {
    role: "Lead Product Designer",
    company: "CocoBasic",
    period: "2017 — 2019",
    description: "Designed and implemented creative solutions such as wellness app and high-traffic e-commerce websites."
  },
  {
    role: "Junior Designer",
    company: "Internstum",
    period: "2015 — 2016",
    description: "Internship and starting position in creative team as Junior Designer. Focused on creating wireframes."
  }
];

export default function Experience() {
  return (
    <Section id="experience" className="bg-gray-50">
      <motion.h2 
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        EXPERIENCE
      </motion.h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-x-12 gap-y-16">
        {experiences.map((exp, index) => (
          <motion.div 
            key={index}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="border-t-2 border-gray-200 pt-8 hover:border-hot-pink transition-colors duration-300"
          >
            <h3 className="text-2xl font-bold mb-1">{exp.role}</h3>
            <div className="flex justify-between items-center mb-4">
              <span className="text-lg text-gray-600 font-medium">{exp.company}</span>
              <span className="text-sm font-mono text-gray-400">{exp.period}</span>
            </div>
            <p className="text-gray-600 leading-relaxed">
              {exp.description}
            </p>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
