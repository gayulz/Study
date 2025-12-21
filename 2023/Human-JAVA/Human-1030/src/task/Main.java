package task;

public class Main {
    public static void main(String[] args) {
        String a ="The only wat to do great work is to love what you do";

        // 문제1
        // 알파벳 a 가 몇개인지 카운딩하시오

        int charCnt =0;
        for (int i = 0; i < a.length(); i++) {
            char tmp = a.charAt(i);
            if (tmp == 'a') charCnt +=1;
        }
        System.out.println("문제 1 : a의 갯수 >>  " + charCnt); // a 의 갯수 총 3개

        // 문제 2-1 indexof를 이용하여
        // do라는 단어가 몇 개인지 카운팅 하시오
        int finderString = a.indexOf("do");
        int finderCnt = 0;
        while ( finderString >= 0 ) {
            finderCnt++;  //카운팅 누적
            finderString = a.indexOf("do" , finderString+1); // 인덱스번호 갱신
        }
        System.out.println("문제 2-1 : indexOf 이용한 do 문자열 찾기 갯수 >> " + finderCnt);

        // 문제 2-2 charAt를 이용하여
        // do라는 단어가 몇 개인지 카운팅 하시오

        char[] arrayTmp = a.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arrayTmp.length; i++) {
            if ( i+1 < arrayTmp.length ){
                if ( arrayTmp[i] == 'd' && arrayTmp[i+1] == 'o') cnt++;
            }
        }
        System.out.println("문제 2-2 : charAt을 이용한 do 문자열 찾기 갯수 >> " + cnt);

        // 문제3 전체 길이를 구하시오
        System.out.println( "문제 3 : 문자열 a 의 전체 길이 >>  " + a.length());


        // 문제4
        // g로 시작되는 단어를 출력하고 그 길이를 구하시오
        // 4-1. charAt, subString 사용
        int atStart = 0;
        int atEnd = 0;
        for (int i = 0; i < a.length(); i++) {
            char tmp = a.charAt(i);
            if (tmp == 'g') atStart = i;
            if (tmp == 32 && i > a.indexOf("g")){
                atEnd = i;
                break;
            }
        }
        System.out.println("문제 4-1 : g로 시작되는 단어를 출력하고 그 길이를 구하시오 >> " + a.substring(atStart,atEnd) + " 길이 : " + a.substring(atStart,atEnd).length());


        // 문제4
        // g로 시작되는 단어를 출력하고 그 길이를 구하시오
        // 4-2. indexof, subString 사용
        int startIdx = a.indexOf('g');
        String minusString = a.substring(startIdx);
        int spaceIdx = minusString.indexOf(32);
        minusString = minusString.substring(0, spaceIdx);
        System.out.println("문제 4-2 : a 문자열 중 g로 시작하는 단어 (great) 의 길이 >> " + minusString.length());



        // 문제 5
        // do 라는 글자를 does로 바꾸시오 (제한 없음)
        System.out.println("문제 5");
        System.out.println("원래 문장 : " + a);
        System.out.println("does로 변경한 문장 " + a.replaceAll("do", "does"));


        // 문제 6
        // greate 단어를 찾아 대문자로 바꾸시오
        System.out.println("문제 6");
        System.out.println("원래 문장 : " + a);
        System.out.println("great만 대문자로 변환 >> " + a.replaceAll("great" , "GREATE"));

        // 문제 6번 다른 방식
        String newMinuseString = "";
        for (int i = 0; i < minusString.length(); i++) {
            char tmp = minusString.charAt(i);
            tmp -= 32;
            newMinuseString += tmp;
        }
//        System.out.println(newMinuseString);  대문자로 변환
        System.out.println(a.substring(0, a.indexOf('g')) + newMinuseString + a.substring(a.indexOf('g')+newMinuseString.length()));

    }
}

