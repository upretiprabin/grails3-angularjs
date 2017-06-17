package automation

import grails.converters.JSON
import org.grails.web.json.JSONObject
import grails.web.context.ServletContextHolder

class FetchDataController {

    def fetchService
    def smokeTestService
    def atoAService
    def reportsService

    def index() {
        //sample call to fetch Report-wise parameters
        def reportParameters = reportsService.fetchReportParameters('20020001',null)
        render reportParameters
    }

    def smokeTest() {
        println "grails FetchDataController===smokeTest===="
        JSONObject result = smokeTestService.performSmoketest("20020001")
        println "result===="+result
        render(result)
    }

    def aToATest() {
        println "AtoA=============="
        JSONObject parameters = (JSONObject) request.getJSON()
        //render atoAService.performAToATest("30470001","30470001")
        render atoAService.performAToATest(parameters.clientId,parameters.clientInstanceId_1) as JSON
    }

    //Reload ReportConfigs
    def reloadBootstrap = {
        try {
            def servletContext = ServletContextHolder.servletContext as Object
            def bootstrapArtefact = grailsApplication.getArtefacts('Bootstrap')[-1]
            bootstrapArtefact.referenceInstance.init(servletContext)
            render "Bootstrap has been successfully loaded !"
        }catch(Exception e){
            render "Error Loading BootStrap!" + e
        }
    }
}
