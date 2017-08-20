package Ryanair_website_java.Ryanair_website_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeats {

	String confirm = "//*[@id='ngdialog3']/div[2]/div[1]/div/div[4]/dialog-footer/div[1]/button[1]";
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	

	public SelectSeats(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		this.executor = (JavascriptExecutor) driver;

	}
	
	public void click_continue_button(){
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		driver.findElement(By.id("continue")).click();
	}
	
	public void confirm_select_seats(){
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".core-btn-primary.same-seats")));
		driver.findElement(By.cssSelector(".core-btn-primary.same-seats")).click();
	}
	
	public void select_seats(){
		List<WebElement> seats = driver.findElements(By.className("seat-click"));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.className("seat-click")).get(0)));
		
		for(int i=0; i<seats.size(); i++){
			WebElement we = driver.findElements(By.className("seat-click")).get(i);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.findElements(By.className("remove-optional-seats-mobile")).size() != 0){
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void close_advert(){
		if(driver.findElements(By.className("priority-boarding-prompt")).size() != 0){ 
			driver.findElement(By.className("core-btn-bb-outline")).click();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click_next_button(){		
		WebElement continue_button = driver.findElement(By.xpath(confirm));
		executor.executeScript("arguments[0].click();", continue_button);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click_confirm(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirm)));
		WebElement confirm_button = driver.findElement(By.xpath(confirm));
		executor.executeScript("arguments[0].click();", confirm_button);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click_checkout(){
		String checkout = "//*[@id='booking-selection']/article/div[2]/section/div[2]/button";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkout)));
		WebElement checkout_button = driver.findElement(By.xpath(checkout));
		executor.executeScript("arguments[0].click();", checkout_button);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
