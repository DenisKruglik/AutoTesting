package by.bsu.students.logic;

import by.bsu.students.entity.Group;
import by.bsu.students.entity.Selectable;
import by.bsu.students.entity.Student;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    private final static String DATA_PATH = "src/main/resources/students.json";

    private List<Group> groups;
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new Calculator();

    public App() {
        Loader loader = new Loader();
        groups = loader.loadFromJson(DATA_PATH);
    }

    public void chooseAction() {
        while (true) {
            System.out.println("Choose an action:\n" +
                    "\t1. Calculate student's average mark\n" +
                    "\t2. Calculate group's average mark\n" +
                    "\t3. Exit");
            int option = getOptionFromInput();
            List<Selectable> selectableGroups;
            Group group;
            double avg;
            switch (option) {
                case 1:
                    selectableGroups = groups.stream().map((g) -> (Selectable) g).collect(Collectors.toList());
                    group = (Group) chooseFrom(selectableGroups, "group");
                    List<Selectable> selectableStudents = group.getStudents().stream().map((student) -> (Selectable)student).collect(Collectors.toList());
                    Student student = (Student) chooseFrom(selectableStudents, "student");
                    avg = calculator.calculateStudentsAvgMark(student);
                    System.out.println(avg);
                    break;
                case 2:
                    selectableGroups = groups.stream().map((g) -> (Selectable) g).collect(Collectors.toList());
                    group = (Group) chooseFrom(selectableGroups, "group");
                    avg = calculator.calculateGroupAvgMark(group);
                    System.out.println(avg);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect option!");
            }
        }
    }

    private Selectable chooseFrom(List<Selectable> variants, String title) {
        while (true) {
            System.out.println("Choose " + title + ":");
            int i = 1;
            for (Selectable item: variants) {
                System.out.println("\t" + i + ". " + item.getName());
                i++;
            }
            int option = getOptionFromInput();
            if (option < 1 || option > variants.size()) {
                System.out.println("Incorrect option!");
            } else {
                return variants.get(option - 1);
            }
        }
    }

    private int getOptionFromInput() {
        int option;
        while (true) {
            try {
                option = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input!");
                scanner.skip(".*");
            }
        }
        return option;
    }
}
