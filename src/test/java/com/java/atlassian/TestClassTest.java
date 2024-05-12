package com.java.atlassian;

import org.junit.Assert;
import org.junit.Test;

public class TestClassTest {

    @Test
    public void test(){
        TestClass test = new TestClass();
        String actual = test.testMethod();
        Assert.assertEquals("Test",actual);
    }
}
