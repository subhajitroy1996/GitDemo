package practisewithMaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();// soft delete wont fail the test like Assert class
		List<WebElement> link = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for (WebElement i : link) {
			String url = i.getAttribute("href");
			HttpURLConnection s = (HttpURLConnection) new URL(url).openConnection();
			s.setRequestMethod("HEAD");
			s.connect();
			int j = s.getResponseCode();
			a.assertTrue(j < 400, "Broken link for Text :" + i.getText());// catching all the failures

		}
		a.assertAll();// used to report the failures (if any) caught.
	}

}
