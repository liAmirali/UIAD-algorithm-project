package algorithms;

import models.Carpet;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    ArrayList<Carpet> carpets;
    int[] carpetsCosts;

    public Shop(ArrayList<Carpet> carpets) {
        this.carpets = carpets;
        this.carpetsCosts = new int[carpets.size()];
        for (int i = 0; i < carpets.size(); i++) {
            this.carpetsCosts[i] = carpets.get(i).getCost();
        }
    }

    public void buyCarpet(int money) {
        int[] values = new int[this.carpets.size()];
        Arrays.fill(values, 1);
        printKnapsack(money, this.carpets.size(), this.carpetsCosts, values);
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
                        inSack[i - 1] = true;
                    } else {
                        K[i][w] = excludeValue;
                        inSack[i - 1] = false;
                    }
                } else {
                    K[i][w] = K[i - 1][w];
                    inSack[i - 1] = false;
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
