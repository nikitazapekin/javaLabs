//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Flat[] flats = {
                new Flat(1, 101, 55.5, 3, 2, "Ленина 10", "Панельный", 50),
                new Flat(2, 102, 72.3, 5, 3, "Пушкина 20", "Кирпичный", 60),
                new Flat(3, 103, 60.0, 2, 2, "Гагарина 5", "Монолит", 70),
                new Flat(4, 104, 90.1, 7, 4, "Советская 30", "Панельный", 40),
                new Flat(5, 105, 45.0, 1, 1, "Октябрьская 15", "Кирпичный", 80)
        };


        FlatUtils.printFlatsByRooms(flats, 2);
        FlatUtils.printFlatsByRoomsAndFloor(flats, 3, 3, 6);
        FlatUtils.printFlatsByArea(flats, 50);


    }
}