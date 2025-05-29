package Part2;

import Part2.Model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentProcessor {

    public static void main(String[] args) {
        List<Student> students = createStudentsList();
        String targetMiddleName = "Ivanovich";
        System.out.println("1. Список студентов с отчеством '" + targetMiddleName + "':");
        printStudentsByPatronymic(students, targetMiddleName);
        System.out.println("\n2. Число студентов в каждой группе:");
        printStudentsCountByGroupStream(students);
        System.out.println("\n3. Список всех студентов в верхнем регистре:");

        printStudentsUppercaseStream(students);
    }

    public static void printStudentsByPatronymic(List<Student> students, String patronymic) {
        System.out.println("\nСтуденты с отчеством '" + patronymic + "':");
        if (patronymic.equals("Ivanovna") || patronymic.equals("Ivanovich")) {
            students.stream()
                    .filter(s -> s.getMiddleName().equals("Ivanovna") || s.getMiddleName().equals("Ivanovich"))
                    .forEach(System.out::println);
        } else if (patronymic.equals("Fedorovna") || patronymic.equals("Fedorovich")) {
            students.stream()
                    .filter(s -> s.getMiddleName().equals("Fedorovna") || s.getMiddleName().equals("Fedorovich"))
                    .forEach(System.out::println);
        } else {
            students.stream()
                    .filter(s -> s.getMiddleName().equals(patronymic))
                    .forEach(System.out::println);
        }
    }



    public static void printStudentsCountByGroupStream(List<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()))
                .forEach((group, count) ->
                        System.out.println("Группа " + group + ": " + count + " студентов"));
    }

    public static void printStudentsUppercaseStream(List<Student> students) {
        students.stream()
                .map(student -> student.toString().toUpperCase())
                .forEach(System.out::println);
    }
    private static List<Student> createStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ivanov", "Ivan", "Ivanovich", 2000,
                "ул. Ленина, 10", "1234567", "Информатика", 3, "И-31"));
        students.add(new Student(2, "Petrova", "Anna", "Ivanovna", 2001,
                "ул. Пушкина, 5", "2345678", "Математика", 2, "М-21"));
        students.add(new Student(3, "Sidorov", "Sidor", "Sidorovich", 1999,
                "ул. Гагарина, 15", "3456789", "Физика", 4, "Ф-41"));
        students.add(new Student(4, "Smirnova", "Elena", "Ivanovna", 2000,
                "ул. Мира, 20", "4567890", "Информатика", 3, "И-32"));
        students.add(new Student(5, "Kuznetsov", "Dmitry", "Viktorovich", 2002,
                "ул. Солнечная, 3", "5678901", "Математика", 1, "М-11"));
        students.add(new Student(6, "Popova", "Olga", "Ivanovna", 2001,
                "ул. Лесная, 7", "6789012", "Физика", 2, "Ф-21"));
        students.add(new Student(7, "Volkov", "Sergey", "Alexandrovich", 2000,
                "ул. Садовая, 12", "7890123", "Информатика", 3, "И-31"));
        students.add(new Student(8, "Kozlov", "Mikhail", "Dmitrievich", 1999,
                "ул. Центральная, 1", "8901234", "Математика", 4, "М-41"));
        students.add(new Student(9, "Novikova", "Tatiana", "Ivanovna", 2001,
                "ул. Молодежная, 9", "9012345", "Физика", 2, "Ф-22"));
        students.add(new Student(10, "Fedorov", "Nikolay", "Vasilievich", 2000,
                "ул. Школьная, 4", "0123456", "Информатика", 3, "И-32"));
        return students;
    }
}