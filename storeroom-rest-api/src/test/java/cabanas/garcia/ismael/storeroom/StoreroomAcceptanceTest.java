package cabanas.garcia.ismael.storeroom;

import cabanas.garcia.ismael.storeroom.test.ServerStart;
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@CucumberOptions(features = "classpath:features/")
public final class StoreroomAcceptanceTest {
    // this class will automatically pick up all *.feature files
    // in src/test/resources and even recurse sub-directories

  private static ServerStart server;

  private StoreroomAcceptanceTest() {
  }

  @BeforeClass
  public static void beforeClass() throws Exception {
    server = new ServerStart();
    server.start(new String[]{"--server.port=0"}, false);
    System.setProperty("server.port", server.getPort() + "");
  }

  @AfterClass
  public static void afterClass() {
    server.stop();
  }
}
