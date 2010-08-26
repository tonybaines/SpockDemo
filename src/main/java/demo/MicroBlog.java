package demo;

public class MicroBlog {
  private Service service;

  public MicroBlog(Service service) {
    this.service = service;
  }
  
  public String[] speak(String message) {
    service.sendMessage(message);
    return getMessages();
  }
  
  public String[] getMessages() {
    return service.getMessages();
  }
}
