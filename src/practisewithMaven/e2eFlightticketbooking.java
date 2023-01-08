package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2eFlightticketbooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=\" Hyderabad (HYD)\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()=' Chennai (MAA)'])[2]")).click();
		driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"picker-first2\"] //button[@class=\"ui-datepicker-trigger\"][1])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for (int i=1;i<=3;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		List<WebElement> options=driver.findElements(By.cssSelector("select[id=\"ctl00_mainContent_DropDownListCurrency\"] option"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("USD"))
			{
				option.click();
			}
		}
		driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).sendKeys("It");
		Thread.sleep(2000);
		List<WebElement> autosugg=driver.findElements(By.cssSelector("li.ui-menu-item a"));
		for(WebElement i:autosugg)
		{
			if(i.getText().equalsIgnoreCase("italy"))
			{
				i.click();
			}
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
		
		
	}

}
