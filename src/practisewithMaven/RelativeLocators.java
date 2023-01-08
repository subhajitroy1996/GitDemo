package practisewithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		System.out.println(driver.findElement(with(By.tagName("label")).above(driver.findElement(By.cssSelector("[name=\"email\"]")))).getText());
		driver.findElement(with(By.tagName("input")).toLeftOf(By.cssSelector("[for=\"exampleCheck1\"]"))).click();
		
		driver.findElement(with(By.tagName("input")).below(driver.findElement(By.cssSelector("[for=\"dateofBirth\"]")))).click();
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(By.cssSelector("#inlineRadio1"))).getText());
//		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("document.querySelector(\"#exampleCheck1\").click");
		
	}

}
