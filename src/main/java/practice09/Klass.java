package practice09;

import java.util.ArrayList;

public class Klass {
    private int number;
    private Student leader = null;
    private ArrayList<Student> students = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    String getDisplayName() {
        return "Class " + getNumber();
    }

    void assignLeader(Student leader) {
        if (hasStudent(leader)) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private boolean hasStudent(Student student) {
        return students.stream().anyMatch(student::equals);
    }

    public Student getLeader() {
        return leader;
    }

    boolean hasLeader() {
        return getLeader() != null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof Klass) && (((Klass) obj).getNumber() == getNumber()));
    }

    void appendMember(Student student) {
        students.add(student);
    }
}
