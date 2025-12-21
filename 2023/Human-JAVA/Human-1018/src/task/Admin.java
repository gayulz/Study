package task;

public class Admin {
    public Admin(){
        writer("휴먼이즈 롸잇나우");
        System.out.println("----------------------------------");
        add(1000,3);
        System.out.println("----------------------------------");
        System.out.println("입력된 값의 합산 : " + add(5,5,5) + " 입니다");
    }

    public void writer(String name){
        System.out.print("개발자 이름 : " + name);
        System.out.println();
        System.out.println(name + "의 개발자가 만들었습니다");
    }

    public void add(int in1, int in2){
        System.out.println("입력된 값 1 : " + in1 + "\t입력된 값 2 : " + in2);
        System.out.println("입력된 값의 합산 : " + (in1+in2) + " 입니다");
    }

    public int add(int in1, int in2,int in3){
        int result = in1+in2+in3;
        System.out.println("입력된 값 1 : " + in1 + "\t입력된 값 2 : " + in2 + "\t입력된 값 3 : " + in3);
        return result;
    }
}
