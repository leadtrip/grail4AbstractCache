package grail4abstractcache


import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Value

import java.time.Duration
import java.time.Instant

class ParentChildController {

    @Value('${databaseItem.total}')
    Integer totalDbItems

    def indexService
    SessionFactory sessionFactory

    def index() {
        indexService.allAbstract().each {
            log.info( "${it}" )
        }

        render 'ok'
    }

    def fetchAll() {
        def totalChildren = []
        Instant start = Instant.now()
        totalDbItems.times {
            totalChildren << indexService.findByParentName("$it")
        }
        Instant end = Instant.now()
        log.info("fetchAll total children ${totalChildren.size()}")
        log.info("fetchAll time taken ${Duration.between(start, end)}")

        render 'ok'
    }

    def clearCache() {
        sessionFactory?.getCache()?.evictAllRegions()

        render 'ok'
    }
}
