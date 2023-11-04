package com.guru99bank.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99bank.utilities.ReadConfig;

public class BaseClass {
	public static  Logger logger = LogManager.getLogger("Guru99Bank");
	//3.  create an object for read config to get values from read config class in utitlites
	ReadConfig readconfig = new ReadConfig();
	//using readconfig variable in beloew to store the values
	public String baseurl = readconfig.getAppURl();
	public String uername = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	//4. giving parameters to launch the code in desired browser using testng.xml file
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		//4. to launch chrome browser
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readconfig.getChromepath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		//4. to launch edge browser
		else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+readconfig.getEdgepath());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		driver.get(baseurl);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	//6. ss
	public void cpatureSS(WebDriver driver,String tname ) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("SS taken");
	}
	
	//generate random email
		public  String generateRandomEmail() {
	        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com", "test.com"};
	        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder email = new StringBuilder();
	        Random random = new Random();

	        // Generate a random username
	        int usernameLength = random.nextInt(10) + 5; // Random length between 5 and 14 characters
	        for (int i = 0; i < usernameLength; i++) {
	            int index = random.nextInt(alphabet.length());
	            char randomChar = alphabet.charAt(index);
	            email.append(randomChar);
	        }

	        // Append "@" symbol
	        email.append("@");

	        // Choose a random domain
	        String randomDomain = domains[random.nextInt(domains.length)];
	        email.append(randomDomain);

	        return email.toString();
	    }
		
	//generate phone num
		public  String generateRandomDigits(int length) {
	        Random random = new Random();
	        StringBuilder digits = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int digit = random.nextInt(10); // Generate a random digit between 0 and 9
	            digits.append(digit);
	        }

	        return digits.toString();
	    }
	
}
