package annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : SimpleMapping
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleMapping {
    String value();
}
