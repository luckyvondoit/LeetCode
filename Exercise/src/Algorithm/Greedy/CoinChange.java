package Algorithm.Greedy;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(Integer[] faces, int money) {
        if (money <= 0) return 0;
        if (faces == null || faces.length == 0) return 0;

        Arrays.sort(faces, (Integer f1, Integer f2) -> f2 - f1);

        int len = faces.length;
        int count = 0;
        int remain = money;

        for (int i = 0; i < len; i++) {
            if (remain < faces[i]) {
                continue;
            }
            remain -= faces[i];
            count++;
        }
        return count;
    }
}
