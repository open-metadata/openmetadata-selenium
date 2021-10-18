package org.openmetadata.selenium.pages;

import org.openmetadata.selenium.properties.Property;
import org.openqa.selenium.By;
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
    String homeXPath = "[data-testid='image']";
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
        webDriver.findElement(By.xpath("//ul[@class='slick-dots testid-dots-button']//li[2]")).click(); // What's new page 2
        webDriver.findElement(By.xpath("//ul[@class='slick-dots testid-dots-button']//li[3]")).click(); // What's new page 3
        webDriver.findElement(By.cssSelector("[data-testid='WhatsNewModalChangeLogs']")).click(); // Change Logs
        webDriver.findElement(By.cssSelector("[data-testid='closeWhatsNew']")).click(); // Close What's new
    }

    @Test
    public void checkTabs() {
        checkWhatsNew();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='tab'][id='myDataTab']")))).click(); // My Data
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='tab'][id='followingTab']")))).click(); // Following
    }

    @Test
    public void checkOverview() {
        checkWhatsNew();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='tables']")));
        webDriver.findElement(By.cssSelector("[data-testid='tables']")).click(); // Tables
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='topics']")));
        webDriver.findElement(By.cssSelector("[data-testid='topics']")).click(); // Topics
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='dashboards']")));
        webDriver.findElement(By.cssSelector("[data-testid='dashboards']")).click(); // Dashboard
        webDriver.findElement(By.cssSelector(homeXPath)).click();  // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='pipelines']")));
        webDriver.findElement(By.cssSelector("[data-testid='pipelines']")).click(); // Pipeline
        webDriver.findElement(By.cssSelector(homeXPath)).click();  // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='service']")));
        webDriver.findElement(By.cssSelector("[data-testid='service']")).click(); // Services
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='user']")));
        webDriver.findElement(By.cssSelector("[data-testid='user']")).click(); // Users
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='terms']")));
        webDriver.findElement(By.cssSelector("[data-testid='terms']")).click();  // Teams
    }

    @Test
    public void checkCards() {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        checkWhatsNew();
        webDriver.findElement(By.xpath("//div[@data-testid='states-box-container']//div[1]")).click(); // Explore Assets
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='states-box-container']//div[2]")));
        webDriver.findElement(By.xpath("//div[@data-testid='states-box-container']//div[2]")).click(); // Register Service
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='knowledgebaseDocs']")));
        webDriver.findElement(By.cssSelector("[data-testid='knowledgebaseDocs']")).click(); // Knowledgebase/docs
        webDriver.switchTo().window(tabs.get(0));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='knowledgebaseAPIs']")));
        webDriver.findElement(By.cssSelector("[data-testid='knowledgebaseAPIs']")).click(); // Knowledgebase/API
        webDriver.navigate().back();
    }

    @Test
    public void checkSearchBar() {
        checkWhatsNew();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[id='searchBox']")))); // Search bar/dim
        webDriver.findElement(By.cssSelector("[id='searchBox']")).sendKeys("dim"); // Search bar/dim
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='data-name']")))); // Search bar/dim
        webDriver.findElement(By.cssSelector("[data-testid='data-name']")).click(); // Search bar/dim
    }


    @Test
    public void checkHeaders() {
        checkWhatsNew();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.findElement(By.cssSelector("[data-testid='appbar-item'][id='explore']")).click(); // Explore
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")).click(); // Setting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-Teams']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-Teams']")).click(); // Setting/Teams
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")).click(); // Setting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-Tags']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-Tags']")).click(); // Setting/Tags
        webDriver.findElement(By.cssSelector(homeXPath)).click(); // Home
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")).click(); // Setting
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-Services']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-Services']")).click(); // Setting/Services
        webDriver.findElement(By.cssSelector("[data-testid='whatsnew-modal']")).click(); // What's New
        checkWhatsNew();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-Docs']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-Docs']")).click();
        webDriver.switchTo().window(tabs.get(0));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-API']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-API']")).click();
        webDriver.navigate().back();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-button'][id='menu-button-Need Help']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='menu-item-Slack']")));
        webDriver.findElement(By.cssSelector("[data-testid='menu-item-Slack']")).click();
        webDriver.switchTo().window(tabs.get(0));
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
