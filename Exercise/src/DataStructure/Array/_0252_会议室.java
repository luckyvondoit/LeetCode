package DataStructure.Array;

import java.util.Arrays;

public class _0252_会议室 {
    public boolean canAttendMeettings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return false;
        Arrays.sort(intervals,(m1, m2) -> m1[0] - m2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0252_会议室 obj = new _0252_会议室();
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(obj.canAttendMeettings(intervals1));
        System.out.println(obj.canAttendMeettings(intervals2));
    }
}
