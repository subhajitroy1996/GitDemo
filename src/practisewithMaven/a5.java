package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class a5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(option);
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		String month="July 2023";
		driver.findElement(By.cssSelector("span.langCardClose")).click();
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.DayPicker-Caption div")));
		while(!driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText().equals(month))
		{
//			System.out.println(driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText());
			driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[2]")).click();
		}
		
		
		for(int i=0;i<driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1] //div[@class='dateInnerCell']/p[1]")).size();i++)
		{
			if(driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1] //div[@class='dateInnerCell']/p[1]")).get(i).getText().equals("10"))
			{
				driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1] //div[@class='dateInnerCell']/p[1]")).get(i).click();
			}
		}
	}
}
