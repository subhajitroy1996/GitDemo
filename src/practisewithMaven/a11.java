package practisewithMaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class a11 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		driver.findElement(By.cssSelector("div #search-field")).sendKeys("Rice");
//		Thread.sleep(2000);
		
		for(int i=3;i<=driver.findElements(By.xpath("//li/a")).size()-1;i++)
		{List<WebElement> l=driver.findElements(By.xpath("//table //tr/td[1]"));

		l.stream().map(a->a.getText()).forEach(a->System.out.println(a));
		if(i<driver.findElements(By.xpath("//li/a")).size()-2)
		{
		driver.findElement(By.xpath("//li/a[@aria-label='Next']")).click();
		}

		}

}}
