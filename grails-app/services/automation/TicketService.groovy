package automation

import grails.transaction.Transactional
import grails.util.Holders


@Transactional
class TicketService {

    def ticketingService

    def serviceHostUrl = Holders.grailsApplication.config.ticketProxy.serviceHostUrl
    def serviceUrl = Holders.grailsApplication.config.ticketProxy.serviceUrl
    def casUrlPrefix = Holders.grailsApplication.config.ticketProxy.casURLPrefix
    def proxyReceptor = Holders.grailsApplication.config.ticketProxy.proxyReceptor


    def getProxyTicket(def dasUrl, int attempts, List loginCredentials) {
        def pt = ticketingService.generateProxyTicket(serviceHostUrl, serviceUrl, casUrlPrefix, proxyReceptor, dasUrl, loginCredentials[0], loginCredentials[1])
        //if (pt == null && attempts == 3) ticketingService.userTicketGrantingTicketStorage = null
        return (isValidAttempt(attempts, pt)) ? getProxyTicket(dasUrl, attempts - 1, loginCredentials): pt
    }

    def isValidAttempt(attempt, pt) {
        return (attempt <= 0 && pt == null)
    }
}
