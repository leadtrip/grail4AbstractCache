package grail4abstractcache

import cache.test.abs.Child
import cache.test.standard.StandardThing
import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->

    }

    @Transactional
    void addToDatabase() {
        new Child(parentName: 'Steve').save(failOnError: true, flush: true)
        new Child(parentName: 'Jeff').save(failOnError: true, flush: true)
        new Child(parentName: 'Dave').save(failOnError: true, flush: true)
        new Child(parentName: 'Andy').save(failOnError: true, flush: true)

        new StandardThing(name: 'Standard 1').save(flush: true)
    }

    def destroy = {
    }
}
