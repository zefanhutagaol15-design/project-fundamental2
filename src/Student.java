public class Student {

    private String studentId;
    private String name;
    private String major;
    private int enrollmentYear;
    private double gpa;

    private static int totalStudents = 0;


    //Constructor
    public Student() {
        totalStudents++;
        this.studentId = generateStudentId();
        this.name = "zefan rafelito halomoan";
        this.major = "Sistem Informasi";
        this.enrollmentYear = 2024;
        this.gpa = 3.65;
    }

    public Student(String name, String major, int enrollmentYear) {
        totalStudents++;
        this.studentId = generateStudentId();

        setName(name);
        setMajor(major);
        setEnrollmentYear(enrollmentYear);
        this.gpa = 0.0;
    }


    private String generateStudentId() {
        return String.format("STD%03d", totalStudents);
    }


    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("Jurusan tidak boleh kosong.");
        }
        this.major = major;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        if (enrollmentYear < 2015 || enrollmentYear > 2025) {
            throw new IllegalArgumentException("Tahun masuk harus antara 2015 - 2025.");
        }
        this.enrollmentYear = enrollmentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
        }
        this.gpa = gpa;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }


    // Menghitumg lama kuliah
    public int getStudyDuration() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - enrollmentYear;
    }

    // Update GPA
    public void updateGPA(double newGPA) {
        setGpa(newGPA);
    }

    // Status berdasarkan GPA
    public String getStudentStatus() {
        if (gpa >= 3.5) return "Cumlaude";
        if (gpa >= 3.0) return "Sangat Memuaskan";
        if (gpa >= 2.5) return "Memuaskan";
        return "Perlu Peningkatan";
    }

    // Tampilkan info lengkap
    public void displayInfo() {
        System.out.println("===== Informasi Mahasiswa =====");
        System.out.println("ID            : " + studentId);
        System.out.println("Name          : " + name);
        System.out.println("Major         : " + major);
        System.out.println("Enrollment Yr : " + enrollmentYear);
        System.out.println("GPA           : " + gpa);
        System.out.println("Status        : " + getStudentStatus());
        System.out.println("Study Duration: " + getStudyDuration() + " tahun");
        System.out.println("========================");
    }
}