package practisewithMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class a4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement foot=driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(foot.findElements(By.cssSelector("a")).size());
		
		WebElement col=foot.findElement(By.xpath("//table/tbody/tr//td[1]/ul"));
		System.out.println(col.findElements(By.tagName("a")).size());
		String e=Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=1;i<col.findElements(By.tagName("a")).size();i++)
		{
			col.findElements(By.tagName("a")).get(i).sendKeys(e);
		}
		Set<String> brow=driver.getWindowHandles();
		Iterator<String> it=brow.iterator();
		while(it.hasNext())
		{
			String url=it.next();
			driver.switchTo().window(url);
			System.out.println(driver.getTitle());
		}
	}

}
