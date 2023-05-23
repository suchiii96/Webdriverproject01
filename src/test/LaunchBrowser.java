package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");// telling selenium that this is my driver path..

		WebDriver driver = new ChromeDriver();//webdriver is a instance (so we cant do webdriver driver= new webdriver),and chromedriver intiate webdriver
                                              //when we use webdriver instead of chroemdriver, we can assign it in to any driver like,firefox,edge,chrome etc..but if we are creating chromedriver we cant do it.
		driver.get("https://www.simplilearn.com/");//launching the browser of app using "get" method
		
		driver.manage().window().maximize();//maximize the window
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);//implicit wait is used that,i want to wait for atleast 3 seconds before throwing any error.
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in")); // you can use any text on url page to click using linktext.
		LoginLink.click();

	}

}
