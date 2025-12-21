package members;

public class MemberList {
    private static MemberList listInstance = null;
    public MemberDefine[] listArray = new MemberDefine[10];

    private MemberList() {} // 생성자 잠금

    // 멤버리스트가 생성이 안되었을 경우 새로 생성하고 있는 경우 주소값을 넘겨준다
    public static MemberList getInstance() {
        if (listInstance == null) {
            listInstance = new MemberList();
        }
        return listInstance;
    }
}
