package org.openmetadata.selenium.pages;

import com.github.javafaker.Faker;
import org.openmetadata.selenium.properties.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TeamsPageTest {

    static WebDriver webDriver;
    static String URL = Property.getInstance().getURL();
    Integer waitTime = Property.getInstance().getSleepTime();
    static Faker faker = new Faker();
    static String teamDisplayName = faker.name().lastName();

    @BeforeMethod
    public void openMetadataWindow() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macM1/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(URL);
    }

    @Test(priority = 1)
    public void openTeamsPage() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/a")).click(); // Setting/Teams
        Thread.sleep(waitTime);
    }

    @Test(priority = 2)
    public void createTeam() throws InterruptedException {
        openTeamsPage();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/span/span/button")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.name("name")).sendKeys(faker.name().firstName());
        webDriver.findElement(By.name("displayName")).sendKeys(teamDisplayName);
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[1]/nav/p[2]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")).click();
        Thread.sleep(waitTime);
    }

    @Test(priority = 3)
    public void addUser() throws InterruptedException {
        openTeamsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        for(int i = 0; i <=10; i++) {
            webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/span/span/button")).click();
            Thread.sleep(500);
            webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div[2]/div[1]/div[2]/input")).click();
            Thread.sleep(waitTime);
            webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[3]/button[2]")).click();
            Thread.sleep(waitTime);
        }
    }

    @Test(priority = 4)
    public void editDescription() throws InterruptedException {
        openTeamsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='add-description']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='save']")).click();
    }

    @Test(priority = 5)
    public void addAsset() throws InterruptedException {
        openTeamsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click(); // Select last listed team
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='assets']")).click(); // Assets
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[4]/a/button")).click(); // Explore
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")).click(); // Sort by
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/div/div/span[1]")).click(); // Last Updated
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/h6/a/button")).click(); // Select Table
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[1]/nav/span/span/button")).click(); // Manage
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='owner-dropdown']")).click(); // Owner
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[placeholder='Search...']")).sendKeys(teamDisplayName);
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/span[2]/div/div[3]/span")).click(); // Select User/Team
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/button[2]")).click(); // Save
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/a")).click(); // Setting/Teams
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[9]")).click(); //
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='assets']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='user-card-container']")).click();
        Thread.sleep(waitTime);
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
