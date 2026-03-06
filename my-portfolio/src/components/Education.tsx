import { useState, useEffect } from "react";
import { motion } from "motion/react";
import Section from "./ui/Section";
import { ExternalLink, CheckCircle, PlayCircle } from "lucide-react";
import { Swiper, SwiperSlide } from 'swiper/react';
import { Navigation, Pagination, A11y, Autoplay } from 'swiper/modules';
import { Document, Page, pdfjs } from 'react-pdf';

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

const certificates = [
  "/certificate-pdf/certificate-java.pdf",
  "/certificate-pdf/certificate-java-mid1.pdf",
  "/certificate-pdf/certificate-java-mid2.pdf",
  "/certificate-pdf/certificate-spring-basic.pdf",
  "/certificate-pdf/certificate-spring-mvc1.pdf",
  "/certificate-pdf/certificate-spring-mvc.pdf",
  "/certificate-pdf/certificate-http.pdf",
  "/certificate-pdf/certificate-steve-ai.pdf",
  "/certificate-pdf/certificate-claudecode.pdf",
];

export default function Education() {
  const [pdfWidth, setPdfWidth] = useState(800);
  
  useEffect(() => {
    const handleResize = () => {
      const vw = window.innerWidth;
      if (vw < 768) {
        setPdfWidth(vw - 80); // 모바일은 1장
      } else if (vw < 1024) {
        setPdfWidth((vw - 120) / 2); // 태블릿은 2장
      } else {
        setPdfWidth(320); // 데스크톱은 3장 보이도록 축소
      }
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  return (
    <Section id="education">
      <motion.h2
        initial={{ opacity: 0, x: -20 }}
        whileInView={{ opacity: 1, x: 0 }}
        viewport={{ once: true }}
        className="text-5xl md:text-7xl font-black text-hot-pink mb-16 tracking-tighter"
      >
        EDUCATION
      </motion.h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-x-12 gap-y-16 mb-20">
        {education.map((edu, index) => (
          <motion.div
            key={index}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ delay: index * 0.1 }}
            className="border-t-2 border-gray-200 dark:border-gray-700 pt-8 hover:border-hot-pink transition-colors duration-300"
          >
            <h3 className="text-2xl font-bold mb-1 dark:text-white">{edu.degree}</h3>
            <div className="flex justify-between items-center mb-4">
              <span className="text-lg text-gray-600 dark:text-gray-400 font-medium">{edu.school}</span>
              <span className="text-sm font-mono text-gray-400 dark:text-gray-500">{edu.period}</span>
            </div>
            <p className="text-gray-600 dark:text-gray-400 leading-relaxed">
              {edu.description}
            </p>
          </motion.div>
        ))}
      </div>

      {/* 인프런 수료증 슬라이더 (PDF 뷰어) */}
      <motion.div
        initial={{ opacity: 0, y: 20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        className="border-t-2 border-gray-200 dark:border-gray-700 pt-16"
      >
        <h3 className="text-3xl font-bold mb-4 dark:text-white text-left">인프런 학습 수료증</h3>
        
        {/* 학습/성장 관련 문구 및 강의 링크 목록 */}
        <div className="mb-12">
          <p className="text-gray-600 dark:text-gray-300 text-lg mb-8 leading-relaxed font-medium">
            "지속적인 성장을 위해 꾸준히 개발 지식을 학습하고 적용하는 성장형 개발자입니다."
          </p>
          
          <div className="space-y-3 w-full">
            <h4 className="text-sm font-bold text-gray-500 dark:text-gray-400 mb-4 px-1 uppercase tracking-wider">최근 수료완료 / 수강중 강의</h4>
            
            <a 
              href="https://biz.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1/dashboard?cid=334352"
              target="_blank"
              rel="noopener noreferrer"
              className="flex items-center gap-4 p-4 rounded-xl bg-gray-50 dark:bg-gray-800/40 hover:bg-hot-pink/5 hover:dark:bg-hot-pink/10 transition-colors group border border-transparent hover:border-hot-pink/30"
            >
              <PlayCircle className="w-6 h-6 text-hot-pink shrink-0" />
              <div className="flex-1 flex flex-col sm:flex-row sm:items-center gap-2">
                <span className="text-[11px] font-bold px-2 py-0.5 rounded bg-hot-pink/10 text-hot-pink w-fit">수강중</span>
                <h5 className="font-bold text-gray-900 dark:text-gray-100 group-hover:text-hot-pink transition-colors text-sm sm:text-base">
                  김영한의 실전 자바 - 고급 1편, 멀티스레드와 동시성
                </h5>
              </div>
              <ExternalLink className="w-4 h-4 text-gray-400 group-hover:text-hot-pink shrink-0 opacity-0 group-hover:opacity-100 transition-opacity" />
            </a>

            <a 
              href="https://biz.inflearn.com/course/%ED%81%B4%EB%A1%9C%EB%93%9C-%EC%BD%94%EB%93%9C-%EC%99%84%EB%B2%BD-%EB%A7%88%EC%8A%A4%ED%84%B0-ai-%EA%B0%9C%EB%B0%9C/dashboard?cid=339317"
              target="_blank"
              rel="noopener noreferrer"
              className="flex items-center gap-4 p-4 rounded-xl bg-gray-50 dark:bg-gray-800/40 hover:bg-emerald-500/5 hover:dark:bg-emerald-500/10 transition-colors group border border-transparent hover:border-emerald-500/30"
            >
              <CheckCircle className="w-6 h-6 text-emerald-500 shrink-0" />
              <div className="flex-1 flex flex-col sm:flex-row sm:items-center gap-2">
                <span className="text-[11px] font-bold px-2 py-0.5 rounded bg-emerald-500/10 text-emerald-500 w-fit">수료완료</span>
                <h5 className="font-bold text-gray-900 dark:text-gray-100 group-hover:text-emerald-500 transition-colors text-sm sm:text-base">
                  클로드 코드 완벽 마스터: AI 개발 워크플로우 기초부터 실전까지
                </h5>
              </div>
              <ExternalLink className="w-4 h-4 text-gray-400 group-hover:text-emerald-500 shrink-0 opacity-0 group-hover:opacity-100 transition-opacity" />
            </a>

            <a 
              href="https://biz.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC?cid=326277"
              target="_blank"
              rel="noopener noreferrer"
              className="flex items-center gap-4 p-4 rounded-xl bg-gray-50 dark:bg-gray-800/40 hover:bg-emerald-500/5 hover:dark:bg-emerald-500/10 transition-colors group border border-transparent hover:border-emerald-500/30"
            >
              <CheckCircle className="w-6 h-6 text-emerald-500 shrink-0" />
              <div className="flex-1 flex flex-col sm:flex-row sm:items-center gap-2">
                <span className="text-[11px] font-bold px-2 py-0.5 rounded bg-emerald-500/10 text-emerald-500 w-fit">수료완료</span>
                <h5 className="font-bold text-gray-900 dark:text-gray-100 group-hover:text-emerald-500 transition-colors text-sm sm:text-base">
                  모든 개발자를 위한 HTTP 웹 기본 지식
                </h5>
              </div>
              <ExternalLink className="w-4 h-4 text-gray-400 group-hover:text-emerald-500 shrink-0 opacity-0 group-hover:opacity-100 transition-opacity" />
            </a>
          </div>
        </div>

        <div className="w-full">
          <Swiper
            modules={[Navigation, Pagination, A11y, Autoplay]}
            spaceBetween={20}
            slidesPerView={1}
            centeredSlides={true}
            loop={true}
            autoplay={{
              delay: 3000,
              disableOnInteraction: false,
            }}
            breakpoints={{
              768: {
                slidesPerView: 2,
                spaceBetween: 30,
              },
              1024: {
                slidesPerView: 3,
                spaceBetween: 40,
              },
            }}
            navigation
            pagination={{ clickable: true }}
            className="w-full h-auto pb-12"
            style={{
              "--swiper-navigation-color": "#ff69b4",
              "--swiper-pagination-color": "#ff69b4",
            } as any}
          >
            {certificates.map((cert, index) => (
              <SwiperSlide key={index} className="flex justify-center items-center transition-transform duration-300 hover:scale-[1.02] py-4">
                <div className="w-fit h-fit bg-white rounded-xl overflow-hidden shadow-md border border-gray-200 dark:border-gray-700">
                  <Document 
                    file={cert} 
                    loading={<div className="flex justify-center items-center h-[200px] text-gray-400 px-10">Loading PDF...</div>}
                    error={<div className="flex justify-center items-center h-[200px] text-red-500 px-10">Failed to load PDF.</div>}
                  >
                    <Page 
                      pageNumber={1} 
                      renderTextLayer={false} 
                      renderAnnotationLayer={false}
                      className="flex justify-center [&>.react-pdf__Page__canvas]:!my-0 [&>.react-pdf__Page__canvas]:!mx-auto"
                      width={pdfWidth}
                    />
                  </Document>
                </div>
              </SwiperSlide>
            ))}
          </Swiper>
        </div>
      </motion.div>
    </Section>
  );
}
