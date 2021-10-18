package org.openmetadata.selenium.pages;

import com.github.javafaker.Faker;
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

public class TagsPageTest {

    static WebDriver webDriver;
    static String url = Property.getInstance().getURL();
    Integer waitTime = Property.getInstance().getSleepTime();
    static Faker faker = new Faker();
    static String tagDisplayName = faker.name().firstName();
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

    @Test(priority = 1)
    public void openTagsPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")))).click(); // Close What's new
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")))).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/a")))).click(); // Setting/Tags
        Thread.sleep(waitTime);
    }

    @Test(priority = 2)
    public void addTagCategory() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/span/span/button")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[1]/select")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.name("name")))).sendKeys(tagDisplayName);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")))).sendKeys(faker.address().toString());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")))).click();
    }

    @Test(priority = 3)
    public void editTagCategoryDescription() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ tagDisplayName +"')]] ")))).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='add-description']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/dialog/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")))).sendKeys(faker.address().toString());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='save']")))).click();
    }

    @Test(priority = 4)
    public void addTag() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ tagDisplayName +"')]] ")))).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='add-new-tag-button']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.name("name")))).sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")))).sendKeys(faker.address().toString());
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")))).click();
    }

    @Test(priority = 5)
    public void changeTagDescription() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ tagDisplayName +"')]] ")))).click();// Select the created listed team
        actions.moveToElement(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div[1]/button"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div[1]/button")))).click();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[1]/div[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[1]/div[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[1]/div[3]")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/dialog/div[2]/div[2]/div/div[2]/div/div/div[1]/div[4]")).click();
        webDriver.findElement(By.cssSelector("[data-testid='save']")).click();
    }

    @Test(priority = 6)
    public void addAssociatedTag() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ tagDisplayName +"')]] ")))).click();// Select the created listed team
        actions.moveToElement(webDriver.findElement(By.cssSelector("[data-testid='tags']"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='tags']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[1]/span/input")))).click();
        for (int i = 0; i <=1; i ++){
            webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[1]/span/input")).sendKeys("P");
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='list-item']")))).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[2]/button[2]")))).click();
    }

    @Test(priority = 7)
    public void removeAssociatedTag() throws InterruptedException {
        openTagsPage();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[text()[contains(.,'"+ tagDisplayName +"')]] ")))).click();// Select the created listed team
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='tags']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='remove']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='remove']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[2]/button[2]")))).click();
    }

    @Test(priority = 8)
    public void addTagToTableColumn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")))).click(); // Close What's new
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/a")))).click(); // Explore
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")))); // Sort by
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")).click(); // Sort by
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/div/div/span[1]")).click(); // Last Updated
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//div[@class='tw-grid tw-grid-rows-1 tw-grid-cols-1']//div[last()]//div[last()]//a"))));
        webDriver.findElement(By.xpath("//div[@class='tw-grid tw-grid-rows-1 tw-grid-cols-1']//div[last()]//div[last()]//a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div"))));
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div")).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[1]/span/input")))).click();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[1]/span/input")).sendKeys("P");
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector("[data-testid='list-item']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[2]/button[2]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")))).click(); // Setting
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/a")))).click(); // Setting/Tags
        webDriver.navigate().refresh();
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
