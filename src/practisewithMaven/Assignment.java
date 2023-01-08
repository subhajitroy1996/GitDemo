package practisewithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String namePerson="Rahul Shetty";
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("div[class=\"form-group\"] input[name=\"name\"]")).sendKeys(namePerson);
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("contact@rahulshettyacademy.com");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("rahul1982shetty");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		
		Select options=new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		options.selectByVisibleText("Male");
		
		driver.findElement(By.xpath("//input[@name=\"bday\"]")).sendKeys("21111996");
		driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();
	}

}
