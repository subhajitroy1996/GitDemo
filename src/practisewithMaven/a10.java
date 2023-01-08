package practisewithMaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class a10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
//		driver.findElement(By.xpath("//table //th[1]")).click();
//		driver.findElement(By.xpath("//table //th[1]")).click();
		Thread.sleep(2000);
		List<String> price;
		do{
		List<WebElement> l=driver.findElements(By.xpath("//table //tr/td[1]"));

		price=l.stream().filter(a->a.getText().equalsIgnoreCase("almond")).map(a->a.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
//		List<String> orig=l.stream().map(a->a.getText()).collect(Collectors.toList());
//		List<String> sec=orig.stream().sorted().collect(Collectors.toList());
//		Assert.assertEquals(orig, sec);
		if(l.stream().map(a->a.getText()).anyMatch(a->a.equalsIgnoreCase("almond")))
		{
			
			price.forEach(a->System.out.println(a));
			break;
		}
		else {
		driver.findElement(By.cssSelector(".pagination.pull-right li:nth-child(7) a")).click();}
		
		
	}while(price.isEmpty());
		}

}
