package org.openmetadata.selenium.pages;

import com.github.javafaker.Faker;
import org.openmetadata.selenium.properties.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TagsPageTest {

    static WebDriver webDriver;
    static String url = Property.getInstance().getURL();
    Integer waitTime = Property.getInstance().getSleepTime();
    static Faker faker = new Faker();
    static String tagDisplayName = faker.name().firstName();

    @BeforeMethod
    public void openMetadataWindow() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macM1/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @Test(priority = 1)
    public void openTagsPage() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/a")).click(); // Setting/Tags
        Thread.sleep(waitTime);
    }

    @Test(priority = 2)
    public void addTagCategory() throws InterruptedException {
        openTagsPage();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/span/span/button")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[1]/select")).click();
        webDriver.findElement(By.name("name")).sendKeys(tagDisplayName);
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")).click();
    }

    @Test(priority = 3)
    public void editTagCategoryDescription() throws InterruptedException {
        openTagsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='add-description']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/dialog/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='save']")).click();
        Thread.sleep(waitTime);
    }

    @Test(priority = 4)
    public void addTag() throws InterruptedException {
        openTagsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='add-new-tag-button']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.name("name")).sendKeys(faker.name().firstName());
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[2]/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).sendKeys(faker.address().toString());
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/dialog/div[2]/form/div[3]/button[2]")).click();
    }

    @Test(priority = 5)
    public void changeAddDescription() throws InterruptedException {
        openTagsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div[1]/button")).click();
        Thread.sleep(waitTime);
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
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='tags']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[1]/span/input")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[1]/span/input")).sendKeys("PII.Sensitive");
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='list-item']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[1]/span/input")).sendKeys("PersonalData.Personal");
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='list-item']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[2]/button[2]")).click();
    }

    @Test(priority = 7)
    public void removeAssociatedTag() throws InterruptedException {
        openTagsPage();
        webDriver.findElement(By.xpath("//div[@class='side-panel']//div[last()]//p[last()]")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='tags']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='remove']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/span/span/div/div[2]/button[2]")).click();
    }

    @Test(priority = 8)
    public void addTagToTableColumn() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/dialog/div[2]/div[1]/div")).click(); // Close What's new
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/a")).click(); // Explore
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/button")).click(); // Sort by
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/nav/div[2]/div[1]/span[2]/div/div/span[1]")).click(); // Last Updated
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("//div[@class='tw-grid tw-grid-rows-1 tw-grid-cols-1']//div[last()]//div[last()]//a")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[1]/span/input")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[1]/span/input")).sendKeys("P");
        Thread.sleep(waitTime);
        webDriver.findElement(By.cssSelector("[data-testid='list-item']")).click();
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/span/span/div/div[2]/button[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div/button")).click(); // Setting
        Thread.sleep(waitTime);
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/a")).click(); // Setting/Tags
        webDriver.navigate().refresh();
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
