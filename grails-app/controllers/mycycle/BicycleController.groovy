package mycycle

import grails.plugin.springsecurity.SpringSecurityService

class BicycleController {

    def index() {
        if (params.id==null) {
            redirect(controller: 'category', view: 'index')
        }
        else{
            def list = Bicycle.list()
            //finds bicycle according to the category id passed in url and shows in the index
            def bicycles = list.findAll { it.categoryId.equals(Long.parseLong(params.id)) }
            [bicycles: bicycles]
        }
    }

    def form() {
        def category = Category.findAll()
        [category: category]
    }

    def save() {
        params.category = Category.findByType(params.category).id
        params.remaining = params.quantity
        println params
        def bicycle = new Bicycle(params)
        if (bicycle.save(flush: true)) {
            redirect(controller: 'bicycle',action:'form' )
        } else {
            render "Not success"
        }
    }
}