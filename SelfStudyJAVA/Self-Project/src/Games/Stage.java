package Games;

import java.util.Random;

public class Stage {
    public String[][] border = new String[25][40];
    static final String[] stage1 = {"한글", "대한민국", "마을", "경찰차", "낙석", "도로", "횡단보도", "영광", "미담", "수성", "금성", "목성", "목사", "기독교", "불교", "천주교", "교회", "성당", "토성", "천왕성", "등산", "공사", "추월", "금일봉", "월급", "회사", "도긴개긴", "낙장불입", "생존", "공무원", "오른쪽", "왼쪽", "휘발유", "등유", "신호등", "지하차도", "교체로", "횡단보도", "도청", "시청", "민간", "대한", "회관", "자동차", "전기자동차", "차선", "주차선", "표지판", "물병", "안식", "휴식", "전기", "전봇대", "나무", "공원", "대문", "대로변", "고속도로", "국도", "종달새", "종말", "사고", "노루", "비", "미끄럼틀", "국제", "영양사", "기술자", "운전자", "정수리", "탈모", "모발", "가발", "비듬", "손톱", "발톱", "손톱깍기", "미용실", "우동", "라면", "바리깡", "정조", "선조", "인조", "광해군", "고종", "국보", "독립운동", "독립", "해방", "국가", "태극기", "모기", "직장인", "취업", "사장님", "벌꿀", "농장", "농부", "공장", "영양", "양양", "양식", "양벌", "의심", "의식주", "주가변동", "공시시가", "주식", "배당금", "주주", "한국은행", "국민은행", "신한은행", "기업은행", "채권", "대부", "발행",};
    static final String[] stage2 = {"Dynamic", "Emotional", "shape", "desk", "bookshelf", "library", "school", "assignment", "YouTube", "Attack", "Classes", "Movie theaters", "Manufacturer", "fish", "Meat", "horse", "Kindergarten", "Provider", "center", "left", "Right", "Ascending", "Descending", "Databases", "Holder", "Subject", "Object", "Markets", "Watch", "watch", "Eavesdropping", "Hacker", "technicians", "January", "February", "March", "April", "May", "June", "July", "Aug.", "September", "October", "November", "December", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Basketball", "Soccer", "Volleyball", "Tennis", "Badminton", "Bowling", "Baseball", "Golf", "Sensory", "Calculators", "Reading", "Handwriting", "Practical", "Goodwill", "Desire", "control", "method", "Rationale", "Profit", "Structure", "Model", "Lean", "fat", "large", "reason", "national", "personal", "law", "Prosecutor", "judge", "prosecutor", "Cryptography", "money", "Banks", "Stocks", "Bonds", "Treasury Bonds", "News", "Birthday", "Photographers", "Novelist", "Filmmaker", "Drama", "Cartoon", "Spacecraft", "Space", "galaxies", "stars", "Singer", "Earth", "forest", "air", "tree", "Sea", "Moon", "Responsibility", "Possibilities", "property", "Joke", "life", "waste", "Tesla", "Invasion", "Emergency", "War", "World War", "Evacuation Orders", "Orders", "Tomorrow", "Days ago", "Evacuation", "Flee", "Population", "inhabit", "alive", "escape", "sandcastle", "pyramid", "political", "presidential", "National", "Dictatorship", "Civilian", "protection", "land", "remain", "they", "public opinion", "endeavor", "sympathize", "is best", "cost", "fear", "refugees", "Peninsula", "Warning", "Worst case", "scenarios", "Entry", "Others", "Worst case scenario", "Declaration of war", "Terrorist", "Animals", "Human", "Give Time", "military", "Exit", "specific", "leaflet", "to spray", "evacuation road", "live", "broadcast", "electricity", "internet", "Shock", "Medicine", "Media", "Humanitarian", "Pacifist", "Embassies", "Borders", "Refugees", "bomb", "nuclear bomb", "damage", "devastation", "hell", "preemptive strike", "First Strike", "reserve", "Standing Army", "Militia", "Air Force", "Navy", "Army", "Hand-to-hand combat", "Tank", "Bullet", "Devastating", "tunnel", "elaborate", "to organize",};
    static final String[] stage3 = {"역동적이다", "감성", "모양", "책상", "책장", "도서관", "학교", "과제", "유튜브", "공격", "학급", "영화관", "제조사", "물고기", "육고기", "말", "유치원", "공급자", "중앙", "왼쪽", "오른쪽", "오름차순", "내림차순", "데이터베이스", "보유자", "주체", "객체", "시장", "시청", "시계", "도청", "해커", "기술자", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일", "농구", "축구", "배구", "테니스", "배드민턴", "볼링", "야구", "골프", "감각", "계산기", "독서", "필기", "실기", "선의", "욕망", "제어", "방법", "명분", "수익", "구조", "모델", "빈약하다", "뚱뚱하다", "대장", "이유", "국가", "개인", "법", "검사", "판사", "검사", "암호", "화폐", "은행", "주식", "채권", "국채", "뉴스", "생일", "사진작가", "소설작가", "영화감독", "드라마", "만화", "우주선", "우주", "은하", "별", "가수", "지구", "숲", "공기", "나무", "바다", "달", "책임", "가능성", "재산", "농담", "인생", "낭비", "테슬라", "침공", "비상", "전쟁", "세계전쟁", "대피령", "명령", "내일", "몇일전", "대피", "도망", "인구", "거주하다", "살아있다", "탈출", "모래성", "피라미드", "정치", "대통령", "국가대표", "독재", "민간인", "보호", "땅", "남아있다", "그들", "여론", "노력하다", "공감하다", "최선이다", "비용", "두렵다", "난민", "반도", "경고", "최악", "시나리오", "입장", "타인", "최악의 시나리오", "전쟁선포", "테러리스트", "동물", "인간", "시간을 주다", "군대", "출구", "특정", "전단지", "살포하다", "피난도로", "실시간", "방송", "전기", "인터넷", "충격", "의약품", "언론", "인도주의적", "평화주의적", "대사관", "국경", "피난민들", "폭탄", "핵폭탄", "피해를 입다", "초토화", "지옥", "선제공격", "일촉즉발", "예비군", "상비군", "민병대", "공군", "해군", "육군", "시가전", "탱크", "총탄", "참혹하다", "터널", "정교하다", "구성하다"};
    static int stageNum = 1;


    public static String[] question = new String[10];
    public static String[] kQuestion = new String[10];
    public static int[] questionNumber = new int[10];

    // 스테이지별 문제 랜덤 출제를 위한 배열 처리
    public static void StageQuestion(int stageNum) {
        Random r = new Random();
        switch (stageNum) {
            case 1:
                for (int i = 0; i < question.length; i++) {
                    questionNumber[i] = r.nextInt(stage1.length - 1);
                    question[i] = stage1[questionNumber[i]];
                }
                break;
            case 2:
                for (int i = 0; i < question.length; i++) {
                    questionNumber[i] =r.nextInt(stage2.length - 1);
                    question[i] = stage2[questionNumber[i]];
                }
                break;
            default:
                for (int i = 0; i < question.length; i++) {
                    questionNumber[i] = r.nextInt(stage3.length - 1);
                    question[i] = stage3[questionNumber[i]];
                    kQuestion[i] = stage2[questionNumber[i]];
                }
                break;
        }
    }
//    public static void main(String[] args) {
//        StageQuestion(3);
//        for (int i = 0; i < question.length; i++) {
//            System.out.println(question[i] + " : " + kQuestion[i] + " : "+ questionNumber[i]);
//        }
//    }
}
