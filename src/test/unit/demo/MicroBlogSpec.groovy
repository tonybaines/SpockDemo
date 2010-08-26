package demo

import spock.lang.Specification;

class MicroBlogSpec extends Specification {

  def "should recieve the list of messages provided by the service"() {
    setup:
      def service = Mock(Service) // This is a Spock mock
      def expectedMessages =  ['Having breakfast. Cereal.']
      def microBlog = new MicroBlog(service)
    when:
      def rxMsgs = microBlog.getMessages()
    then:
      // Assertions and mock expectations are all defined/verified here
      service.getMessages() >> expectedMessages
      rxMsgs == expectedMessages
  }
  
  def "should throw an error if the service is unavailable"() {
    setup:
      def service = Mock(Service)
      def microBlog = new MicroBlog(service)
    when:
      microBlog.getMessages()
    then:
      service.getMessages() >> {throw new java.net.ConnectException("I see nothing special here")}
      def e = thrown(java.net.ConnectException)
      e.message == "I'm in a maze of routes, all alike"
  }
}
