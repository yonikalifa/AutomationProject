package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends BasePage {
	@FindBy(css = ".ui.red.labeled.icon.button")
	private WebElement deleteBtn;
	@FindBy(css = "#confirmation-button")
	private WebElement yesBtn;
	@FindBy(css = "div.ui.icon.positive.message.sylius-flash-message > div > p")
	private WebElement successmsg;
	@FindBy(css = ".ui.breadcrumb > a:nth-child(1)")
	private WebElement administrationLink;

	public CustomersPage(WebDriver driver) {
		super(driver);
	}

	public void deleteNewCustomer() {
		click(deleteBtn);
		click(yesBtn);
	}

	// confirmation message about delete customer
	public String getMessageDeleted() {
		return getText(successmsg);
	}

	// return to the Dashboard page after delete the customer
	public void goBackToDashboard() {
		click(administrationLink);
	}

}
