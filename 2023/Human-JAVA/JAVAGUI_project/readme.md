![image](https://github.com/gayulz/Study/assets/109029219/7c20949c-ed3b-466b-8167-4491a5d3e9bf)

&nbsp;
&nbsp;

<h1 align="center"> 🐶 반려동물과 함께 가는 숙소 찾기 🐈 </h1>
<h2 align="center"> JAVA Swing, awt를 사용한 GUI 프로젝트 </h2>

&nbsp;
&nbsp;

## 👩🏻‍💻 개발 인원
> 1인 개발 

&nbsp;
&nbsp;

## 🚀 프로젝트 기간
> 2023.11.20 ~ 2023.12.01

&nbsp;
&nbsp;

## 📋 프로젝트 개요
> 반려동물과 같이 사는 가족분들은 여행을 떠날 때 애완호텔이나 가족분께 맡겨놓는 일이 많습니다.  
> 이유는 애완동물과 입실이 가능한 숙소를 찾기 어려움이 있어 보통 보호를 맡기곤 합니다     
> 이 부분에 목적을 두고 반려동물과 같이 숙박 가능한 곳을 연계하는 컨셉으로 진행 하였습니다.    
> 🔗 [너만가냥나도가게_발표PDF_Link](https://github.com/gayulz/Study/blob/main/Human-JAVA/statePatten_project/%EB%84%88%EB%A7%8C%EA%B0%80%EB%83%A5%EB%82%98%EB%8F%84%EA%B0%80%EA%B0%9C_JAVAGUI_%EA%B9%80%EA%B0%80%EC%9C%A8.pdf)    

&nbsp;
&nbsp;

## 🚧 개발 환경 
### JAVA 8 version 
- JAVA의 기본 라이브러리인 javax.swing , java.awt를 사용하여 GUI 구현   
- State Pattern을 적용하여 객체 상태에 따라 보여주는 Panel을 변경하도록 구현 
- JFrame을 갖는 RemoteControl 클래스를 중심으로 인터페이스를 통해 Panel을 JFrame위로 새로 그리는 방식을 적용   
- CRUD를 위한 Sql resources는 Driver와 Connection 클래스를 분리 해 DAO패키지 객체들이 Connection클래스를 상속 받아 리소스 사용을 확장 시킴    
- Driver는 프로그램 실행 시 1번만 호출 되도록 별도 클래스로 분리 시킴   
- 프로시저 호출 및 결과값 반환을 위해 CURSOR 사용 
- GUI를 구성 하기 위해 폰트나 기능 메서드를 별도 클래스로 분리 시켜 코드 반복을 줄임    

&nbsp;
&nbsp;

### oracle-xe-11g  
- 함수형 프로시저를 구현 하여 java에서 호출 로직을 좀 더 간결하게 구현 함   
- 매번 달라지는 숙소 검색 조건을 함수형 프로시저를 통해 매개변수로 받아 처리할 수 있도록 구현
- 숙소 예약 시 Insert 문이 2번 실행 되야 하는 로직을 프로시저 1번으로 Customer테이블과 bookingList 테이블에 순서대로 저장 되도록 구현

&nbsp;
&nbsp;

### Tools
- IntelliJ : 주요 코드 작성을 intelliJ에서 진행 함
- docker : M1 macbook환경에 oracle을 사용하며 동일한 작업환경을 위해 image를 다운 받아 container를 실행 하여 환경 구축을 함 
- DBeaver, Sql developer : DBeaver에서는 안되는 명령어(desc나 프로시저 호출 call)이 있어 두가지 툴을 모두 다 사용 함 

&nbsp;
&nbsp;

## 👀 배운 점 
- String 자료형과 StringBuilder 자료형의 차이를 공부함   
- 프로시저를 구현 하면서 PL/SQL문법을 좀더 깊게 공부한 계기가 됨    
- 비슷하게 느껴졌던 상속과 인터페이스가 어떤 차이인지 알게 됨 
- oracle의 프로시저를 사용 할 시 java에서 어떤 문법을 써야 하는지 알게 됨   
&nbsp;
&nbsp;
## 😱 아쉬운 점 
- 프로젝트 규모에 비해 프로시저를 깊게 하지 않아도 됬을 것 같다는 아쉬운 점   
좋은 경험은 되었으나 프로젝트 기간 2주동안 1주일동안 DB설계 및 구현에 매달린게 너무 아쉬움
- 프로시저를 사용 함으로써 성능이 최적화 되는 줄 알았으나 꼭 그런게 아닌 것에 대한 피드백을 받았을 때 아직 잘 모르는게 맞구나, 개발자는 몇 수 앞까지 봐야하는지 고민하는 계기가 됨 

&nbsp;

---
