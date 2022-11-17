public class StudentCollection {
    static class Student {
        private String ID;
        private String name;
        private double GPA;

        public Student(String ID, String name, double GPA) {
            this.ID = ID;
            this.name = name;
            this.GPA = GPA;
        }
    }

    private int size;
    private static int MAX_SIZE = 100;
    private Student[] students;

    public StudentCollection() {
        size = 0;
        students = new Student[MAX_SIZE];
    }

    // addStudent complexity = O(N)
    public void addStudent(Student std) {
        boolean exists = false;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (students[i].ID.equals(std.ID)) {
                    exists = true;
                    break;
                }
            }
        }

        if (!exists) {
            students[size] = std;
            size++;
        }
    }

    // searchByName complexity = O(N * n * m), with n is the length of string of each student, m is the length of input string
    public Student searchByName(String name) {
        for (int i = 0; i < size; i++) {
            if (students[i].name.contains(name)) {
                return students[i];
            }
        }

        return null;
    }

    // rankStudent complexity = O(N)
    public int rankStudent(String sID) {
        int rank = 1;
        boolean exist = false;
        Student foundStudent = null;
        for (int i = 0; i < size; i++) {
            if (students[i].ID.equals(sID)) {
                exist = true;
                foundStudent = students[i];
                break;
            }
        }

        if (!exist) return -1;

        for (int i = 0; i < size; i++) {
            if (!students[i].name.equals(sID)) {
                if (students[i].GPA > foundStudent.GPA) {
                    rank++;
                }
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        StudentCollection studentCollection = new StudentCollection();
        Student s1 = new Student("s1", "tuan1", 3.2);
        Student s2 = new Student("s2", "tuan2", 3.4);
        Student s3 = new Student("s3", "tuan3", 3.9);
        Student s4 = new Student("s1", "tuan1", 2.3);

        studentCollection.addStudent(s1);
        studentCollection.addStudent(s2);
        studentCollection.addStudent(s3);
        studentCollection.addStudent(s4);

        for (int i = 0; i < studentCollection.size; i++) {
            System.out.println(studentCollection.students[i].name);
        }

        Student findStu = studentCollection.searchByName("tuan");
        System.out.println(findStu.name);

        System.out.println(studentCollection.rankStudent("s1"));
    }
}
