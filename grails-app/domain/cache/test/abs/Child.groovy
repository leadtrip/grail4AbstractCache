package cache.test.abs

class Child extends Parent {

    String someData

    static constraints = {
        someData nullable: true
    }

    static mapping = { }


}
