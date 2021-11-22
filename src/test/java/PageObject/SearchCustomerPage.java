package PageObject;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
    public WebDriver idriver;
    public SearchCustomerPage(WebDriver rdriver) {
        idriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    By txtEmail = By.name("SearchEmail");
    By txtFirstName = By.id("SearchFirstName");
    By txtLasttName = By.id("SearchLastName");
    By searchButton = By.id("search-customers");
    By tableRows = By.xpath("//table[@id='customers-grid']/tbody/tr");
    By tableColumn = By.xpath("//table[@id='customers-grid']/tbody/tr/td");


    public void addEmail(String email) {
        idriver.findElement(txtEmail).sendKeys(email);
    }

    public void addFirstName(String firstName) {
        idriver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        idriver.findElement(txtLasttName).sendKeys(lastName);
    }

    public void clickSearchButton() {
        idriver.findElement(searchButton).click();
    }

     public int getRowSize(){
         return (idriver.findElements(tableRows).size());
     }
     public int getColumnSize() {
            return(idriver.findElements(tableColumn).size());
    }

    public boolean searchCustomerByEmailID(String email) {
        boolean emailFound = false;
        for (int i = 1; i <= getRowSize(); i++) {
            String emailId = idriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            if (emailId.equals(email)) {
                emailFound = true;
            }
        }
        return emailFound;
    }

    public boolean serchCustomerByName(String firstName, String secondName) {
        boolean nameFound = false;
        for (int i = 1; i <= getRowSize(); i++) {
            String fullName = idriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            if (fullName.equals(firstName + " " + secondName)) {
                nameFound = true;
            }
        }
        return nameFound;
    }
}

