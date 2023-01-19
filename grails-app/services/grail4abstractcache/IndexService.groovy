package grail4abstractcache

import cache.test.abs.Child
import cache.test.abs.Parent
import grails.gorm.transactions.Transactional

@Transactional
class IndexService {

    def allAbstract() {
        getAbstractDynamicFinder()
        getAbstractCriteria()
        getChildDynamicFinder()
        getChildCriteria()
    }

    def getAbstractDynamicFinder() {
        log.info( "================== START getAbstractDynamicFinder ==================" )
        Parent.findByParentName('Jeff')
        log.info( "================== END getAbstractDynamicFinder ==================" )
    }

    def getAbstractCriteria() {
        log.info( "================== START getAbstractCriteria ==================" )
        Parent.createCriteria().list {
            eq('parentName', 'Jeff')
        }
        log.info( "================== END getAbstractCriteria ==================" )
    }

    def getChildDynamicFinder() {
        log.info( "================== START getChildDynamicFinder ==================" )
        Child.createCriteria().list {
            eq('parentName', 'Jeff')
        }
        log.info( "================== END getChildDynamicFinder ==================" )
    }

    def getChildCriteria() {
        log.info( "================== START getChildCriteria ==================" )
        Child.createCriteria().list {
            eq('parentName', 'Jeff')
        }
        log.info( "================== END getChildCriteria ==================" )
    }
}
