package practisewithMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoSUggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.ui-menu-item a")));
		List<WebElement> options=driver.findElements(By.cssSelector("li.ui-menu-item a"));
		String count="India";
		driver.findElement(By.xpath("//a[text()='"+"India"+"']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Bahrain')]")).click();
		
//		for (WebElement option:options)
//		{
//			if(option.getText().equalsIgnoreCase("India"))
//			{
//				option.click();
//			}
//		}
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).isSelected());
		driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).isSelected());
		List<WebElement> checkboxes=driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
		Assert.assertEquals(checkboxes.size(),6);
		driver.findElement(By.xpath("(//div[@class=\"picker-first2\"] //button[@class=\"ui-datepicker-trigger\"][1])[1]")).click();
//		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-state-default.ui-state-highlight")));
//		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();//if there are any spcaes in class name for cssSelector need to replace them with '.'
		
		System.out.println(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style"));
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]")).click();
		System.out.println(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style"));
		if(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("1"))
		{Assert.assertTrue(true);			
		}
		else
		{
			Assert.assertTrue(false);	
		}
	}

}
