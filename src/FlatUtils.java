public class FlatUtils {

    public static void printFlatsByRooms(Flat[] flats, int roomCount) {
        System.out.println("Квартиры с " + roomCount + " комнатами:");
        for (int i = 0; i < flats.length; i++) {
            if (flats[i] != null && flats[i].getRooms() == roomCount) {
                System.out.println(flats[i]);
            }
        }
    }


    public static void printFlatsByRoomsAndFloor(Flat[] flats, int roomCount, int minFloor, int maxFloor) {
        System.out.println("Квартиры с " + roomCount + " комнатами, этаж от " + minFloor + " до " + maxFloor + ":");
        for (int i = 0; i < flats.length; i++) {
            if (flats[i] != null && flats[i].getRooms() == roomCount &&
                    flats[i].getFloor() >= minFloor && flats[i].getFloor() <= maxFloor) {
                System.out.println(flats[i]);
            }
        }
    }


    public static void printFlatsByArea(Flat[] flats, double minArea) {
        System.out.println("Квартиры с площадью больше " + minArea + " м²:");
        for (int i = 0; i < flats.length; i++) {
            if (flats[i] != null && flats[i].getArea() > minArea) {
                System.out.println(flats[i]);
            }
        }
    }
}


/*import java.util.Arrays;

public class FlatUtils {

    public static void printFlatsByRooms(Flat[] flats, int roomCount) {
        System.out.println("Квартиры с " + roomCount + " комнатами:");
        Arrays.stream(flats)
                .filter(flat -> flat.getRooms() == roomCount)
                .forEach(System.out::println);
    }

    public static void printFlatsByRoomsAndFloor(Flat[] flats, int roomCount, int minFloor, int maxFloor) {
        System.out.println("Квартиры с " + roomCount + " комнатами, этаж от " + minFloor + " до " + maxFloor + ":");
        Arrays.stream(flats)
                .filter(flat -> flat.getRooms() == roomCount && flat.getFloor() >= minFloor && flat.getFloor() <= maxFloor)
                .forEach(System.out::println);
    }

    public static void printFlatsByArea(Flat[] flats, double minArea) {
        System.out.println("Квартиры с площадью больше " + minArea + " м²:");
        Arrays.stream(flats)
                .filter(flat -> flat.getArea() > minArea)
                .forEach(System.out::println);
    }
}
*/