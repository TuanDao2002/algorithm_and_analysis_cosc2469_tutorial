public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int strLen = strs[0].length();
        int strsLen = strs.length;

        if (strsLen == 1) return strs[0];

        String longestCommonPrefix = result.toString();

        for (int i = 0; i < strLen; i++) {
            boolean match = true;
            for (int j = 1; j < strsLen; j++) {
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                result.append(strs[0].charAt(i));
                if (i == strLen - 1) {
                    longestCommonPrefix = result.toString();
                }
            } else {
                longestCommonPrefix = result.toString();
                break;
            }
        }

        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "b"}));
    }
}
