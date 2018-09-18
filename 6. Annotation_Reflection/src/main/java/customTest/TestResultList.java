package customTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestResultList {
    private static TestResultList instance;
    private ArrayList <CustomResult> resList = new ArrayList<>();
    private TestResultList (){}
    private static TestResultList getInstance() {
        if (instance == null)
            instance = new TestResultList();
        return instance;
    }
    public static void reportResult(Object obj, Object obj2) {
        CustomResult customResult = new CustomResult();
        if (obj == null && obj2 == null)
            customResult.setResult(true);
        else if (obj.equals(obj2))
            customResult.setResult(true);
        else
        {
            customResult.setResult(false);
            customResult.setMessage("Expect to get " + obj2.toString() + " but getting " + obj.toString());
        }
        getInstance().resList.add(customResult);
    }
    public static void printResult() {
        StringBuilder message =  new StringBuilder("Total Test count: " + getInstance().resList.size() + "\n");
        List<CustomResult> faults = new ArrayList<>();
        for (CustomResult cr : getInstance().resList)
            if (!cr.getResult())
                faults.add(cr);
        message.append("Total Faults count: " + faults.size() + "\n");
        if (!faults.isEmpty())
        {
            for (CustomResult cr : faults)
                message.append("\t - " + cr.getMessage() + "\n");
            message.append("Test complete with faults!");
        }
        else
            message.append("Test complete successfully");
        System.out.println(message);
    }
    public static void clean() {
        instance = null;
    }
}
class CustomResult {
    private Boolean result = false;
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
