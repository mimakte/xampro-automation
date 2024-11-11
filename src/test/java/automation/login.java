package automation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
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
			
			// close the window
			driver.quit();
	    }
}
