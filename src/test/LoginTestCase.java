package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.launch the chrome browser and open simplilearn website

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		// 2.maximize the browser
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//3.click on the login link on the top right corner
		//WebElement title = driver.findElement(By.tagName("title"));
		//System.out.println("The title  of the page is" + title.getText());
		
		System.out.println("the title of the page is "+ driver.getTitle());
		
		
		WebElement loginLink = driver.findElement(By.linkText("Log in"));//.findelement is a method of webdriver .this will accept a BY class,which will give us diff locators.
		String  location = loginLink.getAttribute("href");// this is to print the o/p that where this link will take you to. .getattribute method is used for this.
		System.out.println("the link will take you to " + location);
		loginLink.click();
		
		//4.enter the username
		WebElement userName =  driver.findElement(By.name("user_login"));
		userName.sendKeys("abcd@xyz.com");
		
		//5.enter the password
		WebElement password = driver.findElement(By.id("password")); 
		password.sendKeys("Abc@12345");
		
		//click on the remember me box
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		RememberMe.click();
		
		//6.click on login button
		WebElement loginBtn= driver.findElement(By.name("btn_login")); 
		loginBtn.click();
		
		//7.validate login was unsucessful
		WebElement error = driver.findElement(By.className("error_msg"));
		String errormsg =error.getText();
		//System.out.println("The error msg is "+ errormsg);
		String expErrorMsg = "The email or password you have entered is invalid.";
		
		if(error.isDisplayed() && errormsg.equals(expErrorMsg) ) {
		
		System.out.println("Test case is passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
		//before closing the browser ,to find out how many no.of links are there in html page (simplilearn)
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));//here all thelocators with <a will fetch ,and assign to  variable alllinks
		System.out.println("The no.of links is " + AllLinks.size());
		
		// to print all the links
		for(WebElement links : AllLinks) {//here,we have to find each and every link present in list"AllLinks",and printing their href.
			System.out.println(links.getAttribute("href"));
			
		}
		//8. close the browser
		driver.close();

}
}

