package Algorithm.Sorting.Sort;

import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static double[] sort(double[] array) {
        // 桶数组
        if (array == null || array.length == 0) return null;
        int len = array.length;
        List[] buckets = new List[len];
        for (int i = 0; i < len; i++) {
            int bucketIndex = (int)(array[i] * len);
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }

        // 对每个桶进行排序
        int index = 0;
        for (int i = 0; i < len; i++) {
            List<Double> bucket = buckets[i];
            if (bucket == null) continue;
            bucket.sort(null);
            for (Double d: bucket) {
                array[index++] = d;
            }
        }
        return array;
    }
}
