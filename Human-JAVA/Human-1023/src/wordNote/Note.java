package wordNote;
import java.util.Scanner;
// 영단어 Note 프로그램
public class Note {
    Scanner in = new Scanner(System.in);
    Words[] wordsNote = new Words[30];
    Functions fnc = new Functions();

    Note() {
        boolean flag = true;
        while (flag) {
            // 단어장 프로그램 소개
            info();
            System.out.println("\n=====================================");
            System.out.print(" 메뉴 선택 >> ");
            int user = in.nextInt();
            in.nextLine();
            switch (user) {
                case 1: // 1번 입력
                    addWord();
                    break;
                case 2: // 2번 수정
                    editWord();
                    break;
                case 3: // 3번 삭제
                    delWord();
                    break;
                case 4: // 4번 검색
                    searchWord();
                    break;
                case 5: // 5번 전체보기
                    viewWord();
                    break;
                case 6: // 종료
                    flag = false;
                    break;
                default:
                    System.out.println("다시 입력 해 주세요");
            }
        }
    }

    // info 5번 전체보기 메서드
    private void viewWord() {
        System.out.println("입력된 영단어 노트 전체 내용 입니다");
        for (int i = 0; i < wordsNote.length; i++) {
            if (wordsNote[i] != null && wordsNote[i].krWord != null) {
                wordsNote[i].prt();
            }
        }
    }
    // info 4번 검색 메서드
    private void searchWord() {
        System.out.println("검색할 내용을 선택 해 주세요");
        fnc.loopFnc(wordsNote);
    }
    // info 3번 삭제 메서드
    private void delWord() {
        System.out.println("삭제할 단어의 분류를 선택하세요");
        Words w = fnc.pickFun(wordsNote);
        for (int i = 0; i < wordsNote.length; i++) {
            if (wordsNote[i] != null ) {
                if (w.equals(wordsNote[i])) {
                    wordsNote[i].prt();
                    System.out.println(" >> [ " + wordsNote[i].krWord + " ] 삭제 완료 ");
                    wordsNote[i] = new Words();
                    w = null;
                    break;
                }
            }
        }
    }

    // info 2번 수정 메서드
    private void editWord() {
        System.out.println("단어를 수정하겠습니다 . 수정할 단어를 찾겠습니다");
        // pickFun 메서드는 수정을 원하는 단어를 찾아 해당 Words 객체를 반환하는 메서드입니다 .
        // 반환값의 주소(wordsNote[인덱스번호])를 w변수에 값 복사를 하여 대입
        Words w = fnc.pickFun(wordsNote);
        System.out.println("[ "+ w.krWord + " ]수정할 내용를 선택하세요");
        System.out.println("1. Level\t2. 한글 단어\t3. 영어 단어");
        System.out.print(" 메뉴 번호 입력 >> ");
        int user = in.nextInt();
        in.nextLine();
        switch (user) {
            case 1:
                System.out.print("수정될 Level 입력 >>  ");
                int level = in.nextInt();
                in.nextLine();
                w.stage = level;
                System.out.println("\t\t[ 변경 후 ]");
                w.prt();
                w = null;
                break;
            case 2:
                System.out.print("수정될 한글 단어 입력 >>  ");
                String editKor = in.nextLine();
                w.krWord = editKor;
                System.out.println("\t\t[ 변경 후 ]");
                w.prt();
                w = null;
                break;
            case 3:
                System.out.print("수정될 영어 단어 입력 >>  ");
                String editEng = in.nextLine();
                w.engWord = editEng;
                System.out.println("\t\t[ 변경 후 ]");
                w.prt();
                w = null;
                break;
            default:
                System.out.println("입력된 번호는 확인할 수 없는 범위입니다.");
        }
    }
    // info 1번 입력 메서드
    private void addWord() {
        // 단어 입력
        Words w = new Words();
        System.out.println("lv 1 : 쉬운단어");
        System.out.println("lv 2 : 국가 및 지역명");
        System.out.println("lv 3 : 동사");
        System.out.print(" 레벨 입력 >> ");
        int level = in.nextInt();
        in.nextLine();
        w.stage = level;
        System.out.print("영어 단어 입력 >> ");
        String eng = in.nextLine();
        w.engWord = eng;
        System.out.print("한글 단어 입력 >> ");
        String kor = in.nextLine();
        w.krWord = kor;
        for (int i = 0; i < wordsNote.length; i++) {
            if (wordsNote[i] == null && fnc.duplicateString(wordsNote, w.engWord)) {
                wordsNote[i] = w;
                break;
            } else if (wordsNote[i] != null &&!(fnc.duplicateString(wordsNote, w.engWord))) {
                System.out.println("영단어가 중복되었거나 잘못된 등록 방식입니다 다시 시도해주세요");
                break;
            } else if(wordsNote[i] == null) continue;
        }
        w = null;
    }
    private void info() {
        System.out.println("\n=====================================");
        System.out.println("단어장 프로그램");
        System.out.println("1. 단어 입력\t2. 단어 수정\t3. 단어 삭제\t4. 단어 검색\t5. 전체 보기\t6. 노트 종료");
    }
}
