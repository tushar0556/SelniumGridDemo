package com.herokuapp.theinternet.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.LoginPage;
import com.herokuapp.theinternet.base.WelcomePage;

public class LoginTests extends BaseTest{

	@Test(groups = { "smoke", "LoginTest", "Regression" })
	public static void verifyLogin() throws IOException, InterruptedException {
		try {
			// open the page
			String url = "https://infobeans.cueback.com";
			driver.get(url);
			log.info("Page is opened.");
			WelcomePage.navigateToLoginPage();
			LoginPage.login("tushar.naik@yopmail.com","Ib@12345");
		} catch (Exception e) {
			throw e;
		}
	}
}