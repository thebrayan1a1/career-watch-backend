package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Base.BasePage;

public class PageSearchGoogle extends BasePage {

	By textBox = By.id("APjFqb");
	By botonSearch = By.name("btnK");

	
	public PageSearchGoogle(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	
	public void searchGoogle() throws InterruptedException {
		teclear("selenium",textBox);
		Thread.sleep(2000);
		oprimir(botonSearch);
		Thread.sleep(2000);
	}

}
