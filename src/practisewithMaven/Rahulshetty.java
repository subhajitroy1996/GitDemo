package practisewithMaven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Rahulshetty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		//Firefox webdriver.gecko.driver  
		//Edge webdriver.edge.driver
		
		WebDriver driver= new ChromeDriver(); //WebDriver is the interface. ChromeDriver implements the methods of WebDriver acc to its definition.
		
		//Firefox WebDriver driver= new FirefoxDriver();
		//Edge WebDriver driver= new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		String open=Keys.chord(Keys.SHIFT,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Learning paths']")).sendKeys(open);
		
//		List<WebElement> w=driver.findElements(By.cssSelector("a[name='a']"));
//		System.out.println(w);
		//driver.close();  //used to close the current window.
		driver.quit();//closes the browser
		
	}

}
