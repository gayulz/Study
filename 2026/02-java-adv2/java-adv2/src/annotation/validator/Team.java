package annotation.validator;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : Team
 */
public class Team {

    @NotEmpty(Message = "이름이 비었습니다.")
    private String name;

    @Range(min = 1, max = 999, Message = "회원 수는 1과 999 사이여야 합니다.")
    private int memberCount;


    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
