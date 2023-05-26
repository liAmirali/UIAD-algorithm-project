import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static void runShopTest() {
        ArrayList<Carpet> carpets = new ArrayList<>();
        carpets.add(new Carpet(200));
        carpets.add(new Carpet(100));
        carpets.add(new Carpet(400));
        carpets.add(new Carpet(900));
        carpets.add(new Carpet(500));
        Shop shop = new Shop(carpets);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your money: ");
        int money = scanner.nextInt();
        shop.buyCarpet(money);
    }
}
