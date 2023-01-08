package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class a6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		String month="July 2023";
		driver.findElement(By.cssSelector(".lbl_input.latoBold.appendBottom10")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".DayPicker-Caption div")));
		
		while(!driver.findElement(By.cssSelector(".DayPicker-Caption div")).getText().equals(month))
		{
			driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		
	}
for(int i=0;i<driver.findElements(By.cssSelector(".DayPicker-Day div p:nth-child(1)")).size();i++)
{if(driver.findElements(By.cssSelector(".DayPicker-Day div p:nth-child(1)")).get(i).getText().equals("16"))
{driver.findElements(By.cssSelector(".DayPicker-Day div p:nth-child(1)")).get(i).click();
break;
	}
	}
		
		
		
		
		
	}

}
