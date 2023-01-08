package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AssignmentAutoCompleteDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("uni");
		Thread.sleep(2000);
		Actions ac=new Actions(driver);
		List<WebElement> w=driver.findElements(By.cssSelector("#ui-id-1 li div"));
		for(WebElement a:w)
		{
			if(a.getText().contains("United States"))
			{	ac.moveToElement(a).build().perform();
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.cssSelector("input#autocomplete")).getText(), "United States", "Found");

			}
		}
	}

}
