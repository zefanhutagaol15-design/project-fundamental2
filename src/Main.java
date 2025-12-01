import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("============================================\n");

        // --------------------------------------------
        // REGISTRASI MAHASISWA
        // --------------------------------------------
        System.out.println("=== REGISTRASI MAHASISWA ===");

        Student s1 = new Student("Adila Dwi Septiani", "Sistem Informasi", 2024);
        Student s2 = new Student("Chelsi Enatalia", "Sistem Informasi", 2024);
        Student s3 = new Student("Engela Taebenu", "Sistem Informasi", 2024);

        System.out.println(" Mahasiswa berhasil ditambahkan: " + s1.getStudentId() + " - " + s1.getName());
        System.out.println(" Mahasiswa berhasil ditambahkan: " + s2.getStudentId() + " - " + s2.getName());
        System.out.println(" Mahasiswa berhasil ditambahkan: " + s3.getStudentId() + " - " + s3.getName());


        // --------------------------------------------
        // REGISTRASI MATA KULIAH
        // --------------------------------------------
        System.out.println("\n=== REGISTRASI MATA KULIAH ===");

        Course c1 = new Course("Pemrograman Berorientasi Obejek", 3, "Sir. Jeremy Panjaitan");
        Course c2 = new Course("Struktur Data", 3, "Sir. Pandia");
        Course c3 = new Course("Pemrograman Web 1", 3, "sir. Jay Idoan");
        Course c4 = new Course("Matematika Diskrit", 2, "sir. ALbinur Limbong");

        System.out.println(" Mata kuliah berhasil ditambahkan: CS101 - Pemrograman Dasar");
        System.out.println(" Mata kuliah berhasil ditambahkan: CS102 - Struktur Data");
        System.out.println(" Mata kuliah berhasil ditambahkan: MTK201 - Pemrograman Web 1");
        System.out.println(" Mata kuliah berhasil ditambahkan: ENG101 - Matematika Diskrit");


        // --------------------------------------------
        // INPUT NILAI
        // --------------------------------------------
        System.out.println("\n=== INPUT NILAI ===");

        Grade g1 = new Grade(s1, c1, 85);
        Grade g2 = new Grade(s1, c2, 78);
        Grade g3 = new Grade(s2, c1, 92);
        Grade g4 = new Grade(s2, c4, 88);
        Grade g5 = new Grade(s3, c3, 65);
        Grade g6 = new Grade(s3, c1, 70);

        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(g1); grades.add(g2); grades.add(g3);
        grades.add(g4); grades.add(g5); grades.add(g6);

        for (Grade g : grades) {
            System.out.println(" Nilai berhasil diinput: "
                    + g.getStudent().getName() + " - "
                    + g.getCourse().getCourseName() + ": "
                    + (int) g.getScore() + " (" + g.getLetterGrade() + ")");
        }



        hitungGPA(s1, grades);
        hitungGPA(s2, grades);
        hitungGPA(s3, grades);


        // --------------------------------------------
        // DAFTAR MAHASISWA
        // --------------------------------------------
        System.out.println("\n============================================");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("============================================");

        printStudent(s1);
        printStudent(s2);
        printStudent(s3);

        System.out.println("============================================");
        System.out.println("Total Mahasiswa: 3\n");


        // --------------------------------------------
        // DAFTAR MATA KULIAH
        // --------------------------------------------
        System.out.println("============================================");
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("============================================");

        System.out.println("[CS101] Pemrograman Dasar (3 SKS) - Sir. Jeremy Panjaitan");
        System.out.println("[CS102] Struktur Data (3 SKS) - Sir. Pandia");
        System.out.println("[MTK201] Pemrograman Web 1 (3 SKS) - sir. Jay Idoan");
        System.out.println("[ENG101] Matematika Diskrit (2 SKS) - Sit. Albinur Limbong");

        System.out.println("============================================");
        System.out.println("Total Mata Kuliah: 4\n");


        // --------------------------------------------
        // DAFTAR NILAI
        // --------------------------------------------
        System.out.println("============================================");
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("============================================");

        for (Grade g : grades) {
            System.out.println("Mahasiswa : " + g.getStudent().getName() + " (" + g.getStudent().getStudentId() + ")");
            System.out.println("Mata Kuliah : " + g.getCourse().getCourseName() + " (" + g.getCourse().getCourseCode() + ")");
            System.out.println("Nilai : " + (int) g.getScore()
                    + " | Grade: " + g.getLetterGrade()
                    + " | Point: " + g.getGradePoint()
                    + " | Status: " + (g.isPassing() ? "LULUS ✓" : "TIDAK LULUS ✗"));
            System.out.println("--------------------------------------------");
        }

        System.out.println("============================================\n");


        // --------------------------------------------
        // STATISTIK SISTEM
        // --------------------------------------------
        System.out.println("============================================");
        System.out.println("STATISTIK SISTEM");
        System.out.println("============================================");

        Student highest = getHighestGPA(s1, s2, s3);

        System.out.println("Mahasiswa dengan GPA Tertinggi: " + highest.getName() + " (" + highest.getGpa() + ")");
        System.out.println("Total Mahasiswa Terdaftar: 3");
        System.out.println("Total Mata Kuliah Tersedia: 4");
        System.out.println("============================================");
    }


    // ================================================================
    // FUNCTION: Hitung GPA mahasiswa dari seluruh grade
    // ================================================================
    public static void hitungGPA(Student s, ArrayList<Grade> list) {
        double totalPoints = 0;
        int totalCourses = 0;

        for (Grade g : list) {
            if (g.getStudent() == s) {
                totalPoints += g.getGradePoint();
                totalCourses++;
            }
        }

        if (totalCourses > 0) {
            double gpa = totalPoints / totalCourses;
            s.setGpa(gpa);
        }
    }


    // ================================================================
    // FUNCTION: Cetak Student Detail
    // ================================================================
    public static void printStudent(Student s) {
        System.out.println("[" + s.getStudentId() + "] " + s.getName());
        System.out.println("Jurusan       : " + s.getMajor());
        System.out.println("Tahun Masuk   : " + s.getEnrollmentYear());
        System.out.printf("GPA           : %.2f\n", s.getGpa());
        System.out.println("Status        : " + s.getStudentStatus());
        System.out.println("Lama Kuliah   : " + s.getStudyDuration() + " tahun");
        System.out.println("--------------------------------------------");
    }


    // ================================================================
    // FUNCTION: Cari GPA tertinggi
    // ================================================================
    public static Student getHighestGPA(Student... students) {
        Student highest = students[0];
        for (Student s : students) {
            if (s.getGpa() > highest.getGpa()) {
                highest = s;
            }
        }
        return highest;
    }
}