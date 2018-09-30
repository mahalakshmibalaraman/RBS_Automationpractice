package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageObject {

	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//ul[starts-with(@class,'sf-menu')]/li/a[@title='T-shirts']") 
	private WebElement TSHIRTS_MENU;

	@FindBy(how=How.CSS,using="input#quantity_wanted") 
	private WebElement TSHIRTS_QTY_INPUT;

	@FindBy(how=How.CSS,using="a.button-plus.product_quantity_up") 
	private WebElement TSHIRTS_QTY_PLUS;

	@FindBy(how=How.CSS,using="a.button-minus.product_quantity_down") 
	private WebElement TSHIRTS_QTY_MINUS;

	@FindBy(how=How.CSS,using="select#group_1") 
	private WebElement TSHIRTS_SIZE_DROPDOWN;

	@FindBy(how=How.ID,using="color_13") 
	private WebElement TSHIRTS_COLOR_ORANGE;

	@FindBy(how=How.ID,using="color_14") 
	private WebElement TSHIRTS_COLOR_BLUE;

	@FindBy(how=How.CSS,using="p#add_to_cart button") 
	private WebElement TSHIRTS_ADD_TO_CART_BTN;

	@FindBy(how=How.XPATH,using="//a[@title='Proceed to checkout']") 
	private WebElement TSHIRTS_PROCEED_TO_CHECKOUT;
	
	@FindBy(how=How.CSS,using="p.cart_navigation>a") 
	private WebElement TSHIRTS_PROCEED_TO_CHECKOUT_CART;

	@FindBy(how=How.CSS,using="input#email") 
	private WebElement EMAIL_ADDRESS;

	@FindBy(how=How.CSS,using="input#passwd") 
	private WebElement PASSWORD;

	@FindBy(how=How.CSS,using="button#SubmitLogin") 
	private WebElement SIGN_IN_BTN;
	
	@FindBy(how=How.XPATH,using="//a[@title='Log in to your customer account']") 
	private WebElement SIGN_IN_MENU_BTN;

	@FindBy(how=How.CSS,using="select#id_address_delivery") 
	private WebElement DELIVERY_ADDRESS_DROPDOWN;

	@FindBy(how=How.CSS,using="input#addressesAreEquals") 
	private WebElement SAME_ADDRESS_CHECKBOX;

	@FindBy(how=How.XPATH,using="//button[@name='processAddress']") 
	private WebElement TSHIRTS_PROCEED_TO_CHECKOUT_ADDRESS_MODAL;

	@FindBy(how=How.CSS,using="div#uniform-cgv") 
	private WebElement AGREEMENT_CHECKBOX;
	
	@FindBy(how=How.XPATH,using="//button[@name='processCarrier']") 
	private WebElement TSHIRTS_PROCEED_TO_CHECKOUT_PAYMENT;

	@FindBy(how=How.XPATH,using="//a[@title='Pay by bank wire']") 
	private WebElement PAY_BY_BANK;

	@FindBy(how=How.XPATH,using="//a[@title='Pay by check.']") 
	private WebElement PAY_BY_CHECK;

	@FindBy(how=How.XPATH,using="//span[text()='I confirm my order']/..") 
	private WebElement CONFIRM_ORDER;

	@FindBy(how=How.CSS,using="p.alert-success") 
	private WebElement ORDER_CONFIRMATION_SUCCESS_MSG;
	
	@FindBy(how=How.XPATH,using="//div[@class='box']")
	private WebElement ORDER_REFERECE_NO;

	@FindBy(how=How.XPATH,using="//a[@title='View my customer account']") 
	private WebElement CUSTOMER_LINK;
	
	@FindBy(how=How.XPATH,using="//a[@title='View my customer account']/span") 
	private WebElement CUSTOMER_NAME;

	@FindBy(how=How.XPATH,using="//a[@title='Orders']") 
	private WebElement ORDERS_LINK; 

	@FindBy(how=How.XPATH,using="//a[@title='Information']") 
	private WebElement PERSONALINFO;
	
	@FindBy(how=How.CSS,using="input#firstname") 
	private WebElement FIRST_NAME;
	
	@FindBy(how=How.CSS,using="input#old_passwd") 
	private WebElement OLD_PWD;
	
	@FindBy(how=How.XPATH,using="//button[@name='submitIdentity']") 
	private WebElement SAVE_BTN;
	
	

	public PageObject(WebDriver driver){

		this.driver = driver;
	}

	public void clickTShirts(){

		try{

			TSHIRTS_MENU.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.linkText("T-shirts")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("T-Shirt Sub menu is not displayed", true);
		}
	}


	public void setQty(String qty){

		try{

			driver.switchTo().frame(0);
			TSHIRTS_QTY_INPUT.clear();
			TSHIRTS_QTY_INPUT.sendKeys(qty);
			driver.switchTo().defaultContent();
		}
		catch(StaleElementReferenceException e){

			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("input#quantity_wanted")).sendKeys(qty);
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e){

			Reporter.log("Quantity input box is not displayed", true);
		}
	}

	public void clickTShirtByName(String name){

		try{

			driver.findElement(By.xpath("//a[@title='"+name+"']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Product is not available", true);
		}
	}


	public void selectSize(String size){

		driver.switchTo().frame(0);
		Select sel = new Select(TSHIRTS_SIZE_DROPDOWN);

		try{

			sel.selectByVisibleText(size);
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e){

			Reporter.log("Size is not available", true);
		}
	}

	public void selectColorOrange(){

		try{

			driver.switchTo().frame(0);
			TSHIRTS_COLOR_ORANGE.click();
			driver.switchTo().defaultContent();
		}
		catch(StaleElementReferenceException e){

			driver.switchTo().frame(0);
			driver.findElement(By.id("color_13")).click();
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e){

			Reporter.log("Color- Orange is not displayed", true);
		}


	}

	public void selectColorBlue(){

		try{

			driver.switchTo().frame(0);
			TSHIRTS_COLOR_BLUE.click();
			driver.switchTo().defaultContent();
		}
		catch(StaleElementReferenceException e){

			driver.switchTo().frame(0);
			driver.findElement(By.id("color_14")).click();
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e){

			Reporter.log("Color- Blue is not displayed", true);
		}


	}


	public void clickAddToCartBtn(){

		try{

			driver.switchTo().frame(0);
			TSHIRTS_ADD_TO_CART_BTN.click();
			driver.switchTo().defaultContent();
		}
		catch(StaleElementReferenceException e){

			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("p#add_to_cart button")).click();
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e){

			Reporter.log("Add to cart btn is not displayed", true);
		}


	}

	public void clickProceedToCheckoutBtn(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(TSHIRTS_PROCEED_TO_CHECKOUT));
		
		try{
			
			TSHIRTS_PROCEED_TO_CHECKOUT.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Proceed To Checkout btn is not displayed", true);
		}


	}
	
	public void clickProceedToCheckoutCartBtn(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(TSHIRTS_PROCEED_TO_CHECKOUT_CART));

		try{

			TSHIRTS_PROCEED_TO_CHECKOUT_CART.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("p.cart_navigation>a")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Proceed To Checkout btn cart is not displayed", true);
		}


	}

	public void setUserEmailID(String email){

		try{

			EMAIL_ADDRESS.sendKeys(email);
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("input#email")).sendKeys(email);
		}
		catch(NoSuchElementException e){

			Reporter.log("User Email id input box is not displayed", true);
		}
	}

	public void setUserPassword(String pwd){

		try{

			PASSWORD.sendKeys(pwd);
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("input#passwd")).sendKeys(pwd);
		}
		catch(NoSuchElementException e){

			Reporter.log("User Password input box is not displayed", true);
		}
	}

	public void clickSignInBtn(){

		try{

			SIGN_IN_BTN.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("button#SubmitLogin")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Sign In btn is not displayed", true);
		}


	}
	
	public void clickSignInMenuBtn(){

		try{

			SIGN_IN_MENU_BTN.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("//a[@title='Log in to your customer account']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Sign In btn in Menu section is not displayed", true);
		}


	}

	public void selectDeliveryAddress(String name){

		Select sel = new Select(DELIVERY_ADDRESS_DROPDOWN);

		try{

			sel.selectByVisibleText(name);
		}
		catch(NoSuchElementException e){

			Reporter.log("Delivery Address value is not available", true);
		}
	}


	public void clickProceedToCheckoutAddressModalBtn(){

		try{

			TSHIRTS_PROCEED_TO_CHECKOUT_ADDRESS_MODAL.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Proceed To Checkout Address Modal btn is not displayed", true);
		}


	}


	public void clickAgreementCheckBox(){

		try{

			AGREEMENT_CHECKBOX.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("div#uniform-cgv")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("User Agreement modal is not displayed", true);
		}


	}
	
	
	public void clickProceedToCheckoutPaymentBtn(){

		try{

			TSHIRTS_PROCEED_TO_CHECKOUT_PAYMENT.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Proceed To Checkout Payment btn is not displayed", true);
		}


	}


	public void clickPayByBankWire(){

		try{

			PAY_BY_BANK.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Pay by Bank wire option is not displayed", true);
		}


	}


	public void clickPayByCheck(){

		try{

			PAY_BY_CHECK.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Pay by check option is not displayed", true);
		}


	}

	public void clickConfirmOrder(){

		try{

			CONFIRM_ORDER.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//span[text()='I confirm my order']/..")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Pay by check option is not displayed", true);
		}

	}


	public String getConfirmOrderMsg(){

		try{

			return ORDER_CONFIRMATION_SUCCESS_MSG.getText();

		}
		catch(StaleElementReferenceException e){

			return driver.findElement(By.cssSelector("p.alert-success")).getText();
		}
		catch(NoSuchElementException e){

			Reporter.log("Order confirmation msg is not displayed", true);
			return "";
		}


	}
	
	
	public String getConfirmOrderReferenceNo(){

		try{

			return ORDER_REFERECE_NO.getText();

		}
		catch(StaleElementReferenceException e){

			return driver.findElement(By.xpath("//div[@class='box']")).getText();
		}
		catch(NoSuchElementException e){

			Reporter.log("Order confirmation refernce no is not displayed", true);
			return "";
		}


	}

	public void clickCustomerDetails(){

		try{

			CUSTOMER_LINK.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Customer profile link is not displayed", true);
		}


	}
	
	public String getCustomerName(){

		try{

			return CUSTOMER_NAME.getText();
		}
		catch(StaleElementReferenceException e){

			return driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
		}
		catch(NoSuchElementException e){

			Reporter.log("Customer profile name is not displayed", true);
			return "";
		}


	}

	public void clickViewMyOrders(){

		try{

			ORDERS_LINK.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='Orders']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("View my orders link is not displayed", true);

		}


	}

	public void clickPersonalInfo(){

		try{

			PERSONALINFO.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//a[@title='Information']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("View my Personal Info link is not displayed", true);

		}


	}
	
	public boolean checkOrderID(String orderId){
		
		return driver.findElement(By.xpath("//table[@id='order-list']//tbody/tr[1]/td/a[contains(text(),'"+orderId+"')")).isDisplayed();
	}
	
	public void setFName(String name){

		try{

			FIRST_NAME.clear();
			FIRST_NAME.sendKeys(name);
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("input#firstname")).sendKeys(name);
		}
		catch(NoSuchElementException e){

			Reporter.log("First Name input box is not displayed", true);

		}


	}
	
	public void setOldPWD(String pwd){

		try{

			OLD_PWD.sendKeys(pwd);
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.cssSelector("input#old_passwd")).sendKeys(pwd);
		}
		catch(NoSuchElementException e){

			Reporter.log("Old Pwd input box is not displayed", true);

		}


	}
	
	public void clickSave(){

		try{

			SAVE_BTN.click();
		}
		catch(StaleElementReferenceException e){

			driver.findElement(By.xpath("//button[@name='submitIdentity']")).click();
		}
		catch(NoSuchElementException e){

			Reporter.log("Save btn is not displayed", true);

		}


	}
}
