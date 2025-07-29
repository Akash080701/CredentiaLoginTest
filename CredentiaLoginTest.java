package loginTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CredentiaLoginTest {
	private static EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\eclipse-workspace\\LoginAssignment\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
		
		driver.get("https://dev.credentiai.com/credcorp/#/auth/login");
		
		driver.manage().window().maximize();
		
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.form-control.inputField")).sendKeys("raghu+blbadmin@credentiai.com"); //Positive Element working with CssSelector 
//		driver.findElement(By.xpath("//input[@class='form-control inputField ng-pristine ng-invalid ng-touched']")).sendKeys("raghu+blbadmin@credentiai.com"); //Negative Element working with CssSelector
		Thread.sleep(2000);
		driver.findElement(By.id("password-input")).sendKeys("Test@234");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField signin ng-star-inserted']")).click();
        
        System.out.println("✅ Login with Email/Password triggered");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //(CSS selector): wait for presence
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("a.nav-link.dropdown-toggle")
        ));
        
        dropdown.click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='col1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("raghu+blbadmin@credentiai.com"); 
        driver.findElement(By.id("phone")).sendKeys("9510000000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField signin ng-star-inserted']")).click();
        
        System.out.println("✅ Forgot Password with Email/Phone Number is triggered");
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='bi bi-arrow-left back-to-login ng-star-inserted']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='col1 showMobile-otp ng-star-inserted']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.form-control.inputField")).sendKeys("raghu+blbadmin@credentiai.com");
//		driver.findElement(By.xpath("//input[@class='form-control inputField ng-pristine ng-invalid ng-touched']")).sendKeys("raghu+blbadmin@credentiai.com"); 
        driver.findElement(By.id("phone")).sendKeys("9510000000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-black inputField ng-star-inserted']")).click();
        
        System.out.println("✅ LoginwithOTP with Email/Phone Number is triggered");
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='d-block loginCredentia ng-star-inserted']")).click();
        
        driver.quit();
	}
}
