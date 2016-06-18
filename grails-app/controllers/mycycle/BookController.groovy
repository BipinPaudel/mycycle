package mycycle

import org.apache.tools.ant.types.resources.selectors.InstanceOf

class BookController {
    def springSecurityService

    def index() {

    }

    def book() {
        def bicycleId = params.id
        [bicycleId: bicycleId]
    }

    def save() {
        def bookedQuantity = Integer.parseInt(params.quantity)
        def bicycleId = params.bicycle
        println("main  :" + Bicycle.findById(bicycleId).getRemaining())
        def inStock = Bicycle.findById(bicycleId).remaining

        if (inStock < bookedQuantity) {
            flash.message = "Not that much bicycle in stock!"
            redirect(controller: 'category', view: 'index')
            return
        } else {

            params.status = 0
            params.paid = 0
            params.user = springSecurityService.currentUser.id
            println(params)
            def booking = new Book(params)

            if (booking.save()) {
//                println("Everythings okay")
//               println("id chai : " + bicycleId.getClass())
                def remaining = inStock - bookedQuantity

//                println("remaining is :"  + remaining + " " + " type is: " + remaining.getClass()  )
                Bicycle.executeUpdate("update Bicycle set remaining = ? where id= ?",
                        [remaining,Long.parseLong(bicycleId)] )
                redirect(controller: 'category', view: 'index')
                return
            } else {

                render "Not saved "
            }
        }
    }


}
