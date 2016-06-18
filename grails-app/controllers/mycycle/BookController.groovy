package mycycle

class BookController {
    def springSecurityService
    def index() {

    }

    def book(){
        def bicycleId=params.id
        [bicycleId:bicycleId]
    }

    def save(){
        params.status=0
        params.paid=0
        params.user=springSecurityService.currentUser.id
        println(params)
        def booking= new Book(params)

        if(booking.save()){
            println("Everythings okay")
            redirect (view: "index", controller: 'category')
        }
        else{
            render "Not done "
        }

    }
}
