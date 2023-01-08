package practisewithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//div/button[1]/following-sibling::button[2]")).getText());//only possible using xpath.
		//using sibling to sibling relationship.
		driver.findElement(By.xpath("//div/button[1]/parent::div/a/button")).click();// traversing from child to parent and following another child.
		driver.navigate().to("https://www.google.co.in/");//diff between get and navigate is in case of get it waits until all the components of the page are loaded.
		driver.navigate().back();//it is like clicking on the back button
		driver.navigate().forward();
	}

}
