package mycycle

class Category {
        Integer price
        String type

        static hasMany = [bicycle:Bicycle]


}
