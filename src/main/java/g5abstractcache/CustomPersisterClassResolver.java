package g5abstractcache;

import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.internal.StandardPersisterClassResolver;

public class CustomPersisterClassResolver extends StandardPersisterClassResolver {

    /**
     * This is wired up in application.yml - hibernate.persister.resolver
     */
    @Override
    public Class<? extends EntityPersister> singleTableEntityPersister() {
        return CustomSingleTableEntityPersister.class;
    }

}
