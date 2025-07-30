package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NegativeForgotPassword {
	private static EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\eclipse-workspace\\LoginAssignment\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://dev.credentiai.com/credcorp/#/auth/login");
		
		
		driver.findElement(By.xpath("//a[@class='col1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("wronguser@credentiai.com"); 
        driver.findElement(By.id("phone")).sendKeys("9510000012");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField signin ng-star-inserted']")).click();
        Thread.sleep(1500);
        
        try {
		    WebElement errorBox = driver.findElement(By.xpath("//*[contains(text(), 'Oops! No user record found')]"));
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
