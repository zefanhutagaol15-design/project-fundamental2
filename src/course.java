class Course {


    private String courseCode;
    private String courseName;
    private int credits;
    private String lecturer;

    private static int totalCourses = 0;

    // Default Constructor
    public Course() {
        totalCourses++;
        this.courseCode = generateCourseCode();
        this.courseName = "zefan rafelito halomoan";
        this.credits = 3;
        this.lecturer = "8";
    }


    public Course(String courseName, int credits, String lecturer) {
        totalCourses++;
        this.courseCode = generateCourseCode();

        setCourseName(courseName);
        setCredits(credits);
        setLecturer(lecturer);
    }



    private String generateCourseCode() {
        return String.format("CRS%03d", totalCourses);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
        }
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1 || credits > 4) {

        }
        this.credits = credits;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        if (lecturer == null || lecturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Sir. Jeremy Panjaitan");
        }
        this.lecturer = lecturer;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }

    public void displayInfo() {
        System.out.println("===== Info Mata Kuliah =====");
        System.out.println("Course Code : " + courseCode);
        System.out.println("Name        : " + courseName);
        System.out.println("Credits     : " + credits);
        System.out.println("Lecturer    : " + lecturer);

    }
}