### Grails 4 app which demonstrates an issue with 2nd level caching on domain hierarchies

This branch attempts to enable 2nd level caching by wiring up a custom entity persister in config, see application.yml

```
hibernate:
  persister:
    resolver: g5abstractcache.CustomPersisterClassResolver
```

By default 1500 items are added to the database in Bootstrap.

A MySql database is required and can be spun up with:

`docker compose -f .\docker\docker-compose.yml up`

Navigating to http://localhost:8080/parentChild/fetchAll will run 1500 queries to fetch the items from the database after which cache statistics are logged.

Run repeatedly to see caching in action.

Disable the persister resolver in config to compare execution times and cache 2nd level cache misses.


