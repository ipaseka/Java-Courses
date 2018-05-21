package core;

import core.exeptions.NotEnoughCashException;

import java.util.HashMap;
import java.util.TreeSet;

public class ATM {
    private CashRegister mainRegister = new CashRegister();

    public void registerCash(int value, int count) {
        mainRegister.add(value, count);
    }

    public void registerCash(int value) {
        mainRegister.add(value);
    }

    @Override
    public String toString() {
        return mainRegister.toString();
    }

    public CashRegister getMoney(long value) throws NotEnoughCashException{
        CashRegister registerToReturn = null;
        if (mainRegister.getTotal() < value)
            throw new NotEnoughCashException();
        if (mainRegister.getTotal() == value) {
            registerToReturn = new CashRegister(mainRegister);
        }
        else {
            registerToReturn = new CashRegister();
            HashMap<Integer, Integer> billMap = mainRegister.getBillMap();
            TreeSet<Integer> keys = new TreeSet<>(billMap.keySet());
            Integer key;
            long valueRemains = value;
            while ((key = keys.pollLast()) != null)
            {
                if (key > valueRemains)
                    continue;
                int i = (int) (valueRemains / key);
                if (i == 0)
                    continue;
                registerToReturn.add(key, Math.min(i, billMap.get(key)));
                valueRemains = value - registerToReturn.getTotal();
                if (valueRemains <  1)
                    break;
            }
            if (valueRemains != 0)
                throw new NotEnoughCashException();
        }
        mainRegister.remove(registerToReturn);
        return registerToReturn;
    }
}
