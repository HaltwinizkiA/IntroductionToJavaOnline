package programming.with.classes.tour_agency;

public class TravelVoucher {

    Type type;
    Place place;
    Transport vehicle;
    Feeding feeding;
    int day;


    public TravelVoucher(Type type, Place place) {
        this.type = type;
        this.place = place;
    }


    @Override
    public String toString() {
        return "TravelVoucher{" +
                "type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", vehicle=" + vehicle +
                ", feeding=" + feeding +
                ", day=" + day +
                '}';
    }
}
