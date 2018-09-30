package wrappers;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public static WebDriver driver=null;

	public WebDriver getInstance(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("IE")||BrowserName.equalsIgnoreCase("InternetExplorer")||BrowserName.equalsIgnoreCase("Internet Explorer"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			capabilities.setCapability(InternetExplorerDriver.SILENT,true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

			driver=new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			setTimeouts();
		}
		else if(BrowserName.equalsIgnoreCase("Chrome")||BrowserName.equalsIgnoreCase("GoogleChrome")||BrowserName.equalsIgnoreCase("Google Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized","--disable-extensions","--incognito"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			setTimeouts();
		}
		return driver;
	}


	private void setTimeouts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
}