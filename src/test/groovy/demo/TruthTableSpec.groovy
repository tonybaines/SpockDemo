package demo

import spock.lang.Specification;

class TruthTableSpec extends Specification {
  def "NOT"() {
    expect:
      (!A) == result
    where:
      A     | result
      true  | false
      false | true
  }
  
  def "AND"() {
    expect:
      (A & B) == result
    where:
      A     | B      | result
      true  | true   | true
      true  | false  | false
      false | true   | false
      false | false  | false
  }
  
  def "OR"() {
    expect:
      (A | B) == result
    where:
      A     | B      | result
      true  | true   | true
      true  | false  | true
      false | true   | true
      false | false  | false
  }

  def "XOR"() {
    expect:
      (A ^ B) == result
    where:
      A     | B      | result
      true  | true   | false
      true  | false  | true
      false | true   | true
      false | false  | false
  }

}
