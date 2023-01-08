package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class aTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("aaa");
		driver.findElement(By.name("inputPassword")).sendKeys("pass");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password')]")).click();
		
		String name="Pandit";
		String email="Pandit@gmail.com";
		String phone="822919211";
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys(phone);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String n=driver.findElement(By.tagName("p")).getText().split("'")[1];
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("aaa");
		driver.findElement(By.name("inputPassword")).sendKeys(n);
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign In']")));
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']"))));
		Assert.assertEquals("aaa",driver.findElement(By.xpath("//h2")).getText().split(",")[0].split(" ")[1]);
		
		driver.quit();
	}

}
