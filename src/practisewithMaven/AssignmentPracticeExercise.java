package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentPracticeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("(//div[@class='right-align']/fieldset/label/input)[3]")).click();
		
		List<WebElement> option=driver.findElements(By.xpath("//div[@class='right-align']/fieldset/label/input"));
		String o=find(option,driver);
		System.out.println(o);
		Select op1=new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		op1.selectByVisibleText(o);
		driver.findElement(By.cssSelector("#name")).sendKeys(o);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		driver.switchTo().alert().getText().contains(o);
		
	}
public static String find(List<WebElement> option,WebDriver driver)
{for (int i=0;i<option.size();i++)
{
	if(option.get(i).isSelected())
	{
	 return driver.findElements(By.xpath("//div[@class='right-align']/fieldset/label")).get(i).getText();
		
	}
}
return null;
	}
}
