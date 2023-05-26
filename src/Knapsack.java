import java.util.ArrayList;

public class Knapsack {

    public void buyCarpet(int money) {
        ArrayList<Carpet> carpets = new ArrayList<>(); // must change with carpets from system


    }

    public int[][] knapsack(int capacity, int n, int[] weights, int[] values) {
        int[][] K = new int[n + 1][capacity + 1];
        boolean[] inSack = new boolean[n];


        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weights[i - 1] <= w)
                    K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K;
    }

    public void printKnapsack(int[][] array, int capacity, int n, int[] weights, int[] values) {

    }
}
