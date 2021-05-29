package com.labs.client;

import com.labs.client.generated.Student;
import com.labs.client.generated.CRUDService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/CRUDService?wsdl");
        CRUDService studentService = new CRUDService(url);

        // Консольный выбор CRUD метода
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose CRUD method (input CREATE, READ, UPDATE or DELETE), or input 'exit' for exit:");
        String choosenMethod;
        do {
            choosenMethod = scanner.nextLine();
            // проверим строку на наличие аргумента: если строка не является пустой и не состоит из пробелов, то
            // проверяем на наличие одной из возможных операций
            if (choosenMethod != null && !choosenMethod.trim().isEmpty()) {

                switch (choosenMethod) {
                    case ("CREATE"):
                        createStudentRow(studentService);
                        System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                        break;
                    case ("READ"):
                        readStudentRowsByFields(studentService);
                        System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                        break;
                    case ("UPDATE"):
                        updateStudentRowById(studentService);
                        System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                        break;
                    case ("DELETE"):
                        deleteStudentRowById(studentService);
                        System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                        break;
                    case ("exit"):
                        System.out.println("Bye-Bye!");
                        break;
                    default:
                        System.out.println("You can input just CREATE, READ, UPDATE or DELETE!");
                        System.out.println("Try again or use 'exit' for exit.");
                        break;
                }
            }
        } while (!Objects.equals(choosenMethod, "exit"));
        scanner.close();
    }

    private static void updateStudentRowById(CRUDService studentService) {

        // TODO: Добавить возможность ввода лишь части полей для обновления
        // TODO: Скорректировать повторяющийся фрагмент кода - см. createStudentRow() метод
        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input rowID (integer): ");
        String rowIDString = scanner.nextLine();
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input surname: ");
        String surname = scanner.nextLine();
        System.out.print("Input age (integer): ");
        String ageString = scanner.nextLine();
        System.out.print("Input student_id (integer): ");
        String studentIdString = scanner.nextLine();
        System.out.print("Input mark: ");
        String mark = scanner.nextLine();

        int age;
        int studentId;

        // проверим ввод на наличие значений: строка не является пустой и не состоит из пробелов
        if ((rowIDString != null && !rowIDString.trim().isEmpty())  &&
                (name != null && !name.trim().isEmpty()) &&
                (surname != null && !surname.trim().isEmpty()) &&
                (ageString != null && !ageString.trim().isEmpty()) &&
                (studentIdString != null && !studentIdString.trim().isEmpty()) &&
                (mark != null && !mark.trim().isEmpty())) {
            try {
                int rowId = Integer.parseInt(rowIDString.trim());
                age = Integer.parseInt(ageString.trim());
                studentId = Integer.parseInt(studentIdString.trim());
                status = studentService.getStudentWebServicePort().updateStudent(rowId, name, surname, age, studentId, mark);
                if (status.equals("1")) status = "Good";
                System.out.println("Status: " + status);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect age or studentId value!");
            }
        }
        else {
            System.out.println("Your request is incorrect!");
        }
    }

    private static void deleteStudentRowById(CRUDService studentService) {
        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input rowID (integer): ");
        String rowIDString = scanner.nextLine();

        try {
            int rowId = Integer.parseInt(rowIDString.trim());
            status = studentService.getStudentWebServicePort().deleteStudent(rowId);
            if (status.equals("1")) status = "Good";
            System.out.println("Status: " + status);
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect rowId value! Input just one integer.");
        }
    }


    private static void readStudentRowsByFields(CRUDService studentService) {
        List<Student> students = studentService.getStudentWebServicePort().getStudentsByFields(getArgsForSearch());
        for (Student student : students) {
            System.out.println("Student: " + "name=" + student.getName() + ", surname=" + student.getSurname() +
                    ", age=" + student.getAge() + ", student_id=" + student.getStudentId() + ", mark=" +
                    student.getMark() + ";");
        }
    }

    private static void createStudentRow(CRUDService studentService) {

        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input surname: ");
        String surname = scanner.nextLine();
        System.out.print("Input age (integer): ");
        String ageString = scanner.nextLine();
        System.out.print("Input student_id (integer): ");
        String studentIdString = scanner.nextLine();
        System.out.print("Input mark: ");
        String mark = scanner.nextLine();

        int age;
        int studentId;

        // проверим ввод на наличие значений: строка не является пустой и не состоит из пробелов
        if ((name != null && !name.trim().isEmpty())  &&
                (surname != null && !surname.trim().isEmpty()) &&
                (ageString != null && !ageString.trim().isEmpty()) &&
                (studentIdString != null && !studentIdString.trim().isEmpty()) &&
                (mark != null && !mark.trim().isEmpty())) {
            try {
                age = Integer.parseInt(ageString.trim());
                studentId = Integer.parseInt(studentIdString.trim());
                status = studentService.getStudentWebServicePort().createStudent(name, surname, age, studentId, mark);
                if (status.equals("1")) status = "Good";
                System.out.println("Status: " + status);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect age or studentId value!");
            }
        }
        else {
            System.out.println("Your request is incorrect!");
        }
    }

    private static List<String> getArgsForSearch() {
        List<String> given_args = new ArrayList<String>();

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input arguments below (one line = one argument, input 'complete' for get results): ");
        String given_arg;
        do {
            given_arg = scanner.nextLine();
            // проверим строку на наличие аргумента: если строка не является пустой и не состоит из пробелов, то
            // добавляем аргумент в массив
            if (given_arg != null && !given_arg.trim().isEmpty()) {
                given_args.add(given_arg);
            }
        } while (!Objects.equals(given_arg, "complete"));

        return given_args;
    }
}