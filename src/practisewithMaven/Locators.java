package practisewithMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//applicable to the entire program, makes selenium wait for 3 seconds for an object to show up in the page.
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.manage().window().maximize();
	driver.findElement(By.id("inputUsername")).sendKeys("Sayantan");
	driver.findElement(By.name("inputPassword")).sendKeys("abc112");
	driver.findElement(By.className("signInBtn")).click();
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());//Selecting using cssSelector: tagname[attribute='value']	,tagname.classname, tagname#id
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(1000);// for the script wait for 1sec..i.e. it waits for something to get into stable state 
	driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Ramu");//using cssSelector tagname[attribute='value']
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Ritesh@gmailodi.com");//using xpath: //tagname[@attribute='value']
	driver.findElement(By.xpath("//input[@type=\"text\"][3]")).sendKeys("219191029");//[3] is used for indexing, incase we cant identify by any unique attribute.
	driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(4)")).clear();//css selects some hidden elements in the page as compared to xpath so the indexing might vary for both.
	System.out.println(driver.findElement(By.xpath("//form/h2")).getText());//using parent Tag child Tag relationship of xpath
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();//using xpath .class
	System.out.println(driver.findElement(By.cssSelector("form p")).getText());//using parent Tag child Tag relationship of cssSelector
	
	driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[@class=\"go-to-login-btn\"]")).click();//using xpath tags locator along with attribute.
	Thread.sleep(1000);//other element would receive the click. so we are making the script wait for 2 sec until the view loads
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
	driver.findElement(By.cssSelector("input[name*=\"input\"]")).sendKeys("rahulshettyacademy");//using regular expression to identify name attribute value by partial text for css.
	driver.findElement(By.xpath("//input[contains(@value,\"rmbr\")]")).click();//using regular expression to identify name attribute value by partial text for xpath.
	driver.findElement(By.cssSelector("div button[class=\"submit signInBtn\"]")).click();// using tags and attribute to locate using cssSelector.
	}

}
