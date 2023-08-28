package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_imdb_ratings {
    ChromeDriver driver;

    public Automate_imdb_ratings() {
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

    public void imdb_rating() throws InterruptedException {

        driver.get("https://www.imdb.com/chart/top");

        WebElement highestrated = driver.findElement(By.xpath(" //h3[text()='1. The Shawshank Redemption']"));
        System.out.println("Highest rated movie : ");
        System.out.println(highestrated.getText());

        List<WebElement> list = driver
                .findElements(By.xpath(" //*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li["));
        System.out.println();

        System.out.println(" Total movies are included in the table: " + list.size());

        System.out.println();
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Release date");

        WebElement oldestmovie = driver
                .findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[250]"));
        System.out.println("oldest movie on the list");
        System.out.println(oldestmovie.getText());

        WebElement Most_Recent_Movie = driver
                .findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]"));
        System.out.println("most recent movie on the list");
        System.out.println(Most_Recent_Movie.getText());
        System.out.println();

        Thread.sleep(2000);

        dropdown.selectByVisibleText("Number of ratings");

        WebElement MostUserRating = driver
                .findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]"));
        System.out.println("movie has the most user ratings");
        System.out.println(MostUserRating.getText());
        System.out.println();

    }

}
