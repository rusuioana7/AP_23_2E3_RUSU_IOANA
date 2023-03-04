package compulsory;
import compulsory.Location;
import compulsory.Road;

public class Main {
    public static void main(String[] args){
        Location location1 = new Location("Iasi", Location.LocationType.CITY, 3,2);
        Location location2 = new Location("Bucuresti", Location.LocationType.CITY, 3,2);
        Road road_between_location1_and_location2 = new Road(location1,location2, Road.RoadType.EXPRESS, 300, 100);
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(road_between_location1_and_location2);
}
}
