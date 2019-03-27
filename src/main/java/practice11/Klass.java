package practice11;

import java.util.ArrayList;

public class Klass {
    private int number;
    private Student leader = null;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private static final String NEW_STUDENTS = "NEW_STUDENTS";
    private static final String NEW_LEADER = "NEW_LEADER";

    public Klass(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public Student getLeader() {
        return leader;
    }

    String getDisplayName() {
        return "Class " + getNumber();
    }

    void assignLeader(Student leader) {
        if (hasStudent(leader)) {
            this.leader = leader;
            notifyAllTeachers(leader, NEW_LEADER);
        } else {
            System.out.println("It is not one of us.");
        }
    }

    void appendMember(Student student) {
        students.add(student);
        notifyAllTeachers(student, NEW_STUDENTS);
    }

    void appendTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    boolean hasStudent(Student student) {
        return students.stream().anyMatch(student::equals);
    }

    boolean hasLeader() {
        return getLeader() != null;
    }

    private void notifyAllTeachers(Student student, String event) {
        switch (event) {
            case NEW_STUDENTS: {
                teachers.stream().filter(teacher -> teacher.isTeaching(student)).forEach(teacher -> teacher.welcomeNewStudent(student, this));
                break;
            }
            case NEW_LEADER: {
                teachers.stream().filter(teacher -> teacher.isTeaching(student)).forEach(teacher -> teacher.welcomeNewLeader(student, this));
                break;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof Klass) && (((Klass) obj).getNumber() == getNumber()));
    }
}
