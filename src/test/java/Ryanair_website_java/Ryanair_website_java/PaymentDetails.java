package Ryanair_website_java.Ryanair_website_java;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDetails {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	
	String fst_name = "John", surname = "Malloy", fst_name_snd = "Tommy", surname_snd = "Williams",
			fst_name_child = "Kate", surname_child = "Williams", phone = "694321123", card_number = "5555555555555557",
			card = "MasterCard", expire_month = "10", expire_year = "2018", code = "265", address1 = "25 Sun Lane",
			address2 = "Sun Land", city = "Dublin", postcode = "51125", country = "Ireland";

	public PaymentDetails(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		this.executor = (JavascriptExecutor) driver;
	}
	
	public void fill_passenger_details(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@id,'firstName')]")));
		driver.findElements(By.xpath("//*[contains(@id,'firstName')]")).get(0).sendKeys(fst_name);
		driver.findElements(By.xpath("//*[contains(@id,'lastName')]")).get(0).sendKeys(surname);
		Select select_fst_title = new Select(driver.findElements(By.xpath("//*[contains(@id,'title')]")).get(0));
		select_fst_title.selectByVisibleText("Mr");

		driver.findElements(By.xpath("//*[contains(@id,'firstName')]")).get(1).sendKeys(fst_name_snd);
		driver.findElements(By.xpath("//*[contains(@id,'lastName')]")).get(1).sendKeys(surname_snd);
		Select select_snd_title = new Select(driver.findElements(By.xpath("//*[contains(@id,'title')]")).get(1));
		select_snd_title.selectByVisibleText("Mr");
		
		driver.findElements(By.xpath("//*[contains(@id,'firstName')]")).get(2).sendKeys(fst_name_child);
		driver.findElements(By.xpath("//*[contains(@id,'lastName')]")).get(2).sendKeys(surname_child);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fill_phone_number(){
		Select select_country = new Select(driver.findElements(By.name("phoneNumberCountry")).get(0));
		select_country.selectByVisibleText("Spain");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("input.ng-valid-valid-phone-prefix")).sendKeys(phone);
	}
	
	public void fill_card_details(){
		driver.findElement(By.xpath("//*[contains(@id,'cardNumber')]")).sendKeys(card_number);;
		
		Select select_card = new Select(driver.findElement(By.name("cardType")));
		select_card.selectByVisibleText(card);
		
		Select select_expiry_month = new Select(driver.findElement(By.name("expiryMonth")));
		select_expiry_month.selectByVisibleText(expire_month);
		
		Select select_expiry_year = new Select(driver.findElement(By.name("expiryYear")));
		select_expiry_year.selectByVisibleText(expire_year);
		
		driver.findElement(By.name("securityCode")).sendKeys(code);
		
		driver.findElement(By.name("cardHolderName")).sendKeys(surname);
	}
	
	public void billing_address(){
		driver.findElement(By.name("billingAddressAddressLine1")).sendKeys(address1);
		driver.findElement(By.name("billingAddressAddressLine2")).sendKeys(address2);
		
		driver.findElement(By.name("billingAddressCity")).sendKeys(city);

		driver.findElement(By.name("billingAddressPostcode")).sendKeys(postcode);

		Select select_countr_billing = new Select(driver.findElement(By.name("billingAddressCountry")));
		select_countr_billing.selectByVisibleText(country);
	}
	
	public void pay_now(){
		driver.findElement(By.name("acceptPolicy")).click();
		driver.findElement(By.xpath("//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[7]/button")).click();
		
		String processing_payment_box = "/html/body/div[2]/main/div[1]/payment/div[1]/div[2]/div[2]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(processing_payment_box)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(processing_payment_box)));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void wrong_card_number(){
		List<WebElement> error = driver.findElements(By.xpath("//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/prompt"));
		Assert.assertEquals(1, error.size());
	}
}
