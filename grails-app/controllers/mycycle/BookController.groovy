package mycycle

import grails.transaction.Transactional
import org.apache.tools.ant.types.resources.selectors.InstanceOf

class BookController {
    def springSecurityService

    def index() {
        def bookList = Book.list()
        println(bookList.quantity)
        [bookList:bookList]
    }

    def book() {
        def bicycleId = params.id
        [bicycleId: bicycleId]
    }

    def save() {
        def bookedQuantity = Integer.parseInt(params.quantity)
        def bicycleId = params.bicycle
        //println("main  :" + Bicycle.findById(bicycleId).getRemaining())
        def inStock = Bicycle.findById(bicycleId).remaining

        if (inStock < bookedQuantity) {
            flash.message = "Not that much bicycle in stock!"
            redirect(controller: 'category', view: 'index')
            return
        } else {

            params.status = 0
            params.paid = 0
            params.user = springSecurityService.currentUser.id
//            println(params)
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

    def returnCycle(){
        def bicycle_id=params.bicycleId
        def quantity=Integer.parseInt(params.quantity)
        def inStock= Bicycle.get(Long.parseLong(params.bicycleId)).remaining

        println("instock: " + inStock.getClass() )
        println("quantity : " + quantity.getClass())
        def ss=inStock+quantity
        println("sum is :" + ss )
        Bicycle.executeUpdate("update Bicycle set remaining=?+? where id=?",
        [inStock,quantity,Long.parseLong(params.bicycleId)])
//
        Book.get(params.id).delete(flush: true)

        redirect(controller: 'category' ,action: 'index')
    }

    def taken(){

        if(params.bookId!=null){
            println("hero is " + params.bookId.getClass())
            Book.findById(params.bookId).status==0?
            Book.executeUpdate("update Book set status=? where id=?",[1,Long.parseLong(params.bookId)]):
                    Book.executeUpdate("update Book set status=? where id=?",[0,Long.parseLong(params.bookId)])
            redirect(controller: 'book',action: 'index')
        }

    }


}
