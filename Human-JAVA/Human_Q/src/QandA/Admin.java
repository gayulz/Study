package QandA;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO;
import DTO.DTO;

public class Admin {
    private DAO qadao = DAO.getInstance();
    private Scanner in = new Scanner(System.in);

    public Admin() {
        // 메뉴선택 코딩
        boolean flag = true;
        while (flag) {
            System.out.println("1.add 2.mod 3. del 4. list 5. search");
            int num = in.nextInt();
            in.nextLine();

            if (num == 1) {
                add();
            } else if (num == 2) {
                mod();
            } else if (num == 3) {
                del();
            } else if (num == 4) {
                list();
            } else if (num == 5) {
                search();
            }
        }
    }

    private void add() {
        DTO newQa = new DTO();
        System.out.println("작성자입력");
        String wruser = in.nextLine();
        int cnt = qadao.chkWrCnt(wruser);
        if (cnt < 2) {
            System.out.println(wruser + "님 현재 " + cnt + "건 작성하셨습니다.");
            newQa.setWr(wruser);
            System.out.println("제목입력");
            newQa.setTitle(in.nextLine());
            System.out.println("내용입력");
            newQa.setMemo(in.nextLine());
            System.out.println("비밀번호입력 4글자");
            newQa.setPass(in.nextLine());
            System.out.println("비밀글 여부 1번은 공개글 , 2번은 비밀글");
            newQa.setScret(in.nextInt());
            in.nextLine();
            qadao.insert(newQa);
        } else {
            System.out.println("한 사람이 3건 이상은 올릴 수 없습니다. ");
        }

    }

    private void search() {
        // 검색이란 ? 검색어가 있으면 결과값이 있다.
        // 기술적으로 검색어 문자열이 있으면 데이터베이스에서 조회해서
        // 한개 이상의튜플을 리턴한다.. 우리는 이렇게 분석을 해야 한다..
        System.out.println("검색어 입력 <제목검색>");
        String mtitle = in.nextLine();
        ArrayList<DTO> slist = qadao.selectSearch(mtitle);
        if (slist.size() == 0) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("총 " + slist.size() + " 건이 검색되었습니다.");
            for (DTO a : slist) {
                a.prt();
            }
        }

    }

    private void list() {
        // TODO Auto-generated method stub
        // 테이블로 부터 튜플을 보두 가져와야 한다. 튜플은 한개 이상일 수 있다.
        ArrayList<DTO> l = qadao.selectAll();
        if (l.size() != 0) {
            for (DTO a : l) {
                a.prt();
            }
        }

    }

    private void del() {
        System.out.println("삭제할 제목 입력");
        String mtitle = in.nextLine();
        DTO retunrdto = qadao.selectOne(mtitle);
        System.out.println("비밀번호를 입력하세요");
        String newPass = in.nextLine();
        if (newPass.equals(retunrdto.getPass())) {
            // db작업
            qadao.delete(mtitle);
        } else {
            System.out.println("비번틀림");
        }

    }

    private void mod() {
        System.out.println("수정할 제목 입력");
        String mtitle = in.nextLine();
        DTO retunrdto = qadao.selectOne(mtitle);
        if (retunrdto != null) {
            retunrdto.prt();
        }
        System.out.println("비밀번호를 입력하세요");
        String newPass = in.nextLine();
        if (newPass.equals(retunrdto.getPass())) {
            System.out.println("내용을 수정하세요");
            mtitle = in.nextLine();
            retunrdto.setMemo(mtitle);
            // db update
            qadao.update(retunrdto);
        } else {
            System.out.println("비밀번호 틀림");
        }

    }

}
