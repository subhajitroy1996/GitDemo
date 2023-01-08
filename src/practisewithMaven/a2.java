package practisewithMaven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class a2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\Test Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] items = { "Cashews", "Walnuts", "Raspberry", "Corn" };
		List<WebElement> a = driver.findElements(By.cssSelector(".product h4"));
//		for(WebElement i:a)
//		{k++;
//			if(l.contains(i.getText().split(" ")[0]))
//			{
//				i.findElement(By.xpath("//following-sibling::div[2]/button")).click();
//			}
//		}
//		.product-action
		int k = items.length;

		for (int i = 0; i < a.size() && k > 0; i++) {
			List l = Arrays.asList(items);
			if (l.contains(a.get(i).getText().split(" ")[0])) {
				driver.findElements(By.cssSelector(".product-action button[type='button']")).get(i).click();
				k--;
			}
		}

		driver.findElement(By.cssSelector(".cart-icon img")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'PROCEED')]")));

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), "Code applied ..!");
	}
}
