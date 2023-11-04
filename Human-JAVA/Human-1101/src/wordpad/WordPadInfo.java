package wordpad;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class WordPadInfo {
    private Scanner in = new Scanner(System.in);
    private HashMap<String, Word> wordList = new HashMap<>();
    private Word w = null;

    private ArrayList<String> gameWord = new ArrayList<>();

    public WordPadInfo() {
        boolean flag = true;
        while (flag) {
            info();
            int userNum = in.nextInt();
            in.nextLine();
            switch (userNum) {
                case 1: // 단어 등록
                    addWord();
                    break;
                case 2: // 단어 검색
                    searchWord();
                    break;
                case 3: // 단어 삭제
                    delWord();
                    break;
                case 4: // 단어 전체 보기
                    totalWord();
                    break;
                case 5: // 단어 맞추기 게임
                    gameStart();
                    break;
                case 6:
                    System.out.println("프로그램 종료");
                    flag = false;
                    break;
                default:
                    System.out.println("등록된 번호가 아닙니다. 다시 입력하세요");
            }
        }
    }

    private void gameStart() {
        Random r = new Random();
        for (String key : wordList.keySet()) {
            gameWord.add(key);
        }
        System.out.println("영단어 맞추기 게임입니다. 시작 희망시 Enter");
        in.nextLine();
        int cnt = 0;
        while (cnt < 5) {
            String taskStr = gameWord.get(r.nextInt(wordList.size() - 1) + 1);
            char[] randomChar = new char[taskStr.length()];
            for (int i = 0; i < randomChar.length; i++) { randomChar[i] = taskStr.charAt(r.nextInt(taskStr.length()/2)+1);}
            System.out.print(" 문제 : ");
            for (int i = 0; i < taskStr.length(); i++) {
                char tmp = taskStr.charAt(i);
                if (tmp == randomChar[i]) System.out.print("*");
                else System.out.print(tmp);
            }
            String userText = inputString(" 정답").toUpperCase();
            if (taskStr.toUpperCase().equals(userText)) {
                System.out.println("정답입니다");
                cnt++;
            } else System.out.println("오답입니다");
        }

    }

    // 영어 단어 전체 보기
    private void totalWord() {
        System.out.println("전체 단어 보기 입니다");
        for (String key : wordList.keySet()) {
            w = finderWord(key);
            wordPrt(w, key);
        }
    }

    // 영어 단어 삭제
    private void delWord() {
        System.out.println("단어 삭제 입니다");
        String engWord = inputString("삭제 할 영어 단어");
        if (finderWord(engWord) != null) {
            wordList.remove(engWord);
            System.out.println(engWord + " 단어 삭제 완료");
        } else System.out.println(engWord + " 해당 단어는 찾을 수 없습니다");
    }

    // 단어 검색 기능
    private void searchWord() {
        System.out.println("단어 검색 메뉴 입니다");
        String engWord = inputString("검색 영단어");
        if (finderWord(engWord) != null) {
            w = finderWord(engWord);
            wordPrt(w, engWord);
        } else System.out.println(engWord + " 단어는 검색 할 수 없습니다. ");
    }

    // 단어장 추가 메서드
    private void addWord() {
        w = new Word();
        int point = Integer.parseInt(inputString("중요도 : 상 3 / 중 2 / 하 1 "));
        String engWord = inputString("영어 단어");
        if (finderWord(engWord) == null) {
            System.out.println("한글 단어 등록 횟수 (최소1 ~ 최대 5회)");
            int loopNum = Integer.parseInt(inputString("단어 횟수"));
            if (loopNum <= 5 && loopNum >= 1) {
                for (int i = 0; i < loopNum; i++) {
                    String korWord = inputString("한글 단어");
                    w.setKorWordList(korWord);
                    w.setPoint(point);
                    wordList.put(engWord, w);
                }
                System.out.println("중요도 [ "+point +" ]\n\t"+engWord +" 정상 등록 되었습니다");
            } else System.out.println("최소 1회 , 최대 5회까지 가능합니다.");
        } else System.out.println("해당 단어는 이미 등록된 단어입니다");
    }

    // 입출력 메서드
    private String inputString(String text) {
        System.out.print(text + "입력 >> ");
        return in.nextLine();
    }

    // 매개변수 : w 주소값 , hashmap단어 -> 출력 메서드
    private void wordPrt(Word w, String engWord) {
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < w.getPoint(); i++) {
            star.append("*");
        }
        System.out.println("영어 단어 : " + engWord + "[ " + star + " ]");
        for (int i = 0; i < w.getKorWordList().size(); i++) {
            System.out.println("한글 단어 : " + w.getKorWordList().get(i));
        }
        System.out.println("--------------------------------------");
    }

    // 매개변수 : hash key단어 -> 리턴 key의 value
    private Word finderWord(String engWord) {
        if (wordList.get(engWord) != null) return w = wordList.get(engWord);
        return null;
    }

    // 인포 메서드
    public void info() {
        System.out.println(" 메뉴 : 1. 등록 , 2. 검색 , 3. 삭제 , 4. 전체보기 , 5. 단어맞추기 게임 , 6. 종료 ");
        System.out.print(" 번호 입력 >> ");
    }
}
