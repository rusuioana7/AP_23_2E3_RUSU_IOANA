package compulsory;

public class Road {
    public enum RoadType{
        HIGHWAY, EXPRESS, COUNTRY;
    }
    private RoadType roadtype;
    public Location startlocation;
    public Location endlocation;

    public Road(Location startlocation, Location endlocation, RoadType roadtype, double length, double speedlimit){
        this.startlocation=startlocation;
        this.endlocation=endlocation;
        this.roadtype = roadtype;
        this.length = length;
        this.speedlimit = speedlimit;
    }

    double length ;
    double speedlimit;

    public RoadType getRoadtype() {
        return roadtype;
    }

    public void setRoadtype(RoadType roadtype) {
        this.roadtype = roadtype;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;

    }

    /*public void calculatelength(){
        double x1= startlocation.getX();
        double x2= endlocation.getX();
        double y1= startlocation.getY();
        double y2= endlocation.getY();

        double length = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }*/

    public double getSpeedlimit() {
        return speedlimit;
    }

    public void setSpeedlimit(double speedlimit) {
        this.speedlimit = speedlimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "roadtype=" + roadtype +
                ", startlocation=" + startlocation +
                ", endlocation=" + endlocation +
                ", length=" + length +
                ", speedlimit=" + speedlimit +
                '}';
    }

}
