package practisewithMaven;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class aAddingToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] items = { "Cashews", "Walnuts", "Raspberry", "Corn" };
		List bag=Arrays.asList(items);
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> w=driver.findElements(By.xpath("//h4"));
		w.stream().filter(a->bag.contains(a.getText().split(" ")[0])).map(a->getout(a)).forEach(a->System.out.println(""));
		

	}
	
	public static String getout(WebElement a)
	{
		a.findElement(By.xpath("following-sibling::div[2]/button")).click();
		return a.getText();
	}
}
