package stepDefintion;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test_Steps {
	public static WebDriver driver;
	public static Properties ORProperties;
	public String url = "https://hms.passogen.com/index.php/Hms/index";
	public String parent;
	public String child_window;
	@Before(order = 1)
    public void beforeScenario(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(url);
	    parent=driver.getWindowHandle();
        System.out.println("This will run before the Scenario");
    }	
	@Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    }
	@Before("@End2End")
    public void beforeScenarioStart1(){
        System.out.println("-----------------Start of Scenario start execute End2End test -----------------");
    }
	@Before("@SmokeTest")
    public void beforeScenarioStart2(){
        System.out.println("-----------------Start of Scenario start execute Smoke test -----------------");
    }
	@Before("@RegressionTest")
    public void beforeScenarioStart3(){
        System.out.println("-----------------Start of Scenario start execute Regression test -----------------");
    }
	@After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    } 
	@After(order = 1)
    public void afterScenario(){
		driver.close();
        System.out.println("This will run after the Scenario");
    }
	@Given("User is on HMS Portal Login Page")
	public void user_is_on_hms_portal_login_page() {
//	   driver = new ChromeDriver();
//	   driver.get("https://hms.passogen.com/index.php/Hms/index");
//	   driver.manage().window().maximize();
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("User is on HMS portal login page");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	  WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
	  WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
	  UserName.sendKeys(string);
	  Password.sendKeys(string2);
	}
	@When("User selects {string} as choose account")
	public void user_selects_as_choose_account(String string) {
	Select chooseAccount = new Select(driver.findElement(By.xpath("//select[@name='category']")));
	chooseAccount.selectByVisibleText(string);
	}
	@When("User click on {string}")
	public void user_click_on(String locator){
		driver.findElement(By.xpath(locator)).click();
      //  ExtentTestManager.getTest().log(LogStatus.INFO, "[STEP] Clicking on: "+locator);
	}
	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	   System.out.println("Message displayed Login Successfully");
	}
	@When("User click on User Profile")
	public void user_click_on_user_profile() {
	   WebElement UserProfile = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle link']"));
	   UserProfile.click();
	}
	
	protected By getSelectorType(String locator){
        switch (locator.toLowerCase()){
            case "css": return By.cssSelector(ORProperties.getProperty(locator));
            case "id": return By.id(ORProperties.getProperty(locator));
            case "classname": return By.className(ORProperties.getProperty(locator));
            case "linktext": return By.linkText(ORProperties.getProperty(locator));
            case "name": return By.name(ORProperties.getProperty(locator));
            default: return By.xpath(ORProperties.getProperty(locator));
        }

    }
	@Given("This is a blank test")
	public void this_is_a_blank_test() {
	    System.out.println("Blank Test");
	}
}
