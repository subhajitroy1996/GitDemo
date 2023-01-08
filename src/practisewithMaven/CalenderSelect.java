package practisewithMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.path2usa.com/travel-companions");
//		driver.findElement(By.cssSelector(".sumome-react-svg-image-container svg")).click();
		driver.findElement(By.cssSelector("#travel_date")).click();
		while(!driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText().equals("October 2022"))
		{	
			driver.findElement(By.cssSelector(".datepicker-days .table-condensed .next")).click();
			
		}
		
		List<WebElement> c=driver.findElements(By.xpath("//table[@class=\" table-condensed\"]/tbody/tr/td"));
		for(int i=0;i<c.size();i++)
		{
			if(c.get(i).getText().equals("15"))
			{
				c.get(i).click();
				break;
			}
		}
	}

}
