package automation
import grails.io.IOUtils
import grails.transaction.Transactional
import grails.util.Holders
import org.grails.web.json.JSONObject

@Transactional
class FetchService {

    def serviceMethod() {

    }

    def getUrlJsonBody(){
        Map<String,JSONObject> jsonBodies=new HashMap<>();

        jsonBodies.put("hpss",new JSONObject("{\"benchmarkType\":\"default\",\"clientId\":\"30470001\",\"comparisonFrom\":\"2012-10-01\",\"comparisonPaidThrough\":\"2013-09-30\",\"comparisonTo\":\"2013-09-30\",\"dataView\":\"PMPM\",\"eligibilityType\":[\"dental\",\"medical\",\"vision\"],\"includes\":[\"truvenBenchmark\"],\"phiCEDate\":\"09-30-2014\",\"phiCSDate\":\"10-01-2009\",\"recordTypes\":[\"ADT\",\"Allergy\",\"AppointmentsEmr\",\"Authorization\",\"Biometrics\",\"Dental\",\"DiagnosisEMR\",\"Disability\",\"EMR_Lab\",\"Eligibility\",\"EnrollmentData\",\"Episodes\",\"ExamScreening\",\"HRA\",\"Immunization\",\"KYN\",\"Lab\",\"Medical\",\"OSHA\",\"Participation\",\"Pharmacy\",\"PrescriptionEmr\",\"ProcedureEMR\",\"ProspectiveRiskGaps\",\"Provider\",\"Utilization\",\"Vendor\",\"Vision\",\"VisitEmr\",\"Vitals\",\"Workers_Comp\"],\"report\":\"healthPlan:default\",\"reportingBasis\":\"ServiceDate\",\"reportingFrom\":\"2013-10-01\",\"reportingPaidThrough\":\"2014-09-30\",\"reportingTo\":\"2014-09-30\",\"service\":\"trendingReport\",\"ticket\":\"ST-21583-DZCaq14VNzHt01jITS1G-cas\",\"clientName\":\"branded\"}"))
        jsonBodies.put("um",new JSONObject("{\"benchmarkType\":\"default\",\"clientId\":\"30470001\",\"comparisonFrom\":\"2012-10-01\",\"comparisonPaidThrough\":\"2013-09-30\",\"comparisonTo\":\"2013-09-30\",\"dataView\":\"PMPM\",\"eligibilityType\":[\"dental\",\"medical\",\"vision\"],\"includes\":[\"truvenBenchmark\"],\"phiCEDate\":\"09-30-2014\",\"phiCSDate\":\"10-01-2009\",\"report\":\"UMReport:default\",\"reportingBasis\":\"ServiceDate\",\"reportingFrom\":\"2013-10-01\",\"reportingPaidThrough\":\"2014-09-30\",\"reportingTo\":\"2014-09-30\",\"service\":\"trendingReport\",\"ticket\":\"ST-21683-CBgQjffwpf9iA1ZSMeka-cas\",\"clientName\":\"branded\"}"))
        return jsonBodies
    }

    def fetchReport(def parameters){
        String defaultURL=Holders.config.url.backEndUrl
        def url = new URL(defaultURL)
        JSONObject urlBodies=parameters;
        // def connection = null
        try {
            URLConnection connection = url.openConnection();
            println "====connection===111==" + connection
            connection.setRequestMethod("POST")
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.doOutput = true

            println "parameters = $urlBodies"
            OutputStream os = connection.outputStream
            // os.write((parameters as JSON).toString().getBytes("UTF-8"))
            os.write(urlBodies.toString().getBytes("UTF-8"))
            os.flush()
            os.close()
            connection.connect();
            println("URL Response :::::::::::::::::::: ${connection.getResponseCode()}")

            // println "fhgfhgfhg ${connection.content.toString()}"

            StringWriter writer = new StringWriter();
            IOUtils.copy(connection.getInputStream(), writer, "UTF-8");

            println("Url connection related work is completed successfully..............")
           // println "outPut====="+JsonOutput.prettyPrint(writer.toString())

            JSONObject result=new JSONObject(writer.toString())
            return result
            // println "result========"+result as JSON
//            result.put(entry.getKey(),result)
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    def dasRequest(){
        Map<String,JSONObject> resultSet=new HashMap<>();

        for (Map.Entry entry:getUrlJsonBody().entrySet()) {
            println "===key=="+entry.getKey()+"===value==="+entry.getValue()
            fetchReport(entry.getValue())
        }



        /*
        def moduleUrl = getModuleUrl(module)
		def url       = new URL(moduleUrl)
		def connection = null
		try {
			logger.info("Connecting to url..... $moduleUrl")
			connection = url.openConnection()
			connection.setRequestMethod("POST")
			connection.doOutput = true
			Writer wr           = new OutputStreamWriter(connection.outputStream)

			String ticket = null
			if(Environment.DEVELOPMENT != Environment.getCurrent()) {
				logger.info("Currrent Environment..................... ${Environment.getCurrent()}")
				def mainUrl = grailsApplication.config.ticketProxy.backEndMAINURL
				ticket = ticketService.getProxyTicket(mainUrl,5)
			}

			String parameterWithTicket = getProxyTicketAndClient(ticket, clientName, parameters)

			wr.write(parameterWithTicket)
			wr.flush()
			wr.close()
			connection.connect();
			logger.info("URL Response :::::::::::::::::::: ${connection.getResponseCode()} ")

			StringWriter writer = new StringWriter();
			org.apache.commons.io.IOUtils.copy(connection.getInputStream(), writer, "UTF-8");
			logger.info("Url connection related work is completed successfully..............")
			return writer.toString();

			def jsonData = cachedFetchData(parameters, it.getAt('module'), grailsApplication.config.ticketProxy.clientName)
				def data = JSON.parse(jsonData)
		}*/
    }
    def getSmokeTestResponse(){
        Map<String,JSONObject> jsonBodies=getUrlJsonBody();

    }
}
