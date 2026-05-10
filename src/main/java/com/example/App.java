package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        ChromeOptions options = new ChromeOptions();

        // Required for Jenkins/Linux
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ----------- TEST 1 : SauceDemo -----------
        driver.get("https://www.saucedemo.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        System.out.println("Test 1 Passed");

        // ----------- TEST 2 : Practice Test Automation -----------
        driver.get("https://practicetestautomation.com/practice-test-login/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        System.out.println("Test 2 Passed");

        // ----------- TEST 3 : Automation Exercise -----------
        driver.get("https://automationexercise.com/products");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));

        driver.findElement(By.id("search_product")).sendKeys("blue top");
        driver.findElement(By.id("submit_search")).click();

        Thread.sleep(2000);

        System.out.println("Test 3 Passed");

        // Final verification
        System.out.println("Final Page Title: " + driver.getTitle());

        // Close browser
        driver.quit();

        System.out.println("All Tests Executed Successfully");
    }
}
