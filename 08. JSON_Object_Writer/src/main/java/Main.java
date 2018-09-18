import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        BagOfFields bagOfFields = new BagOfFields(17, "testString", false);
        String jsonString = JOW.getJsonStringByObject(bagOfFields);
        Gson gson = new Gson();
        BagOfFields bagOfFieldsAfter = gson.fromJson(jsonString, BagOfFields.class);

        System.out.println("bagOfFields = " + bagOfFields);
        System.out.println("jsonString = " + jsonString);
        System.out.println("bagOfFieldsAfter = " + bagOfFieldsAfter);
    }
}
