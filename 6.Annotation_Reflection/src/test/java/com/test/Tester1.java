package com.test;

import annotations.After;
import annotations.Before;
import annotations.Test;
import customTest.TestResultList;

public class Tester1 {
    private TestClass testClass1;
    private TestClass testClass2;
    @Before
    public void init() {
        testClass1 = new TestClass(45);
        testClass2 = new TestClass("data");
    }
    @Test
    public void testNulls () {
        TestClass t = null;
        TestResultList.reportResult(t, null);
    }
    @Test
    public void testVals() {
        TestResultList.reportResult(new TestClass("data"), testClass2);
        TestResultList.reportResult(new TestClass(45), testClass1);
    }
    @Test
    public void errorMaker() {
        TestResultList.reportResult(new TestClass("data"), testClass1);
        TestResultList.reportResult(new TestClass(45), testClass2);
    }
    @After
    public void killObj () {
        testClass1 = testClass2 = null;
    }
}
