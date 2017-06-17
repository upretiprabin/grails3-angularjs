package automation

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "index", action: "index")
        "/login"(view:"/login/index")
        "/dashBoard"(view: "/index")
        "500"(view:'/error')
        "404"(view:'/notFound')



        //Common partials
        '/common/sidebar'(view: '/common/sidebar')
        '/a2a/a2a'(view: '/a2a/a2a')
        '/smoketest/smoketest'(view: '/smoketest/smoketest')

        //fetch urls

        "/test/a2a"(controller: "fetchData",action: "aToATest")
        "/test/smoke"(controller: "fetchData",action: "smokeTest")

    }
}
