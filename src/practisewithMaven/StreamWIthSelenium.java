package practisewithMaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StreamWIthSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		String name="a";
		driver.findElement(By.cssSelector("div input#search-field")).sendKeys(name);
		Thread.sleep(1000);
		do
		{
		List<WebElement> w=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> names=w.stream().filter(a->a.getText().toLowerCase().contains(name)).map(a->a.getText()).collect(Collectors.toList());
//	Stream creation -> performing intermediate op to create another stream ->terminal operation to get output.
		//		streams scan the collection parallely(i.e. all the webelement are searched at once in parallel ,if something
//		are found then stored in a stream )
		//		names.forEach(a->System.out.println(a));
		if(driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).getAttribute("aria-disabled").contains("false"))
		{
			driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
			Thread.sleep(2000);
		}
		names.forEach(a->System.out.println(a));
//		Assert.assertEquals(names.size(), w.size());
		}while((driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).getAttribute("aria-disabled").contains("false")));
	}

}
