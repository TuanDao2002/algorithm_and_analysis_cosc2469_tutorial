public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int strLen = s.length();
        int mid = strLen / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(strLen - i - 1)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
