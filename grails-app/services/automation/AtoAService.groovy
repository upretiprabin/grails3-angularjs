package automation

import grails.converters.JSON
import org.grails.web.json.JSONObject
import grails.transaction.Transactional

@Transactional
class AtoAService {

    def reportsService
    def fetchService

    def performAToATest(def parentClient, def childClients) {

        println "====AtoAService====performAToAtest==="

        Map parentReports = reportsService.fetchReportParameters(parentClient, null)
        Map childReports = reportsService.fetchReportParameters(childClients, null)

        def results = [:]

        parentReports.each { report, parentRequest ->
            results[report]  = compareJSON(fetchService.fetchReport((parentRequest as JSONObject).requestJSON),
                    fetchService.fetchReport((childReports.get(report) as JSONObject).requestJSON)
            )
        }
        return results
    }


    def compareJSON(JSONObject parentObj, JSONObject childObj) {
        if (parentObj == childObj) {println parentObj ; return  true}

        parentObj.keys().each { aParentKey -> // loops in child elements

            Object parentValue = parentObj.get(aParentKey)
            Object childValue = childObj.get(aParentKey)

            if (parentValue != childValue) { // if a child element is not equal
                if (parentValue instanceof JSONObject) { //if child element is a JSON
                    List recursiveValue = (List) compareJSON(parentValue, childValue as JSONObject)
                    if (!recursiveValue.contains("true")) return [aParentKey, recursiveValue] as LinkedList
                } else {
                    return [aParentKey.toString()]
                }
            }
            // if parentValue == childValue then continue
        }
        //return true -- not reachable
    }
}
