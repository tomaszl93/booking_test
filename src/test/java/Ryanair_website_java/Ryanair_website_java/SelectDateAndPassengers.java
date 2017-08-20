package Ryanair_website_java.Ryanair_website_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDateAndPassengers {
	
	WebDriver driver;
	WebDriverWait wait;
	
	String date_flight_input = "//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]";
	String month_name = "//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[3]/div/div/div[2]/popup-content/core-datepicker/div/div[1]/ul/li";
	String passengers_div = "//*[@id='row-dates-pax']/div[2]/div[2]/div[2]/div/div[1]";
	String add_adult_button = "//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[6]"
			+ "/div/div[3]/core-inc-dec/button[2]";

	public SelectDateAndPassengers(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void select_date(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(date_flight_input)));
		driver.findElement(By.xpath(date_flight_input)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(month_name+"[1]/h1")));
		
		int i = 1;
		String slide_next_month = "//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[3]/div/"
				+ "div/div[2]/popup-content/core-datepicker/div/div[2]/button[2]";
		while (!driver.findElement(By.xpath(month_name+"["+i+"]/h1")).getAttribute("innerHTML").equals("December 2017")){
			driver.findElement(By.xpath(slide_next_month)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(month_name+"["+(i+2)+"]/h1")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(slide_next_month)));
			i++;
		}
	}
	
	public void select_passengers(){
		driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[3]/div/div/"
				+ "div[2]/popup-content/core-datepicker/div/div[1]/ul/li[5]/ul[2]/li[19]/span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passengers_div)));
		
		driver.findElement(By.xpath(passengers_div)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(add_adult_button)));
		driver.findElement(By.xpath(add_adult_button)).click();
	
		driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/"
				+ "div/div[3]/core-inc-dec/button[2]")).click();
		
	}
	
	public void select_lets_go_button(){
		driver.findElement(By.xpath("//*[@id='search-container']/div[1]/div/form/div[4]/button[2]")).click();
	}
}
