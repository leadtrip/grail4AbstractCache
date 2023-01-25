package grail4abstractcache

import org.hibernate.SessionFactory
import org.hibernate.stat.Statistics

class CacheStatisticsInterceptor {

    SessionFactory sessionFactory
    Statistics stats

    CacheStatisticsInterceptor() {
        matchAll()
    }

    boolean before() {
        stats = sessionFactory.getStatistics()
        stats.setStatisticsEnabled(true)
        true
    }

    boolean after() {
        log.info( toString() )
        true
    }

    String toString() {
        return new StringBuilder()
                .append( '\n' ).append( "=======================================" ).append( '\n' )
                .append( "second level cache puts=" ).append( stats.secondLevelCachePutCount ).append( '\n' )
                .append( "second level cache hits=" ).append( stats.secondLevelCacheHitCount ).append( '\n' )
                .append( "second level cache misses=" ).append( stats.secondLevelCacheMissCount ).append( '\n' )
                .append( "queries executed to database=" ).append( stats.queryExecutionCount ).append( '\n' )
                .append( "query cache puts=" ).append( stats.queryCachePutCount ).append( '\n' )
                .append( "query cache hits=" ).append( stats.queryCacheHitCount ).append( '\n' )
                .append( "query cache misses=" ).append( stats.queryCacheMissCount ).append( '\n' )
                .toString();
    }

    void afterView() {
        // no-op
    }
}
