package was.v6;

import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.reflection.ReflectionServlet;
import was.v5.servlet.HomeServlet;

import java.io.IOException;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : ServerMainV6
 */
public class ServerMainV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        List<Object> controllers = List.of(new SiteControllerV6(), new SearchControllerV6());
        // 리플렉션 서블릿을 생성하고 사용할 컨트롤러를 인자로 전달
        HttpServlet reflectionServlet = new ReflectionServlet(controllers);
        ServletManager servletManager = new ServletManager();

        // 리플렉션 서블릿을 기본 서블릿 등록. 이렇게 되면 다른 서블릿에서 경로를 찾지 못할 때
        // 우리가 만든 리플렉션 서블릿이 항상 호출 됨
        servletManager.setDefaultServlet(reflectionServlet);
        servletManager.add("/", new HomeServlet());
        servletManager.add("favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
