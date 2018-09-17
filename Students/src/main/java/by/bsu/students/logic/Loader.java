package by.bsu.students.logic;

import by.bsu.students.entity.Group;
import by.bsu.students.entity.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loader {

    private final static String NAME_KEY = "name";
    private final static String STUDENTS_KEY = "students";
    private final static String MARKS_KEY = "marks";

    public List<Group> loadFromJson(String filename) {
        List<Group> groups = new ArrayList<Group>();
        String json = readFile(filename);
        JSONArray groupsRaw = new JSONArray(json);
        for (Object aGroupsRaw : groupsRaw) {
            Group group = new Group();
            JSONObject groupRaw = (JSONObject) aGroupsRaw;
            String groupName = groupRaw.getString(NAME_KEY);
            group.setName(groupName);
            JSONArray studentsRaw = groupRaw.getJSONArray(STUDENTS_KEY);
            Iterator<Object> studentIterator = studentsRaw.iterator();
            List<Student> students = new ArrayList<Student>();
            while (studentIterator.hasNext()) {
                JSONObject studentRaw = (JSONObject) studentIterator.next();
                String studentName = studentRaw.getString(NAME_KEY);
                JSONArray marksRaw = studentRaw.getJSONArray(MARKS_KEY);
                List<Object> marksUnconverted = marksRaw.toList();
                List<Integer> marks = new ArrayList<Integer>(marksUnconverted.size());
                for (Object mark : marksUnconverted) {
                    marks.add((Integer) mark);
                }
                Student student = new Student(studentName, marks);
                students.add(student);
            }
            group.setStudents(students);
            groups.add(group);
        }
        return groups;
    }

    private String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
