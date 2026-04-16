import { useState, useEffect } from "react";
import { motion } from "motion/react";
import Section from "./ui/Section";
import { ExternalLink, CheckCircle, PlayCircle, Award, GraduationCap } from "lucide-react";
import { Swiper, SwiperSlide } from 'swiper/react';
import { Navigation, Pagination, A11y, Autoplay } from 'swiper/modules';
import { Document, Page, pdfjs } from 'react-pdf';
import { cn } from "../lib/utils";

// Import swiper styles
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';

// Set up react-pdf worker
pdfjs.GlobalWorkerOptions.workerSrc = `//unpkg.com/pdfjs-dist@${pdfjs.version}/build/pdf.worker.min.mjs`;

const education = [
  {
    degree: "자바기반 웹 개발자 프로그래밍 과정",
    school: "휴먼교육센터",
    period: "2023.08 — 2024.01",
    description: "과정평가형 정보처리 산업기사. Java, Spring Framework, Database 등 실무 중심의 웹 개발 기술을 학습했습니다."
  },
  {
    degree: "컴퓨터공학과 (학사)",
    school: "서울디지털대학교",
    period: "2020.06 — 2024.02",
    description: "학사 학위 취득. 컴퓨터 과학 전반에 대한 기초를 다지고 소프트웨어 개발 역량을 키웠습니다."
  }
];

const certifications = [
  {
    name: "SQL 개발자 (SQLD)",
    organization: "한국데이터산업진흥원",
    period: "2025.04",
    description: "데이터베이스 모델링, SQL 작성 및 최적화에 대한 전문성을 인정받았습니다."
  },
  {
    name: "정보처리기사",
    organization: "한국산업인력공단",
    period: "2024.09",
    description: "소프트웨어 설계, 개발, 데이터베이스 구축 및 운영에 대한 전문 지식을 검증받았습니다."
  },
  {
    name: "변액보험 판매자격",
    organization: "생명보험협회",
    period: "2018.05",
    description: "보험 상품에 대한 전문 지식과 고객 상담 능력을 검증받았습니다."
  }
];

const inflearnCourses = [
  { title: "오브젝트", author: "조영호", link: "https://biz.inflearn.com/course/%EC%98%A4%EB%B8%8C%EC%A0%9D%ED%8A%B8-%EA%B8%B0%EC%B4%88%ED%8E%B8-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5/dashboard?cid=334416", status: "in-progress" },
  { title: "김영한의 실전 자바 - 고급 1편, 멀티스레드와 동시성", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1/dashboard?cid=334352", status: "in-progress" },
  { title: "스프링 MVC 2편 - 백엔드 웹 개발 활용 기술", author: "김영한", link: "https://biz.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-2/dashboard?cid=327260", status: "in-progress" },
  { title: "자바 ORM 표준 JPA 프로그래밍 - 기본편", author: "김영한", link: "https://biz.inflearn.com/course/ORM-JPA-Basic/dashboard?cid=324109", status: "in-progress" },
  { title: "제미니의 개발실무 - 커머스 백엔드 레거시와 AI 활용편", author: "제미니", link: "https://biz.inflearn.com/course/%EC%A0%9C%EB%AF%B8%EB%8B%88%EC%9D%98-%EA%B0%9C%EB%B0%9C%EC%8B%A4%EB%AC%B4-%EB%B0%B1%EC%97%94%EB%93%9C%EB%A0%88%EA%B1%B0%EC%8B%9C-ai%ED%99%9C%EC%9A%A9/dashboard?cid=340204", status: "completed" },
  { title: "AI Agent 영어 과외 선생님과 함께하는 요즘시대 영어 학습법!", author: "Terry Lee", link: "https://biz.inflearn.com/course/ai-agent-%EA%B3%BC%EC%99%B8-%EC%84%A0%EC%83%9D%EB%8B%98%EA%B3%BC-%ED%95%A8%EA%BB%98%ED%95%98/dashboard?cid=340335", status: "completed" },
  { title: "10,000장의 이력서를 본 기술이사의 이력서 가이드", author: "제미니", link: "https://biz.inflearn.com/course/10000%EC%9E%A5%EC%9D%98-%EC%9D%B4%EB%A0%A5%EC%84%9C%EB%A5%BC-%EB%B3%B8-%EA%B8%B0%EC%88%A0%EC%9D%B4%EC%82%AC%EC%9D%98/dashboard?cid=341151", status: "completed" },
  { title: "핵심만 콕 집어주는, 무조건 토익스피킹 IM-IH 단기완성 STEP 1", author: "컨100", link: "https://biz.inflearn.com/course/%EB%AC%B4%EC%A1%B0%EA%B1%B4-%ED%86%A0%EC%9D%B5%EC%8A%A4%ED%94%BC%ED%82%B9-im-ih-1/dashboard?cid=336299", status: "completed" },
  { title: "클로드 코드 완벽 마스터: AI 개발 워크플로우 기초부터 실전까지", author: "짐코딩", link: "https://biz.inflearn.com/course/%ED%81%B4%EB%A1%9C%EB%93%9C-%EC%BD%94%EB%93%9C-%EC%99%84%EB%B2%BD-%EB%A7%88%EC%8A%A4%ED%84%B0-ai-%EA%B0%9C%EB%B0%9C/dashboard?cid=339317", status: "completed" },
  { title: "모든 개발자를 위한 HTTP 웹 기본 지식", author: "김영한", link: "https://biz.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard?cid=326277", status: "completed" },
  { title: "AI 200% 활용한 서버 개발자 이력서 작성법", author: "steve", link: "https://biz.inflearn.com/course/%EB%A9%B4%EC%A0%91%EA%B4%80%EC%9D%B4-%EC%95%8C%EB%A0%A4%EC%A3%BC%EB%8A%94-ai-200-%ED%99%9C%EC%9A%A9%ED%95%9C/dashboard?cid=338965", status: "completed" },
  { title: "코딩자율학습 제로초의 자바스크립트 입문", author: "제로초(조현영)", link: "https://biz.inflearn.com/course/%EB%A0%88%EC%B8%A0%EA%B8%B0%EB%A6%BF-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8/dashboard?cid=327126", status: "completed" },
  { title: "김영한의 실전 자바 - 중급 2편", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EC%A4%91%EA%B8%89-2/dashboard?cid=333482", status: "completed" },
  { title: "스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술", author: "김영한", link: "https://biz.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard?cid=325630", status: "completed" },
  { title: "스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술", author: "김영한", link: "https://biz.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1/dashboard?cid=326674", status: "completed" },
  { title: "김영한의 실전 자바 - 중급 1편", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EC%A4%91%EA%B8%89-1/dashboard?cid=333308", status: "completed" },
  { title: "스프링 핵심 원리 - 기본편", author: "김영한", link: "https://biz.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard?cid=325969", status: "completed" },
  { title: "김영한의 실전 자바 - 기본편", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8?cid=332506", status: "completed" },
  { title: "나도코딩의 자바 기본편 - 풀코스 (20시간)", author: "나도코딩", link: "https://biz.inflearn.com/course/%EB%82%98%EB%8F%84%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8/dashboard?cid=329986", status: "completed" },
];

const pdfCertificates = [
  { path: "/certificate-pdf/certificate-java.pdf", title: "자바 기본편" },
  { path: "/certificate-pdf/certificate-java-mid1.pdf", title: "자바 중급 1편" },
  { path: "/certificate-pdf/certificate-java-mid2.pdf", title: "자바 중급 2편" },
  { path: "/certificate-pdf/certificate-spring-basic.pdf", title: "스프링 핵심 원리" },
  { path: "/certificate-pdf/certificate-spring-mvc1.pdf", title: "스프링 MVC 1편" },
  { path: "/certificate-pdf/certificate-spring-mvc.pdf", title: "스프링 MVC 2편" },
  { path: "/certificate-pdf/certificate-http.pdf", title: "HTTP 웹 기본 지식" },
  { path: "/certificate-pdf/certificate-steve-ai.pdf", title: "AI 활용 이력서 작성" },
  { path: "/certificate-pdf/certificate-claudecode.pdf", title: "클로드 코드 마스터" },
  { path: "/certificate-pdf/certificate-english.pdf", title: "AI Agent 영어 학습" },
  { path: "/certificate-pdf/certificate-legacyAI.pdf", title: "백엔드 레거시 & AI" },
  { path: "/certificate-pdf/certificate-gemini.pdf", title: "기술이사 이력서 가이드" },
  { path: "/certificate-pdf/certificate-speaking.pdf", title: "토익스피킹 단기완성" },
];

export default function Learning() {
  const [pdfWidth, setPdfWidth] = useState(300);
  const [isExpanded, setIsExpanded] = useState(false);

  useEffect(() => {
    const handleResize = () => {
      const vw = window.innerWidth;
      if (vw < 640) {
        setPdfWidth(vw - 80);
      } else if (vw < 1024) {
        setPdfWidth((vw - 160) / 2);
      } else {
        setPdfWidth(280);
      }
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const visibleCourses = isExpanded ? inflearnCourses : inflearnCourses.slice(0, 12);

  return (
    <Section id="learning" className="bg-tech-black border-t border-white/5">
      <style dangerouslySetInnerHTML={{
        __html: `
        .swiper-pagination-bullet {
          background: rgba(255, 255, 255, 0.2) !important;
          opacity: 1 !important;
        }
        .swiper-pagination-bullet-active {
          background: #00F3FF !important;
        }
      `}} />
      <div className="max-w-[1200px] mx-auto">
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">05. Academic Trace</span>
          <h2 className="text-5xl md:text-7xl font-black text-white tracking-tighter uppercase">LEARNING</h2>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-12 gap-12 mb-32 max-w-[1200px] mx-auto">
        {/* Left: Education */}
        <div className="lg:col-span-7 space-y-12">
          <div className="flex items-center gap-4 mb-8">
            <GraduationCap className="text-neon-cyan" size={32} />
            <h3 className="text-3xl font-black text-white">Education</h3>
          </div>
          <div className="space-y-12 border-l border-white/5 pl-8 ml-4">
            {education.map((edu, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, x: -20 }}
                whileInView={{ opacity: 1, x: 0 }}
                viewport={{ once: true }}
                className="relative"
              >
                <div className="absolute left-[-36px] top-2 w-3 h-3 rounded-full bg-neon-cyan shadow-[0_0_10px_#00F3FF]" />
                <h4 className="text-xl font-bold text-white mb-2">{edu.degree}</h4>
                <div className="flex justify-between items-center mb-4">
                  <span className="mono text-[10px] text-zinc-500 uppercase tracking-widest">{edu.school}</span>
                  <span className="mono text-[10px] text-neon-cyan uppercase tracking-widest">{edu.period}</span>
                </div>
                <p className="text-zinc-400 text-sm leading-relaxed">{edu.description}</p>
              </motion.div>
            ))}

            <br />

            <br />
          </div>
        </div>

        {/* Right: Certifications */}
        <div className="lg:col-span-5 space-y-12">
          <div className="flex items-center gap-4 mb-8">
            <Award className="text-neon-cyan" size={32} />
            <h3 className="text-3xl font-black text-white">Certifications</h3>
          </div>
          <div className="space-y-4">
            {certifications.map((cert, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                className="p-6 bg-tech-gray border border-white/5 rounded-2xl hover:border-neon-cyan/30 transition-all group"
              >
                <h4 className="font-bold text-zinc-200 mb-2 group-hover:text-neon-cyan transition-colors">{cert.name}</h4>
                <div className="flex justify-between mono text-[9px] text-zinc-500 uppercase tracking-widest">
                  <span>{cert.organization}</span>
                  <span>{cert.period}</span>
                </div>
              </motion.div>
            ))}
          </div>
        </div>
      </div>

      {/* Online Courses Grid */}
      <div className="max-w-[1200px] mx-auto border-t border-white/5 pt-32 mb-32">
        <div className="flex flex-col md:flex-row justify-between items-end gap-8 mb-16">
          <div className="flex flex-col gap-4">
            <span className="mono text-neon-cyan text-[10px] uppercase tracking-[0.4em]">Continuous Growth</span>
            <h3 className="text-4xl md:text-5xl font-black text-white tracking-tight uppercase">Technical Training</h3>
          </div>
          <div className="flex gap-3">
            <span className="mono text-[9px] px-3 py-1 border border-emerald-500/30 text-emerald-500 rounded-full uppercase tracking-widest">Completed</span>
            <span className="mono text-[9px] px-3 py-1 border border-neon-cyan/30 text-neon-cyan rounded-full uppercase tracking-widest">In Progress</span>
          </div>
        </div>

        <div className="relative">
          <motion.div
            layout
            className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4"
          >
            {visibleCourses.map((course, index) => (
              <motion.a
                layout
                initial={{ opacity: 0, scale: 0.9 }}
                animate={{ opacity: 1, scale: 1 }}
                key={course.title}
                href={course.link}
                target="_blank"
                rel="noopener noreferrer"
                className={cn(
                  "p-6 bg-tech-gray border border-white/5 rounded-2xl transition-all duration-500 group",
                  course.status === 'in-progress' ? "hover:border-neon-cyan/40" : "hover:border-emerald-500/40"
                )}
              >
                <div className="flex justify-between items-center mb-6">
                  {course.status === 'in-progress' ? <PlayCircle size={20} className="text-neon-cyan" /> : <CheckCircle size={20} className="text-emerald-500" />}
                  <span className={cn(
                    "mono text-[8px] uppercase tracking-widest",
                    course.status === 'in-progress' ? "text-neon-cyan" : "text-emerald-500"
                  )}>{course.status === 'in-progress' ? "Active" : "Done"}</span>
                </div>
                <h5 className="font-bold text-zinc-200 leading-snug mb-4 h-12 line-clamp-2">{course.title}</h5>
                <span className="mono text-[9px] text-zinc-500 uppercase tracking-widest">{course.author}</span>
              </motion.a>
            ))}
          </motion.div>

          {!isExpanded && inflearnCourses.length > 12 && (
            <div className="absolute bottom-0 left-0 right-0 h-40 bg-gradient-to-t from-tech-black via-tech-black/80 to-transparent flex items-end justify-center pb-4">
              <button
                onClick={() => setIsExpanded(true)}
                className="group flex flex-col items-center gap-2 cursor-pointer"
              >
                <span className="mono text-[10px] uppercase tracking-[0.5em] text-zinc-400 group-hover:text-neon-cyan transition-colors">
                  Expand Protocol
                </span>
                <motion.div
                  animate={{ y: [0, 4, 0] }}
                  transition={{ duration: 1.5, repeat: Infinity }}
                  className="w-px h-8 bg-gradient-to-b from-neon-cyan to-transparent"
                />
              </button>
            </div>
          )}
        </div>
      </div>

      {/* PDF Slider - Improved Alignment and Interaction */}
      <div className="w-full relative px-2 max-w-[1200px] mx-auto">
        <Swiper
          modules={[Navigation, Pagination, A11y, Autoplay]}
          spaceBetween={24}
          slidesPerView={1}
          loop={true}
          autoplay={{ delay: 4000 }}
          breakpoints={{
            640: { slidesPerView: 2 },
            1024: { slidesPerView: 4 }
          }}
          navigation
          pagination={{ clickable: true }}
          className="pb-24"
          style={{ "--swiper-navigation-color": "#00F3FF", "--swiper-pagination-color": "#00F3FF" } as any}
        >
          {pdfCertificates.map((cert, index) => (
            <SwiperSlide key={index} className="flex justify-center items-center py-10">
              <div className="w-full flex flex-col group cursor-pointer">
                <div className="mb-4">
                  <span className="mono text-[9px] text-zinc-500 uppercase tracking-[0.3em] block mb-1">Verify Credential</span>
                  <h4 className="text-xs font-bold text-zinc-200 line-clamp-1 group-hover:text-neon-cyan transition-colors">{cert.title}</h4>
                </div>

                {/* PDF Card - No pink filter, clean zoom */}
                <div className="relative aspect-[1.4/1] bg-white rounded-2xl overflow-hidden shadow-2xl border border-white/5 transition-all duration-700 group-hover:scale-[1.2] group-hover:z-50 flex items-center justify-center">
                  <div className="w-full h-full flex items-center justify-center bg-white">
                    <Document
                      file={cert.path}
                      loading={<div className="flex items-center justify-center h-full text-zinc-400 mono text-[10px]">Loading</div>}
                      className="flex items-center justify-center w-full"
                    >
                      <Page
                        pageNumber={1}
                        renderTextLayer={false}
                        renderAnnotationLayer={false}
                        className="flex items-center justify-center !bg-transparent"
                        width={pdfWidth}
                      />
                    </Document>
                  </div>
                  {/* Clean Technical Border on Hover */}
                  <div className="absolute inset-0 border-2 border-transparent group-hover:border-neon-cyan/20 rounded-2xl transition-colors pointer-events-none" />
                </div>
              </div>
            </SwiperSlide>
          ))}
        </Swiper>
      </div>
    </Section>
  );
}
