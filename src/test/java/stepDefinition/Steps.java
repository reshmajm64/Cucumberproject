package stepDefinition;

import PageObject.BaseClass;
import PageObject.CustomerPage;
import PageObject.LogInPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        configProp = new Properties();
        FileInputStream file = new FileInputStream("config.properties");
        configProp.load(file);
        String br = configProp.getProperty("browser");

        if (br.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
        }

        else if (br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie")){
            System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
            driver = new FirefoxDriver();
        }

    }

    @Given("when chrome browser is launched")
    public void when_chrome_browser_is_launched() {

        lp = new LogInPage(driver);
    }

    @When("Login URL {string} is opened")
    public void login_url_is_opened(String url) {
        driver.get(url);
    }

    @When("username given as {string}")
    public void username_given_as(String email) {
        lp.setUserName(email);
    }

    @When("password given as {string}")
    public void password_given_as(String password) {
        lp.setPassword(password);
    }

    @When("log in button is clicked")
    public void log_in_button_is_clicked() {
        lp.clickLogInButton();
    }

    @Then("page title must be {string}")
    public void page_title_must_be(String LogedInPageTitle) throws InterruptedException {
        //Thread. sleep(2000);
        boolean logedinPageTitleVerifivcation = driver.getTitle().equals(LogedInPageTitle);
        Assert.assertEquals(true, logedinPageTitleVerifivcation);
    }

    @When("Logout button is clicked")
    public void logout_button_is_clicked() {
        lp.clickLogOutButton();

    }

    @Then("page title mus be {string}")
    public void page_title_mus_be(String LogInPageTitile) throws InterruptedException {
        //Thread. sleep(2000);
        boolean logInPageTitleVerification = driver.getTitle().equals(LogInPageTitile);
        Assert.assertEquals(true, logInPageTitleVerification);
    }

    @Then("close Browser")
    public void close_browser() {
        driver.close();

    }

    //add customer steps

    @Then("user can view Dashboard")
    public void user_can_view_dashboard() {
        cus = new CustomerPage(driver);
        Assert.assertEquals(cus.getPageTitle(), "Dashboard / nopCommerce administration");

    }

    @When("user clicks on customer menu")
    public void user_clicks_on_customer_menu() {
        cus.click_on_customerMenu();
    }

    @When("clicks on customers item")
    public void clicks_on_customers_item() throws InterruptedException {
        //Thread.sleep(2000);
        cus.click_on_CustomersMenuItem();
    }

    @When("click on Add new icon")
    public void click_on_add_new_icon() throws InterruptedException {
        Thread.sleep(2000);
        cus.click_on_add_new_customer_button();
    }

    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals(cus.getPageTitle(), "Add a new customer / nopCommerce administration");
        //System.out.println("Customers / nopCommerce administration");
        // System.out.println(driver.getTitle());
    }

    @When("user enters customer info")
    public void user_enters_customer_info() throws InterruptedException {
        String email = randomString(5) + "@gmail.com";
        cus.add_email(email);
        String password = "Test1234";
        cus.add_password(password);
        String firstname = randomString(4);
        cus.add_firstName(firstname);
        String lastname = randomString(5);
        cus.add_lastName(lastname);
        cus.set_Sex("male");
        cus.add_dob("03/05/1995");
        cus.click_activity();
        cus.set_customer_roles("Administrators");
        cus.add_admin_comment(randomString(10));
    }


    @When("click on save button")
    public void click_on_save_button() {
        cus.click_save_button();

    }


    @Then("user can view confirmation message")
    public void user_can_view_confirmation_message() {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));


    }
    //search customer by emailID

    @When("enters Customer EmailID")
    public void enters_customer_email_id() {
        searchCus = new SearchCustomerPage(driver);
        searchCus.addEmail("victoria_victoria@nopCommerce.com");
        //driver.findElement(By.id("SearchEmail")).sendKeys("julianbass@domain.org");
    }

    @When("user clicks search button")
    public void user_clicks_search_button() throws InterruptedException {
        searchCus.clickSearchButton();
        Thread.sleep(2000);

    }

    @Then("User must find email in the search table")
    public void user_must_find_email_in_the_search_table() {
        Assert.assertTrue(searchCus.searchCustomerByEmailID("victoria_victoria@nopCommerce.com"));
    }

    //Search By Name


    @When("enters Customer name")
    public void enters_customer_name() {
        searchCus = new SearchCustomerPage(driver);
        searchCus.addFirstName("Victoria");
        searchCus.addLastName("Terces");

    }

    @Then("User must find name in the search table")
    public void user_must_find_name_in_the_search_table() {
        Assert.assertTrue(searchCus.serchCustomerByName("Victoria", "Terces"));
    }


}
