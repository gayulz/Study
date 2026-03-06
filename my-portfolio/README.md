<div align="center">
  <h1>✨ Gayul Kim | Backend Developer Portfolio ✨</h1>
  <p>안정적이고 확장 가능한 백엔드 아키텍처를 설계하는 개발자입니다.</p>

[![Deploy with Vercel](https://vercelbutton.com/api/button.svg)](https://gayul.vercel.app/)

**[🌐 포트폴리오 웹사이트 바로가기](https://gayul.vercel.app/)**

</div>

## 🧑🏻‍💻 About Me

안녕하세요! 문제 해결을 즐기고, 코드의 가독성과 유지보수성을 중요하게 생각하는 주니어 백엔드 개발자 **김가율**입니다.

단순히 기능이 동작하는 것에 만족하지 않고, **'읽기 좋은 코드(Readability)'**, **'안정성(Stability)'**, **'성능 최적화(Performance)'**, 그리고 **'테스트 용이성(Testability)'** 이라는 핵심 원칙을 바탕으로 시스템을 구축해 나가고 있습니다. 레거시 마이그레이션부터 큐(Queue)를 활용한 대용량 정산 엔진까지, 다양한 비즈니스 요구사항을 기술적으로 풀어나가는 데 관심이 많습니다.

## 🚀 Live Demo

현재 Vercel을 통해 글로벌 CI/CD 파이프라인으로 배포되어 있습니다. 어서 오셔서 작업물들을 구경해 보세요!
👉 **[https://gayul.vercel.app](https://gayul.vercel.app/)**

## 🛠 Tech Stack

### Backend

- **Java 17, Spring Boot 3.3.2**
- **JPA / QueryDSL**
- **PostgreSQL**, RabbitMQ
- Lombok, MapStruct

### Frontend & UI (Portfolio Web)

- React, Vite, TypeScript
- Tailwind CSS, Framer Motion
- Three.js / React Three Fiber

### DevOps & Tools

- Git, GitHub
- Vercel (Auto-Deployment CI/CD)
- Formspree (Serverless Contact Form)

## 💻 Projects Overview

1. **레거시 시스템 마이그레이션 및 현대화 (Legacy System Modernization)**
   - 노후화된 레거시 코드를 최신 Spring Boot 환경(`GW_v3` 아키텍처)으로 안전하게 이관하고 구조를 고도화하는 프로젝트
   - DTO 변환 레이어 분리 및 핵심 비즈니스 로직 유지보수성 향상
2. **트리 기반 다단계 정산 엔진 (Fee Settlement System)**
   - 복잡한 계층 구조를 가진 수수료 정산 로직을 RabbitMQ 메시지 브로커와 연동하여 빠르고 정확하게 비동기 처리하는 안정적인 백엔드 시스템 구축
3. **모바일 청첩장 웹사이트 (Wedding Invitation Website)**
   - 감성적인 UI/UX(마이크로 애니메이션 등)와 함께 서버 트래픽을 처리하는 웹 애플리케이션 프로젝트

## ⚙️ Running Locally (Portfolio Project)

이 포트폴리오 UI/UX 프로젝트를 로컬 시스템에서 바로 실행하고 확인해 볼 수 있습니다.

```bash
# 1. 저장소 클론
git clone https://github.com/gayulz/Study.git
cd Study/my-portfolio

# 2. 패키지 설치
npm install

# 3. 개발 서버 실행
npm run dev
```

> 💡 **Contact Form 세팅 안내:**
> `src/components/Contact.tsx` 파일 속 Formspree endpoint URL을 본인 계정의 ID로 교체하시면 즉시 라이브로 메일링 연동 기능을 사용하실 수 있습니다.

<br />
<div align="center">
  <i>"Crafted with ❤️ by Gayul Kim"</i><br />
  <a href="mailto:gayulz@kakao.com">gayulz@kakao.com</a>
</div>
