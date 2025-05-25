package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> List<T> loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл данных не найден. Будет создан новый при сохранении.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static <T extends Serializable> void saveData(String filename, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }
}