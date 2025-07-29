package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginWithOTP {
	private static EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\eclipse-workspace\\LoginAssignment\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
		
		driver.get("https://dev.credentiai.com/credcorp/#/auth/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='col1 showMobile-otp ng-star-inserted']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.form-control.inputField")).sendKeys("raghu+blbadmin@credentiai.com");
//		driver.findElement(By.xpath("//input[@class='form-control inputField ng-pristine ng-invalid ng-touched']")).sendKeys("raghu+blbadmin@credentiai.com"); 
        driver.findElement(By.id("phone")).sendKeys("9510000000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField ng-star-inserted']")).click();
		
        driver.quit();
	}
}
