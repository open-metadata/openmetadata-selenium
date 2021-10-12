package org.openmetadata.selenium.pages;

import org.openmetadata.selenium.properties.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class MyDataPageTest {

    static WebDriver webDriver;
    String homeXPath = "/html/body/div/div/div[2]/div[1]/div/div[1]/a";
    static String url = Property.getInstance().getURL();
    static Actions actions;
    static WebDriverWait wait;

    @BeforeMethod
    public void openMetadataWindow() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macM1/chromedriver");
        webDriver = new ChromeDriver();
        actions = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @Test
    public static void checkWhatsNew() {
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/button")).click(); // What's new page 2
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[3]/button")).click(); // What's new page 3
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/button[2]")).click(); // Change Logs
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
    }

    @Test
    public void checkTabs() throws InterruptedException {
        checkWhatsNew();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]/nav/button[2]")))).click(); // My Data
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]/nav/button[3]")))).click(); // Following
    }

    @Test
    public void checkOverview() throws InterruptedException {
        checkWhatsNew();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[1]/a/button")).click(); // Tables
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[2]/a/button")))).click(); // Topics
        webDriver.findElement(By.xpath(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[3]/a/button")))).click(); // Dashboard
        webDriver.findElement(By.xpath(homeXPath)).click();  // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[4]/a/button")))).click(); // Services
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[5]/a/button")));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[5]/a/button")))).click(); // Users
        webDriver.findElement(By.xpath(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[1]/div[6]/a/button")))).click();  // Teams
    }

    @Test
    public void checkCards() throws Exception {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        checkWhatsNew();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[2]/div[1]/p[1]")).click(); // Explore Assets
        webDriver.findElement(By.xpath(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[2]/div[2]/p[1]")).click(); // Register Service
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[2]/div[3]/p[2]/a")).click(); // Knowledgebase/docs
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.switchTo().window(tabs.get(0));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/section/div[2]/div[3]/p[2]/span")).click(); // Knowledgebase/API
    }

    @Test
    public void checkSearchBar() throws InterruptedException {
        checkWhatsNew();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[1]/input")))).sendKeys("dim"); // Search bar/dim
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[1]/div/div/div[4]/a")))).click(); // Search bar/dim
    }


    @Test
    public void checkHeaders() throws InterruptedException {
        checkWhatsNew();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/a")).click(); // Explore
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/a")))).click(); // Setting/Teams
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/a")))).click(); // Setting/Tags
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[3]/a")))).click(); // Setting/Services
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(homeXPath)))).click(); // Home
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/button")).click(); // What's New
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/button")).click(); // What's new page 2
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[2]/div/ul/li[3]/button")).click(); // What's new page 3
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/button[2]")).click(); // Change Logs
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div/button/p")))).click(); // Need Help
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/a/button")))).click(); // Need Help/Docs
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.switchTo().window(webDriver.getWindowHandle());
        webDriver.switchTo().window(tabs.get(0));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div/button/p")).click(); // Need Help
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div[3]/a/button")))).click(); // Need Help/Slack
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html")));
        webDriver.switchTo().window(webDriver.getWindowHandle());
        webDriver.switchTo().window(tabs.get(0));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div/button/p")).click(); // Need Help
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/a/button")))).click(); // Need Help/API
    }

    @AfterMethod
    public void closeTabs() {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        String originalHandle = webDriver.getWindowHandle();
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                webDriver.switchTo().window(handle);
                webDriver.close();
            }
        }
        webDriver.switchTo().window(tabs.get(0)).close();
    }
}
