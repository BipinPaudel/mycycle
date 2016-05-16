package mycycle

class Category {
        int id
        int price
        String type
        static hasMany = [bicycles:Bicycle]


}
