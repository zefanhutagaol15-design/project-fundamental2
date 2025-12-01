public class Main {
    public static <Course> void main(String[] args) {

        // ============================
        // 1. Membuat 3 Student Objects

        Student s1 = new Student();

        // Constructor kedua: (name, major)
        Student s2 = new Student("Jane Smith", "Sistem Informasi");

        // Constructor default (tanpa parameter)
        Student s3 = new Student();
        s3.setStudentId("STD003");
        s3.setName("Michael Jordan");
        s3.setMajor("Teknik Komputer");
        s3.setEnrollmentYear(2023);

        // ============================
        // 2. Membuat 4 Course Objects

        Course c1 = new Course("CS101", "Pemrograman Dasar",3, "Pak budi");
        Course c2 = new Course("CS102", "Struktur Data", 3, "bu Ani");
        Course c3 = new Course("MTK201", "Kalkulus", 4, "pak joko");
        Course c4 = new Course("ENG105", "Bahasa Inggris", 2, "Miss linda");

        // ============================
        // 3. Membuat 6 Grade Objects

        Grade g1 = new Grade(s1, c1, 88);
        Grade g2 = new Grade(s1, c2, 91);
        Grade g3 = new Grade(s2, c1, 75);
        Grade g4 = new Grade(s2, c2, 82);

        // Grade g5 sebelumnya salah — harus berisi student + course + score
        Grade g5 = new Grade(s3, c2, 67);

        Grade g6 = new Grade(s3, c4, 45); // otomatis letter grade D/E

        // ============================
        // 4. Demonstrasi Encapsulation

        System.out.println("\n=== DEMONSTRASI ENCAPSULATION ===");
        s1.setMajor("Teknik Informatika");
        System.out.println("Major baru student 1: " + s1.getMajor());

        c1.getClass("Prof. Alexander");
        System.out.println("Dosen baru matkul CS101: " + c1.getClass());

        g1.setScore(95);
        System.out.println("Score baru grade g1: " + g1.getScore()
                + " (" + g1.getLetterGrade() + ")");

        // ============================
        // 5. Demonstrasi Static Variables

        System.out.println("\n=== STATIC VARIABLES ===");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("Total Courses: " + Course.getTotalCourses());

        // ============================
        // 6. Test Validasi (Invalid Input)

        System.out.println("\n=== TEST VALIDASI ===");
        Grade invalid = new Grade(s1, c4, 150); // score invalid (>100)

        // ============================
        // 7. Tampilkan Laporan Lengkap

        System.out.println("\n====================================");
        System.out.println("         LAPORAN LENGKAP             ");
        System.out.println("====================================");

        // ---- Daftar Mahasiswa ----
        System.out.println("\n--- DAFTAR MAHASISWA ---");
        Student[] students = {s1, s2, s3};
        for (Student s : students) {
            System.out.println(s);
        }

        // ---- Daftar Mata Kuliah ----
        System.out.println("\n--- DAFTAR MATA KULIAH ---");
        Course[] courses = {c1, c2, c3, c4};
        for (Course c : courses) {
            System.out.println(c);
        }

        // ---- Daftar Nilai ----
        System.out.println("\n--- DAFTAR NILAI ---");
        Grade[] grades = {g1, g2, g3, g4, g5, g6};
        for (Grade g : grades) {
            System.out.println(g);
        }

        // ---- Mahasiswa dengan GPA Tertinggi ----
        System.out.println("\n--- MAHASISWA DENGAN GPA TERTINGGI ---");
        Student topStudent = findHighestGPA(students);
        System.out.println("GPA Tertinggi: " + topStudent.getName()
                + " (" + topStudent.getGpa() + ")");
    }

    // ============================
    // Fungsi mencari GPA tertinggi

    public static Student findHighestGPA(Student[] list) {
        Student top = list[0];
        for (Student s : list) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }
        return top;
    }
}
