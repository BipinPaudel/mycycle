package mycycle

class Photo {

    int CategoryId;
    String photoLocation;

    static belongsTo = [bicycles:Bicycle]
    static constraints = {
    }
}
