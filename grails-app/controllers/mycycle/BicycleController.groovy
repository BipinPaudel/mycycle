package mycycle

class BicycleController {
    static scaffold = true
    def index() {
        def bicycles=Bicycle.list()
        [bicycles:bicycles]

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