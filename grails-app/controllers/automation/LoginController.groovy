package automation

import grails.util.Environment
import org.grails.web.json.JSONObject


class LoginController {

    def ticketService
    def atoAService

    def index() {}


    def login() {

        def mainUrl = grailsApplication.config.ticketProxy.backEndMAINURL

        if (Environment.current.name == 'development' || ticketService.getProxyTicket(mainUrl, 5, [params.username, params.password])) {
            session.user = params.username
            session.password = params.password
            redirect(controller:"index",action: "index")
        } else {
            flash.message = "Not Authorized"
            render(view: "index")
        }

//        if(params.username=="john"){
//            session.user = params.username
//            redirect(controller:"index",action: "index")
//        }
    }

    def validate() {
        render "Welcome ${session.user}\n"
        render atoAService.serviceMethod()
    }

    def error() {
        render "Not Authorized"
    }

    def logout() {
        session.invalidate()
        redirect(action: index())
    }
}
