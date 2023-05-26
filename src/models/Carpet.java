package models;

import java.util.HashMap;
import java.util.Map;

public class Carpet {
    private final int[][] pattern;
    private final int width = 300;
    private final int length = 400;
    private final Map<Integer, Color> colorMap;

    public Carpet() {
        this.pattern = new int[width][length];
        this.colorMap = new HashMap<>();
    }

    public int[][] getPattern() {
        return pattern;
    }

    public Map<Integer, Color> getColorMap() {
        return colorMap;
    }
}
