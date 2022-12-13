public class PowWithSqrt {
    static int powWithSqrt(int X, int N, int mod) {
        if (N == 0) return 1 % mod;

        int sqrt = powWithSqrt(X, N / 2, mod);
        if (N % 2 == 0) {
            return (sqrt * sqrt) % mod;
        } else {
            return (X * (sqrt * sqrt) % mod) % mod;
        }
    }

    public static void main(String[] args) {
        System.out.println(powWithSqrt(2, 2, 2));
    }
}
