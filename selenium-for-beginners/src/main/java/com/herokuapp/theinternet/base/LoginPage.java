package com.herokuapp.theinternet.base;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static Logger log = Logger.getLogger(LoginPage.class.getName());

	@FindBy(id = "edit-name")
	static WebElement emailPlaceholder;

	@FindBy(id = "edit-password")
	static WebElement passwordPlaceholder;

	@FindBy(id = "edit-submit")
	static WebElement loginButton;

	@FindBy(linkText = "Forgot Password?")
	static WebElement forgotPasswordLink;

	@FindBy(linkText = "Log In")
	static WebElement logInLink;

	@FindBy(linkText = "Register")
	static WebElement registerLink;

	@FindBy(xpath = "//label[text()='Email']")
	static WebElement emailMadatoryElement;

	@FindBy(xpath = "//label[text()='Password']")
	static WebElement passwordMandatoryElement;

	@FindBy(xpath = "//div[@class='messages error']/ul/li")
	static WebElement errorForEmail;

	@FindBy(xpath = "//div[@class='messages error']/ul/li[last()]")
	static WebElement errorForPassword;

	@FindBy(xpath = "//div[@class='messages error']")
	static WebElement errorMessage;

	@FindBy(xpath = "//span[@class='show-hide-icon cb-show']")
	static WebElement showPasswordElement;

	@FindBy(xpath = "//input[@type='text' and @id='edit-password']")
	static WebElement passwordVisibleElement;

	@FindBy(xpath = "//label[@for='edit-field-address-line-2-user-field-privacy']")
	static WebElement rememberMeCheckBox;

	/**
	 * This Method will enable you to login to your account
	 * 
	 * @param username
	 * @param password
	 */

	public static void login(String username, String password) {
		emailPlaceholder.clear();
		emailPlaceholder.sendKeys(username);
		log.info("Username entered");
		passwordPlaceholder.clear();
		passwordPlaceholder.sendKeys(password);
		log.info("Password entered");
		loginButton.click();
		log.info("Clicked on Login button");
	}
}
