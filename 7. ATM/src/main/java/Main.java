import core.ATM;
import core.ATMDepartment;
import core.exeptions.NotEnoughCashException;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        ATM atm2 = new ATM();
        ATMDepartment atmDepartment = new ATMDepartment();
        atmDepartment.addATM(atm);
        atmDepartment.addATM(atm2);
        atm.registerCash(1, 250);
        atm.registerCash(2, 500);
        atm.registerCash(5, 150);
        atm.registerCash(10, 800);
        atm.registerCash(1, 1500);
        atm.registerCash(50, 80);
        atm2.registerCash(500);
        atm2.registerCash(100, 62);
        atm2.registerCash(5, 120);
        atm2.registerCash(500);
        atm2.registerCash(500, 9);
        atm2.registerCash(52, 9);
        atm.flush();
        atm2.flush();

        System.out.println(atmDepartment);
        try {
            System.out.println(atm.getMoney(600));
            System.out.println(atm2.getMoney(6000));
        } catch (NotEnoughCashException e) {
            System.out.println("Not enough cash for this operation");
        }
        System.out.println(atmDepartment);
        atmDepartment.restoreAll();
        System.out.println(atmDepartment);

    }
}
