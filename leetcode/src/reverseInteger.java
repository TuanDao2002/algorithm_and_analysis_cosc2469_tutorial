public class reverseInteger {
    public static int reverse(int x) {
        long result = 0;
        boolean negative = x < 0;

        int abs = Math.abs(x);
        while (abs > 0) {
            result = result * 10 + abs % 10;
            if (result > Math.pow(2, 31) || result < -Math.pow(2, 31)) return 0;
            abs = abs / 10;
        }

        if (negative) return (int) -result;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
