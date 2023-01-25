package grail4abstractcache

import cache.test.abs.Child
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->
        createLotsOfChildren();
    }

    @Transactional
    def createLotsOfChildren() {
        (grailsApplication.config.getProperty('databaseItem.total') as Integer).times {
            new Child(parentName: "${it}").save()
        }
    }

    def destroy = {
    }
}
