package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : SiteControllerV6
 */
public class SiteControllerV6 {
    public void site1(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>Site1</h1>");
    }
    public void site2(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>Site2</h1>");
    }
}
