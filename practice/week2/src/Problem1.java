public class Problem1 {
    static int calculateExponential(int a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a;

        int result = 1;
        int squareRoot;
        if (n % 2 == 0) {
            squareRoot = calculateExponential(a, n / 2);
        } else {
            result *= a;
            squareRoot = calculateExponential(a, (n - 1) / 2);
        }

        result *= squareRoot * squareRoot;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(calculateExponential(3, 2));
    }
}
