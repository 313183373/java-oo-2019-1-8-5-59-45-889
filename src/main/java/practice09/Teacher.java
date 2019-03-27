package practice09;

public class Teacher extends Person {
    private Klass klass = null;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    private boolean isKlassNull() {
        return klass == null;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (isKlassNull() ? "No Class." : (getKlass().getDisplayName() + "."));
    }

    private boolean isTeaching(Student student) {
        return student.getKlass().equals(getKlass());
    }

    String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I " + (isTeaching(student) ? "" : "don't ") + "teach " + student.getName() + ".";
    }
}

