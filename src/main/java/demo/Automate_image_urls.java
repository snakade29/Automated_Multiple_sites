package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_image_urls {

    ChromeDriver driver;

    public Automate_image_urls() {

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void automate_image_urls() {

        driver.get("https://www.bookmyshow.com/explore/home/chennai");

        List<WebElement> list = driver
                .findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../..//img"));

        for (WebElement ele : list) {
            System.out.println(ele.getAttribute("src"));
        }

        WebElement moviename = driver.findElement(By.xpath(" //div[text()='Follow Me']"));
        System.out.println(moviename.getText());

        WebElement movieLanguage = driver.findElement(By.xpath("//div[text()='English']"));
        System.out.println(movieLanguage.getText());

    }

}
