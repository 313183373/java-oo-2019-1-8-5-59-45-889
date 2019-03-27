package practice08;

public class Klass {
    private int number;
    private Student leader = null;

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
        this.leader = leader;
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
}
