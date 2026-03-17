package com.example;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class App {
    public static void main(String[] args) {
        // Prove TestNG is on the classpath
        Assert.assertTrue(true, "TestNG is available");

        // Reference Selenium at compile time without actually launching a browser
        WebDriver driver = null; // not used; avoids requiring WebDrivers

        System.out.println("Hello from Java app! Selenium & TestNG are wired in.");
    }
}
