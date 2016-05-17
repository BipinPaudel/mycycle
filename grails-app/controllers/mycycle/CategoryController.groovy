package mycycle

class CategoryController {
    static scaffold = true
    def form(){}
    def save(){
        def category=new Category(params)
        if(category.save()){
            render "success"
        }
        else{
            render "Not success this is shit"
        }
    }
}
