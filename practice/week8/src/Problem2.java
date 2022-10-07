public class Problem2 {
    static int matching(String str, String substr) {
        int strlen = str.length();
        int subLen = substr.length();
        for (int i = 0; i < strlen - subLen + 1; i++) {
            for (int j = 0; j < subLen; j++) {
                if (str.charAt(i + j) != substr.charAt(j)) break;
                if (j == subLen - 1) return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(matching("Hello", "ell"));
        System.out.println(matching("Hello", "l"));
        System.out.println(matching("Hello", "Hello"));
        System.out.println(matching("Hello", "T"));
    }
}
