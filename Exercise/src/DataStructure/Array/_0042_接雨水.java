package DataStructure.Array;

public class _0042_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lastIndex = height.length - 2;

        // 边界处无法储存水，index取值[1, height.length - 2]
        int[] leftMax = new int[height.length];
        for (int i = 1; i <= lastIndex; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        int[] rightMax = new int[height.length];
        for (int i = lastIndex; i >=1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int water = 0;
        for (int i = 1; i <= lastIndex; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                water += min - height[i];
            }
        }
        return water;
    }

    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, lowerMax = 0, water = 0;
        while (l < r) {
            int lower = height[l] < height[r] ? height[l++] : height[r--];
            lowerMax = Math.max(lowerMax, lower);
            water += lowerMax - lower;
        }
        return water;
    }
}
