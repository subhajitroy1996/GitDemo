package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> l=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		System.out.println(l.size());
		System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());
		List<WebElement> w=l.get(2).findElements(By.tagName("td"));
		for(int i=0;i<w.size();i++)
				{
					System.out.println(w.get(i).getText());
				}
		
		
	}

}
