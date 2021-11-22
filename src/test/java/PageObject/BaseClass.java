package PageObject;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LogInPage lp;
    public CustomerPage cus;
    public SearchCustomerPage searchCus;
    public Properties configProp;


//Random string generation

public static String randomString(int length){
    String generatedString1 = RandomStringUtils.randomAlphabetic(length);
    return generatedString1;
    }
}




