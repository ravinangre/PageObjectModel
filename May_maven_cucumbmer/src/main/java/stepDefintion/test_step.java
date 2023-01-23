package stepDefintion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test_step {
	public static WebDriver driver;
	@When("User click on LogOut button from the Application")
	public void user_click_on_log_out_button_from_the_application() {
	    WebElement LogoutBtn = driver.findElement(By.xpath("//a[text()='Logout']"));
	    LogoutBtn.click();
	}
	@Then("Message displayed LogOut Successfully")
	public void message_displayed_log_out_successfully() {
	  System.out.println("Message displayed LogOut Successfully");
	}
	@Then("Message displayed Login unsuccessfully")
	public void message_displayed_login_unsuccessfully() {
	    System.out.println("Message displayed as login unsuccessfully");
	}
}
