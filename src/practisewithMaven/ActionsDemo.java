package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);//Actions class is used to automate for all mouse/keyboard actions.
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("nav-al-signin")));
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		Action ac=a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build();
		ac.perform();//build builds the entire command before it an then perform makes it perform the action. 
	}

}
