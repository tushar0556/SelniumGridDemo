package com.herokuapp.theinternet.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.WelcomePage;

public class Login extends BaseTest{

	@Test(groups = { "smoke", "Login", "Regression" })
	public static void TC_1_verifyWelcomePage() throws IOException, InterruptedException {
		try {
			String url = "https://infobeans.cueback.com";
			driver.get(url);
			log.info("Page is opened.");
			WelcomePage.verifyWelcomePage();
		} catch (Exception e) {
			throw e;
		}
	}
}