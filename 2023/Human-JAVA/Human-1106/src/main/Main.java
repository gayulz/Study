package main;
import DAO.MemberDAO;
import DTO.MemberDTO;
public class Main {
    public static void main(String[] args) {
        //데이터 CRUD test code
        MemberDAO mdao=new MemberDAO();
        MemberDTO m= new MemberDTO();
        m.setName("human");
        m.setAge(33);
        m.setAddr("수원시팔달구");
        mdao.insert(m);

        //수정샘플.. human이라는 사람의 나이를 40으로 바꾼다
        MemberDTO m1=new MemberDTO();
        m1.setName("human");
        m1.setAge(10);
        mdao.mod(m1);
    }
}