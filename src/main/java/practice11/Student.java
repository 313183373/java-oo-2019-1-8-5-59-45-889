package practice11;

public class Student extends Person {

    private final Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        klass.appendMember(this);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Student. I am " + (isLeader() ? "Leader of " : "at ") + getKlass().getDisplayName() + ".";
    }

    public boolean isLeader() {
        return getKlass().hasLeader() && equals(getKlass().getLeader());
    }
}
