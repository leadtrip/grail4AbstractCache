package cache.test.standard

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StandardThingSpec extends Specification implements DomainUnitTest<StandardThing> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
