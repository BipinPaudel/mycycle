package mycycle

class Book {
    static belongsTo = [user:User,bicycle:Bicycle]
    Date startDate
    Date endDate
    Integer paid
    Integer quantity
    Integer status //0->booked, 1->taken
    static constraints = {
    }
}
