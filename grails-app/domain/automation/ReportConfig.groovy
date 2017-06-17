package automation

class ReportConfig {
    String reportId
    String reportName
    String module
    String list
    String mapping
    String requestJSON
    String exception
    String format

    static constraints = {
        reportId unique: true
        reportId nullable: false
        reportName nullable: true
        module nullable: true
        list nullable: true
        mapping nullable: true
        requestJSON nullable: true
        exception nullable: true
        format nullable: true
        requestJSON sqlType: 'longtext'
    }
}
