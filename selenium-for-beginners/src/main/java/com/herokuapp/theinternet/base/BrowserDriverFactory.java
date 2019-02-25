package com.herokuapp.theinternet.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;


	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}


	public WebDriver createDriver() {
		System.out.println("Starting " + browser + " locally");

		// Creating driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
		}

		return driver.get();
	}


	public WebDriver createDriverGrid() {
		String hubUrl = "http://192.168.2.120:5555/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Starting " + browser + " on grid");

		// Creating driver
		switch (browser) {
		case "chrome":
			System.out.println("Chrome browser initiated...");
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.VISTA);
			capabilities.setAcceptInsecureCerts(true);
			break;

		case "firefox":
			System.out.println("Firefox browser initiated...");
			capabilities.setBrowserName("firefox");
			capabilities.setCapability("marionette", true);
			capabilities.setPlatform(Platform.VISTA);
//			
//			capabilities.setAcceptInsecureCerts(true);
			break;
			
		case "internet explorer":
			System.out.println("Internet Explore browser initiated...");
			capabilities.setBrowserName("internet explorer");
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setAcceptInsecureCerts(true);
			break;
		}

		try {
			driver.set(new RemoteWebDriver(new URL(hubUrl), capabilities));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver.get();
	}

}
