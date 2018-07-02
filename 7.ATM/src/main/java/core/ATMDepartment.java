package core;

import java.util.ArrayList;
import java.util.List;

public class ATMDepartment {
    private List<ATM> atmList = new ArrayList<>();

    public boolean addATM(ATM atm) {
        return atmList.add(atm);
    }
    public long getTotalAmount(){
        return atmList.stream().mapToLong(value -> value.getTotal()).sum();
    }
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < atmList.size(); i++) {
            sb.append(i)
              .append(" - > ")
              .append(atmList.get(i).getTotal())
              .append("\n");
        }
        return sb.append("Total - > ")
                 .append(getTotalAmount())
                 .toString();
    }
    public void restoreAll(){
        for (ATM atm : atmList)
        {
            atm.restore();
        }
    }
}
