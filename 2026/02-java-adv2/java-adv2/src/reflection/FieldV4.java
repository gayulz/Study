package reflection;

import reflection.data.Team;
import reflection.data.User;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : FieldV3
 */
public class FieldV4 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
        System.out.println();
        FieldUtil.nullFieldToDefault(user);
        FieldUtil.nullFieldToDefault(team);


        System.out.println();
        System.out.println("===== after =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
