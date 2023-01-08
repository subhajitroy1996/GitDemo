package practisewithMaven;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fluentwaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);// creating an object of
																							// Wait interface and
																							// overwriting it with
																							// FluentWait
																							// CLass,mentioning that
																							// driver is of WebDriver
																							// type.

		driver.findElement(By.cssSelector("div button")).click();

		WebElement z = w.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("#finish h4")).isDisplayed())
				{
				return driver.findElement(By.cssSelector("#finish h4"));
			}
				else
				{
					return null;
				}
			}
		}

		);
//		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#finish h4")));
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText());
	}

}
