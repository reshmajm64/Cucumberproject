import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D://WORK//SeleniumCucumber//DRIVERS new//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.findElement(By.xpath("//p[text()=' Customers']/../../../..")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()=' Customers']/../..")).click();


    }



}
