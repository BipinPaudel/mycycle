package mycycle

class Photo {

    String photoLocation;

    static belongsTo = [bicycles:Bicycle]
    static constraints = {
    }
}
