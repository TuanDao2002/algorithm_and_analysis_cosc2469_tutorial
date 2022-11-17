import java.util.ArrayList;

public class ZizagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int strLen = s.length();
        ArrayList<String>[] arr = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new ArrayList<>();
        }

        int row = 0;
        boolean down = true;
        for (int i = 0; i < strLen; i++) {
            if (row == numRows) {
                down = false;
                row -= 2;
            } else if (!down && row == -1) {
                down = true;
                row += 2;
            }

            arr[row].add(s.charAt(i) + "");
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        for (ArrayList<String> charInRow : arr) {
            for (String c : charInRow) {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
