package grail4abstractcache

import org.hibernate.SessionFactory
import org.hibernate.cache.internal.EnabledCaching
import org.hibernate.stat.Statistics

class ParentChildController {

    SessionFactory sessionFactory
    def indexService

    def index() {
        Statistics stats = sessionFactory.getStatistics()
        stats.setStatisticsEnabled(true)

        indexService.allAbstract().each {
            println it
        }

        EnabledCaching enabledCaching = sessionFactory.getCache()

        log.info("${enabledCaching.getCacheRegionNames()}")
        log.info("${enabledCaching.containsEntity('cache.test.abs.Parent', 2l)}")               // not in cache

        log.info("Fetch count=" + stats.getEntityFetchCount());
        log.info("Second level hit count=" + stats.getSecondLevelCacheHitCount());
        log.info("Second level miss count=" + stats.getSecondLevelCacheMissCount());
        log.info("Second level put count=" + stats.getSecondLevelCachePutCount());

        render 'ok'
    }
}
