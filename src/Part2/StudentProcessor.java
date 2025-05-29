package Part2;

import Part2.Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentProcessor {

    public static void main(String[] args) {

        List<Student> students = createStudentsList();


        String targetFaculty = "Информатика";

        System.out.println("Студенты факультета " + targetFaculty + " (традиционный способ):");
        printStudentsByFacultyTraditional(students, targetFaculty);

        System.out.println("\nСтуденты факультета " + targetFaculty + " (Stream API):");
        printStudentsByFacultyStream(students, targetFaculty);
    }

    private static List<Student> createStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ivanov", "Ivan", "Ivanovich", 2000,
                "ул. Ленина, 10", "1234567", "Информатика", 3, "И-31"));
        students.add(new Student(2, "Petrov", "Petr", "Petrovich", 2001,
                "ул. Пушкина, 5", "2345678", "Математика", 2, "М-21"));
        students.add(new Student(3, "Sidorov", "Sidor", "Sidorovich", 1999,
                "ул. Гагарина, 15", "3456789", "Физика", 4, "Ф-41"));
        students.add(new Student(4, "Smirnov", "Alexey", "Sergeevich", 2000,
                "ул. Мира, 20", "4567890", "Информатика", 3, "И-32"));
        students.add(new Student(5, "Kuznetsov", "Dmitry", "Viktorovich", 2002,
                "ул. Солнечная, 3", "5678901", "Математика", 1, "М-11"));
        students.add(new Student(6, "Popov", "Andrey", "Olegovich", 2001,
                "ул. Лесная, 7", "6789012", "Физика", 2, "Ф-21"));
        students.add(new Student(7, "Volkov", "Sergey", "Alexandrovich", 2000,
                "ул. Садовая, 12", "7890123", "Информатика", 3, "И-31"));
        students.add(new Student(8, "Kozlov", "Mikhail", "Dmitrievich", 1999,
                "ул. Центральная, 1", "8901234", "Математика", 4, "М-41"));
        students.add(new Student(9, "Novikov", "Pavel", "Igorevich", 2001,
                "ул. Молодежная, 9", "9012345", "Физика", 2, "Ф-22"));
        students.add(new Student(10, "Fedorov", "Nikolay", "Vasilievich", 2000,
                "ул. Школьная, 4", "0123456", "Информатика", 3, "И-32"));
        return students;
    }
    public static void printStudentsByFacultyTraditional(List<Student> students, String faculty) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
    }
    public static void printStudentsByFacultyStream(List<Student> students, String faculty) {
        students.stream()
                .filter(student -> student.getFaculty().equals(faculty))
                .forEach(System.out::println);
    }
}