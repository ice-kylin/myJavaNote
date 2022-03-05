package test;

public class UnivariateLinearRegression {
    public static void main(String[] args) {
        double f, cost = 0, w0 = 0, w1 = 0, a = 1;

        double[][] trainingSet = new double[][]{
                new double[]{1, 1},
                new double[]{2, 5},
                new double[]{3, 11},
        };

        for (double[] data : trainingSet) {
            f = w0 + w1 * data[0];
            cost += Math.pow(data[1] - f, 2);
            w0 += a * (data[1] - f);
            w1 += a * (data[1] - f) * data[0];
        }

        System.out.println("cost = " + cost);
        System.out.println("w0 = " + w0);
        System.out.println("w1 = " + w1);
    }
}
