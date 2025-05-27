package util;

import model.ComputerUsage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<ComputerUsage> loadDataFromFile(String filename) {
        List<ComputerUsage> usages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int computerNumber = Integer.parseInt(parts[0]);
                    usages.add(new ComputerUsage(
                            computerNumber,
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4]
                    ));
                }
            }
            System.out.println("Данные успешно загружены из файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Будет создан новый при сохранении.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return usages;
    }

    public static void saveDataToFile(String filename, List<ComputerUsage> usages) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (ComputerUsage usage : usages) {
                writer.println(usage.toCSVString());
            }
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
}