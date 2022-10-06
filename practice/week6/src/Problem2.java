import java.util.Objects;

public class Problem2 {
    static class ADT {
        static int N = 14;
        static String[] hashTable = new String[N];
        static int collisions = 0;
        static String DELETED = "Deleted";

        private static int hashFunction(String str) {
            int index = 0;
            int strLen = str.length();
            for (int i = 0; i < strLen; i++) {
                index += str.charAt(i) - 65;
            }

            index %= N;
            return index;
        }

        static boolean insert(String str) {
            int findIndex = hashFunction(str);
            while (hashTable[findIndex] != null && !Objects.equals(hashTable[findIndex], DELETED)) {
                collisions++;
                if (Objects.equals(hashTable[findIndex], str)) {
                    return false;
                }
                findIndex = (findIndex + 1) % N;
            }

            hashTable[findIndex] = str;
            return true;
        }

        static int getIndex(String str) {
            int findIndex = hashFunction(str);

            while (hashTable[findIndex] != null && !Objects.equals(hashTable[findIndex], DELETED)) {
                if (Objects.equals(hashTable[findIndex], str)) return findIndex;
                findIndex = (findIndex + 1) % N;
            }

            return -1;
        }

        static boolean remove(String str) {
            if (getIndex(str) == -1) return false;
            int findIndex = getIndex(str);
            hashTable[findIndex] = DELETED;
            return true;
        }
    }

    public static void main(String[] args) {
        String[] test = new String[]{"A", "B", "C", "ABC", "D", "E", "DEF", "CBA", "XYZ", "BAC", "BAC"};

        for (String s : test) {
            if (ADT.insert(s)) {
                System.out.println("Insert " + s);
            } else {
                System.out.println("Cannot insert " + s);
            }
        }

        System.out.println("Collisions: " + ADT.collisions);

        for (String s : ADT.hashTable) {
            System.out.print(s + " ");
        }
        System.out.println();

        if (ADT.remove("BAC")) {
            System.out.println("Remove BAC");
        } else {
            System.out.println("Cannot remove BAC");
        }

        for (String s : ADT.hashTable) {
            System.out.print(s + " ");
        }
        System.out.println();

        if (ADT.remove("ABC")) {
            System.out.println("Remove BAC");
        } else {
            System.out.println("Cannot remove BAC");
        }

        if (ADT.insert("ABC")) {
            System.out.println("Insert ABC");
        } else {
            System.out.println("Cannot insert ABC");
        }

        for (String s : ADT.hashTable) {
            System.out.print(s + " ");
        }
    }
}
