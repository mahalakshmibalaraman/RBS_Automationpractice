package stepDefinition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.PageObject;
//import test.assertion.SoftAssertTest;
import wrappers.DriverFactory;

public class stepDef {
	
	private DriverFactory driverFac;
	private WebDriver driver;
	private PageObject home;
	private String orderRefNo;
	private SoftAssert softAssert;
	private String pwd = "Password123";
	
	
	public stepDef(){
		
		driverFac = new DriverFactory();
		home = null;
		orderRefNo =null;
		softAssert = new SoftAssert();
		
	}

	@Given("^launch the My Store application \"([^\"]*)\" in \"([^\"]*)\"$")
	public void launch_the_My_Store_application_in(String url, String browser) throws Throwable {
		
		driver = driverFac.getInstance(browser);
		home = PageFactory.initElements(driver,PageObject.class );
		driver.get(url);
		
	    
	}

	@Given("^Click on T-shirt tab$")
	public void click_on_T_shirt_tab() throws Throwable {
	    
	    home.clickTShirts();
	}
	
	@Given("^choose t-shirt \"([^\"]*)\"$")
	public void choose_t_shirt(String name) throws Throwable {
	    
		home.clickTShirtByName(name);
	}

	@When("^set \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" and add the product to the cart$")
	public void choose_the_and_Add_the_product_to_the_cart(String color, String size,String qty) throws Throwable {
		
		home.setQty(qty);
		home.selectSize(size);		
		if(color.equalsIgnoreCase("Orange")){
			home.selectColorOrange();
		}
		else if(color.equalsIgnoreCase("Blue")){
			home.selectColorBlue();
		}
		else{
			
			System.err.println("Please specify available color");
		}
		
		home.clickAddToCartBtn();
		
		
	    
	}

	@When("^Click on Proceed to Checkout page")
	public void click_on_Proceed_to_Checkout_page() throws Throwable {
	    home.clickProceedToCheckoutBtn();
	    home.clickProceedToCheckoutCartBtn();
	}

	@When("^Sign-in into account by providing valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void sign_in_into_account_by_providing_valid_credentials_and(String mailAddress, String password) throws Throwable {
	    
	    home.setUserEmailID(mailAddress);
	    home.setUserPassword(password);
	    
	    home.clickSignInBtn();
	}
	
	@When("^select Delivery Address \"([^\"]*)\" and Proceed$")
	public void select_Delivery_Address_and_Proceed(String deliveryAddresss_Type) throws Throwable {
	    
	    home.selectDeliveryAddress(deliveryAddresss_Type);
	    home.clickProceedToCheckoutAddressModalBtn();
	}

	@When("^Accept the terms and condition anf proceed to Checkout")
	public void accept_the_terms_and_condition_anf_proceed_to_Checkout() throws Throwable {
	    
	    home.clickAgreementCheckBox();
	    home.clickProceedToCheckoutPaymentBtn();
	}

	@When("^Select the \"([^\"]*)\" and Confirm the order$")
	public void select_the_and_Confirm_the_order(String paymentMethod) throws Throwable {
	    
	    if(paymentMethod.equalsIgnoreCase("Pay by bank wire")){
	    	home.clickPayByBankWire();
	    }
	    else if(paymentMethod.equalsIgnoreCase("Pay by check")){
	    	home.clickPayByCheck();
	    }
	    
	    home.clickConfirmOrder();
	}

	@Then("^Verify the order confirmation page")
	public void verify_the_order_confirmation_page() throws Throwable {
	    
		String msg = home.getConfirmOrderReferenceNo();
		Pattern p = Pattern.compile("Do not forget to insert your order reference ([A-Z]*) in the subject of your bank wire.");
		
		Matcher m = p.matcher(msg);
		while(m.find()){

			orderRefNo = m.group(1);
			System.out.println("Order Ref No is "+orderRefNo);
		}
	}
	
	@Then("^check order reference no present in order history page")
	public void verify_order_history_page() throws Throwable {
	    
		/*home.clickCustomerDetails();
		home.clickViewMyOrders();
		softAssert.assertTrue(home.checkOrderID(orderRefNo),"Order Referenece no is not displayed");
		softAssert.assertAll();*/
		
	}
	
	@Given("^Click on Sign-In$")
	public void click_on_Sign_In() throws Throwable {
	    
		home.clickSignInMenuBtn();
	}

	@When("^Click on View My Account link$")
	public void click_on_View_My_Account_link() throws Throwable {
	    
		home.clickCustomerDetails();
	}

	@When("^Click on My Personal Information$")
	public void click_on_My_Personal_Information() throws Throwable {
	    
		home.clickPersonalInfo();
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and click sign in$")
	public void enter_and_and_click_sign_in(String arg1, String arg2) throws Throwable {
	    
		home.setUserEmailID(arg1);
		home.setUserPassword(arg2);
		home.clickSignInBtn();
	}

	@When("^Edit the Firstname as \"([^\"]*)\" and provide the mandatory details and save the details$")
	public void edit_the_Firstname_as_and_provide_the_mandatory_details_and_save_the_details(String arg1) throws Throwable {
	    
		home.setFName(arg1);
		home.setOldPWD(pwd);
		home.clickSave();
	}

	@Then("^Verify the \"([^\"]*)\" detail is displayed in My Account$")
	public void verify_the_success_message_and_check_whether_the_detail_is_displayed_in_My_Account(String arg1) throws Throwable {
	    
		softAssert.assertTrue(home.getCustomerName().contains(arg1),"First Name is as expected");
		softAssert.assertAll();
		
	}


}
