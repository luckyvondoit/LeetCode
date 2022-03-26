package Algorithm.Sequence;

public class BF {
    public int indexOf(String text, String pattern) {
        if (text == null || text.length() == 0) return -1;
        if (pattern == null || pattern.length() ==0) return -1;
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen < plen) return -1;
        int tmax = tlen - plen;

        int ti = 0;
        while (ti <= tmax) {
            int pi = 0;
            while (pi < plen) {
                if (text.charAt(ti + pi) != pattern.charAt(pi)) break;
                pi++;
            }
            if (pi == plen) return ti;

            ti++;
        }

        return -1;
    }

    public static void main(String[] args) {
        BF bf = new BF();
        String s = "abcdefg";
        String p = "cd";
        System.out.println(bf.indexOf(s, p));
    }
}
