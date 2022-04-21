import java.util.*;

public class MyITCenter {
    private final List<Lecturer> lecturers = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public MyITCenter() {
        init();
    }

    public void init() {
        Lecturer l1 = new Lecturer("Pham Van Tinh", new GregorianCalendar(1970,
                Calendar.NOVEMBER, 20).getTime(), "PhD");
        Lecturer l2 = new Lecturer("Mai Anh Tho", new GregorianCalendar(1979, Calendar.DECEMBER,
                24).getTime(), "MS");
        Lecturer l3 = new Lecturer("Nguyen Duc Cong Song", new GregorianCalendar(
                1977, Calendar.SEPTEMBER, 14).getTime(), "MS");
        lecturers.add(l1);
        lecturers.add(l2);
        lecturers.add(l3);

        Course c1 = new Course("Lap trinh co ban", 4, l2);
        Course c2 = new Course("Lap trinh nang cao", 4, l3);
        Course c3 = new Course("Lap trinh mang", 4, l1);
        Course c4 = new Course("Mang may tinh", 4, l1);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        Student s1 = new Student("Nguyen Van Tuan", new GregorianCalendar(1988, Calendar.FEBRUARY,23).getTime());
        Student s2 = new Student("Tran Van Thiet", new GregorianCalendar(1989, Calendar.DECEMBER,2).getTime());
        Student s3 = new Student("Nguyen Thi Lan", new GregorianCalendar(1988, Calendar.JULY,20).getTime());
        Student s4 = new Student("Nguyen Thi Truc", new GregorianCalendar(1990, Calendar.MAY,15).getTime());
        Student s5 = new Student("Vo Tan Doi", new GregorianCalendar(1988, Calendar.MARCH,26).getTime());
        Student s6 = new Student("Do The Sang", new GregorianCalendar(1989, Calendar.APRIL,12).getTime());
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        s1.register(c1);
        s1.register(c2);
        s1.register(c3);

        s2.register(c2);
        s2.register(c3);
        s2.register(c4);

        s3.register(c1);
        s3.register(c2);
        s3.register(c3);
        s3.register(c4);

        s4.register(c1);
        s4.register(c3);
        s4.register(c4);

        s5.register(c1);
        s5.register(c2);
        s5.register(c3);
        s5.register(c4);

        s6.register(c1);
        s6.register(c2);

        s1.updateGrade(c1, 6);
        s1.updateGrade(c2, 7);
        s1.updateGrade(c3, 8);

        s2.updateGrade(c2, 8.5f);
        s2.updateGrade(c3, 5);
        s2.updateGrade(c4, 7);

        s3.updateGrade(c1, 4);
        s3.updateGrade(c2, 7.5f);
        s3.updateGrade(c3, 8);
        s3.updateGrade(c4, 10);

        s4.updateGrade(c1, 8);
        s4.updateGrade(c3, 3);
        s4.updateGrade(c4, 6);

        s5.updateGrade(c1, 5);
        s5.updateGrade(c2, 4);
        s5.updateGrade(c3, 6);
        s5.updateGrade(c4, 8);

        s6.updateGrade(c1, 5);
        s6.updateGrade(c2, 8);
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("---------------------------------");
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name))
                return student;
        }
        return null;
    }

    public Course findCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }

    public List<Student> getStudentsOfCourse(Course course) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            for (Register register : student.getCourseRegisters()) {
                if (register.getCourse().getName().equals(course.getName())) {
                    result.add(student);
                }
            }
        }
        return result;
    }

    public void printStudentReportCardUseCase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        Student student = findStudentByName(name);
        if (student == null) {
            System.out.println("Student name not found!");
        } else {
            student.printGradeReport();
        }
    }

    public void printStudentOfCourseUseCase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        Course course = findCourseByName(name);
        if (course == null) {
            System.out.println("Course name not found!");
        } else {
            printList(getStudentsOfCourse(course));
        }
    }

    public static void main(String[] args) {
        MyITCenter myCenter = new MyITCenter();
        myCenter.printStudentReportCardUseCase();
        myCenter.printStudentOfCourseUseCase();
    }
}
