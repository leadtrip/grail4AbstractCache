package grail4abstractcache

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class CacheStatisticsInterceptorSpec extends Specification implements InterceptorUnitTest<CacheStatisticsInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test cacheStatistics interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"cacheStatistics")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
