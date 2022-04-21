import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private Date dateOfBirth;
    private Lecturer assistant;
    private List<Register> courseRegisters = new ArrayList<>();

    public Student(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Lecturer getAssistant() {
        return assistant;
    }

    public List<Register> getCourseRegisters() {
        return courseRegisters;
    }

    public void register(Course c) {
        courseRegisters.add(new Register(c));
    }

    public void updateGrade(Course c, float grade) {
        for (Register r : courseRegisters) {
            if (r.getCourse().getName().equals(c.getName())) {
                r.setGrade(grade);
                break;
            }
        }
    }

    public float averageOfGrade() {
        float sum = 0;
        int creditToal = 0;
        for (Register r : courseRegisters) {
            sum += r.getGrade() * r.getCredits();
            creditToal += r.getCredits();
        }
        return sum / creditToal;
    }

    public String rank() {
        float average = averageOfGrade();
        if (average >= 9) return "XUAT SAC";
        else if (average >= 8) return "GIOI";
        else if (average >= 7) return "KHA";
        else if (average >= 6) return "TRUNG BINH KHA";
        else if (average >= 5) return "TRUNG BINH";
        else return "ROT";
    }

    public void printGradeReport() {
        System.out.println("Name: " + getName());
        System.out.println("Date of birth: " + new SimpleDateFormat("dd/MM/yyyy").format(getDateOfBirth()));
        System.out.println("STT\tMon\tDiem");
        for (int i = 0; i < courseRegisters.size(); i++) {
            System.out.println(i + 1 + "\t" + courseRegisters.get(i).getCourse().getName() + "\t" +
                    courseRegisters.get(i).getGrade());
        }
        System.out.println("Average: " + averageOfGrade());
        System.out.println("Rank: " + rank());
        System.out.println("-----------------------------------------------------");
    }

    public String toString() {
        return getName() + " " + new SimpleDateFormat("dd/MM/yyyy").format(getDateOfBirth());
    }
}
