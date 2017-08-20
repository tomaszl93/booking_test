package Ryanair_website_java.Ryanair_website_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeABooking {
	
	WebDriver driver;
	WebDriverWait wait;

	String flight_from_container = "//*[@id='search-container']/div[1]/div/form/div[2]/div/div/"
			+ "div[1]/div[2]/div[2]/div/div[1]/input";
	String flight_to_container = "//*[@id='search-container']/div[1]/div/form/div[2]/div/div/"
			+ "div[2]/div[2]/div[2]/div/div[1]/input";

	public MakeABooking(WebDriver driver){
		this.wait = new WebDriverWait(driver, 15);
		this.driver = driver;
	}
	
	public void close_cookie_policy(){
		String popup = ".close-icon > div:nth-child(1) > svg:nth-child(1)";
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(popup)));
		driver.findElement(By.cssSelector(popup)).click();
	}
	
	public void select_one_way_trip(){
		driver.findElement(By.id("lbl-flight-search-type-one-way")).click();
	}
	
	public void select_city_from(){
		driver.findElement(By.xpath(flight_from_container)).clear();
		driver.findElement(By.xpath(flight_from_container)).sendKeys("Krakow");
		driver.findElement(By.xpath(flight_from_container)).sendKeys(Keys.ENTER);
	}
	
	public void select_city_to(){
		driver.findElement(By.xpath(flight_to_container)).clear();
		driver.findElement(By.xpath(flight_to_container)).sendKeys("Gdansk");
		driver.findElement(By.xpath(flight_to_container)).sendKeys(Keys.ENTER);
	}
	

}
