package automation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profileUpdate {
	 public static void main(String[] args) throws IOException {
		 	// read the file
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\HP\\eclipse-workspace\\SeleniumMaven\\src\\test\\java\\automation\\users.json"));
	        String email = jsonNode.get("email").asText();
	        String  password = jsonNode.get("password").asText();
	        
	        // go to login page
	        WebDriver driver= new ChromeDriver();
			driver.get("https://www.xampro.org/login");
			driver.manage().window().maximize();
			
			// get email and password elements
			WebElement emailEl = driver.findElement(By.id("email"));
			WebElement passwordEl = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.xpath("//div[@class='account-form-submit-button']"));
			
			// type the inputs
			emailEl.sendKeys(email);
			passwordEl.sendKeys(password);
			
			// click on login button
			loginButton.click();
			
			// wait for navigation
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		    
		    // open the profile drop-down
			WebElement profileViewDropdownButton = driver.findElement(By.cssSelector(".profile-view-btn > #basic-nav-dropdown"));
			profileViewDropdownButton.click();
			
		    // click on the profile
			WebElement profileButton = driver.findElement(By.cssSelector("li a[href='/profile']"));
			profileButton.click();
			
			// wait for navigation
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			// select full name and update
			WebElement fullNameEl = driver.findElement(By.id("fullName"));
			fullNameEl.clear();
			fullNameEl.sendKeys("updated name");
			
			// click on update button
			WebElement updateButton = driver.findElement(By.className("profile-submit-page-btn"));
			// forcefully click the button because sometimes it's not clickable 
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateButton);
			
			// Check if the profile gets updated
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//*[contains(text(), 'Profile update successful')]")
		    ));
		    
		    // check "successful" toast message contents
		    String actualMessage = toastMessage.getText();
		    String expectedMessage = "Profile update successful";
		    Assertions.assertEquals(expectedMessage, actualMessage, "Test Failed: Toast message did not match!");

			// quit the window
			driver.quit();
	    }
}
