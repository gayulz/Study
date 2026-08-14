package was.httpserver.servlet;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : PageNotFoundException
 */
public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String message) {
        super(message);
    }
}
