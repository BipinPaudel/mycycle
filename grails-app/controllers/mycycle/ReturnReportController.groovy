package mycycle

import grails.plugin.springsecurity.annotation.Secured

class ReturnReportController {
@Secured(['ROLE_ADMIN'])
    def index() {
        def reports=ReturnReport.findAll()
        [reports:reports]
    }

    def delete(){
        ReturnReport.get(params.id).delete(flush: true)
        redirect(controller: 'category',
        action: 'index')
    }
}
