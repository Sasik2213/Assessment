package org.sasi.assesment.Assesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPackage {
	public static void main(String[] args) throws InterruptedException {
		String reqName = "Packages";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://ecs-qa.kloudship.com");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.id("login-email"))).sendKeys("kloudship.qa.automation@mailinator.com")
				.build().perform();
		actions.click(driver.findElement(By.id("login-password"))).sendKeys("Password1").build().perform();
		actions.click(driver.findElement(By.cssSelector("button[type='submit']"))).build().perform();
		List<WebElement> operations = driver.findElements(By.cssSelector(".count-card"));
		WebElement req = operations.stream()
				.filter(p -> p.findElement(By.cssSelector(".text-count-card")).getText().equals(reqName)).findFirst()
				.orElse(null);
		req.findElement(By.cssSelector("mat-card:nth-child(8) p:nth-child(3)")).click();
		driver.findElement(By.xpath(
				"//mat-icon[@class='mat-icon notranslate mat-tooltip-trigger material-icons mat-ligature-font mat-icon-no-color']"))
				.click();
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample_test");
		driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys("0");
		driver.findElement(By.xpath("//mat-icon[normalize-space()='more_vert']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//button[@role='menuitem'])[8]")).click();
		
	}

}
