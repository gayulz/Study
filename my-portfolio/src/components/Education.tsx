import { motion } from "motion/react";
import Section from "./ui/Section";

const education = [
  {
    degree: "Master of Arts in Interaction Design",
    school: "Stanford University",
    period: "2012 — 2014",
    description: "Specialized in user research, interaction design, user interface, digital and graphic design."
  },
  {
    degree: "Bachelor of Science in Computer Science",
    school: "University of California, Berkeley",
    period: "2008 — 2012",
    description: "Gained a solid foundation in software development overall. Focused on building mobile applications."
  },
  {
    degree: "Diploma in Graphic Design",
    school: "San Francisco Design Institute",
    period: "2007 — 2008",
    description: "Focused on typography and digital design skills."
  },
  {
    degree: "Art School",
    school: "San Francisco Design Institute",
    period: "2006 — 2007",
    description: "Acquired fundamental graphic design skills. Gained basic knowledge of design in general."
  }
];

export default function Education() {
  return (
    <Section id="education" className="bg-white">
      <motion.h2 
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        EDUCATION
      </motion.h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-x-12 gap-y-16">
        {education.map((edu, index) => (
          <motion.div 
            key={index}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="border-t-2 border-gray-200 pt-8 hover:border-hot-pink transition-colors duration-300"
          >
            <h3 className="text-2xl font-bold mb-1">{edu.degree}</h3>
            <div className="flex justify-between items-center mb-4">
              <span className="text-lg text-gray-600 font-medium">{edu.school}</span>
              <span className="text-sm font-mono text-gray-400">{edu.period}</span>
            </div>
            <p className="text-gray-600 leading-relaxed">
              {edu.description}
            </p>
          </motion.div>
        ))}
      </div>
    </Section>
  );
}
