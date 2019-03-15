package org.CucumberVinoth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddCustomerSteps {
	static WebDriver driver;

	@Given("The user is in add customer page")
	public void the_user_is_in_add_customer_page() {
		System.setProperty("webdriver.chrome.driver", "E:\\Java programs\\Cucumber\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/addcustomer.php");
		driver.manage().window().maximize();
	}
	   
	@When("The user fills the customer details")
	public void the_user_fills_the_customer_details() {
	    driver.findElement(By.id("fname")).sendKeys("vinoth");
	    driver.findElement(By.id("lname")).sendKeys("Subramaniam");
	    driver.findElement(By.id("email")).sendKeys("vinothvino@gmail.com");
	    driver.findElement(By.name("addr")).sendKeys("Chennai");
	    driver.findElement(By.id("telephoneno")).sendKeys("1234567891");
	    
	}

	@When("The user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("The user should see the success message")
	public void the_user_should_see_the_success_message() {
		Assert.assertEquals("Please Note Down Your CustomerID", driver.findElement(By.xpath("//table//tr[2]//b")).getText());
	    
	}

	@Then("The user should see the customer ID")
	public void the_user_should_see_the_customer_ID() {
	    Assert.assertTrue(driver.findElement(By.xpath("//table//tr[1]//b")).isDisplayed());
	}
	}

