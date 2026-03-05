import { motion } from "motion/react";
import Section from "./ui/Section";

export default function About() {
  return (
    <Section id="about" className="relative overflow-hidden">
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">
        {/* Text Content */}
        <motion.div 
          initial={{ opacity: 0, x: -50 }}
          whileInView={{ opacity: 1, x: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
        >
          <h2 className="text-6xl md:text-9xl font-black text-hot-pink mb-8 tracking-tighter">
            ABOUT
          </h2>
          <p className="text-xl md:text-2xl leading-relaxed font-light text-gray-800 mb-6">
            My passion lies in the intersection of art and technology, creating visually captivating interfaces and elevating overall user digital experiences.
          </p>
          <p className="text-gray-600 leading-relaxed mb-8">
            I hold a Bachelor of Technology in Computer Science from the esteemed Art University and a Master of Fine Arts in Interactive Design. This academic foundation has equipped me with a solid understanding of the principles that underpin effective interaction design.
          </p>
          
          {/* Skills */}
          <div className="space-y-6">
            {[
              { name: "Framer", level: "92%" },
              { name: "Illustrator", level: "74%" },
              { name: "React", level: "88%" },
            ].map((skill) => (
              <div key={skill.name} className="bg-blue-50 p-4 rounded-lg flex justify-between items-center border-l-4 border-hot-pink">
                <span className="font-bold text-lg">{skill.name}</span>
                <span className="text-hot-pink font-mono">{skill.level}</span>
              </div>
            ))}
          </div>
        </motion.div>

        {/* Image Placeholder */}
        <motion.div 
          initial={{ opacity: 0, scale: 0.9 }}
          whileInView={{ opacity: 1, scale: 1 }}
          viewport={{ once: true }}
          transition={{ duration: 0.8 }}
          className="relative aspect-[3/4] bg-gray-200 rounded-2xl overflow-hidden shadow-2xl"
        >
          <img 
            src="https://picsum.photos/seed/portfolio/800/1200" 
            alt="Profile" 
            className="object-cover w-full h-full grayscale hover:grayscale-0 transition-all duration-500"
          />
          <div className="absolute inset-0 bg-hot-pink/10 mix-blend-overlay pointer-events-none" />
        </motion.div>
      </div>
    </Section>
  );
}
