import java.util.LinkedList;
import java.util.Objects;

public class Problem3 {
    static class RMITStudent {
        String studentId;
        String major;
        String fullName;
        double GPA;

        public RMITStudent(String studentId, String major, String fullName, double GPA) {
            this.studentId = studentId;
            this.major = major;
            this.fullName = fullName;
            this.GPA = GPA;
        }
    }

    static class RMITStudentCollection {
        static int N = 14;
        static LinkedList<RMITStudent>[] hashTable = new LinkedList[N];
        static int collisions = 0;

        private static int hashFunction(String str) {
            int index = 0;
            int strLen = str.length();
            for (int i = 0; i < strLen; i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    index += str.charAt(i) - 65;
                } else if (c >= '0' && c <= '9') {
                    index += c - '0' + 26;
                }
            }

            index %= N;
            return index;
        }

        boolean put(RMITStudent s) {
            int findIndex = hashFunction(s.studentId);
            if (hashTable[findIndex] != null) {
                collisions++;
                for (RMITStudent student : hashTable[findIndex]) {
                    if (Objects.equals(student.studentId, s.studentId)) {
                        return false;
                    }
                }

                hashTable[findIndex].add(s);
                System.out.println("Insert at index: " + findIndex);
                return true;
            }

            hashTable[findIndex] = new LinkedList<>();
            hashTable[findIndex].add(s);

            System.out.println("Insert at index: " + findIndex);
            return true;
        }

        boolean get(String studentId) {
            int findIndex = hashFunction(studentId);

            while (hashTable[findIndex] != null) {
                for (RMITStudent student : hashTable[findIndex]) {
                    if (Objects.equals(student.studentId, studentId)) {
                        return true;
                    }
                }

                findIndex = (findIndex + 1) % N;
            }

            return false;
        }

        void print() {
            for (LinkedList<RMITStudent> list : hashTable) {
                if (list == null) continue;
                for (RMITStudent s : list) {
                    System.out.print(s.studentId + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        RMITStudent s1 = new RMITStudent("s3877347", "IT", "Dao Kha Tuan", 3.77);
        RMITStudent s2 = new RMITStudent("s3876348", "IT", "Dao Kha Tuan", 3.77);
        RMITStudent s3 = new RMITStudent("s3877339", "IT", "Dao Kha Tuan", 3.77);
        RMITStudentCollection rmitStudentCollection = new RMITStudentCollection();

        if (rmitStudentCollection.put(s1)) {
            System.out.println("Insert s1");
        } else {
            System.out.println("Cannot insert s1");
        }

        if (rmitStudentCollection.put(s2)) {
            System.out.println("Insert s2");
        } else {
            System.out.println("Cannot insert s2");
        }

        if (rmitStudentCollection.put(s3)) {
            System.out.println("Insert s3");
        } else {
            System.out.println("Cannot insert s3");
        }

        if (rmitStudentCollection.get("s3876348")) {
            System.out.println("exist");
        } else {
            System.out.println("does not exist");
        }

        rmitStudentCollection.print();
    }
}
