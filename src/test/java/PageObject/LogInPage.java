package PageObject;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public WebDriver idriver;
    public LogInPage(WebDriver rdriver){
        idriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(id= "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id= "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath= "//button[text()='Log in']")
    @CacheLookup
    WebElement LoginButton;

    @FindBy(xpath = "//a[text()='Logout']")
    @CacheLookup
    WebElement LogOutButton;


    public void setUserName(String uName){
        txtEmail.clear();
        txtEmail.sendKeys(uName);
    }
    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void clickLogInButton(){
        LoginButton.click();
    }

    public void clickLogOutButton(){
        LogOutButton.click();
    }


}
