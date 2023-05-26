package algorithms;


// Needleman–Wunsch algorithm
public class SequenceAlignment {
    public SequenceAlignment() {
    }

    public static String[] align(String x, String y, int pxy, int pgap) {
        int m = x.length();
        int n = y.length();

        int[][] table = new int[n + m + 1][n + m + 1];

        // Initializing the table
        for (int i = 0; i <= (n + m); i++) {
            table[i][0] = i * pgap;
            table[0][i] = i * pgap;
        }


        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1];
                else
                    table[i][j] = Math.min(Math.min(table[i - 1][j - 1] + pxy, table[i - 1][j] + pgap), table[i][j - 1] + pgap);

        // Reconstructing the solution
        int l = n + m;

        int i = m;
        int j = n;

        int xpos = l;
        int ypos = l;

        // Final answers for the respective strings
        int[] xans = new int[l + 1];
        int[] yans = new int[l + 1];

        while (!(i == 0 || j == 0)) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                xans[xpos--] = x.charAt(i - 1);
                yans[ypos--] = y.charAt(j - 1);
                i--;
                j--;
            } else if (table[i - 1][j - 1] + pxy == table[i][j]) {
                xans[xpos--] = x.charAt(i - 1);
                yans[ypos--] = y.charAt(j - 1);
                i--;
                j--;
            } else if (table[i - 1][j] + pgap == table[i][j]) {
                xans[xpos--] = x.charAt(i - 1);
                yans[ypos--] = '_';
                i--;
            } else if (table[i][j - 1] + pgap == table[i][j]) {
                xans[xpos--] = '_';
                yans[ypos--] = y.charAt(j - 1);
                j--;
            }
        }
        while (xpos > 0)
            if (i > 0) xans[xpos--] = x.charAt(--i);
            else xans[xpos--] = '_';

        while (ypos > 0)
            if (j > 0) yans[ypos--] = y.charAt(--j);
            else yans[ypos--] = '_';

        // Finding the index that the actual answers start
        int start = 1;
        for (i = l; i >= 1; i--)
            if ((char) yans[i] == '_' && (char) xans[i] == '_') {
                start = i + 1;
                break;
            }

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (i = start; i < l; i++)
            str1.append((char) xans[i]);

        for (i = start; i < l; i++)
            str2.append((char) yans[i]);


        return new String[]{str1.toString(), str2.toString()};
    }
}
