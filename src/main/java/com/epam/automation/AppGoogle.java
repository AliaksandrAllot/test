package com.epam.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class AppGoogle {

    private static final String START_URL = "https://google.com/";
    private static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver88.exe");
        driver = new ChromeDriver();
        driver.get(START_URL);
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

        //new WebDriverWait(driver, 10)
        //  .until(ExpectedConditions.p(By.name("q")));
        //WebElement searchInput = driver.findElement(By.name("q"));

        WebElement searchInput = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchInput.sendKeys("selenium java");

        //List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Поиск в Google']"));
        List<WebElement> searchBtn = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@name='btnK']")));
        searchBtn.get(0).click();
        driver.quit();
    }
}
