package com.herokuapp.theinternet.base;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class WelcomePage {

	private static Logger log = Logger.getLogger(WelcomePage.class.getName());
	
	@FindBy(linkText = "Log In")
	static WebElement logInLink;

	@FindBy(linkText = "Register")
	static WebElement registerLink;
	/**
	 * This Method will navigate a user to login page
	 * 
	 * @param 
	 */
	public static void navigateToLoginPage() {
		Assert.assertTrue(logInLink.isDisplayed());
		logInLink.click();
		log.info("Clicked on login");
		}
	
	/**
	 * This Method navigate a new user to registration page
	 * 
	 * @param 
	 */
	
	public static void navigateToRegistratioPage() {
		Assert.assertTrue(registerLink.isDisplayed());
		registerLink.click();
		log.info("Clicked on login");
		}
	
	/**
	 * This Method will verify landing page
	 * 
	 * @param void
	 * @return void
	 */
	
	public static void verifyWelcomePage() {
		Assert.assertTrue(logInLink.isDisplayed());
		log.info("Verified logout");
		}
	
}
