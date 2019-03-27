package practice10;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private LinkedList<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes.addAll(classes);
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    private boolean isKlassNull() {
        return getClasses().size() == 0;
    }

    private String getClassesDisplayName() {
        return "Class " + classes.stream().map(klass -> Integer.toString(klass.getNumber())).collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (isKlassNull() ? "No Class." : (getClassesDisplayName() + "."));
    }

    boolean isTeaching(Student student) {
        return getClasses().stream().anyMatch(klass -> klass.hasStudent(student));
    }

    String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I " + (isTeaching(student) ? "" : "don't ") + "teach " + student.getName() + ".";
    }
}
