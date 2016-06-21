package mycycle

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.transaction.Transactional
import org.apache.tools.ant.types.resources.selectors.InstanceOf

class BookController {
    def springSecurityService

    def index() {
        def userId = springSecurityService.currentUser
        def roleId = UserRole.findByUser(userId).roleId
        def roleName = Role.findById(roleId).authority
        if (roleName == 'ROLE_ADMIN') {
            println("inside required")
            def bookList = Book.findAll()
            println(bookList.quantity)
            [bookList: bookList]
        } else {
            def bookList = Book.findAllByUser(springSecurityService.currentUser)
            [bookList: bookList]
        }
    }

    def book() {
        def bicycleId = params.id
        [bicycleId: bicycleId]
    }

    def save() {
        def bookedQuantity = Integer.parseInt(params.quantity)
        def bicycleId = params.bicycle
        def inStock = Bicycle.findById(bicycleId).remaining

        if (inStock < bookedQuantity) {
            flash.message = "Not that much bicycle in stock!"
            redirect(controller: 'category', view: 'index')
            return
        } else {
            params.status = 0
            params.paid = 0
            params.user = springSecurityService.currentUser.id
            def duration
            use(groovy.time.TimeCategory) {
                duration = (params.endDate - params.startDate).days + 1
            }

            def bicycleReference = Bicycle.findById(params.bicycle).category
            def categoryReferenceForPrice = Category.findById(bicycleReference.id).price
            params.totalAmount = bookedQuantity * categoryReferenceForPrice * duration
            def booking = new Book(params)
            if (booking.save()) {
                def remaining = inStock - bookedQuantity
                Bicycle.executeUpdate("update Bicycle set remaining = ? where id= ?",
                        [remaining, Long.parseLong(bicycleId)])
                redirect(controller: 'category', view: 'index')
                return
            } else {
                render "Not saved "
            }
        }
    }

    def returnCycle() {
        def quantity = Integer.parseInt(params.quantity)
        def inStock = Bicycle.get(Long.parseLong(params.bicycleId)).remaining
        Bicycle.executeUpdate("update Bicycle set remaining=?+? where id=?",
                [inStock, quantity, Long.parseLong(params.bicycleId)])
        params.user = params.user_id
        params.bicycle = params.bicycleId
        params.date = new Date()
        params.price = params.totalAmount
        def report = new ReturnReport(params)
        if (report.save()) {
            println("Report has been saved")
        } else {
            println("Report not saved")
        }
        Book.get(params.id).delete(flush: true)
        redirect(controller: 'category', action: 'index')
    }

    def delete() {
        def quantity = Integer.parseInt(params.quantity)
        def inStock = Bicycle.get(Long.parseLong(params.bicycleId)).remaining
        Bicycle.executeUpdate("update Bicycle set remaining=?+? where id=?",
                [inStock, quantity, Long.parseLong(params.bicycleId)])
        Book.get(params.id).delete(flush: true)
        redirect(controller: 'book', action: 'index')
    }

    def taken() {
        if (params.bookId != null) {
            Book.findById(params.bookId).status == 0 ?
                    Book.executeUpdate("update Book set status=? where id=?", [1, Long.parseLong(params.bookId)]) :
                    Book.executeUpdate("update Book set status=? where id=?", [0, Long.parseLong(params.bookId)])
            redirect(controller: 'book', action: 'index')
        }
    }
}
