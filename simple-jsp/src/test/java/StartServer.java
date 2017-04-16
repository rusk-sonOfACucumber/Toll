import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server( 8080 );
        ResourceCollection resources = new ResourceCollection(new String[] {
                "simple-jsp/src/main/webapp",
        });


        WebAppContext webapp = new WebAppContext();
        webapp.setServer(server);
        webapp.setContextPath("/");
        webapp.setBaseResource(resources);
        webapp.setWar("/simple-jsp/src/main/webapp");

        // Для правильной работы контейнера с JSP нужно сделать такие установки
        Configuration.ClassList classlist = Configuration.ClassList
                .setServerDefault( server );
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration" );

        // это позволяет подключать библиотеки тегов, если такие используются в наших JSP
        /*webapp.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".[^/]*servlet-api-[^/]*\\.jar$|.javax.servlet.jsp.jstl-.*\\.jar$|.[^/]*taglibs.*\\.jar$" );*/

        server.setHandler(webapp);

        try {
            System.out.println(">>>STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
            server.start();
            System.in.read();
            System.out.println(">>>STOPPING EMBEDDED JETTY SERVER");
            server.stop();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }
}