package mycycle

import grails.plugin.springsecurity.SpringSecurityService

class BicycleController {
def springSecurityService
    def index() {
        def list=Bicycle.list()
        def bicycles = list.findAll{it.categoryId.equals(Long.parseLong(params.id))}
//        SpringSecurityService springSecurityService
        def current=springSecurityService.currentUser.id
        println("currentuser": current)
        [bicycles: bicycles]
        //[currentUser:currentUser]

    }
    def form(){
        def category=Category.findAll()
        [category:category]
    }
    def save(){
        params.category=Category.findByType(params.category).id

        params.remaining=params.quantity
        println params
        def bicycle=new Bicycle(params)
        if(bicycle.save(flush: true)){
            render "success"
        }
        else{
            render "Not success"

        }
    }

}