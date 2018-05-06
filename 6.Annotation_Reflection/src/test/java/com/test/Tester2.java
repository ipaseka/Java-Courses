package com.test;

import annotations.Test;
import customTest.TestResultList;

public class Tester2 {
    @Test
    public void oneMoreError () {
        TestResultList.reportResult("66", "84");
    }
}
