package Ryanair_website_java.Ryanair_website_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginToRyanairWebsite {
	String login = "Test_wroclaw@wp.pl";
	String pass = "Test_website_wro1";
	String password = "//input[contains(@id, 'password')]";
	
	WebDriver driver;
	WebDriverWait wait;

	public LoginToRyanairWebsite(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void click_on_myryanair_auth(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("base-carousel")));
		driver.findElement(By.xpath("//*[@id='myryanair-auth-login']")).click();
	}
	
	public void type_username(){
		wait.until(ExpectedConditions.elementToBeClickable(By.className("form-field")));
		driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys(login);
	}
	
	public void type_password(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(password)));
		driver.findElement(By.xpath(password)).sendKeys(pass);
	}
	
	public void click_login_button(){
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-container']/ul[2]/ra-toaster[1]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='menu-container']/ul[2]/ra-toaster[1]")));
	}
	
	public void click_from_price(){
		int ok_size = driver.findElements(By.className("flights-table-price__header")).size();
		driver.findElements(By.className("flights-table-price__header")).get(ok_size-1).click();
	}
	
	public void select_standard_fare(){
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		driver.findElements(By.id("continue")).get(0).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
