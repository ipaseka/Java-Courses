import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Number> customList = new CustomList<>();
        Collections.addAll(customList, 5,4,3,2,1,4,5,3,34,432,2,3,2,3,23,2);
        for (Number n : customList)
            System.out.println("n = " + n);

        List<Object> copyTo = new CustomList<>();
        Collections.addAll(copyTo, "","","","","","","","","","","","","","tenis",",","","tenis","tenis");
        Collections.copy(copyTo, customList);
        for (Object n: copyTo)
            System.out.println("n = " + n);

        Comparator<Number> comp = (o1, o2) -> (o1.doubleValue() > o2.doubleValue()) ? 1 : (o2.doubleValue() > o1.doubleValue()) ? -1 : 0;
        Collections.sort(customList, comp);
        for (Number n: customList)
            System.out.println("n = " + n);
    }
}
