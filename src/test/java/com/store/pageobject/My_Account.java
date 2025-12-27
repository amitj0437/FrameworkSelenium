package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Account {
	
	WebDriver driver;
	public My_Account(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locate the webelement here
	@FindBy(xpath = "//input[@id='email_create']") WebElement inputField;
	@FindBy(xpath = "//button[@id='SubmitCreate']") WebElement createBtn;
	
	//already registered page
	@FindBy(id = "email") WebElement email;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(id = "SubmitLogin") WebElement submitButton;
	
	//perform the action on the webelement
	public void accountCreate(String email) {
		inputField.sendKeys(email);
	}
	public void clickSubmit() {
		createBtn.click();
	}
	
	public void enterEmail(String emails) {
		email.sendKeys(emails);
	}
	
	public void enterPass(String pass) {
		password.sendKeys(pass);
	}
	
	public void submitBtn() {
		submitButton.click();
	}

}
