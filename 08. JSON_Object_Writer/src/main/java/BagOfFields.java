import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BagOfFields {
    private int intVal;
    private String stringVal;
    private boolean booleanVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public boolean isBooleanVal() {
        return booleanVal;
    }

    public void setBooleanVal(boolean booleanVal) {
        this.booleanVal = booleanVal;
    }

    public int[] getIntArrVal() {
        return intArrVal;
    }

    public void setIntArrVal(int[] intArrVal) {
        this.intArrVal = intArrVal;
    }

    public String[] getStrArrVal() {
        return strArrVal;
    }

    public void setStrArrVal(String[] strArrVal) {
        this.strArrVal = strArrVal;
    }

    private int[] intArrVal = {12, 32, 33, 77, 90};
    private String[] strArrVal = {"one", "data"};

    @Override
    public String toString() {
        return "BagOfFields{" +
                "intVal=" + intVal +
                ", stringVal='" + stringVal + '\'' +
                ", booleanVal=" + booleanVal +
                ", intArrVal=" + Arrays.toString(intArrVal) +
                ", strArrVal=" + Arrays.toString(strArrVal) +
                ", listVal=" + listVal +
                '}';
    }

    private List<Float> listVal = new ArrayList<>();

    public BagOfFields (int i, String s, boolean b){
        intVal = i;
        stringVal = s;
        booleanVal = b;
        listVal.add(12f);
        listVal.add(45f);
        listVal.add(67.76f);
    }
}
