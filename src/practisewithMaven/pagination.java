package practisewithMaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagination {

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
//		driver.findElement(By.xpath("//input")).sendKeys("")
		do{
		List<WebElement> l=driver.findElements(By.xpath("//tr/td[1]"));

		price=l.stream().filter(a->a.getText().equalsIgnoreCase("Mango")).map(a->a.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
//		if((driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).getAttribute("aria-disabled").equals("false")))
//		{
//		driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
//		}
		if(price.size()==0)
		{
			driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();	
		}
		
//		else {
//			break;
//		}
		
	}while(price.size()==0);
		
		
	}

}
