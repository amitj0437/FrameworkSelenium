package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetails {
	
	WebDriver driver;
	public AccountCreationDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locate the webelement 
	@FindBy(xpath = "//input[@id='id_gender1']") WebElement maleGender;
	@FindBy(id = "customer_firstname") WebElement custmerName;
	@FindBy(id = "customer_lastname") WebElement custmerLastName;
	@FindBy(id = "passwd") WebElement custmerPassword;
	@FindBy(id = "submitAccount") WebElement registerBtn;
	
	//action method on the located webelements
	
	public void selectTitleMr() {
		maleGender.click();
	}
	public void enterCustFName(String fname) {
		custmerName.sendKeys(fname);
	}
	public void enterCustLName(String lname) {
		custmerLastName.sendKeys(lname);
	}
	public void enterPass(String pass) {
		custmerPassword.sendKeys(pass);
	}
	public void clickOnRegBtn() {
		registerBtn.click();
	}

}
