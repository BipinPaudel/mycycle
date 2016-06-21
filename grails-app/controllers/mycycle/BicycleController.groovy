package mycycle

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class BicycleController {

    @Secured(['ROLE_ADMIN','ROLE_USER'])
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

    def edit(){
        if(params.id==null){
            render "Send Id"
        }else{
            def bicycles = Bicycle.get(params.id)
            def category = Category.findAll()
            //def bicycles = Bicycle.list().findAll { it.id.equals(Long.parseLong(params.id)) }
            //render bicycles.title
            [bicycle: bicycles,category: category]
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
    def delete(){
        Bicycle.get(params.id).delete(flush: true)
        redirect(controller: 'category',action: 'index')
    }
    def update(){
        params.category = Category.findByType(params.category).id
        params.remaining = params.quantity
        def bicycle = Bicycle.get(params.id)

        if(bindData(bicycle,params)){
            println bicycle
            println params
            render "Success"
        }else{
            render "not success"
        }
    }
}