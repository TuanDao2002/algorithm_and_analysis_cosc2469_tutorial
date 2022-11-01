public class LongestSubstring {
    static public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder subStr = new StringBuilder();
        int strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            for (int j = i; j < strLen; j++) {
                if (subStr.toString().indexOf(s.charAt(j)) == -1) {
                    subStr.append(s.charAt(j));
                } else {
                    break;
                }

                if (subStr.length() > maxLength) {
                    maxLength = subStr.length();
                }
            }

            subStr = new StringBuilder();
        }

        return maxLength;
    }

    // apply sliding window technique
    static public int lengthOfLongestSubstringWindowSlicing(String str) {
        StringBuilder test = new StringBuilder();

        // Result
        int maxLength = -1;

        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character
            // Then substring after repeating character
            if (test.toString().contains(current)) {
                test = new StringBuilder(test.substring(test.indexOf(current) + 1));
            }
            test.append(c);
            System.out.println(test);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringWindowSlicing("abcabcbb"));
//        System.out.println(lengthOfLongestSubstringWindowSlicing("bbbbb"));
//        System.out.println(lengthOfLongestSubstringWindowSlicing("pwwkew"));
//        System.out.println(lengthOfLongestSubstringWindowSlicing(" "));
    }
}
