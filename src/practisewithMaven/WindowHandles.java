package practisewithMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> s=driver.getWindowHandles();//[parentid,childid,subchild] gets the ids of all windows opned by selenium
		Iterator<String> it=s.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);//selenium treats new tab or window as window//switching driver to next window
		String emailid=driver.findElement(By.cssSelector(".col-md-8 .im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parent);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailid);
		driver.quit();
	}

}
