import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPratt {

    public static void main(String args[]) {
        boolean verbose = false;

        if (args.length == 3 && args[0].equals("-v")) {
            verbose = true;
        } else if (args.length < 2 || (args.length > 2 && args[0] != "-v")) {
            usage();
            return;
        }

        if (verbose) {
            int[] next = initNext(args[2]);
            System.out.print("Next Array: [");
            for (int i = 0; i < next.length; i++) {
                System.out.print(next[i]);
                if (i != next.length - 1)
                    System.out.print(", ");
            }
            System.out.print("]\n");
            System.out.print(kmp(args[1], args[2]));
        } else {
            System.out.print(kmp(args[0], args[1]));
        }
    }

    public static String kmp(String t, String p) {
        int[] next = initNext(p);
        String out = "";
        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && p.charAt(j) != t.charAt(i))
                j = next[j - 1];

            if (p.charAt(j) == t.charAt(i))
                j += 1;

            if (j == p.length()) {
                int pos = i - j + 1;
                out += "Pattern detected at position: " + pos + "\n";
                j = next[j - 1];
            }
        }

        return out != "" ? out : "Pattern not detected in text\n";
    }

    public static int[] initNext(String p) {
        int[] next = new int[p.length()];

        next[0] = 0;
        int l = 0;

        for (int q = 1; q < p.length(); q++) {
            while (l > 0 && p.charAt(l) != p.charAt(q))
                l = next[l - 1];

            if (p.charAt(l) == p.charAt(q))
                l += 1;

            next[q] = l;
        }

        return next;
    }

    public static void usage() {
        System.out.println("Usage: java KMP [-v] <text> <pattern>");
    }
}
