package practisewithMaven;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class a7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
//		Proxy proxy=new Proxy();
//		proxy.setHttpProxy("ipaddress:4444");
//		option.setCapability("proxy",proxy);
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
//		driver.get("https://expired.badssl.com/");
		driver.get("https://optinmonster.com/40-top-brands-using-pop-ups-to-increase-their-conversions/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(""));
	}

}
