package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
		driver.manage().window().maximize();
		//Dynamic Dropdown is when the dropdown element doesnt appear on the main webpage unless an action is performed.
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
//		driver.findElement(By.xpath("//a[text()=\" Hyderabad (HYD)\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[text()=\" Dehradun (DED)\"]")).click();//alternative to selecting by indexing in xpath is using parent child xpath relationship.parent xpath child xpath
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//a[text()=' Hyderabad (HYD)'])[2]")));
		driver.findElement(By.xpath("(//a[text()=' Hyderabad (HYD)'])[2]")).click();
//		driver.findElement(By.xpath("(//a[text()=' Ahmedabad (AMD)'])[2]")).click();//using indexing on xpath, to select 2nd xpath. since both xpaths are same.
	
	}

}
