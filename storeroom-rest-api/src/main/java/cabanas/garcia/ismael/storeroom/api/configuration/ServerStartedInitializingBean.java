package cabanas.garcia.ismael.storeroom.api.configuration;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ServerStartedInitializingBean implements ApplicationListener<ServletWebServerInitializedEvent> {

  private int localPort;

  public int getLocalPort() {
    return localPort;
  }

  @Override
  public void onApplicationEvent(ServletWebServerInitializedEvent event) {
    localPort = event.getApplicationContext().getWebServer().getPort();
  }
}
