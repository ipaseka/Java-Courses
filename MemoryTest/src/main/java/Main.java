public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Main();
    }
    public Main() throws InterruptedException {
        test("Object");
        test("Integer");
        test("Array");
    }
    public void test(String type) throws InterruptedException {
        System.gc();
        Thread.sleep(1000);
        long m1 = Runtime.getRuntime().freeMemory();
        System.out.println("free memory before: " + m1);

        System.out.println("Create Array of " + type);

        if (type.equals("Integer"))
            createIntArr();
        if (type.equals("Array"))
            createArrArr();
        if (type.equals("Object"))
            createObjectArr();

        System.gc();
        Thread.sleep(1000);
        long m2 = Runtime.getRuntime().freeMemory();
        System.out.println("free memory after: " + m2);
        System.out.println("diff: " + (m1 - m2));
        System.out.println("each " + type + " size: " + (m1 - m2) / 1_000_000);
        System.out.println("\n");
    }

    private Object[] createObjectArr()
    {
        Object[] o = new Object[1_000_000];
        for (int i = 0; i < o.length; i++) {
            o[i] =  new Object();
        }
        return o;
    }
    private int[] createIntArr()
    {
        int[] o = new int[1_000_000];
        for (int i = 0; i < o.length; i++) {
            o[i] =  i;
        }
        return o;
    }
    private Object[] createArrArr()
    {
        Object[] o = new Object[1_000_000];
        for (int i = 0; i < o.length; i++) {
            o[i] =  new Object[1];
        }
        return o;
    }

}
