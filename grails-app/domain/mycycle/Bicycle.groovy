package mycycle

class Bicycle {
    int categoryId
    String title
    int quantity
    Date date
    int totalPrice
    String description
    int remaining

    static belongsTo = [categories:Category]

}
