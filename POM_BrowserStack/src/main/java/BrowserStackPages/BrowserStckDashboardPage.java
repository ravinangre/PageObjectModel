package BrowserStackPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BrowserStckDashboardPage {
// Object Repository
	WebDriver driver;
	By UserProfileBtn = By.xpath("//button[@id='account-menu-toggle']");
	By Summary = By.xpath("//a[text()='Summary']");
	By UserFullName = By.xpath("(//span[@class='profile-details-card__list-item-value-text'])[1]");
	
// Constructor
	public BrowserStckDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
// Methods
	public void UserProfileClick() {
		driver.findElement(UserProfileBtn).click();
	}
	public void ClickonSummary() {
		driver.findElement(Summary).click();
	}
	public String verifyUserName() {
		String getUserText = driver.findElement(UserFullName).getText();
		return getUserText;
	}
}
