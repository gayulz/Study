package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : SearchControllerV6
 */
public class SearchControllerV6 {
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1> Search </h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
