package automation


import grails.rest.*
import grails.converters.*

class IndexController {

    def index() {
        redirect(url:"/dashBoard")
    }
}
