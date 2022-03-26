package Algorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static int select(int capacity, int[] weights) {
        if (capacity < 1) return 0;
        if (weights == null || weights.length == 0) return 0;

        Arrays.sort(weights);
        int len = weights.length;

        int count = 0;
        int weight = 0;

        for (int i = 0; i < len; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int capacity = 30;
        int[] weights = {3,5,4,10,7,14,2,11};
        System.out.println("共选择" + Knapsack.select(capacity, weights) + "件");
    }
}
