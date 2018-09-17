package by.bsu.students.logic;

import by.bsu.students.entity.Group;
import by.bsu.students.entity.Student;

import java.util.List;

public class Calculator {
    public double calculateStudentsAvgMark(Student student) {
        List<Integer> marks = student.getMarks();
        double sum = 0;
        for (Integer mark: marks) {
            sum += mark;
        }
        return sum / marks.size();
    }

    public double calculateGroupAvgMark(Group group) {
        List<Student> students = group.getStudents();
        double sum = 0;
        for (Student student: students) {
            sum += calculateStudentsAvgMark(student);
        }
        return sum / students.size();
    }
}
