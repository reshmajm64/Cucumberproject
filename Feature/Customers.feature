Feature: Customer

  Background:  Common Steps

    Given when chrome browser is launched
    When Login URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" is opened
    And username given as "admin@yourstore.com"
    And password given as "admin"
    And log in button is clicked
    Then user can view Dashboard
    When user clicks on customer menu
    And  clicks on customers item
@Sanity
  Scenario: Create new customer successfully

    And click on Add new icon
    Then user can view add new customer page
    When user enters customer info
    And click on save button
    Then user can view confirmation message
    And close Browser
@Regression
  Scenario: Search Customer by EMailID:

    And enters Customer EmailID
    When user clicks search button
    Then User must find email in the search table
    And close Browser

  Scenario: Search Customer by Name:

    And enters Customer name
    When user clicks search button
    Then User must find name in the search table
    And close Browser