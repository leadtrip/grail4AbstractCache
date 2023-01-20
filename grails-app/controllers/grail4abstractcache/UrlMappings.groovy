package grail4abstractcache

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "parentChild")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
