package Algorithm.Sequence;

public class KMP {
    public static int indexOf(String text, String pattern) {
        if (text == null || text.length() == 0) return -1;
        if (pattern == null || pattern.length() == 0) return -1;
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen < plen) return -1;
        int ti = 0, tmax = tlen - plen;
        int pi = 0;
        int[] next = next(pattern);
        while (pi < plen && ti - pi <= tmax) {
            if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
                pi++;
                ti++;
            } else {
                pi = next[pi];
            }
        }
        return pi == plen ? ti - pi : -1;
    }

    public static int[] next(String pattern) {
        int len = pattern.length();
        int i = 0, imax = len - 1;
        int[] next = new int[len];
        next[i] = -1;
        int n  = -1;
        while (i < imax) {
            if (n < 0 || pattern.charAt(n) == pattern.charAt(i)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
