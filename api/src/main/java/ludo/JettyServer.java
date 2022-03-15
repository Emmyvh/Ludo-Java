package ludo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = startServer(8080);
        ServletContextHandler context = createStatefulContext(server);
        registerServlets(context);

        server.start();
        System.out.println("Started server.");
        System.out.println("Listening on http://localhost:8080/");
        System.out.println("Press CTRL+C to exit.");
        server.join();
    }

    private static Server startServer(int port) {
        return new Server(8080);
    }

    private static ServletContextHandler createStatefulContext(Server server) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        return context;
    }

    private static void registerServlets(ServletContextHandler context) {
        ServletHolder serverHolder = context.addServlet(ServletContainer.class, "/ludo/api/*");
        serverHolder.setInitOrder(1);
        serverHolder.setInitParameter("jersey.config.server.provider.packages",
                "ludo.api");
    }
}
