public class Register {
    private Course course;
    private float grade;

    public Register(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public float getCredits() {
        return course.getCredits();
    }
}
