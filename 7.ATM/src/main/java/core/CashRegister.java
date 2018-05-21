package core;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CashRegister {
   private HashMap<Integer, Integer> billMap = new HashMap<>();

   public CashRegister() {

   }
   public CashRegister(CashRegister cr) {
       billMap = cr.getBillMap();
   }
   public void add (int value) {
       add(value, 1);
   }
   public void add (int value, int count) {
       if (count < 1)
           throw new IllegalArgumentException("Count value is less then 1: " + count);

       Integer oldValue = billMap.get(value) == null ? 0 : billMap.get(value);
       billMap.put(value, oldValue + count);
   }
   public long getTotal() {
       long total = 0;
       for (Integer val: billMap.keySet())
       {
           total += val * billMap.get(val);
       }
       return total;
   }
   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(" Bill \t\t Count \t\t Amount\n");
       TreeSet<Integer> keys = new TreeSet<>(billMap.keySet());
       Integer val;
       while ((val = keys.pollFirst()) != null)
       {
           long localSum = val * billMap.get(val);
           sb.append(" " + val + "   \t\t " + billMap.get(val) + " \t\t " + localSum + "\n");
       }
       sb.append("\n Total Amount = " + getTotal());
       return sb.toString();
   }
   public HashMap<Integer, Integer> getBillMap() {
       return new HashMap<>(billMap);
   }
   public void remove(CashRegister toRemove) {
       Objects.requireNonNull(toRemove);
       HashMap<Integer, Integer> mapToRemove = toRemove.getBillMap();
       for (Integer key: mapToRemove.keySet())
       {
           if (!billMap.containsKey(key))
               throw new IllegalArgumentException("No such Bill to remove: " + key.toString());
           if (billMap.get(key) < mapToRemove.get(key))
               throw new IllegalArgumentException("Not enough count of Bills to remove, for Bill " + key.toString() + ", Exist: " + billMap.get(key) + ", Try to remove: " + mapToRemove.get(key)+ ".");
           if (billMap.get(key).equals(mapToRemove.get(key)))
               billMap.remove(key);
           else
               billMap.put(key, billMap.get(key) - mapToRemove.get(key));
       }
   }
}
