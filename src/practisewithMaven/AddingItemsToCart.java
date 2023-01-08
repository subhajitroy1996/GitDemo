package practisewithMaven;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddingItemsToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wish = { "Capsicum", "Tomato", "Banana", "Beetroot" };
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));// calling the explicit wait class. it acts
																			// on a specific element and like implicit
																			// wait follows instruction of Dom so if the
																			// element appears at 2s then it starts
																			// execution right after without waiting for
																			// 5s.
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit
		// wait is declared globally so when selenium is not able to locate a webelement
		// it will wait for max of 5seconds before throwing an error.if the object loads
		// before 5 s, lets take at 2s then it follows the instruction of dom to execute
		// from then without waiting any further.
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		AddingItemsToCart aitc = new AddingItemsToCart();
		aitc.AddItems(driver, wish, w);
	}

	public void AddItems(WebDriver driver, String[] wish, WebDriverWait w) {
		List<WebElement> options = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		for (int i = 0; i < options.size(); i++) {
			List a = Arrays.asList(wish);
			int l = a.size();
			String[] name = options.get(i).getText().split(" ");
			if (a.contains(name[0])) {
				l--;
				driver.findElements(By.cssSelector("div[class=\"product-action\"] button[type=\"button\"]")).get(i)
						.click();// do not depend on text() specially if its dynamic text.
				if (l == 0) {
					break;
				}
			}

		}
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));

		Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

	}

}
