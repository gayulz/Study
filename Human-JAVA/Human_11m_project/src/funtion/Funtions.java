package funtion;

import DTO.MembersDTO;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

import static infoDesk.Info.getMemberList;

public class Funtions {
    Scanner in = new Scanner(System.in);
    private ArrayList<MembersDTO> memberList = getMemberList();
    private MembersDTO prMember = null;



    // 기존 회원 정보배열에 id와 pw가 일치시 해당 회원객체를 리턴해주는 메서드
    public MembersDTO isMappingMember(String id , String pw) {
        for (MembersDTO isMember : memberList) {
            if (isMember.getId().equals(id)) {
                if (isMember.getPw().equals(pw)) return isMember;
            }
        }
        return null;
    }

    public void memberInfoPrt(MembersDTO member){
        this.prMember = member;
        System.out.println("-------------< Information >-------------");
        System.out.println("  I     D : " + prMember.getId());
        System.out.println("  P     W : " + prMember.getPw());
        System.out.println("  N A M E : " + prMember.getName());
        System.out.println("P O I N T : " + prMember.getPoint());
    }


    // 입력 문자열 리턴 메서드
    public String OutText(String text) {
        System.out.print("\t" + text + " 입력 >> ");
        return in.nextLine();
    }
}
