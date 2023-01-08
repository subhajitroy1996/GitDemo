package practisewithMaven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");//proxy setting in chrome.
		options.setCapability("proxy", proxy);
		
		Map<String, Object> prefs = new HashMap<String, Object>();		
		prefs.put("download.default_directory", "/directory/path");//used for setting the default directory for download using chrome browser.
    	options.setExperimentalOption("prefs", prefs);
    	
    	options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));//block a pop up on any site.
		
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);//modifying the default behavior of the browser
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		
		
		
	}

}
