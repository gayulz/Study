package Project;

import java.util.Scanner;

public class Exe {

    Scanner in = new Scanner(System.in);
    // 멤버 변수선언
    String[][] movieList = new String[10][2];

    // 생성자
    public Exe() {
        boolean flag = true;
        while (flag) {
            info();
            System.out.print("번호를 입력하세요 : ");
            int inPutNum = in.nextInt();
            in.nextLine();
            switch (inPutNum) {
                case 1: // 컨텐츠 입력기능
                    inContent();
                    break;
                case 2: // 컨텐츠 수정 기능
                    editContent();
                    break;
                case 3: // 컨텐츠 삭제 기능
                    System.out.println("삭제된 컨텐츠 이름 : [" + deleteContent() + "] 입니다");
                    System.out.println();
                    break;
                case 4: // 컨텐츠 검색 기능
                    searchContent();
                    break;
                case 5: // 저장된 전체 컨텐츠 검색
                    totalContent();
                    break;
                case 6: // 종료기능
                    flag = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        }

    }

    // 입력 작업 메서드
    public void inContent() {
        System.out.print("입력할 컨텐츠 이름 : ");
        String contentName = in.nextLine();
        System.out.print("컨텐츠가 등록된 OTT이름 : ");
        String contentOtt = in.nextLine();
        for (int i = 0; i < 10; i++) {
            if (movieList[i][0] == null) {
                movieList[i][0] = contentName;
                movieList[i][1] = contentOtt;
                break;
            }
        }
        System.out.println();
    }

    // 수정 작업 메서드

    public void editContent() {
        String tmpC = "";
        String tmpO = "";
        boolean flag = true;
        boolean ckeck = true;
        while (flag) {
            System.out.println("1 : 컨텐츠 이름 수정\t2 : 컨텐츠의 OTT 이름 수정");
            System.out.print("번호를 입력하세요 >> ");
            int searchNum = in.nextInt();
            in.nextLine();
            System.out.println();
            if (searchNum == 1) {
                System.out.print("변경 전 컨텐츠 이름 입력 : ");
                tmpC = in.nextLine();
                System.out.print("변경 후 컨텐츠 이름 입력 : ");
                tmpO = in.nextLine();
                for (int j = 0; j < 10; j++) {
                    if (movieList[j][0] != null) {
                        if (movieList[j][0].equals(tmpC)) {
                            System.out.println(" >> 변경 전 [" + movieList[j][0] + "]\t 변경 후 [" + tmpO + "] ");
                            movieList[j][0] = tmpO;
                            flag = false;
                            ckeck = false;
                            break;
                        }
                    }
                }
            } else if (searchNum == 2) {
                System.out.print("등록된 OTT를 변경 할 컨텐츠 이름 입력 : ");
                tmpC = in.nextLine();
                System.out.print("변경 후 OTT 입력 : ");
                tmpO = in.nextLine();
                for (int j = 0; j < 10; j++) {
                    if (movieList[j][0] != null) {
                        if (movieList[j][0].equals(tmpC)) {
                            System.out.println(" >> 변경 전 [" + movieList[j][1] + "]\t 변경 후 [" + tmpO + "] ");
                            movieList[j][1] = tmpO;
                            flag = false;
                            ckeck = false;
                            break;
                        }
                    }
                }
            }
        }
        if (ckeck == false){
            System.out.println("처리 완료 되었습니다.");
        } if (ckeck == true) {
            System.out.println("요청하신 작업에 오류가 있어 처리하지 못했습니다.");
        }
        System.out.println();
    }

    // 삭제 기능 메서드
    public String deleteContent() {
        System.out.print("삭제할 컨텐츠 이름을 입력하세요 : ");
        String contentName = in.nextLine();
        for (int i = 0; i < 10; i++) {
            if (movieList[i][0] != null) {
                if (movieList[i][0].equals(contentName)) {
                    movieList[i][0] = null;
                    movieList[i][1] = null;
                    break;
                }
            }
        }
        return contentName;
    }

    // 검색 기능 메서드
    public void searchContent() {
        System.out.print("검색할 영화 이름 : ");
        String searchName = in.nextLine();
        System.out.print("\t >> ");
        for (int i = 0; i < 10; i++) {
            if (movieList[i][0] != null) {
                if (movieList[i][0].equals(searchName)) {
                    System.out.println("검색한 [" + movieList[i][0] + "] 컨텐츠는 [" + movieList[i][1] + "]에서 시청가능합니다.");
                    break;
                }
            }
        }
        System.out.println();
    }

    // 전체 보기 메서드
    public void totalContent() {
        System.out.println();
        System.out.println("전체 컨텐츠 및 OTT 리스트 보기");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". 이름 : " + movieList[i][0] + "\n>> 저장된 OTT 정보 : " + movieList[i][1]);
            System.out.println();
        }
        System.out.println();
    }

    // 사용법 메서드
    public void info() {
        System.out.println("----------[          영화 컨텐츠와 영화컨텐츠가 등록된 OTT를 관리하는 프로그램            ]---------- ");
        System.out.println("----------[ 1. 입력(10개만 가능) | 2. 수정 | 3. 삭제 | 4. 검색 | 5. 전체보기 | 6. 종료 ]----------");
    }


}
