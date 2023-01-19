package cache.test.abs

abstract class Parent  {
    String parentName
    Date dateCreated
    Date lastUpdated

    String getName() {
        return parentName
    }

    static constraints = {
        parentName nullable: false
    }

    static mapping = {
        cache 'true'
    }
}
