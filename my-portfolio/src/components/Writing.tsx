import { motion } from "motion/react";
import Section from "./ui/Section";

/**
 * [MIG] Writing 컴포넌트 - oryzo.ai 'Abstract' 스타일 반영
 * - 기술 문서 목록과 같은 정갈하고 엔지니어링 감성이 느껴지는 레이아웃
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
const articles = [
  {
    title: "OKTA SAML 로그인 무한 루프 디버깅기 (feat. 백엔드·프론트 환장의 콜라보)",
    date: "2026.04.17",
    category: "Security",
    url: "https://yurizzy.tistory.com/262"
  },
  {
    title: "GCP to OCI 이전 구축기 및 504 Gateway Time-out 해결기 (feat. Swap Memory)",
    date: "2026.04.03",
    category: "Cloud Engineering",
    url: "https://yurizzy.tistory.com/261"
  },
  {
    title: "인프런(인프랩) 방문기 | 공약은 반드시 지킨다 (feat. 카파도키아 파우치)",
    date: "2026.04.01",
    category: "Tech Culture",
    url: "https://yurizzy.tistory.com/260"
  },
  {
    title: "실무 : Referer로 망분리를 시도했다가 배운 것들 (feat. Stateless vs Stateful)",
    date: "2026.03.30",
    category: "Security Architecture",
    url: "https://yurizzy.tistory.com/259"
  },
  {
    title: "IP:8080은 이제 그만! 내 Spring Boot 프로젝트에 HTTPS(무료) 자물쇠 달아주기",
    date: "2026.03.06",
    category: "Backend Deployment",
    url: "https://yurizzy.tistory.com/258"
  },
  {
    title: "Springframwork 실무 : JSP에서 JavaScript로 데이터 토스! ObjectMapper로 해결한 이야기",
    date: "2026.01.22",
    category: "Fullstack Engineering",
    url: "https://yurizzy.tistory.com/257"
  },
];

export default function Writing() {
  return (
    <Section id="writing" className="bg-tech-black border-t border-white/5">
      <div className="max-w-[1200px] mx-auto">
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">06. Knowledge Base</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter uppercase">WRITING</h2>
        </div>
      </div>

      <div className="max-w-[1000px] mx-auto space-y-0">
        {articles.map((article, index) => (
          <a
            href={article.url}
            target="_blank"
            rel="noopener noreferrer"
            key={index}
            className="group block border-b border-white/5 last:border-0"
          >
            <motion.div
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ delay: index * 0.05 }}
              className="grid grid-cols-1 md:grid-cols-[120px_1fr] gap-6 items-center py-12 px-4 group-hover:bg-tech-gray transition-all duration-500"
            >
              <span className="mono text-[10px] text-zinc-500 uppercase tracking-widest">{article.date}</span>
              <h3 className="text-xl md:text-2xl font-bold text-zinc-200 group-hover:text-neon-cyan transition-colors tracking-tight">
                {article.title}
              </h3>
            </motion.div>
          </a>
        ))}
      </div>
    </Section>
  );
}
