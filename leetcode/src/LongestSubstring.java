public class LongestSubstring {
    static public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder subStr = new StringBuilder();
        int strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            if (subStr.toString().indexOf(s.charAt(i)) == -1) {
                subStr.append(s.charAt(i));
            } else {
                if (subStr.length() > maxLength) {
                    maxLength = subStr.length();
                }

                subStr = new StringBuilder();
                subStr.append(s.charAt(i));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
