package mycycle

import grails.plugin.springsecurity.annotation.Secured

class CategoryController {
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def index(){
        def categories=Category.list()
        println("categories: "+categories)
        [categories:categories]

    }


    def form(){

    }
   // @Secured(['ROLE_ADMIN','ROLE_USER'])
    def firstPage(){

    }

    def delete(){
        Category.get(params.id).delete(flush: true)
        redirect(controller: 'category',action: 'index')
    }

    @Secured(['ROLE_ADMIN'])
    def save(){
        println params
        def category=new Category(params)
        if(category.save(flush: true)){
            redirect(controller: 'category',action: 'index')
        }
        else{
            render "Not success"
        }
    }
    @Secured(['ROLE_ADMIN'])
    def edit() {
        if(params.id == null) {
            render "Please Send ID"
        }
        else {
            def category = Category.get(params.id)
            [category:category ]
        }
    }
    @Secured(['ROLE_ADMIN'])
    def update() {
        def category = Category.get(params.id)

        if(bindData(category,params)) {
            render "successfully edited"
        } else {
            render "Update failed!"
        }
    }
}
