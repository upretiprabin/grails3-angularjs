import automation.ReportConfig

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        def reportingConfigs = ReportConfig.findAll()
        reportingConfigs.each {
            it.delete(flush: true)
        }
        def reportList = [
                [reportId:'topRecordsProvider', reportName:'Provider Top Records', requestJSON:'{"clientId":"30470001","comparisonFrom":"2012-10-01","comparisonPaidThrough":"2013-09-30","comparisonTo":"2013-09-30","dataView":"PMPM","eligibilityType":["dental","medical","vision"],"from":0,"frontCohortId":"301427_1496737659152_97007","phiCEDate":"09-30-2014","phiCSDate":"10-01-2009","report":"provider","reportingBasis":"ServiceDate","reportingFrom":"2013-10-01","reportingPaidThrough":"2014-09-30","reportingTo":"2014-09-30","topRecords":20,"service":"topRecords","clientName":"branded"}'],
                [reportId:'gbsTierEnrollment', reportName:'Tier Enrollment', requestJSON:'{"BOB":"BOB","clientId":"30470001","eligibilityType":["dental","medical","vision"],"phiCEDate":"09-30-2014","phiCSDate":"10-01-2009","report":"gbsTierEnrollment","reportingBasis":"ServiceDate","reportingFrom":"2013-10-01","reportingPaidThrough":"2014-09-30","reportingTo":"2014-09-30","service":"report","userId":"301427","clientName":"branded","benefitTypeId":["1","3","4"]}'],
                [reportId:'programReport', reportName:'Program Summary', requestJSON:'{"clientId":"30470001","comparisonFrom":"2012-10-01","comparisonPaidThrough":"2013-09-30","comparisonTo":"2013-09-30","dataView":"PMPM","eligibilityType":["dental","medical","vision"],"frontCohortId":"55456860_1478162315003_997284","isParticipation":"both","page":1,"pageSize":20,"phiCEDate":"09-30-2014","phiCSDate":"10-01-2009","report":"programReport","reportingBasis":"ServiceDate","reportingFrom":"2013-10-01","reportingPaidThrough":"2014-09-30","reportingTo":"2014-09-30","service":"esReport","clientName":"branded"}']
        ]
        reportList.each {
            ReportConfig reportConfig = new ReportConfig()
            it.each {
                reportConfig."$it.key" = it.value
            }
            reportConfig.save(failOnError: true)
        }
    }
    def destroy = {
    }
}
