public class Flat {
    private int id;
    private int number;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private String buildingType;
    private int serviceLife;


    public Flat() {}

    public Flat(int id, int number, double area, int floor, int rooms, String street, String buildingType, int serviceLife) {
        this.id = id;
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = buildingType;
        this.serviceLife = serviceLife;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public int getRooms() { return rooms; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getBuildingType() { return buildingType; }
    public void setBuildingType(String buildingType) { this.buildingType = buildingType; }
    public int getServiceLife() { return serviceLife; }
    public void setServiceLife(int serviceLife) { this.serviceLife = serviceLife; }

    @Override
    public String toString() {
        return "Квартира: " +
                "id=" + id +
                ", number=" + number +
                ", area=" + area +
                ", floor=" + floor +
                ", rooms=" + rooms +
                ", street='" + street + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", serviceLife=" + serviceLife ;
    }
}
