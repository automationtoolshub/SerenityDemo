package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.util.UserConstants;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class UserFormPages extends PageObject{
	
	@FindBy(name="address1")
	WebElement addressElement;
	
	@FindBy(name="address2")
	WebElement address1Element;
	
	@FindBy(name="city")
	WebElement cityElement;
	
	@FindBy(name="state")
	WebElement stateElement;
	
	@FindBy(name="zipCode")
	WebElement zipCodeElement;
	
	@FindBy(name="email")
	WebElement emailElement;
	
	@FindBy(name="phone")
	WebElement phoneElement;
	
	@FindBy(name="dobDay")
	WebElement dateElement;
	
	@FindBy(name="dobMonth")
	WebElement monthElement;
	
	@FindBy(name="dobYear")
	WebElement yearElement;
	
	@FindBy(xpath="//*[contains(text(),'Submit')]")
	WebElement submit_button;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	WebElement continue_button;
	
	@FindBy(xpath="//*[contains(text(),'Success')]")
	WebElement successText;
	
	public void navigateToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void openApplication() {
		getDriver().get(UserConstants.LANDING_PAGE);
		getDriver().manage().window().maximize();
	}
	public void enterUserInformation(String address,String city, String state,String zip,String email, String phone, String dob) {
		String[] userAddress = address.split(",");
		addressElement.sendKeys(userAddress[0]);
		address1Element.sendKeys(userAddress[1]);
		cityElement.sendKeys(city);
	    Select select = new Select(stateElement);
	    select.selectByValue(state.toUpperCase());
	    zipCodeElement.sendKeys(zip);
		phoneElement.sendKeys(phone);
		emailElement.sendKeys(email);
		String[] birth = dob.split("-");
		monthElement.sendKeys(birth[0]);
		dateElement.sendKeys(birth[1]);
		yearElement.sendKeys(birth[2]);
	
	}
	
	public void submitUserForm() {
		navigateToElement(submit_button);
		submit_button.click();
	}
	
	public void NavigateToSummaryPage() {
//		Assert.assertEquals(UserConstants.SUMMARY_PAGE, getDriver().getCurrentUrl());
	}

	
	public void submitSummaryPage() {
		navigateToElement(continue_button);
		continue_button.click();
	}
	
	public void NavigateToSuccessPage() {
		Assert.assertEquals(UserConstants.SUCCESS_PAGES, getDriver().getCurrentUrl());
		Assert.assertEquals(UserConstants.SUCCESS_MESSAGE,successText.getText());
	}
	

}
