package mycycle

class Bicycle {
    String title
    Integer quantity
    Date date
    Integer totalPrice
    String description
    Integer remaining

    static belongsTo = [categories:Category]

}
