package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignoutPage {
	
	WebDriver driver;
	public SignoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//locate the web element
	@FindBy(xpath = "//a[@title='View my customer account']") WebElement signOutLink;
	
	//action method
	public String userLoginDetialsLink() {
		String text = signOutLink.getText();
		return text;
	}

}
