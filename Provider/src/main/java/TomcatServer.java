import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer extends Thread{

    private Tomcat tomcat = new Tomcat();
    private volatile boolean started = false;

        //Internal java server does not support Jersey so tomcat or jetty could be an alternative
       private void startTomcat() throws ServletException, LifecycleException {
           String webappDirLocation = "src/main/";
            String webPort = System.getenv("PORT");
            if(webPort == null || webPort.isEmpty()) {
                webPort = "8080";
            }
            tomcat.setPort(Integer.valueOf(webPort));
            Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
            tomcat.addServlet(context,"jersey-container-servlet",resourceConfig());
            context.addServletMapping("/calculator", "jersey-container-servlet");
            tomcat.start();
            started = true;
            tomcat.getServer().await();
        }

    @Override
    public synchronized void run() {
        try {
            startTomcat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws LifecycleException {
       tomcat.stop();
    }

    public boolean isStarted() {
        return started;
    }

    private ServletContainer resourceConfig() {
            return new ServletContainer(new ResourceConfig().register(new Calculator()));
        }
    }