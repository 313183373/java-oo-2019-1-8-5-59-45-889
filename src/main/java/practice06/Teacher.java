package practice06;

public class Teacher extends Person {
    private Integer klass = null;

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public int getKlass() {
        return klass;
    }

    private boolean isKlassNull() {
        return klass == null;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (isKlassNull() ? "No Class." : ("Class " + getKlass() + "."));
    }
}
