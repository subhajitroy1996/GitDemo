package practisewithMaven;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class a1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.className("submit")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".error")));
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		String name="Pandit";
		String email="Pandit@gmail.com";
		String phone="822919211";
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys(phone);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".infoMsg")));
		
		String realpass=driver.findElement(By.cssSelector(".infoMsg")).getText().split("'")[1];
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(realpass);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Sign In']")));//application is still in the changing state, waiting for it to be in stable state.
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
//		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='login-container']/p")));
		
		Assert.assertEquals("You are successfully logged in.", driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		
	}

}
