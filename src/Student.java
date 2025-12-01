public class Student {


    // Private Attributes

    private String studentId;      // Format: STD001, STD002, ...
    private String name;           // Nama mahasiswa
    private String major;          // Jurusan
    private int enrollmentYear;    // Tahun masuk
    private double gpa;            // IPK mahasiswa

    private static int totalStudents = 0; // Counter mahasiswa


    // Default Constructor

    public Student() {
        totalStudents++;
        this.studentId = generateStudentId();
        this.name = "Unknown";
        this.major = "Unknown";
        this.enrollmentYear = 0;
        this.gpa = 0.0;
    }

    // Parameterized Constructor

    public Student(String name, String major) {
        totalStudents++;
        this.studentId = generateStudentId();
        this.name = name;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.gpa = 0.0; // default
    }


    // Private Method: Auto ID Generator

    private String generateStudentId() {
        return String.format("STD%03d", totalStudents);
    }

    // ============================
    // Getter & Setter Methods
    // ============================
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("IPK harus antara 0.0 - 4.0");
        }
    }

    public static int getTotalStudents() {
        return totalStudents;
    }


    // Additional Method: Display Student Info

    public void displayInfo() {
        System.out.println("===== STUDENT INFO =====");
        System.out.println("ID        : " + studentId);
        System.out.println("Name      : " + name);
        System.out.println("Major     : " + major);
        System.out.println("Enrolled  : " + enrollmentYear);
        System.out.println("GPA       : " + gpa);
    }

    public void setStudentId(String std003) {
    }
}
