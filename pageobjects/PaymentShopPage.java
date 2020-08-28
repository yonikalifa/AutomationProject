package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentShopPage extends BasePage {
	@FindBy(css = ".ui.fluid.stackable.items > div:nth-child(1)")
	private WebElement cashBtn;
	@FindBy(css = "#next-step")
	private WebElement nextBtn;

	public PaymentShopPage(WebDriver driver) {
		super(driver);
	}

	//select the "cash payment" option
	public void selectCashPayment() {
		sleep(500);
		click(cashBtn);
		click(nextBtn);
		sleep(2000);
	}
	
	
	
}
