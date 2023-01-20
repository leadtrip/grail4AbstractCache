package grail4abstractcache

import cache.test.abs.Child
import cache.test.abs.Parent
import cache.test.standard.StandardThing
import grails.gorm.transactions.Transactional

@Transactional
class IndexService {

    def allAbstract() {
        [
            getAbstractDynamicFinder(),
            getAbstractCriteria(),
            getChildDynamicFinder(),
            getChildCriteria()
        ]
    }

    def getAbstractDynamicFinder() {
        log.info( "================== START getAbstractDynamicFinder ==================" )
        Parent.findByParentName('Jeff')
    }

    def getAbstractCriteria() {
        log.info( "================== START getAbstractCriteria ==================" )
        Parent.createCriteria().list {
            eq('parentName', 'Jeff')
        }
    }

    def getChildDynamicFinder() {
        log.info( "================== START getChildDynamicFinder ==================" )
        Child.createCriteria().list {
            eq('parentName', 'Jeff')
        }
    }

    def getChildCriteria() {
        log.info( "================== START getChildCriteria ==================" )
        Child.createCriteria().list {
            eq('parentName', 'Jeff')
        }
    }

    def allNonAbstract() {
        [getNonAbstractDynamicFinder(),
        getNonAbstractCriteria()]
    }

    def getNonAbstractDynamicFinder() {
        log.info("================== getNonAbstractDynamicFinder ==================")
        StandardThing.findByName( 'Standard 1' )
    }

    def getNonAbstractCriteria() {
        log.info("================== getNonAbstractCriteria ==================")
        StandardThing.createCriteria().list {
            eq 'name', 'Standard 1'
        }
    }
}
