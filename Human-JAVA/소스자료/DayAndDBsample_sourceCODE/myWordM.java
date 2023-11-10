import DAO.DaydayDAO;
import DTO.DaydayDTO;

import java.util.Scanner;

public class myWordM {
    private Scanner in;
    private DaydayDAO daydao;

    public WordM() {
        this.in = new Scanner(System.in);
        this.daydao = new DaydayDAO();
        boolean flag = true;

        while (flag) {
            System.out.println("1.add 2.mod 3.del 4.list");
            int selNum = this.in.nextInt();
            this.in.nextLine();
            if (selNum == 1) {
                this.add();
            } else if (selNum == 2) {
                this.mod();
            } else if (selNum == 3) {
                this.del();
            } else if (selNum == 4) {
                this.list();
            }
        }

    }

    private void list() {
    }

    private void del() {
    }

    private void mod() {
        System.out.println("수정할 제목을 입력하세요");
        String sTitle = this.in.nextLine();
        DTO nowDay = this.daydao.oneSelect(sTitle);
        System.out.println(nowDay.getMemo() + "/" + nowDay.getTitle());
    }

    private void add() {
        System.out.println("일정을 추가하세요");
        DTO addday = new DTO();
        addday.setTitle(this.in.nextLine());
        addday.setMemo(this.in.nextLine());
        this.daydao.add(addday);
    }
}
