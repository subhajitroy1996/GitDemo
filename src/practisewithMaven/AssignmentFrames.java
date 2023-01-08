package practisewithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.tagName("div")).getText());
	}

}
