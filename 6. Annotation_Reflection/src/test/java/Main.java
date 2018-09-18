import com.test.Tester1;
import customTest.TestResultList;

public class Main {
    public static void main(String[] args) {
        CustomTest.testClass(Tester1.class);
//        CustomTest.testPackage("com.test");
        TestResultList.printResult();
        TestResultList.clean();

    }
}
