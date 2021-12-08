import java.util.Arrays;
import java.util.List;

/**
 * Day03
 */
public class Day03 {
    public static void part1() {
        List<String> strings = Util.loadStringList("day03.txt");
        int[] data = new int[strings.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(strings.get(i), 2);
        }

        int bitCount = strings.get(0).length();
        System.out.println("bitCount: " + bitCount);
        int[] counters = new int[bitCount];
        for (int i = 0; i < data.length; i++) {
            int v = data[i];
            for (int j = 0; j < bitCount; j++) {
                if ((v & 1) == 1) {
                    counters[bitCount - 1 - j]++;
                }
                v = v >> 1;
            }

        }

        System.out.println("counters: " + Arrays.toString(counters));

        int gamma = 0;

        for (int i = 0; i < bitCount; i++) {
            int delta = (counters[i] > data.length / 2) ? 1 : 0;
            gamma = (gamma << 1) + delta;
            System.out
                    .println(i + ": delta " + delta + ", gamma: " + Integer.toBinaryString(gamma));
        }

        int epsilon = (int) (Math.pow(2, bitCount)) - gamma - 1;
        System.out.println("epsilon: " + epsilon);
        System.out.println("power consumption: " + gamma * epsilon);
    }

    public static void main(String[] args) {
        part1();
    }
}
