package cabanas.garcia.ismael.storeroom.test;

public class ServerStop {
  public void stopServer() {
    MonitorThread.stop(8081);
  }
}
