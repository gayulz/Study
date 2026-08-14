package was.httpserver;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : HttpServlet
 */
public interface HttpServlet {
    void service(HttpRequest request, HttpResponse response) throws IOException;
}
