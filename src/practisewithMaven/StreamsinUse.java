package practisewithMaven;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsinUse {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
//		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr/th[1]")).click();
//		driver.findElement(By.xpath("//tr/th[1]")).click();
		Thread.sleep(2000);

//		List<String> s=w.stream().map(a->a.getText()).collect(Collectors.toList());
		List<Integer> price;
//		List<String> fin=s.stream().sorted().collect(Collectors.toList());
//		Assert.assertEquals(s, fin);
		do {
			List<WebElement> w = driver.findElements(By.xpath("//tr/td[1]"));
			price=w.stream().filter(a->a.getText().contains("Mango")).map(a->getPrice(a)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
			}
		} while (price.size() < 1);
	}

	private static int getPrice(WebElement a) {
		return Integer.parseInt(a.findElement(By.xpath("//following-sibling::td[1]")).getText());

	}

}
