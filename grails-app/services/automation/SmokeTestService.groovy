package automation

import grails.transaction.Transactional
import org.grails.web.json.JSONObject

@Transactional
class SmokeTestService {

    def reportsService
    def fetchService
    def serviceMethod() {

    }
    def reportList(){
        def reports = ["healthPlan", "UMReport", "erVisitCategory"] as ArrayList
        return reports;
    }

    def performSmoketest(def clientId){
        println "====SmokeTestService====performSmoketest==="+clientId

        JSONObject resultSets=new JSONObject()
        for (Map.Entry<String, JSONObject> entry : reportsService.fetchReportParameters(clientId,reportList()).entrySet()) {
            def report=entry.getKey()
            JSONObject jsonBody=entry.getValue()
            println "=====jsonBody===="+jsonBody
            JSONObject status=evaluateResponse(fetchService.fetchReport(jsonBody))
            resultSets.put(report,status);
        }
        return resultSets

    }
    def evaluateResponse(JSONObject result){

        if (result.isEmpty()){
            return new JSONObject("{\"message\":\"Report responsed empty, something might be wrong\"}")
        }
        else {
            return new JSONObject("{\"message\":\"Report worked FINE\"}")
        }
    }
}
