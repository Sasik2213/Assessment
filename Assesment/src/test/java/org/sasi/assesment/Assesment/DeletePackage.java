package org.sasi.assesment.Assesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeletePackage {
public static void main(String[] args) throws InterruptedException{
	String reqName = "Packages";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://ecs-qa.kloudship.com");
	Actions actions = new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	actions.click(driver.findElement(By.xpath("(//input[@id='login-email'])[1]"))).sendKeys("kloudship.qa.automation@mailinator.com").build().perform();
	actions.click(driver.findElement(By.xpath("(//input[@id='login-password'])[1]"))).sendKeys("Password1").build().perform();
	actions.click(driver.findElement(By.xpath("//span[normalize-space()='Log in']"))).build().perform();
	List<WebElement> operations = driver.findElements(By.cssSelector(".count-card"));
	WebElement req = operations.stream()
			.filter(p -> p.findElement(By.cssSelector(".text-count-card")).getText().equals(reqName)).findFirst()
			.orElse(null);
	req.findElement(By.cssSelector("mat-card:nth-child(8) p:nth-child(3)")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/perfect-scrollbar[1]/div[1]/div[1]/div[1]/app-dashboard[1]/div[1]/div[1]/app-package-type-list[1]/perfect-scrollbar[1]/div[1]/div[1]/mat-card[6]/div[1]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/perfect-scrollbar[1]/div[1]/div[1]/div[1]/app-dashboard[1]/div[1]/div[1]/app-package-type-list[1]/perfect-scrollbar[1]/div[1]/div[1]/mat-card[6]/div[2]/mat-icon[1]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-alert-dialog[1]/mat-card[1]/div[1]/button[1]/span[1]")).click();
	driver.findElement(By.xpath("//mat-icon[normalize-space()='more_vert']")).click();
	driver.findElement(By.xpath("(//button[@role='menuitem'])[8]")).click();
}
}
