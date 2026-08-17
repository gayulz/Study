package annotation.basic;

import java.lang.annotation.*;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : AnnoMeta
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AnnoMeta {
}
