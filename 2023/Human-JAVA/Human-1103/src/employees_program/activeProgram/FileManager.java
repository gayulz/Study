package employees_program.activeProgram;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static employees_program.activeProgram.AcitveEmplyoeeProgram.getEmployessList;

public class FileManager {
    private HashMap<Integer, Employees> employeesList = getEmployessList();
    private ArrayList<String> outEmInfo = null;
    private Employees em = null;

    FileManager() {
        fileCreate();
    }

    private void fileCreate() {
        Functions fn = new Functions();
        fileInfo();
        boolean choic = (Integer.parseInt(fn.returnText("번호")) == 1) ? true : false;
        fn.prtDeptAndJobTitle("부서");
        // 조회할 부서명 입력
        String deptTitle = fn.returnText("부서");
        if (fn.compareDept(deptTitle)) {
            File file = null;
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                // File에 입력될 내용을 List형식으로 등록함으로 List 생성
                outEmInfo = new ArrayList<>();
                file = new File(deptTitle + ".txt");
                fw = new FileWriter(file, choic);
                bw = new BufferedWriter(fw);
                // employeesList <key 사번, value Employees> value값 가져오는 반복문
                for (Integer key : employeesList.keySet()) {
                    this.em = employeesList.get(key);
                    // 입력한 부서명과 등록된 사원들 중 부서명이 일치한 사원이 확인하는 판단문
                    if (employeesList.get(key).getEmDept().equals(deptTitle)) {
                        // 부서명 동일한 Employees 대상의 정보를 txt파일에 입력되기 전 작업
                        emReturnList(em);
                        // 파일에 저장하는 작업
                        for (String writeText : outEmInfo) {
                            bw.write(writeText);
                            bw.write("\n");
                        }
                    }
                }
                bw.flush();
                System.out.println(" [ " + deptTitle + " ] 추출 완료");
            } catch (IOException e) { throw new RuntimeException(e);
            } catch (Exception ee) {ee.printStackTrace();
            } finally {
                try { bw.close();
                } catch (IOException e) { throw new RuntimeException(e);}
            }
        }
    }

    // txt파일 정보 입력 시 내용을 보기 쉽도록 처리하는 메서드
    private ArrayList<String> emReturnList(Employees tmpEm) {
        this.outEmInfo = new ArrayList<>();
        this.em = tmpEm;
        String[] outGuides = {"사원 번호 : ", "이    름 : ", "나    이 : ", "부    서 : ", "직    위 : "};
        String[] emInfo = {String.valueOf(em.getEmNum()), em.getEmName(), String.valueOf(em.getEmAge()), em.getEmDept(), em.getEmJobTitle()};
        for (int i = 0; i < emInfo.length; i++) {
            outEmInfo.add(outGuides[i] + emInfo[i]);
        }
        outEmInfo.add("------------------------------");
        return outEmInfo;
    }

    private void fileInfo() {
        System.out.println("부서별 사원 정보를 txt 파일로 만들어 저장합니다.");
        System.out.println("부서명이 파일명으로 자동 생성 됩니다");
        System.out.println("1번 : 기존 txt 파일 내용 유지 및 현재 기록 추가");
        System.out.println("2번 : 기존 txt 파일 내용 삭제 후 현재 상태로 기록 작성");
    }
}
