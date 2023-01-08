package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class aCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@data-cy='departureDate']"))));
		
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker-Caption']/div")));
		
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText().equals("March 2023"))
		{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		for(int i=0;i<driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1] //div[@class='DayPicker-Day']/div/p[1]")).size();i++)
		{
			if(driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1] //div[@class='DayPicker-Day']/div/p[1]")).get(i).getText().equals("21"))
			{
				driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1] //div[@class='DayPicker-Day']/div/p[1]")).get(i).click();
			}
		}
	}

}
