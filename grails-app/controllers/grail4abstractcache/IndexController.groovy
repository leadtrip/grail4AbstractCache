package grail4abstractcache

class IndexController {

    def indexService

    def index() {
        indexService.allAbstract()

        render 'ok'
    }
}
