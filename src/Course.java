public class Course {
    private String name;
    private int credits;
    private Lecturer lecturer;

    public Course(String name, int credits, Lecturer lecturer) {
        this.name = name;
        this.credits = credits;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public String toString() {
        return getName() + " " + getCredits() + " " + getLecturer();
    }
}
