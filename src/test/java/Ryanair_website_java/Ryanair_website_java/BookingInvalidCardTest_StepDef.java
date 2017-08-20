package Ryanair_website_java.Ryanair_website_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingInvalidCardTest_StepDef {

	WebDriver driver;
	
	@Given("^user opens ryanair booking page$")
	public void user_opens_ryanair_booking_page(){
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ryanair.com/ie/en/");
	}
	
	@When("^user makes a one way booking from krakow to gdansk$")
	public void user_makes_a_booking(){
		MakeABooking booking = new MakeABooking(driver);
		
		booking.close_cookie_policy();
		booking.select_one_way_trip();
		booking.select_city_from();
		booking.select_city_to();
		
	}
	
	@And("^user selects date: 15/12/2017 and passengers: 2 adults and 1 child$")
	public void user_select_date_passengers(){
		SelectDateAndPassengers date_passengers = new SelectDateAndPassengers(driver);
		
		date_passengers.select_date();
		date_passengers.select_passengers();
		date_passengers.select_lets_go_button();
		
	}
	
	
	@And("^user logs in to myryanair$")
	public void user_login_to_myryanair(){
		
		if(driver.findElements(By.className("promo-popup-close")).size() != 0){ // Close advert... 
			driver.findElement(By.className("promo-popup-close")).click();
		}
		
		LoginToRyanairWebsite login = new LoginToRyanairWebsite(driver);
		
		login.click_on_myryanair_auth();
		login.type_username();
		login.type_password();
		login.click_login_button();
		login.click_from_price();
		login.select_standard_fare();
		
	}
	
	@And("^user select seats$")
	public void user_selects_seats(){
		
		SelectSeats seats = new SelectSeats(driver);
		
		seats.click_continue_button();
		seats.confirm_select_seats();
		seats.select_seats();
		seats.close_advert();
		seats.click_next_button();
		seats.click_confirm();
		seats.close_advert();
		seats.click_checkout();
	}
	
	@Then("^user gets payment declined message using card 5555555555555557 expired on 10/18, ccv: 265$")
	public void user_gets_payment_declined_message(){
		
		PaymentDetails details = new PaymentDetails(driver);
		
		details.fill_passenger_details();
		details.fill_phone_number();
		details.fill_card_details();
		details.billing_address();
		details.pay_now();
		details.wrong_card_number();
	}
}
