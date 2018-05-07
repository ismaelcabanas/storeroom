package cabanas.garcia.ismael.storeroom.test;

import cabanas.garcia.ismael.storeroom.api.Application;
import cabanas.garcia.ismael.storeroom.api.configuration.ServerStartedInitializingBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("PMD.SignatureDeclareThrowsException")
public class ServerStart {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServerStart.class);

  private ConfigurableApplicationContext context;
  private int port;

  public void start(String[] args, boolean wait) throws Exception {
    if (wait) {
      try {
        LOGGER.info("attempting to stop server if it is already running");
        new ServerStop().stopServer();
      } catch (Exception e) {
        LOGGER.info("failed to stop server (was probably not up): {}", e.getMessage());
      }
    }
    context = Application.run(args);
    ServerStartedInitializingBean ss = context.getBean(ServerStartedInitializingBean.class);
    port = ss.getLocalPort();
    LOGGER.info("started server on port: {}", port);
    if (wait) {
      int stopPort = port + 1;
      LOGGER.info("will use stop port as {}", stopPort);
      MonitorThread monitor = new MonitorThread(stopPort, new Stoppable() {
        @Override
        public void stop() {
          context.close();
          }
      });
      monitor.start();
      monitor.join();
    }
  }

  public int getPort() {
    return port;
  }

  public void stop() {
    LOGGER.info("stopping spring context");
    context.stop();
  }


}
