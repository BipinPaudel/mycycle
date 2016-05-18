package mycycle

class CategoryController {
    def index(){
        def categories=Category.list()
        [categories:categories]
    }
    def form(){}
    def save(){
        def category=new Category(params)
        if(category.save()){
            render "success"
        }
        else{
            render "Not success"
        }
    }
}
