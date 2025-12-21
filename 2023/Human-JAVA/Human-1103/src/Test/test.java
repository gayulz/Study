package Test;

import employees_program.activeProgram.Employees;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int num = 1;
        HashMap<Integer, Employees> employessList = new HashMap<>();
        Employees em = new Employees();
        em.setEmName("가율");
        em.setEmAge(30);
        em.setEmJobTitle("사원");
        em.setEmNum(1);
        em.setEmDept("개발팀");
        employessList.put(em.getEmNum(), em);
        System.out.println(employessList.containsKey(num));


        String emNum = "사원 번호 : " + String.valueOf(em.getEmNum());
        System.out.println(emNum);

    }
}
