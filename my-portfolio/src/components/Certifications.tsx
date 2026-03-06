import { motion } from "motion/react";
import Section from "./ui/Section";

const certifications = [
	{
		name: "SQL 개발자 (SQLD)",
		organization: "한국데이터산업진흥원",
		period: "2025.04",
		description: "SQL 개발자 자격증 취득. 데이터베이스 모델링, SQL 작성 및 최적화에 대한 전문성을 인정받았습니다."
	},
	{
		name: "정보처리기사",
		organization: "한국산업인력공단",
		period: "2024.09",
		description: "정보처리기사 자격증 취득. 소프트웨어 설계, 개발, 데이터베이스 구축 및 운영에 대한 전문 지식을 검증받았습니다."
	},
	{
		name: "변액보험 판매자격",
		organization: "생명보험협회",
		period: "2018.05",
		description: "변액보험 판매자격 취득. 변액보험 상품에 대한 전문 지식과 고객 상담 능력을 검증받았습니다."
	},
	{
		name: "생명보험, 제3보험 설계사 자격",
		organization: "생명보험협회",
		period: "2018.04",
		description: "생명보험 및 제3보험 설계사 자격 취득. 보험 상품 설계 및 고객 재무 설계 능력을 검증받았습니다."
	}
];

export default function Certifications() {
	return (
		<Section id="certifications">
			<motion.h2
				initial={{ opacity: 0, x: -20 }}
				whileInView={{ opacity: 1, x: 0 }}
				viewport={{ once: true }}
				className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
			>
				CERTIFICATIONS
			</motion.h2>

			<div className="grid grid-cols-1 md:grid-cols-2 gap-x-12 gap-y-16">
				{certifications.map((cert, index) => (
					<motion.div
						key={index}
						initial={{ opacity: 0, y: 20 }}
						whileInView={{ opacity: 1, y: 0 }}
						viewport={{ once: true }}
						transition={{ delay: index * 0.1 }}
						className="border-t-2 border-gray-200 dark:border-gray-700 pt-8 hover:border-hot-pink transition-colors duration-300"
					>
						<h3 className="text-2xl font-bold mb-1 dark:text-white">{cert.name}</h3>
						<div className="flex justify-between items-center mb-4">
							<span className="text-lg text-gray-600 dark:text-gray-400 font-medium">{cert.organization}</span>
							<span className="text-sm font-mono text-gray-400 dark:text-gray-500">{cert.period}</span>
						</div>
						<p className="text-gray-600 dark:text-gray-400 leading-relaxed">
							{cert.description}
						</p>
					</motion.div>
				))}
			</div>
		</Section>
	);
}
