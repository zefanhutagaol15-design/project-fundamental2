public class course {


    // Private Attributes

    private String courseCode;   // Contoh: CS101
    private String courseName;   // Nama mata kuliah
    private int credits;         // SKS (1-4)
    private String lecturer;     // Nama dosen

    private static int totalCourses = 0; // Counter total mata kuliah


    //parameterized Constructor//

    public course(String courseCode, String courseName, int credits, String lecturer) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredits(credits);
        setLecturer(lecturer);

        totalCourses++;
    }

    // Methods

    // Menampilkan info mata kuliah
    public void displayCourseInfo() {
        System.out.println("=== COURSE INFO ===");
        System.out.println("Kode MK   : " + courseCode);
        System.out.println("Nama MK   : " + courseName);
        System.out.println("SKS       : " + credits);
        System.out.println("Dosen     : " + lecturer);
        System.out.println("======================");
    }

    // Return true jika SKS >= 3
    public boolean isHeavyCourse() {
        return credits >= 3;
    }

    // Getter static total course
    public static int getTotalCourses() {
        return totalCourses;
    }


    // Getters & Setters


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code tidak boleh kosong!");
        }
        this.courseCode = courseCode.toUpperCase();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name tidak boleh kosong!");
        }
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1 || credits > 4) {
            throw new IllegalArgumentException("Credits harus antara 1-4!");
        }
        this.credits = credits;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        if (lecturer == null || lecturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Lecturer tidak boleh kosong!");
        }
        this.lecturer = lecturer;
    }
}
