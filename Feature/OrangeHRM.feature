Feature: Login

  @Sanity
  Scenario: Successfull login with valid cridenntiols
    Given when chrome browser is launched
    When Login URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" is opened
    And username given as "admin@yourstore.com"
    And password given as "admin"
    And log in button is clicked
    Then page title must be "Dashboard / nopCommerce administration"
    When Logout button is clicked
    Then page title mus be "Your store. Login"
    And close Browser


  Scenario Outline: Successfull login with valid cridenntiols
    Given when chrome browser is launched
    When Login URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" is opened
    And username given as "<email>"
    And password given as "<password>"
    And log in button is clicked
    Then page title must be "Dashboard / nopCommerce administration"
    When Logout button is clicked
    Then page title mus be "Your store. Login"
    And close Browser
    Examples:
      | email               | password |
      | abhi                | 1234     |
      | achu                | 4321     |
      | admin@yourstore.com | admin    |
