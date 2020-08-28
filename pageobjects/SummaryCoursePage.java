package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryCoursePage extends BasePage {
	@FindBy(css = "#sylius-billing-address > address")
	private WebElement billingaddress;
	@FindBy(css = ".ui.toggle.checkbox label")
	private WebElement accepttermsBtn;
	@FindBy(css = ".ui.huge.primary.fluid.icon.labeled.button")
	private WebElement placeorderBtn;
	@FindBy(css = ".sylius-validation-error")
	private WebElement msgtermsfail;
	@FindBy(css = ".completed.step:nth-child(2) > .content")
	private WebElement paymentBtn;

	public SummaryCoursePage(WebDriver driver) {
		super(driver);
	}
	
	//print the billing address
	public String getBillingAddressMessage() {
		return getText(billingaddress);
	}
	
	//process purchase course without click on "accept terms and conditions" button
	public void purchaseWithoutAcceptTerms() {
		click(placeorderBtn);
	}
	
	//error message about the previous test
	public String getMsgFailTerms() {
		return getText(msgtermsfail);
	}
	
	//return to the "payment" section
	public void goBackToPayment() {
		click(paymentBtn);
	}
	
	//complete purchase course
	public void completePurchaseCourse() {
		click(accepttermsBtn);
		click(placeorderBtn);
	}
	
	
	
	
	
	

}
