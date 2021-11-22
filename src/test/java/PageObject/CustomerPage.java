package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
    public WebDriver idriver;
    public CustomerPage(WebDriver rdriver){
        idriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }
    By linkCustomers_menu = By.xpath("//p[text()=' Customers']/../../../..");
    By linkCustomers_menu_item = By.xpath("//p[text()=' Customers']/../..");
    By add_new_customer_button =By.xpath("//a[@class='btn btn-primary']");
    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");
    By txtFirstName = By.id("FirstName");
    By txtLastName = By.id("LastName");
    By button_Male = By.id("Gender_Male");
    By button_Female = By.id("Gender_Female");
    By txt_Dob = By.id("DateOfBirth");
    By txtCompany_name = By.id("Company");
    By button_tax_exempt = By.id("IsTaxExempt");
    By txtNewsLetter = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[1]");
    By listItem_YourStoreName = By.xpath("//li[text()='Your store name']");
    By listItem_TestStore2 = By.xpath("//li[text()='Test store 2']");
    By textCustomer_roles = By.xpath("//input[@aria-owns='SelectedCustomerRoleIds_taglist SelectedCustomerRoleIds_listbox']");
    By listItem_Administrators = By.xpath("//li[text()='Administrators']");
    By listItem_Forum_Moderators = By.xpath("//li[text()='Forum Moderators']");
    By listItem_Guests = By.xpath("//li[text()='Guests']");
    By listItem_Registered = By.xpath("//li[text()='Registered']");
    By listItem_Vendors = By.xpath("//li[text()='Vendors']");
    By txt_ManagerOf_Vendors = By.id("VendorId");
    By checkboxActivity= By.id("Active");
    By txtAdminComment= By.id("AdminComment");
    By saveButton=By.name("save");


//Action Methods
    public String getPageTitle(){
        return(idriver.getTitle());

    }
    public void click_on_customerMenu(){
        idriver.findElement(linkCustomers_menu).click();
    }
    public void click_on_CustomersMenuItem() throws InterruptedException {
       Thread.sleep(2000);
        idriver.findElement(linkCustomers_menu_item).click();
    }
    public void click_on_add_new_customer_button(){
        idriver.findElement(add_new_customer_button).click();
    }
    public void add_email(String email){
        idriver.findElement(txtEmail).sendKeys(email);
    }
    public void add_password(String password){
        idriver.findElement(txtPassword).sendKeys(password);
    }
    public void add_firstName(String firstName){
        idriver.findElement(txtFirstName).sendKeys(firstName);
    }
    public void add_lastName(String lastName){
        idriver.findElement(txtLastName).sendKeys(lastName);
    }
    public void set_Sex(String sex){
        if (sex.equals("male")){
            idriver.findElement(button_Male).click();
        }
        else{
            idriver.findElement(button_Female).click();
        }
    }
    public void add_dob(String dob){
        idriver.findElement(txt_Dob).sendKeys(dob);
    }

    public void add_company_name (String company_name){
        idriver.findElement(txtCompany_name).sendKeys(company_name);
    }
    public void click_button_tax_exeption(){
        idriver.findElement(button_tax_exempt).click();
    }
    public void set_customer_roles(String customerRoles) throws InterruptedException {
        idriver.findElement(textCustomer_roles).click();
        //Thread.sleep(2000);

        if (customerRoles.equals("Administrators")){
            idriver.findElement(listItem_Administrators).click();
        }
        else if(customerRoles.equals("Forum Moderators")){
            idriver.findElement(listItem_Forum_Moderators).click();
        }
        else if(customerRoles.equals("Guests")){
            idriver.findElement(listItem_Guests).click();
        }
        else if(customerRoles.equals("Registered")){
            idriver.findElement(listItem_Registered).click();
        }
        else {
            idriver.findElement(listItem_Vendors).click();
        }
    }
    public void set_Manager_Of_Ventor(String value){
        Select sel = new Select(idriver.findElement(txt_ManagerOf_Vendors));
        sel.selectByValue(value);
    }

    public void click_activity(){
        idriver.findElement(checkboxActivity).click();
    }

    public void add_admin_comment(String admin_Comment){
        idriver.findElement(txtAdminComment).sendKeys(admin_Comment);
    }

    public void click_save_button(){
        idriver.findElement(saveButton).click();
    }


}





