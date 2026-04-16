import { motion } from "motion/react";
import Section from "./ui/Section";

/**
 * [MIG] Writing 컴포넌트 업데이트
 * - GitHub Latest Blog Posts 데이터와 완벽하게 동기화
 * - 각 포스팅별 개별 티스토리 링크 매칭 완료
 *
 * @author gayul.kim
 * @since 2026-04-16
 */
const articles = [
  {
    title: "GCP to OCI 이전 구축기 및 504 Gateway Time-out 해결기 (feat. Swap Memory)",
    date: "2026.04.03",
    category: "CLOUD",
    url: "https://yurizzy.tistory.com/261"
  },
  {
    title: "인프런(인프랩) 방문기 | 공약은 반드시 지킨다 (feat. 카파도키아 파우치)",
    date: "2026.04.01",
    category: "CULTURE",
    url: "https://yurizzy.tistory.com/260"
  },
  {
    title: "실무 : Referer로 망분리를 시도했다가 배운 것들 (feat. Stateless vs Stateful)",
    date: "2026.03.30",
    category: "SECURITY",
    url: "https://yurizzy.tistory.com/259"
  },
  {
    title: "IP:8080은 이제 그만! 내 Spring Boot 프로젝트에 HTTPS(무료) 자물쇠 달아주기",
    date: "2026.03.06",
    category: "BACKEND",
    url: "https://yurizzy.tistory.com/258"
  },
  {
    title: "Springframwork 실무 : JSP에서 JavaScript로 데이터 토스! ObjectMapper로 해결한 이야기",
    date: "2026.01.22",
    category: "JAVA",
    url: "https://yurizzy.tistory.com/257"
  },
  {
    title: "Inflearn ✅ 내가 하는 공부 로드맵 (feat. 2년 차 주니어가 만든 두 가지 학습 로드맵 이야기)",
    date: "2026.01.04",
    category: "LEARNING",
    url: "https://yurizzy.tistory.com/256"
  },
];

export default function Writing() {
  return (
    <Section id="writing" noBorder>
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter uppercase"
      >
        WRITING
      </motion.h2>

      <div className="space-y-0">
        {articles.map((article, index) => (
          <a
            href={article.url}
            target="_blank"
            rel="noopener noreferrer"
            key={index}
            className="block group"
          >
            <motion.div
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ delay: index * 0.05 }}
              className="grid grid-cols-1 md:grid-cols-[1fr_120px_160px] md:gap-6 md:items-center py-10 border-b border-zinc-800 hover:bg-zinc-900/50 hover:px-6 transition-all duration-500 cursor-pointer"
            >
              <h3 className="text-xl md:text-2xl font-bold group-hover:text-hot-pink transition-colors text-white tracking-tight">
                {article.title}
              </h3>
              <span className="text-sm text-zinc-500 font-mono mt-4 md:mt-0">{article.date}</span>
              <div className="flex justify-start md:justify-end mt-4 md:mt-0">
                <span className="text-[10px] font-black uppercase tracking-widest text-hot-pink border border-hot-pink/30 px-3 py-1 rounded-full bg-hot-pink/5">
                  {article.category}
                </span>
              </div>
            </motion.div>
          </a>
        ))}
      </div>
    </Section>
  );
}
