package g5abstractcache;

import org.grails.orm.hibernate.cfg.CacheConfig;
import org.grails.orm.hibernate.cfg.GrailsDomainBinder;
import org.hibernate.HibernateException;
import org.hibernate.cache.spi.access.EntityDataAccess;
import org.hibernate.cache.spi.access.NaturalIdDataAccess;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.spi.PersisterCreationContext;

public class CustomSingleTableEntityPersister extends SingleTableEntityPersister {
    public CustomSingleTableEntityPersister(PersistentClass persistentClass, EntityDataAccess cacheAccessStrategy, NaturalIdDataAccess naturalIdRegionAccessStrategy, PersisterCreationContext creationContext) throws HibernateException {
        super(persistentClass, cacheAccessStrategy, naturalIdRegionAccessStrategy, creationContext);
    }

    /**
     * Although the mapping on the parent class isn't enabling caching, it is set when fetching from the domain binder
     */
    @Override
    public boolean canWriteToCache() {
        CacheConfig cache = GrailsDomainBinder.getMapping(getMappedClass()).getCache();     // not sure how expensive this is or if there's a better way to determine
        return cache != null && cache.getEnabled();
    }
}
