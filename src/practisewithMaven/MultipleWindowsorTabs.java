package practisewithMaven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsorTabs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);//opening a new Window
		Set<String> a=driver.getWindowHandles();
		Iterator<String> it=a.iterator();
		String parent=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		driver.get("https://rahulshettyacademy.com/");
		String v=driver.findElement(By.xpath("//h2/a[1]")).getText();
		driver.switchTo().window(parent);
		WebElement b=driver.findElement(By.xpath("//input[1]"));
		b.sendKeys(v);
		File src=b.getScreenshotAs(OutputType.FILE);//capturing screenshot of WebElement
		FileUtils.copyToDirectory(src, new File("capture.png"));
		System.out.println(b.getRect().getDimension().getHeight());//to get the dimension of a WebELement
		System.out.println(b.getRect().getDimension().getWidth());
	}

}
