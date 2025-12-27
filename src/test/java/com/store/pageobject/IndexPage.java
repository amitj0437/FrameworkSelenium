package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identify the webelement here
	@FindBy(linkText = "Sign in") WebElement signIn;
	
	//perform the action 
	public void clickOnSignInBtn() {
		signIn.click();
	}

}
