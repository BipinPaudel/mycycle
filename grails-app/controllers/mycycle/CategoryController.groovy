package mycycle

class CategoryController {

    def index(){
        def categories=Category.list()
        [categories:categories]

    }

    def form(){

    }

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
}
