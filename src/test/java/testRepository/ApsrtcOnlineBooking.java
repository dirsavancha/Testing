package testRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class ApsrtcOnlineBooking {

	public static void HoverAndClick(WebDriver driver, WebElement elemToHover,
			WebElement eleToClick) {
		Actions click = new Actions(driver);
		click.moveToElement(elemToHover).click(eleToClick).build().perform();

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(
				"webdriver.chrome.driver",
				"D:/RK/Selenium/Browsers/Chrome/New folder/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		// FirefoxDriver
		
		/*System.setProperty("webdriver.firefox.marionette",
				"D:\\RK\\Selenium\\Browsers\\Geko\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();*/
		driver.get("https://www.apsrtconline.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Finding the from place
		WebElement frmplace = (driver.findElement(By
				.xpath("//input[contains(@name,'source')]")));
		frmplace.click();
		frmplace.sendKeys("BAN");
		Thread.sleep(1000);
		WebElement ban = driver.findElement(By
				.xpath("//a[contains(text(),'BANGALORE')]"));
		Actions rtc = new Actions(driver);
		rtc.click(ban).build().perform();

		// finding the to place
		WebElement toplace=driver.findElement(By.xpath("//input[contains(@name,'destination')]"));
		toplace.click();
		toplace.sendKeys("Nellor");
		WebElement nlr=driver.findElement(By.xpath("//a[text()='NELLORE']"));
		
		Thread.sleep(20);
		rtc.click(nlr).build().perform();
		
		
		//Journy Date- Strat
		WebElement sdate=driver.findElement(By.id("txtJourneyDate"));
            sdate.click();
            Thread.sleep(30);
           WebElement startdate =driver.findElement(By.xpath("//div//table//tbody//tr[5]//td[6]//a[@class='ui-state-default']"));
	        rtc.click(startdate).build().perform();
	        //journt Date-End
	        WebElement edate=driver.findElement(By.id("txtReturnJourneyDate"));
	       edate.click();
	       WebElement enddate=driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table//tbody//tr[3]//td[2]"));
	       rtc.moveToElement(enddate).build().perform();
	       Thread.sleep(150);
	       
	       // Submiit Button
	       driver.findElement(By.id("searchBtn")).click();
	}

}
