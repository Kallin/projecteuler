package structural.flyweight

import static org.hamcrest.Matchers.*

import spock.lang.Specification

class FlyweightSpec extends Specification {

    def 'can create flyweights'() {
        when:
        def flyweightFactory = new FlyweightFactory()

        def name1 = 'NAME1'
        def name2 = 'NAME2'

        def flyweight1 = flyweightFactory.getFlyWeight(name1)
        def flyweight2 = flyweightFactory.getFlyWeight(name1)
        def flyweight3 = flyweightFactory.getFlyWeight(name2)

        then:

        flyweight1 sameInstance(flyweight2)
        flyweight1 not(sameInstance(flyweight3))

        2 equalTo(flyweightFactory.flyweightMap.keySet().size())
    }

}
