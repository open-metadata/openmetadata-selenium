package org.openmetadata.selenium.pages;

import com.github.javafaker.Faker;
import org.openmetadata.selenium.properties.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TeamsPageTest {

    static WebDriver webDriver;
    static String URL = Property.getInstance().getURL();
    Integer waitTime = Property.getInstance().getSleepTime();
    static Faker faker = new Faker();
    static String teamDisplayName = faker.name().lastName();
    static Actions actions;
    static WebDriverWait wait;

    @BeforeMethod
    public void openMetadataWindow() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macM1/chromedriver");
        webDriver = new ChromeDriver();
        actions = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get(URL);
    }

    @Test(priority = 1)
    public void openTeamsPage() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")))).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/a")))).click(); // Setting/Teams
        Thread.sleep(waitTime);
    }

    @Test(priority = 2)
    public void createTeam() throws InterruptedException {
        openTeamsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/span/span/button")))).click();
        webDriver.findElement(By.name("name")).sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.name("displayName")))).sendKeys(teamDisplayName);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")))).sendKeys(faker.address().toString());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[1]/nav/p[2]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")))).click();
    }

    @Test(priority = 3)
    public void addUser() throws InterruptedException {
        openTeamsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ teamDisplayName +"')]] ")))).click();// Select the created listed team
        for(int i = 0; i <=10; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/span/span/button")))).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div[2]/div[1]/div[2]/input")))).click();
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[3]/button[2]")))).click();
        }
    }

    @Test(priority = 4)
    public void editDescription() throws InterruptedException {
        openTeamsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ teamDisplayName +"')]] ")))).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='add-description']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")))).sendKeys(faker.address().toString());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='save']")))).click();
    }

    @Test(priority = 5)
    public void addAsset() throws InterruptedException {
        openTeamsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ "Adams" +"')]] ")))).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='assets']")))).click(); // Assets
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[4]/a/button")))).click(); // Explore
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")))); // Sort by
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")).click(); // Sort by
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/div/div/span[1]")))).click(); // Last Updated
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/h6/a/button")))); // Select Table
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/h6/a/button")).click(); // Select Table
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/nav/span/span/button")))).click(); // Manage
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='owner-dropdown']")))).click(); // Owner
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[placeholder='Search...']"))));
        webDriver.findElement(By.cssSelector("[placeholder='Search...']")).sendKeys("Adams");
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='list-item']")))); // Select User/Team
        webDriver.findElement(By.cssSelector("[data-testid='list-item']")).click(); // Select User/Team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/button[2]")))).click(); // Save
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")))).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/a")))).click(); // Setting/Teams
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ "Adams" +"')]] "))));// Select the created listed team
        webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ "Adams" +"')]] ")).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='assets']"))));
        webDriver.findElement(By.cssSelector("[data-testid='assets']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='user-card-container']"))));
        webDriver.findElement(By.cssSelector("[data-testid='user-card-container']")).click();
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
