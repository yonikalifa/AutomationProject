package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryShopPage extends BasePage {
	@FindBy(css = ".ui.huge.primary.fluid.icon.labeled.button")
	private WebElement placeorderBtn;
	@FindBy(css = "#sylius-thank-you")
	private WebElement msgconfirm;
	

	public SummaryShopPage(WebDriver driver) {
		super(driver);
	}
    
	//complete purchase items
	public void completePurchase() {
		click(placeorderBtn);
	}
	
	//message confirmation about the purchase
	public String getMessageConfirmation() {
		return getText(msgconfirm);
	}
}
