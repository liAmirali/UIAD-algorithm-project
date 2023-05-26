import java.util.ArrayList;

public class Knapsack {

    public void buyCarpet(int money) {
        ArrayList<Carpet> carpets = new ArrayList<>(); // must change with carpets from system

    }

    public boolean[] knapsack(int capacity, int n, int[] weights, int[] values) {
        int[][] K = new int[n + 1][capacity + 1];
        boolean[] inSack = new boolean[n];
        int includeValue, excludeValue;

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weights[i - 1] <= w) {
                    includeValue = values[i - 1] + K[i - 1][w - weights[i - 1]];
                    excludeValue = K[i - 1][w];
                    if (includeValue > excludeValue) {
                        K[i][w] = includeValue;
                        inSack[i] = true;
                    } else {
                        K[i][w] = excludeValue;
                        inSack[i] = false;
                    }
                }
                else {
                    K[i][w] = K[i - 1][w];
                    inSack[i] = false;
                }
            }
        }

        return inSack;
    }

    public void printKnapsack(int capacity, int n, int[] weights, int[] values) {
        boolean[] sack = knapsack(capacity, n, weights, values);
        int sackWeight = 0;
        int sackValue = 0;
        for (int i = 0; i < sack.length; i++) {
            if (sack[i]) {
                System.out.println("The cost: " + weights[i] + " | The value: " + values[i]);
                sackValue += values[i];
                sackWeight += weights[i];
            }
        }
        System.out.println("Total sack value: " + sackValue + "|| Total sack weight: " + sackWeight);
    }
}
