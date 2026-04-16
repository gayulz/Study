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
    degree: "컴퓨터공학과 (학사)",
    school: "서울디지털대학교",
    period: "2020.06 — 2024.02",
    description: "학사 학위 취득. 컴퓨터 과학 전반에 대한 기초를 다지고 소프트웨어 개발 역량을 키웠습니다."
  },
  {
    degree: "자바기반 웹 개발자 프로그래밍 과정",
    school: "휴먼교육센터",
    period: "2023.08 — 2024.01",
    description: "과정평가형 정보처리 산업기사. Java, Spring Framework, Database 등 실무 중심의 웹 개발 기술을 학습했습니다."
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
  // 수강중
  { title: "오브젝트", author: "조영호", link: "https://biz.inflearn.com/course/%EC%98%A4%EB%B8%8C%EC%A0%9D%ED%8A%B8-%EA%B8%B0%EC%B4%88%ED%8E%B8-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5/dashboard?cid=334416", status: "in-progress" },
  { title: "김영한의 실전 자바 - 고급 1편, 멀티스레드와 동시성", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1/dashboard?cid=334352", status: "in-progress" },
  { title: "스프링 MVC 2편 - 백엔드 웹 개발 활용 기술", author: "김영한", link: "https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1/dashboard?cid=334352", status: "in-progress" },
  { title: "자바 ORM 표준 JPA 프로그래밍 - 기본편", author: "김영한", link: "https://biz.inflearn.com/course/ORM-JPA-Basic/dashboard?cid=324109", status: "in-progress" },
  // 수료 완료
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

  useEffect(() => {
    const handleResize = () => {
      const vw = window.innerWidth;
      if (vw < 640) {
        setPdfWidth(vw - 80);
      } else if (vw < 1024) {
        setPdfWidth((vw - 160) / 2);
      } else {
        setPdfWidth(280); // 4열 그리드 너비에 최적화
      }
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  return (
    <Section id="learning">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter uppercase"
      >
        Learning & Credentials
      </motion.h2>

      <div className="grid grid-cols-1 lg:grid-cols-12 gap-16 mb-24">
        {/* Left: Education Timeline (60%) */}
        <div className="lg:col-span-7">
          <h3 className="text-3xl font-bold mb-10 dark:text-white flex items-center gap-3">
            <GraduationCap className="text-hot-pink" /> Education
          </h3>
          <div className="space-y-12 relative">
            <div className="absolute left-0 top-2 bottom-0 w-[1px] bg-zinc-800" />
            {education.map((edu, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, x: -20 }}
                whileInView={{ opacity: 1, x: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className="relative pl-8"
              >
                <div className="absolute left-[-4.5px] top-2 w-2.5 h-2.5 rounded-full bg-hot-pink" />
                <h4 className="text-xl font-bold mb-1 text-white">{edu.degree}</h4>
                <div className="flex justify-between items-center mb-3">
                  <span className="text-sm font-medium text-zinc-400">{edu.school}</span>
                  <span className="text-[11px] font-mono text-zinc-500 uppercase tracking-wider">{edu.period}</span>
                </div>
                <p className="text-zinc-400 text-sm leading-relaxed">
                  {edu.description}
                </p>
              </motion.div>
            ))}
          </div>
        </div>

        {/* Right: Certifications (40%) */}
        <div className="lg:col-span-5">
          <h3 className="text-3xl font-bold mb-10 dark:text-white flex items-center gap-3">
            <Award className="text-hot-pink" /> Certifications
          </h3>
          <div className="space-y-6">
            {certifications.map((cert, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className="bg-zinc-900/40 p-5 rounded-xl border border-zinc-800 hover:border-hot-pink/30 transition-all group"
              >
                <h4 className="font-bold text-zinc-100 mb-1 group-hover:text-hot-pink transition-colors">{cert.name}</h4>
                <div className="flex justify-between text-[11px] font-mono text-zinc-500 mb-2 uppercase tracking-tighter">
                  <span>{cert.organization}</span>
                  <span>{cert.period}</span>
                </div>
                <p className="text-zinc-500 text-xs leading-relaxed">
                  {cert.description}
                </p>
              </motion.div>
            ))}
          </div>
        </div>
      </div>

      {/* 인프런 수료증 및 온라인 강의 */}
      <motion.div
        initial={{ opacity: 0, y: 20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        className="pt-16 border-t border-zinc-900"
      >
        <div className="flex flex-col lg:flex-row justify-between items-start lg:items-end gap-6 mb-12">
          <div>
            <h3 className="text-3xl font-black mb-4 dark:text-white uppercase tracking-tighter">Continuous Learning</h3>
            <p className="text-zinc-400 text-lg max-w-2xl font-medium leading-relaxed">
              "지속적인 성장을 위해 꾸준히 개발 지식을 학습하고 적용하는 성장형 개발자입니다."
            </p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-500/10 text-emerald-500 text-[10px] font-black uppercase rounded-full border border-emerald-500/20">Course Completion</span>
            <span className="px-3 py-1 bg-hot-pink/10 text-hot-pink text-[10px] font-black uppercase rounded-full border border-hot-pink/20">In-Progress</span>
          </div>
        </div>

        {/* 인프런 강의 그리드 */}
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4 mb-16">
          {inflearnCourses.map((course, index) => (
            <a
              key={index}
              href={course.link}
              target="_blank"
              rel="noopener noreferrer"
              className={cn(
                "flex flex-col gap-3 p-5 rounded-2xl bg-zinc-900/30 transition-all group border border-zinc-800 shadow-xl",
                course.status === 'in-progress' ? "hover:border-hot-pink/30 hover:bg-hot-pink/5" : "hover:border-emerald-500/30 hover:bg-emerald-500/5"
              )}
            >
              <div className="flex justify-between items-center">
                {course.status === 'in-progress'
                  ? <PlayCircle className="w-6 h-6 text-hot-pink" />
                  : <CheckCircle className="w-6 h-6 text-emerald-500" />
                }
                <span className={cn(
                  "text-[9px] font-black px-1.5 py-0.5 rounded uppercase",
                  course.status === 'in-progress' ? "bg-hot-pink/10 text-hot-pink" : "bg-emerald-500/10 text-emerald-500"
                )}>
                  {course.status === 'in-progress' ? "수강중" : "수료완료"}
                </span>
              </div>
              <h5 className={cn(
                "font-bold text-zinc-100 transition-colors leading-snug text-sm line-clamp-2 h-10",
                course.status === 'in-progress' ? "group-hover:text-hot-pink" : "group-hover:text-emerald-500"
              )}>
                {course.title}
              </h5>
              <div className="mt-auto flex items-center justify-between text-zinc-500 text-[9px] font-mono uppercase tracking-widest">
                <span>{course.author}</span>
                <ExternalLink size={12} className="opacity-0 group-hover:opacity-100 transition-opacity" />
              </div>
            </a>
          ))}
        </div>

        {/* PDF Certificate Slider */}
        <div className="w-full relative px-2">
          <Swiper
            modules={[Navigation, Pagination, A11y, Autoplay]}
            spaceBetween={20}
            slidesPerView={1}
            loop={true}
            autoplay={{
              delay: 4000,
              disableOnInteraction: false,
            }}
            breakpoints={{
              640: {
                slidesPerView: 2,
                spaceBetween: 24,
              },
              1024: {
                slidesPerView: 4, // 상단 그리드와 일치
                spaceBetween: 24,
              },
            }}
            navigation
            pagination={{ clickable: true }}
            className="w-full h-auto pb-16"
            style={{
              "--swiper-navigation-color": "#ff69b4",
              "--swiper-pagination-color": "#ff69b4",
            } as any}
          >
            {pdfCertificates.map((cert, index) => (
              <SwiperSlide key={index} className="flex justify-center items-center py-10 px-4">
                <div className="w-full flex flex-col group cursor-pointer">
                  {/* 상단 라벨: 강의 제목 노출로 구분감 부여 */}
                  <div className="mb-4 px-1">
                    <span className="text-[10px] font-black text-hot-pink uppercase tracking-[0.2em] block mb-1">Inflearn Certificate</span>
                    <h4 className="text-sm font-bold text-zinc-100 line-clamp-1 group-hover:text-hot-pink transition-colors">
                      {cert.title}
                    </h4>
                  </div>
                  
                  <div className="relative bg-white rounded-xl overflow-hidden shadow-2xl border border-zinc-800 transition-all duration-500 group-hover:scale-[1.2] group-hover:z-50 group-hover:shadow-[0_30px_60px_rgba(255,105,180,0.3)] flex flex-col justify-center items-center">
                    <div className="w-full flex justify-center items-center bg-white min-h-[180px] overflow-hidden">
                      <Document
                        file={cert.path}
                        loading={<div className="flex justify-center items-center h-[180px] bg-zinc-900 text-zinc-700 font-mono text-[10px] uppercase tracking-widest w-full">Loading...</div>}
                        error={<div className="flex justify-center items-center h-[180px] bg-zinc-900 text-red-900 font-mono text-[10px] uppercase tracking-widest w-full">Error</div>}
                        className="flex justify-center items-center w-full"
                      >
                        <Page
                          pageNumber={1}
                          renderTextLayer={false}
                          renderAnnotationLayer={false}
                          className="flex justify-center items-center !bg-transparent"
                          canvasBackground="transparent"
                          width={pdfWidth}
                        />
                      </Document>
                    </div>
                  </div>
                </div>
              </SwiperSlide>
            ))}
          </Swiper>
        </div>
      </motion.div>
    </Section>
  );
}
