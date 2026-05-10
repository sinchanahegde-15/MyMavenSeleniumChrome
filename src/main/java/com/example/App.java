package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        ChromeOptions options = new ChromeOptions();

        // Required for Jenkins/Linux
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        // ----------- TEST 1 -----------
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        // ----------- TEST 2 -----------
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        // ----------- TEST 3 -----------
        driver.get("https://automationexercise.com/products");
        driver.findElement(By.id("search_product")).sendKeys("blue top");
        driver.findElement(By.id("submit_search")).click();

        Thread.sleep(2000);

        // Print title (to verify execution in Jenkins logs)
        System.out.println("Final Page Title: " + driver.getTitle());

        driver.quit();
    }
}

