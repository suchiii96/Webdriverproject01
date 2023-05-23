package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1.launch the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		//2.maximize the browser
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//3.enter the username
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("hello@9876.com");
		
		//4.enter the password
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("9876#Abcd");
		
		//5.click on the login button
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();

	}

}
