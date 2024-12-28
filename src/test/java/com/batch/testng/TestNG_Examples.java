package com.batch.testng;


import org.testng.annotations.*;

public class TestNG_Examples {


   @AfterSuite
    public void afterSuiteExamples(){
        System.out.println("afterSuiteExample");
    }

    @Test(priority = 1)
    public void testExample(){
        System.out.println("testExample");
    }

    @Test(priority = 0)
    public void testExample2(){
        System.out.println("testExample2");
    }

    @BeforeTest
    public void beforeTestExample(){
        System.out.println("beforeTestExample");
    }

    @AfterTest
    public void afterTestExample(){
        System.out.println("afterTestExample");
    }

    @BeforeSuite
    public void beforeSuiteExample(){
        System.out.println("beforeSuiteExample");
    }

    @BeforeClass
    public void beforeClassExample(){
        System.out.println("beforeClassExample");
    }

    @AfterClass
    public void afterClassExample(){
        System.out.println("afterClassExample");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }



}
