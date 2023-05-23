package com.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.Pages.PageSearchGoogle;

public class TestSearch {
	
	private WebDriver driver;
	PageSearchGoogle pageSearchGoogle;
	
	@BeforeEach
	public void setUp() throws Exception {
		pageSearchGoogle = new PageSearchGoogle(driver);
		driver =pageSearchGoogle.chromeDriverConnection();
		pageSearchGoogle.link("http://www.google.com/");
	}
	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		pageSearchGoogle.searchGoogle();
	}
}
