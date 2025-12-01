public class Grade {

    // ============================
    // Private Attributes
    // ============================
    private Student student;      // Object mahasiswa
    private Course course;        // Object mata kuliah
    private double score;         // Nilai angka
    private String letterGrade;   // Nilai huruf (A, B+, dst)


    // ============================
    // Constructor
    // ============================
    public Grade(Student student, Course course, double score) {
        this.student = student;
        this.course = course;
        this.score = score;
        calculateLetterGrade(); // otomatis hitung nilai huruf
    }

    public <Course> Grade(Student s2, Course c2, int score) {
    }


    // ============================
    // Method: Hitung Letter Grade
    // ============================
    public void calculateLetterGrade() {
        if (score >= 85) {
            letterGrade = "A";
        } else if (score >= 80) {
            letterGrade = "A-";
        } else if (score >= 75) {
            letterGrade = "B+";
        } else if (score >= 70) {
            letterGrade = "B";
        } else if (score >= 65) {
            letterGrade = "B-";
        } else if (score >= 60) {
            letterGrade = "C+";
        } else if (score >= 55) {
            letterGrade = "C";
        } else if (score >= 50) {
            letterGrade = "D";
        } else {
            letterGrade = "E";
        }
    }


    // ============================
    // Method: Grade Point (untuk GPA)
    // ============================
    public double getGradePoint() {
        switch (letterGrade) {
            case "A":  return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B":  return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C":  return 2.0;
            case "D":  return 1.0;
            default:   return 0.0; // E
        }
    }


    // ============================
    // Method: Cek Lulus
    // ============================
    public boolean isPassing() {
        return !letterGrade.equals("D") && !letterGrade.equals("E");
    }


    // ============================
    // Display Grade
    // ============================
    public void displayGrade() {
        System.out.println("==== GRADE REPORT ====");
        System.out.println("Student    : " + student.getName() + " (" + student.getStudentId() + ")");
        System.out.println("Course     : " + course.getCourseCode() + " - " + course.getCourseName());
        System.out.println("Score      : " + score);
        System.out.println("Letter     : " + letterGrade);
        System.out.println("Status     : " + (isPassing() ? "Lulus" : "Tidak Lulus"));
        System.out.println();
    }


    // ============================
    // Getters & Setters
    // ============================
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
        calculateLetterGrade(); // update letter ketika score berubah
    }

    public String getLetterGrade() {
        return letterGrade;
    }
}
