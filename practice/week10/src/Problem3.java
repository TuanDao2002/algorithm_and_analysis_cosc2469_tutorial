import java.text.DecimalFormat;

public class Problem3 {
    public static String sqrt(double value, int numOfDigits) {
        if (value < 0) return "-1";
        if (value <= 1) return String.valueOf(value);

        double low = 0;
        double high = value;
        double expectedResult = (low + high) / 2;

        while (Math.abs(value - expectedResult * expectedResult) > Math.pow(0.1, numOfDigits)) {
            if (value < expectedResult * expectedResult) {
                high = expectedResult;
            } else if (value > expectedResult * expectedResult) {
                low = expectedResult;
            }

            expectedResult = (low + high) / 2;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(numOfDigits);
        return df.format(expectedResult);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(99999, 9));
    }
}
