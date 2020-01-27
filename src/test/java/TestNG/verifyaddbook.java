package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifyaddbook {
	WebDriver driver;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/addressbook");
		driver.manage().window().maximize();
	}

	@Test
	public void verify() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='v-button v-widget']")).click();
		//driver.findElement(By.className("v-button")).click();
		driver.findElement(By.id("gwt-uid-5")).sendKeys("Testing");
		driver.findElement(By.id("gwt-uid-7")).sendKeys("Devops");
		driver.findElement(By.id("gwt-uid-9")).sendKeys("9834562789");
		driver.findElement(By.id("gwt-uid-11")).sendKeys("Devops@edureka.co");
		driver.findElement(By.id("gwt-uid-13")).sendKeys("01/01/2015");
		driver.findElement(By.className("v-button-primary")).click();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
