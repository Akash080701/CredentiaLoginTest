package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NegativeLoginTest {
	
	private static EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\eclipse-workspace\\LoginAssignment\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://dev.credentiai.com/credcorp/#/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.form-control.inputField")).clear();
		driver.findElement(By.cssSelector("input.form-control.inputField")).sendKeys("wronguser@credentiai.com");
		driver.findElement(By.id("password-input")).clear();
		driver.findElement(By.id("password-input")).sendKeys("WrongPassword!");
		driver.findElement(By.xpath("//button[@class='btn btn-black inputField signin ng-star-inserted']")).click();
		Thread.sleep(1500);

		// Check for error message (Replace with the actual selector/text for your page)
		try {
		    WebElement errorBox = driver.findElement(By.xpath("//*[contains(text(), 'No user record was found')]"));
		    if (errorBox.isDisplayed()) {
		        System.out.println("✅ Negative Test Passed: Wrong credentials - Error message found");
		    } 
		} catch (Exception e) {
		    System.out.println("❌ Negative Test Failed: Expected error message not displayed for wrong credentials");
		} finally {
		    System.out.println("All the negative test cases are executed!");
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
