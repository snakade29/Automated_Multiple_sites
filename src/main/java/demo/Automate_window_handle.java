package demo;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_window_handle {
    ChromeDriver driver;

    public Automate_window_handle() {

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

    public static void TakesScreenshot(ChromeDriver driver) {

        String homepath = System.getProperty("user.dir") + "\\src\\main\\java\\demo\\screenshots\\abc.png";

        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(homepath);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }

    public void window_handle() throws InterruptedException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        WebElement frameele = driver.findElement(By.id("iframeResult"));

        driver.switchTo().frame(frameele);

        String url = "";
        String Tittle = "";
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);

        url = driver.getCurrentUrl();
        Tittle = driver.getTitle();

        System.out.println(url);
        System.out.println(Tittle);

        TakesScreenshot(driver);

        // Set<String> windowHandles = driver.getWindowHandles();
        // String ParentWindow = driver.getWindowHandle();
        // System.out.println("ParentWindowhandle" + ParentWindow);
        // String Tittle = "";
        // for (String window : windowHandles) {

        // if (ParentWindow.contains(window)) {

        // driver.switchTo().window(window);

        // url = driver.getCurrentUrl();
        // Tittle = driver.getTitle();

        // System.out.println(url);
        // System.out.println(Tittle);

        // TakesScreenshot(driver);

        // }

        // }
        driver.close();
        driver.switchTo().window(handles.toArray(new String[handles.size()])[0]);

    }

}
