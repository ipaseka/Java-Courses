import core.ATM;
import core.exeptions.NotEnoughCashException;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.registerCash(1, 250);
        atm.registerCash(2, 500);
        atm.registerCash(5, 150);
        atm.registerCash(10, 800);
        atm.registerCash(1, 1500);
        atm.registerCash(50, 80);
        atm.registerCash(500);
        atm.registerCash(100, 62);
        atm.registerCash(5, 120);
        atm.registerCash(500);
        atm.registerCash(500, 9);

        atm.registerCash(52, 9);
        System.out.println(atm);

        try {
            System.out.println(atm.getMoney(15001));
        } catch (NotEnoughCashException e) {
            System.out.println("Not enough cash for this operation");
        }
        System.out.println(atm);

    }
}
