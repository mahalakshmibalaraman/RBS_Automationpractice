#Author: Mahalakshmi Balraman

Feature: Verify Order History and Personal Information

@T-shirtpurchase
Scenario Outline: Verify Order History
    Given launch the My Store application "<URL>" in "<Browser>"
    And Click on T-shirt tab
    And choose t-shirt "<t-shirt-name>"
    When set "<color>","<size>" and "<qty>" and add the product to the cart
    And Click on Proceed to Checkout page
    And Sign-in into account by providing valid credentials "<EmailAddress>" and "<Password>"
    And select Delivery Address "<DeliveryAddresss_Type>" and Proceed
    And Accept the terms and condition anf proceed to Checkout
    And Select the "<paymentMode>" and Confirm the order
    Then Verify the order confirmation page
    And check order reference no present in order history page

    Examples: 
      | URL  | Browser|EmailAddress | Password |t-shirt-name|color|size|qty|DeliveryAddresss_Type|paymentMode|
      | http://automationpractice.com|Chrome|someone@example.com|Password123|Faded Short Sleeve T-shirts|Blue|S|1|automation|Pay by bank wire|

@UpdatePersonalInfo
Scenario Outline: Update Personal Information in My Account
    Given launch the My Store application "<URL>" in "<Browser>"
    And Click on Sign-In
    When Enter "<EmailAddress>" and "<Password>" and click sign in
    And Click on View My Account link
    And Click on My Personal Information
    And Edit the Firstname as "<FirstName>" and provide the mandatory details and save the details
    Then Verify the "<FirstName>" detail is displayed in My Account

    Examples: 
      | URL  | Browser|EmailAddress | Password |FirstName |
      | http://automationpractice.com|Chrome|someone@example.com  | Password123 |Automation|
