package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class McFit {



		@BeforeEach
		void setUp() {
		}

		@BeforeEach
		void tearDown() {
		}

		@Test
		public void site_header_is_on_home_page() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vreee\\chromedriver.exe");
			WebDriver browser = new ChromeDriver();
			browser.get("https://my.mcfit.com/studio/cnNnLWdyb3VwOjE4NTgzNzcxMDA%3D/booking/course/3848204812?v=1");
			WebElement href = browser.findElement(By.xpath("//a[@href='/beta/login']"));
			assertTrue((href.isDisplayed()));
			browser.close();

		}
		
		
		@Test
		public void mf() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vreee\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://my.mcfit.com/studio/cnNnLWdyb3VwOjE4NTgzNzcxMDA%3D/booking/course/3848204812?v=1");
			driver.manage().window().setSize(new Dimension(1552,840)); //resize window
			WebElement sesh = driver.findElement(By.cssSelector(".sc-gFSPHw:nth-child(3) > .sc-iCfLBT:nth-child(5) > .sc-iCfLBT:nth-child(1)"));
			sesh.click();
			WebElement login = driver.findElement(By.cssSelector(".sc-GamvQ:nth-child(2) .sc-eoHYXO"));
			login.click();
			login.sendKeys(System.getenv("EMAIL"));
			WebElement pw = driver.findElement(By.cssSelector(".sc-GamvQ:nth-child(3) .sc-eoHYXO"));
			pw.sendKeys(System.getenv("PW"));
			pw.sendKeys(Keys.RETURN);
			WebElement next = driver.findElement(By.cssSelector(".cYkrXw > span"));
			next.click();
			WebElement book = driver.findElement(By.xpath("//button[contains(.,'Book appointment')]"));
			assertTrue((!book.isDisplayed())); //book appointment button gone, cause booking happend
			driver.close();

		}
	}

