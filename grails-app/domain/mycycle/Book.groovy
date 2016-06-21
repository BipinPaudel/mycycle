package mycycle

class Book {
    static belongsTo = [user:User,bicycle:Bicycle]
    Date startDate
    Date endDate
    Integer paid // 0 -> not paid , 1 -> paid
    Integer quantity
    Integer status //0->booked, 1->taken
    Integer totalAmount
    static constraints = {
    }
}
