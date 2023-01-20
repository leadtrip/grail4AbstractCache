### Grails 4 app which demonstrates an issue with 2nd level caching on domain hierarchies

2nd level caching is enabled in config.

The Parent domain has cache true configured in its mapping block, the Child domain extends Parent.

Run the app and check the logs when accessing http://localhost:8080/ which will run a number of dynamic finder and criteria queries resulting in cache misses and database access.

Navigate to http://localhost:8080/standardThing to view the output from a single domain with caching enabled exhibiting the expected behaviour
