package com.test;

public class TestClass {
    private int anInt;
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getAnInt() {

        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public TestClass (int i, String string) {
        setString(string);
        setAnInt(i);
    }
    public TestClass (int i) {
        setAnInt(i);
    }
    public TestClass (String str) {
        setString(str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestClass testClass = (TestClass) o;

        if (anInt != testClass.anInt) return false;
        return string != null ? string.equals(testClass.string) : testClass.string == null;
    }

    @Override
    public int hashCode() {
        int result = anInt;
        result = 31 * result + (string != null ? string.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "anInt=" + anInt +
                ", string='" + string + '\'' +
                '}';
    }
}
