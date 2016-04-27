import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RollingStats {

    private final int k;

    // track running sum and count as numbers are added
    private double sum = 0;
    private int count = 0;

    // store only the last k numbers
    private final Queue<Double> lastk = new LinkedList<>();

    public RollingStats(int k) {
        this.k = k;
    }

    public void add(double x) {
        sum += x;
        count++;

        lastk.add(x);

        // if bigger than window, remove the first element
        if (lastk.size() > k) {
            lastk.poll();
        }
    }

    public double mean() {
        if (count == 0) {
            return Double.NaN;
        }

        return sum / count;
    }

    public double rollingMean() {
        if (count == 0) {
            return Double.NaN;
        }

        double total = 0;
        for (double value : lastk) {
            total += value;
        }
        return total / lastk.size();
    }

    public static void main(String[] args) {
//        int k = Integer.parseInt(args[0]);
        int k = Integer.parseInt("4");

        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner("15 16 13 12 14 11");

        RollingStats stats = new RollingStats(k);
        while (scanner.hasNextDouble()) {
            stats.add(scanner.nextDouble());
            System.out.printf("%.2f %.2f\n", stats.mean(), stats.rollingMean());
        }
    }
}
