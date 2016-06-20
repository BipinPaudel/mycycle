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

    def edit() {
        if(params.id == null) {
            render "Please Send ID"
        }
        else {
            def category = Category.get(params.id)
            [category:category ]
        }
    }

    def update() {
        def category = Category.get(params.id)

        if(bindData(category,params)) {
            render "successfully edited"
        } else {
            render "Update failed!"
        }
    }
}
