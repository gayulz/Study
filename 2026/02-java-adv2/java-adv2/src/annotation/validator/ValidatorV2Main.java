package annotation.validator;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : ValidatorV1Main
 */
public class ValidatorV2Main {
    public static void main(String[] args) {
        User user = new User("user1", 10);
        Team team = new Team("teamA", 2);
        try {
            log("== user 검증 ==");
            Validator.validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
}
