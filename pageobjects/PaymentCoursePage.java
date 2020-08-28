package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentCoursePage extends BasePage {
	@FindBy(css = ".item:nth-child(2) .required")
	private WebElement paypalBtn;
	@FindBy(css = "#next-step")
	private WebElement nextBtn;
	@FindBy(css = ".completed.step:nth-child(1) > .content")
	private WebElement addressBtn;

	public PaymentCoursePage(WebDriver driver) {
		super(driver);
	}

	//select "paypal payment"
	public void choosePaypalPayment() {
	click(paypalBtn);
	click(nextBtn);
	}
	
	//return to the address section
	public void goBackToAddress() {
		click(addressBtn);
	}

}
