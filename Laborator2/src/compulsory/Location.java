package compulsory;

public class Location {
        private String name;
        private LocationType locationtype;
        private double x;
        private double y;
        public enum LocationType{
            CITY, AIRPORT, GAS_STATION, VILLAGE, SCHOOL;
        }

        public Location(String name, LocationType locationtype, double x, double y){
            this.name = name;
            this.locationtype = locationtype;
            this.x = x;
            this.y = y;
        }

        public void setName (String n){
            this.name = n;
        }
        public String getName(){
            return name;
        }

        public LocationType getLocationType() {
            return locationtype;
        }

        public void setLocationtype(LocationType locationtype) {
            this.locationtype = locationtype;
        }

        public double getX() {
            return x;
        }
        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }
        public void setY(double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "name='" + name + '\'' +
                    ", locationtype=" + locationtype +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

