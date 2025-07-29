package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class CredentiaLogin {
	
	private static EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\eclipse-workspace\\LoginAssignment\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
		
		driver.get("https://dev.credentiai.com/credcorp/#/auth/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.form-control.inputField")).sendKeys("raghu+blbadmin@credentiai.com"); //Positive Element working with CssSelector 
//		driver.findElement(By.xpath("//input[@class='form-control inputField ng-pristine ng-invalid ng-touched']")).sendKeys("raghu+blbadmin@credentiai.com"); //Negative Element working with CssSelector
		Thread.sleep(3000);
		driver.findElement(By.id("password-input")).sendKeys("Test@234");
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField signin ng-star-inserted']")).click();
        
        System.out.println("✅ Login with Email/Password triggered");
		
        driver.quit();
	}
}
