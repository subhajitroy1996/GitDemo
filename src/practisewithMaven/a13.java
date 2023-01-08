package practisewithMaven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class a13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\Test Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> w=driver.getWindowHandles();
		Iterator<String> it=w.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");
		String course=driver.findElement(By.cssSelector("h2 a")).getText();
		System.out.println(course);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input")).sendKeys(course);
		File src=driver.findElement(By.xpath("//input")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\screenshot.png"));
	}

}
