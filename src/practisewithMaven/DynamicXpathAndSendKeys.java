package practisewithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathAndSendKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String veg="Cauliflower";
		WebElement w=driver.findElement(By.xpath("//h4[contains(text(),'"+veg+"')]/following-sibling::div[2]/button"));
		
//			String city = "Shirdi";
			
//			WebElement dynamicElement = driver.findElement(By.xpath("//p[contains(text(), '"+city+"')][contains(text(), 'India')]"));
			
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click", dynamicElement);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", w);
		
		
	}

}
