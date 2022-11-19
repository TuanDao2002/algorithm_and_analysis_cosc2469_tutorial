public class StudentBST {
    public static class Student {
        public int id;
        public String name;
        public double GPA;

        public Student(int id, String name, double GPA) {
            this.id = id;
            this.name = name;
            this.GPA = GPA;
        }
    }

    public static class StudentNode {
        public Student student;
        public StudentNode left;
        public StudentNode right;

        public StudentNode(Student student) {
            this.student = student;
        }

        public void add(Student newStudent) {
            if (newStudent.GPA < student.GPA) {
                if (left == null) {
                    left = new StudentNode(newStudent);
                } else {
                    left.add(newStudent);
                }
            } else {
                if (right == null) {
                    right = new StudentNode(newStudent);
                } else {
                    right.add(newStudent);
                }
            }
        }
    }

    StudentNode root;
    public StudentBST(StudentNode root) {
        this.root = root;
    }

    // addStudent complexity O(logN)
    void addStudent(Student student) {
        root.add(student);
    }

    private StudentNode search(Student student) {
        StudentNode node = root;
        while (node != null) {
            if (node.student.GPA == student.GPA) {
                return node;
            }
            if (student.GPA < node.student.GPA) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    // nextStudentEasy complexity O(logN)
    Student nextStudentEasy(Student student) {
        StudentNode studentNode = search(student);
        if (studentNode == null) return null;
        StudentNode left = studentNode.left;
        StudentNode right = studentNode.right;

        StudentNode findStudentNode = right;
        double minGPA = Integer.MAX_VALUE;

        while (right != null) {
            StudentNode curr = right.left;
            if (curr == null) break;
            if (curr.student.GPA < minGPA) {
                findStudentNode = curr;
                minGPA = curr.student.GPA;
            }

            right = curr.left;
        }

        while (left != null) {
            StudentNode curr = left.right;
            if (curr == null) break;
            if (curr.student.GPA < minGPA && curr.student.GPA >= studentNode.student.GPA) {
                findStudentNode = curr;
                minGPA = curr.student.GPA;
            }

            left = curr.right;
        }

        return findStudentNode.student;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
        Student s2 = new Student(2, "B", 65.0);
        Student s3 = new Student(3, "C", 80.0);
        Student s4 = new Student(4, "D", 78.0);
        Student s5 = new Student(5, "E", 68.0);

        StudentBST studentBST = new StudentBST(new StudentNode(s1));
        studentBST.addStudent(s2);
        studentBST.addStudent(s3);
        studentBST.addStudent(s4);
        studentBST.addStudent(s5);

        System.out.println(studentBST.nextStudentEasy(s1).GPA);
    }
}
