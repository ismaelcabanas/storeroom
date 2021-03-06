package cabanas.garcia.ismael.storeroom.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.storeroom.api.configuration"
    })
@SuppressWarnings("PMD.UseUtilityClass")
public class Application {
  public static void main(String[] args) {
    run(args);
  }

  public static ConfigurableApplicationContext run(String[] args) {
    return SpringApplication.run(Application.class, args);
  }

}
