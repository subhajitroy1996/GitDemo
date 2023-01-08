package practisewithMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class a3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//body/a")).click();
//		Set<String> a=driver.getWindowHandles();
		for(String window: driver.getWindowHandles())
		{
			driver.switchTo().window(window);
		}
		
//		Iterator<String> it=a.iterator();
//		String parent=it.next();
//		String child=it.next();
//		driver.switchTo().window(child);
//		String email=driver.findElement(By.xpath("//strong/a")).getText();
//		driver.switchTo().window(parent);
//		driver.findElement(By.cssSelector("#username")).sendKeys(email);
		
	}

}
