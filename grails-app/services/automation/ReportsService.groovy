package automation

import grails.transaction.Transactional
import org.grails.web.json.JSONObject

import java.text.SimpleDateFormat

@Transactional
class ReportsService {

    def fetchService

    /**
     * Function to fetch Report specific report Parameter.
     *
     * @param   clientId    the Client's Id.
     * @param   reportIds   list of ReportIds to fetch parameters for. If it is null, all available reportIds will be worked with.
     * @return  A map with reportId key, and an inner map containing various properties regarding the report's parameters.
     */
    def fetchReportParameters(def clientId, ArrayList<String> reportIds){

        String cycleEndDate

        try{
            cycleEndDate = fetchClientConfig(clientId)
        }catch (Exception e){
            print(e.printStackTrace())
            return null
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        cal.setTime(sdf.parse(cycleEndDate));
        String reportingToDate = sdf.format(cal.getTime())
        cal.add(Calendar.YEAR, -1)
        String reportingFromDate = sdf.format(cal.getTime())

        def reports
        def reportParameters = [:]
        if(reportIds==null){
            reports = ReportConfig.findAll()
        }       else {
            reports = ReportConfig.findAllByReportIdInList(reportIds)
        }
        reports.each {
            def requestJSON = updateRequestJSON(clientId,it.requestJSON,reportingToDate,reportingFromDate)
            reportParameters.put(it.reportId, ['format':it.format,'requestJSON' :requestJSON ] )
        }
       // reportParameters.put("um",new JSONObject("{\"benchmarkType\":\"default\",\"clientId\":\"30470001\",\"comparisonFrom\":\"2012-10-01\",\"comparisonPaidThrough\":\"2013-09-30\",\"comparisonTo\":\"2013-09-30\",\"dataView\":\"PMPM\",\"eligibilityType\":[\"dental\",\"medical\",\"vision\"],\"includes\":[\"truvenBenchmark\"],\"phiCEDate\":\"09-30-2014\",\"phiCSDate\":\"10-01-2009\",\"report\":\"UMReport:default\",\"reportingBasis\":\"ServiceDate\",\"reportingFrom\":\"2013-10-01\",\"reportingPaidThrough\":\"2014-09-30\",\"reportingTo\":\"2014-09-30\",\"service\":\"trendingReport\",\"ticket\":\"ST-21683-CBgQjffwpf9iA1ZSMeka-cas\",\"clientName\":\"branded\"}"))
        return reportParameters
    }

    def updateRequestJSON(def clientId, String requestString, def reportingToDate, def reportingFromDate){
        JSONObject requestJSON = new JSONObject(requestString)
        requestJSON.put("reportingTo",reportingToDate)
        requestJSON.put("reportingFrom",reportingFromDate)
        requestJSON.put("clientId",clientId)
        requestJSON
    }

    def fetchClientConfig(clientId){
        def parameters = ["clientId":clientId,"page":1,"pageSize":1,"phiCEDate":"09-30-2014","phiCSDate":"10-01-2009","table":"ClientConfig","service":"search"]
        return fetchService.fetchReport(parameters)['result_sets']['0']['cycleEndDate']
    }

}

