package models;

public enum Color {
    WHILE("#FFFFFF"),
    BLACK("#000000"),
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    BEIGE("#F5F5DC"),

    ;

    final private String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
