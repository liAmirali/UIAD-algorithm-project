import algorithms.SequenceAlignment;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1 = "GCATGCG";
        String str2 = "GATTACA";

        int mismatchPenalty = 3;
        int gapPenalty = 2;

        String[] answer = SequenceAlignment.align(str1, str2, mismatchPenalty, gapPenalty);
        System.out.println(Arrays.toString(answer));
    }
}
