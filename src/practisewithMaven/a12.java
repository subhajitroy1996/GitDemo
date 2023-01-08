package practisewithMaven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class a12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\Test Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		ArrayList items = new ArrayList();
		items.add("Cashews");
		items.add("Walnuts"); 
		items.add("Raspberry");
		items.add("Corn");
		List<WebElement> a = driver.findElements(By.cssSelector(".product h4"));
		a.stream().filter(b->items.contains(b.getText().split(" ")[0])).map(b->getout(b)).forEach(b->System.out.println(b));
	}


public static String getout(WebElement b)
{b.findElement(By.xpath("following-sibling::div[2]/button")).click();
return b.getText();

	}
}